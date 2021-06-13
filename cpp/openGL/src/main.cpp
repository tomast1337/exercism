#include <glad/glad.h>
#include <GLFW/glfw3.h>

#include <cmath>
#include <iostream>
#include <cmath>
#include "Shader.h"

void framebuffer_size_callback(GLFWwindow *window, int width, int height);

void processInput(GLFWwindow *window);

#define WIDTH 800
#define HEIGHT 600

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


    float vertices[] = {
            0.5f, -0.5f, 0.0f, 1.0f, 0.0f, 0.0f,  // baixo direita
            -0.5f, -0.5f, 0.0f, 0.0f, 1.0f, 0.0f,  // baixo esquerda
            0.0f, 0.5f, 0.0f, 0.0f, 0.0f, 1.0f   // topo
    };

    auto *shader = new Shader("../shaders/vertex.vert\0", "../shaders/fragment.frag\0");

    unsigned int VBO, VAO;
    glGenVertexArrays(1, &VAO);
    glGenBuffers(1, &VBO);

    glBindVertexArray(VAO);

    glBindBuffer(GL_ARRAY_BUFFER, VBO);
    glBufferData(GL_ARRAY_BUFFER, sizeof(vertices), vertices, GL_STATIC_DRAW);

    // atributo de posição
    glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 6 * sizeof(float), (void *) 0);
    glEnableVertexAttribArray(0);
    // Atributo de cores
    glVertexAttribPointer(1, 3, GL_FLOAT, GL_FALSE, 6 * sizeof(float), (void *) (3 * sizeof(float)));
    glEnableVertexAttribArray(1);

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


        shader->use();
        shader->setFloat("xOffset",0.1f);
        shader->setFloat("yOffset",0.1f);
        shader->setFloat("scale",(float)(-0.2*std::sin(glfwGetTime())+1));
        shader->setFloat("colorShift",0.5f*(float)(0.2*std::cos(glfwGetTime()+1)));
        glBindVertexArray(VAO);
        glDrawArrays(GL_TRIANGLES, 0, 3);

        glfwSwapBuffers(window);
        glfwPollEvents();
    }


    glDeleteVertexArrays(1, &VAO);
    glDeleteBuffers(1, &VBO);

    glfwTerminate();
    return 0;
}


void processInput(GLFWwindow *window) {
    if (glfwGetKey(window, GLFW_KEY_ESCAPE) == GLFW_PRESS)
        glfwSetWindowShouldClose(window, true);
}

void framebuffer_size_callback(GLFWwindow *window, int width, int height) {
    glViewport(0, 0, width, height);
}