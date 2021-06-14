#version 330 core
layout (location = 0) in vec3 aPos;
layout (location = 1) in vec3 aColor;
layout (location = 2) in vec2 aTexCoord;

out vec3 ourColor;
out vec2 Tex1Coord;
out vec2 Tex2Coord;

uniform float scale;

void main(){
    gl_Position = vec4(aPos*scale, 1.0);
    ourColor = aColor*scale;
    Tex1Coord = aTexCoord;
    Tex2Coord = aTexCoord;
}