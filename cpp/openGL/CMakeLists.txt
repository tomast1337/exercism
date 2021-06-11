cmake_minimum_required(VERSION 3.16)
project(openGL)
set(CMAKE_CXX_STANDARD 14)

# OpenGl
find_package( OpenGL REQUIRED )
include_directories( ${OPENGL_INCLUDE_DIRS} )
#glfw
find_package(glfw3 REQUIRED)

add_executable(${PROJECT_NAME} src/main.cpp src/glad.c)


target_link_libraries( ${PROJECT_NAME}
        PUBLIC
        ${OPENGL_LIBRARIES}
        glfw
        )