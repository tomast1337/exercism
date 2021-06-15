#include <glad/glad.h>
#include <GLFW/glfw3.h>
#include <cmath>
#include <iostream>
#include <glm/glm.hpp>
#include <glm/gtc/matrix_transform.hpp>
#include <glm/gtc/type_ptr.hpp>
#include "Shader.h"
#include "Texture.h"

void framebuffer_size_callback(GLFWwindow *window, int width, int height);

void processInput(GLFWwindow *window);

#define WIDTH 800
#define HEIGHT 600

int main() {
    glfwInit();
    glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
    glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
    glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
    GLFWwindow *window = glfwCreateWindow(WIDTH, HEIGHT, "LearnOpenGL", nullptr, nullptr);
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

    Shader *shaders[2];
    shaders[0] = new Shader("../shaders/vertex.vert\0", "../shaders/fragment.frag\0");
    shaders[1] = new Shader("../shaders/vertex.vert\0", "../shaders/fragment.frag\0");

    float vertices1[] = {
            // Posição         // cores           // Posição textura1
            0.2f, 0.2f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, // top right
            0.2f, -0.2f, 0.0f, 0.5f, 0.5f, 0.5f, 1.0f, 0.0f, // bottom right
            -0.2f, -0.2f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, // bottom left
            -0.2f, 0.2f, 0.0f, 0.5f, 0.5f, 0.5f, 0.0f, 1.0f  // top left
    };

    float vertices2[] = {
            // Posição         // cores           // Posição textura1
            0.2f, 0.2f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, // top right
            0.2f, -0.2f, 0.0f, 0.5f, 0.5f, 0.5f, 1.0f, 0.0f, // bottom right
            -0.2f, -0.2f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, // bottom left
            -0.2f, 0.2f, 0.0f, 0.5f, 0.5f, 0.5f, 0.0f, 1.0f  // top left
    };

    unsigned int indices[] = {
            0, 1, 3, // first triangle
            1, 2, 3  // second triangle
    };

    unsigned int VBO[2], VAO[2], EBO[2];
    glGenVertexArrays(2, VAO);
    glGenBuffers(2, VBO);
    glGenBuffers(2, EBO);

    glBindVertexArray(VAO[0]);

    glBindBuffer(GL_ARRAY_BUFFER, VAO[0]);
    glBufferData(GL_ARRAY_BUFFER, sizeof(vertices1), vertices1, GL_STATIC_DRAW);

    glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, EBO[0]);
    glBufferData(GL_ELEMENT_ARRAY_BUFFER, sizeof(indices), indices, GL_STATIC_DRAW);

    // atributo de posição
    glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 8 * sizeof(float), (void *) 0);
    glEnableVertexAttribArray(0);
    // Atributo de cores
    glVertexAttribPointer(1, 3, GL_FLOAT, GL_FALSE, 8 * sizeof(float), (void *) (3 * sizeof(float)));
    glEnableVertexAttribArray(1);
    // Atributo de condenadas das texturas
    glVertexAttribPointer(2, 2, GL_FLOAT, GL_FALSE, 8 * sizeof(float), (void *) (6 * sizeof(float)));
    glEnableVertexAttribArray(2);


    glBindVertexArray(VAO[1]);

    glBindBuffer(GL_ARRAY_BUFFER, VAO[1]);
    glBufferData(GL_ARRAY_BUFFER, sizeof(vertices2), vertices2, GL_STATIC_DRAW);

    glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, EBO[1]);
    glBufferData(GL_ELEMENT_ARRAY_BUFFER, sizeof(indices), indices, GL_STATIC_DRAW);

    // atributo de posição
    glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 8 * sizeof(float), (void *) 0);
    glEnableVertexAttribArray(0);
    // Atributo de cores
    glVertexAttribPointer(1, 3, GL_FLOAT, GL_FALSE, 8 * sizeof(float), (void *) (3 * sizeof(float)));
    glEnableVertexAttribArray(1);
    // Atributo de condenadas das texturas
    glVertexAttribPointer(2, 2, GL_FLOAT, GL_FALSE, 8 * sizeof(float), (void *) (6 * sizeof(float)));
    glEnableVertexAttribArray(2);

    Texture sol("../texturas/sun.png",GL_LINEAR);
    Texture terra("../texturas/globe.png",GL_LINEAR);

    shaders[0]->use();
    glUniform1i(glGetUniformLocation(shaders[0]->ID, "textura"), 0);

    shaders[1]->use();
    glUniform1i(glGetUniformLocation(shaders[1]->ID, "textura"), 0);

    //loop
    while (!glfwWindowShouldClose(window)) {
        // input
        processInput(window);

        // render
        // Limpar tela
        glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        glClear(GL_COLOR_BUFFER_BIT);

        glActiveTexture(GL_TEXTURE0);
        glBindTexture(GL_TEXTURE_2D, terra.GetTexture());

        glm::mat4 transform1 = glm::mat4(1.0f);
        transform1 = glm::translate(transform1, glm::vec3((float) (std::cos(glfwGetTime())) * 0.9f,
                                                          (float) (std::sin(glfwGetTime())) * 0.5f,
                                                          0.0f));
        transform1 = glm::rotate(transform1, (float) glfwGetTime() * -0.8f, glm::vec3(0.0f, 0.0f, 1.0f));

        shaders[0]->use();
        unsigned int transformLoc = glGetUniformLocation(shaders[0]->ID, "transform");
        glUniformMatrix4fv(transformLoc, 1, GL_FALSE, glm::value_ptr(transform1));
        shaders[0]->setFloat("scale", 0.4f);
        glBindVertexArray(VAO[0]);
        glDrawElements(GL_TRIANGLES, 6, GL_UNSIGNED_INT, 0);

        glActiveTexture(GL_TEXTURE0);
        glBindTexture(GL_TEXTURE_2D, sol.GetTexture());

        glm::mat4 transform2 = glm::mat4(1.0f);
        transform2 = glm::rotate(transform2, (float) glfwGetTime() * 0.1f, glm::vec3(0.0f, 0.0f, 1.0f));

        shaders[1]->use();
        unsigned int transformLoc2 = glGetUniformLocation(shaders[0]->ID, "transform");
        glUniformMatrix4fv(transformLoc2, 1, GL_FALSE, glm::value_ptr(transform2));
        shaders[1]->setFloat("scale", 1.0f);
        glBindVertexArray(VAO[1]);
        glDrawElements(GL_TRIANGLES, 6, GL_UNSIGNED_INT, 0);

        glfwSwapBuffers(window);
        glfwPollEvents();
    }


    glDeleteVertexArrays(2, VAO);
    glDeleteBuffers(2, VBO);
    glDeleteBuffers(2, EBO);

    glfwTerminate();
    return 0;
}

static unsigned char wireframe = 0;

void processInput(GLFWwindow *window) {
    if (glfwGetKey(window, GLFW_KEY_ESCAPE) == GLFW_PRESS)
        glfwSetWindowShouldClose(window, true);
    if (glfwGetKey(window, GLFW_KEY_W) == GLFW_PRESS)
        glPolygonMode(GL_FRONT_AND_BACK, (wireframe = 1 - wireframe) ? GL_LINE : GL_FILL);
}

void framebuffer_size_callback(GLFWwindow *window, int width, int height) {
    glViewport(0, 0, width, height);
}