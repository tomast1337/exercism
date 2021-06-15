cmake_minimum_required(VERSION 3.16)
project(openGL)
set(CMAKE_CXX_STANDARD 14)

# OpenGl
find_package(OpenGL REQUIRED)
include_directories(${OPENGL_INCLUDE_DIRS})
#glfw
find_package(glfw3 REQUIRED)

add_executable(${PROJECT_NAME}
        src/main.cpp
        src/glad.c
        src/Shader.h
        src/Shader.cpp
        src/stb_image.h)


target_link_libraries(${PROJECT_NAME}
        PUBLIC
        ${OPENGL_LIBRARIES}
        glfw
        )

# glm
add_subdirectory(lib/glm EXCLUDE_FROM_ALL)
target_link_libraries(${PROJECT_NAME} PRIVATE glm)