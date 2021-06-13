#version 330 core
out vec4 FragColor;
in vec3 minhaColor;

void main(){
    FragColor = vec4(minhaColor, 1.0);
}
