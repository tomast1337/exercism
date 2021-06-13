#version 330 core
layout (location = 0) in vec3 aPos;
layout (location = 1) in vec3 aColor;

uniform float xOffset;
uniform float yOffset;
uniform float scale;

out vec3 minhaColor;

void main(){
    vec3 bPos = aPos * scale;
    gl_Position = vec4(bPos.x+xOffset,bPos.y+yOffset,bPos.z, 1.0);
    minhaColor = aColor;
}
