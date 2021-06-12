#include <glad/glad.h>
#include <GLFW/glfw3.h>

#include <iostream>

void framebuffer_size_callback(GLFWwindow *window, int width, int height);

void processInput(GLFWwindow *window);

#define WIDTH 800
#define HEIGHT 600

const char *vertexShaderSource = "#version 330 core\n"
                                 "layout (location = 0) in vec3 aPos; \n"
                                 "\n"
                                 "out vec4 vertexColor;\n"
                                 "\n"
                                 "void main()\n"
                                 "{\n"
                                 "\tgl_Position = vec4(aPos, 1.0);\n"
                                 "\tvertexColor = gl_Position;\n"
                                 "}\0";
const char *fragmentShaderSource = "#version 330 core\n"
                                   "out vec4 FragColor;\n"
                                   "\n"
                                   "in vec4 vertexColor; // the input variable from the vertex shader (same name and same type)  \n"
                                   "\n"
                                   "void main()\n"
                                   "{\n"
                                   "\tFragColor = vertexColor;\n"
                                   "}\0";

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
    unsigned int shaders[2];
    // vertex shader
    shaders[0] = compileShader(GL_VERTEX_SHADER, vertexShaderSource);
    // fragment shader
    shaders[1] = compileShader(GL_FRAGMENT_SHADER, fragmentShaderSource);

    // link shaders
    unsigned int shaderProgram = criarShaderProgram(shaders, 2);

    float vertices[] = {

            -0.5f, 0.5f, 0.0f, // topo esquerda
            -0.5f, -0.5f, 0.0f, // baixo esquerda
            0.5f, -0.5f, 0.0f, // baixo direita

            -0.5f, 0.5f, 0.0f, // topo esquerda
            0.5f, 0.5f, 0.0f,  // topo direita
            0.5f, -0.5f, 0.0f // baixo direita
    };

    unsigned int VBO, VAO;
    glGenVertexArrays(1, &VAO);
    glGenBuffers(1, &VBO);

    glBindVertexArray(VAO);

    glBindBuffer(GL_ARRAY_BUFFER, VBO);
    glBufferData(GL_ARRAY_BUFFER, sizeof(vertices), vertices, GL_STATIC_DRAW);

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

        // Desenha triangulo
        glUseProgram(shaderProgram);
        glBindVertexArray(VAO);
        glDrawArrays(GL_TRIANGLES, 0, 6);

        glfwSwapBuffers(window);
        glfwPollEvents();
    }


    glDeleteVertexArrays(1, &VAO);
    glDeleteBuffers(1, &VBO);
    glDeleteProgram(shaderProgram);


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