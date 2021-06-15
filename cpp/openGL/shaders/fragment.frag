#version 330 core
out vec4 FragColor;

in vec3 ourColor;
in vec2 TexCoord;

uniform sampler2D textura1;
uniform sampler2D textura2;

void main(){
    FragColor = mix(texture(textura1, TexCoord), texture(textura2, TexCoord), 0.2)* vec4(ourColor, 0.02);
}