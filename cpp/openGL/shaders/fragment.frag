#version 330 core
out vec4 FragColor;
in vec3 minhaColor;

uniform float colorShift;

void main(){
    FragColor = vec4(minhaColor + colorShift, 1.0);
}
