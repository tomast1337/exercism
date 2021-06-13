//
// Created by tomast1337 on 13/06/2021.
//

#include "Shader.h"


Shader::Shader(const char *vertexPath, const char *fragmentPath) {
    std::ifstream vertexFile, fragmentFile;
    std::string vertexCode, fragmentCode;

    vertexFile.exceptions(std::ifstream::failbit | std::ifstream::badbit);
    fragmentFile.exceptions(std::ifstream::failbit | std::ifstream::badbit);
    try {

        vertexFile.open(vertexPath);
        fragmentFile.open(fragmentPath);
        std::stringstream vShaderStream, fShaderStream;
        vShaderStream << vertexFile.rdbuf();
        fShaderStream << fragmentFile.rdbuf();
        vertexFile.close();
        fragmentFile.close();
        vertexCode = vShaderStream.str();
        fragmentCode = fShaderStream.str();

    } catch (std::ifstream::failure e) {
        std::cout << "File Stream erro: " << e.what() << std::endl;
    }
    const char *vertexShaderCode = vertexCode.c_str();
    const char *fragmentShaderCode = fragmentCode.c_str();

    unsigned int vertex = compileShader(GL_VERTEX_SHADER, vertexShaderCode);
    unsigned int fragment = compileShader(GL_FRAGMENT_SHADER, fragmentShaderCode);

    this->ID = criarShaderProgram(vertex, fragment);
}

void Shader::use() {
    glUseProgram(this->ID);
}

void Shader::setBool(const std::string &name, bool value) const {
    glUniform1i(glGetUniformLocation(this->ID, name.c_str()), (int) value);
}

void Shader::setInt(const std::string &name, int value) const {
    glUniform1i(glGetUniformLocation(this->ID, name.c_str()), value);
}

void Shader::setFloat(const std::string &name, float value) const {
    glUniform1f(glGetUniformLocation(this->ID, name.c_str()), value);
}

unsigned int criarShaderProgram(unsigned int vertex, unsigned int fragment) {
    int status;
    char log[512];
    unsigned int shaderProgram = glCreateProgram();

    glAttachShader(shaderProgram, vertex);
    glAttachShader(shaderProgram, fragment);

    glLinkProgram(shaderProgram);

    glGetProgramiv(shaderProgram, GL_LINK_STATUS, &status);
    if (!status) {
        glGetProgramInfoLog(shaderProgram, 512, nullptr, log);
        std::cout << "ERROR::SHADER::PROGRAM::LINKING_FAILED\n" << log << std::endl;
    }

    glDeleteShader(vertex);
    glDeleteShader(fragment);

    return shaderProgram;
}

unsigned int compileShader(int type, const char *source) {
    unsigned int shader = glCreateShader(type);

    glShaderSource(shader, 1, &source, nullptr);
    glCompileShader(shader);
    // Checar por erros e se existir erros imprimir log
    int statusCompilacao;
    char Log[512];
    glGetShaderiv(shader, GL_COMPILE_STATUS, &statusCompilacao);
    if (!statusCompilacao) {
        glGetShaderInfoLog(shader, 512, nullptr, Log);
        if (type == GL_VERTEX_SHADER)
            std::cout << "ERROR::SHADER::VERTEX::COMPILATION_FAILED\n" << Log << std::endl;
        if (type == GL_FRAGMENT_SHADER)
            std::cout << "ERROR::SHADER::FRAGMENT::COMPILATION_FAILED\n" << Log << std::endl;
    }
    return shader;
}