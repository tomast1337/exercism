#include <glad/glad.h>
#include <GLFW/glfw3.h>

#include <iostream>

void framebuffer_size_callback(GLFWwindow *window, int width, int height);

void processInput(GLFWwindow *window);

#define WIDTH 800
#define HEIGHT 600

const char *vertexShaderSource = "#version 330 core\n"
                                 "layout (location = 0) in vec3 aPos;\n"
                                 "void main()\n"
                                 "{\n"
                                 "   gl_Position = vec4(aPos.x, aPos.y, aPos.z, 1.0);\n"
                                 "}\0";
const char *fragmentShaderSourceOrange = "#version 330 core\n"
                                         "out vec4 FragColor;\n"
                                         "void main()\n"
                                         "{\n"
                                         "   FragColor = vec4(1.0f, 0.5f, 0.2f, 1.0f);\n"
                                         "}\n\0";

const char *fragmentShaderSourceYellow = "#version 330 core\n"
                                         "out vec4 FragColor;\n"
                                         "void main()\n"
                                         "{\n"
                                         "   FragColor = vec4(1.0f, 1.0f, 0.0f, 1.0f);\n"
                                         "}\n\0";

unsigned int compileShader(int type, const char *source);

unsigned int criarShaderProgram(unsigned int *shadersArray, int quantShader);

int main() {
    glfwInit();
    glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
    glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
    glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
    GLFWwindow *window = glfwCreateWindow(WIDTH, HEIGHT, "LearnOpenGL", NULL, NULL);
    if (window == nullptr) {
        std::cout << "Failed to create GLFW window" << std::endl;
        glfwTerminate();
        return -1;
    }
    glfwMakeContextCurrent(window);
    glfwSetFramebufferSizeCallback(window, framebuffer_size_callback);

    if (!gladLoadGLLoader((GLADloadproc) glfwGetProcAddress)) {
        std::cout << "Failed to initialize GLAD" << std::endl;
        return -1;
    }

    unsigned int shadersMeio[2];
    // vertex shader
    shadersMeio[0] = compileShader(GL_VERTEX_SHADER, vertexShaderSource);
    // fragment shader
    shadersMeio[1] = compileShader(GL_FRAGMENT_SHADER, fragmentShaderSourceYellow);

    // link shadersLaterais
    unsigned int shaderPrograMeio = criarShaderProgram(shadersMeio, 2);


    float quadMeio[] = {
            //quad meio
            -0.7f, 0.9f, 0.0f, // topo esquerda
            -0.7f, 0.7f, 0.0f, // baixo esquerda
            0.7f, -0.9f, 0.0f, // baixo direita

            -0.7f, 0.9f, 0.0f, // topo esquerda
            0.7f, -0.7f, 0.0f,  // topo direita
            0.7f, -0.9f, 0.0f // baixo direita
    };

    unsigned int shadersLaterais[2];
    // vertex shader
    shadersLaterais[0] = compileShader(GL_VERTEX_SHADER, vertexShaderSource);
    // fragment shader
    shadersLaterais[1] = compileShader(GL_FRAGMENT_SHADER, fragmentShaderSourceOrange);

    // link shadersLaterais
    unsigned int shaderProgramLateral = criarShaderProgram(shadersLaterais, 2);

    float quadsLaterais[] = {

            //quad esquerda
            -0.9f, 0.9f, 0.0f, // topo esquerda
            -0.9f, -0.9f, 0.0f, // baixo esquerda
            -0.7f, -0.9f, 0.0f, // baixo direita

            -0.9f, 0.9f, 0.0f, // topo esquerda
            -0.7f, 0.9f, 0.0f,  // topo direita
            -0.7f, -0.9f, 0.0f, // baixo direita

            //quad direita
            0.9f, 0.9f, 0.0f, // topo esquerda
            0.9f, -0.9f, 0.0f, // baixo direita
            0.7f, -0.9f, 0.0f, // baixo esquerda

            0.9f, 0.9f, 0.0f, // topo esquerda
            0.7f, 0.9f, 0.0f,  // topo direita
            0.7f, -0.9f, 0.0f, // baixo direita
    };

    unsigned int VBOs[2], VAOs[2];
    glGenVertexArrays(2, VAOs);
    glGenBuffers(2, VBOs);

    // quads laterais
    glBindVertexArray(VAOs[0]);
    glBindBuffer(GL_ARRAY_BUFFER, VBOs[0]);
    glBufferData(GL_ARRAY_BUFFER, sizeof(quadsLaterais), quadsLaterais, GL_STATIC_DRAW);
    glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 3 * sizeof(float), (void *) 0);
    glEnableVertexAttribArray(0);

    // quad meio
    glBindVertexArray(VAOs[1]);
    glBindBuffer(GL_ARRAY_BUFFER, VBOs[1]);
    glBufferData(GL_ARRAY_BUFFER, sizeof(quadMeio), quadMeio, GL_STATIC_DRAW);
    glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 3 * sizeof(float), (void *) 0);
    glEnableVertexAttribArray(0);

    glBindBuffer(GL_ARRAY_BUFFER, 0);
    glBindVertexArray(0);


    // wireframe  mode
    //glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);

    //loop
    while (!glfwWindowShouldClose(window)) {
        // input
        processInput(window);

        // render
        // Limpar tela
        glClearColor(0.2f, 0.3f, 0.3f, 1.0f);
        glClear(GL_COLOR_BUFFER_BIT);

        // Desenha quad laterais
        glUseProgram(shaderProgramLateral);
        glBindVertexArray(VAOs[0]);
        glDrawArrays(GL_TRIANGLES, 0, 12);
        // Desenhar quad meio
        glUseProgram(shaderPrograMeio);
        glBindVertexArray(VAOs[1]);
        glDrawArrays(GL_TRIANGLES, 0, 6);

        glfwSwapBuffers(window);
        glfwPollEvents();
    }


    glDeleteVertexArrays(2, VAOs);
    glDeleteBuffers(2, VBOs);
    glDeleteProgram(shaderProgramLateral);

    glfwTerminate();
    return 0;
}


unsigned int criarShaderProgram(unsigned int *shadersArray, int quantShader) {
    int status;
    char log[512];
    unsigned int shaderProgram = glCreateProgram();

    for (int i = 0; i < quantShader; ++i) {
        glAttachShader(shaderProgram, shadersArray[i]);
    }

    glLinkProgram(shaderProgram);

    glGetProgramiv(shaderProgram, GL_LINK_STATUS, &status);
    if (!status) {
        glGetProgramInfoLog(shaderProgram, 512, nullptr, log);
        std::cout << "ERROR::SHADER::PROGRAM::LINKING_FAILED\n" << log << std::endl;
    }

    for (int i = 0; i < quantShader; ++i) {
        glDeleteShader(shadersArray[i]);
    }

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

void processInput(GLFWwindow *window) {
    if (glfwGetKey(window, GLFW_KEY_ESCAPE) == GLFW_PRESS)
        glfwSetWindowShouldClose(window, true);
}

void framebuffer_size_callback(GLFWwindow *window, int width, int height) {
    glViewport(0, 0, width, height);
}