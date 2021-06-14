#version 330 core
out vec4 FragColor;

in vec3 ourColor;
in vec2 Tex1Coord;
in vec2 Tex2Coord;

uniform sampler2D textura1;
uniform sampler2D textura2;

uniform float verticalTrasform;

void main(){
    vec2 finalTex2Coord = vec2(Tex2Coord.x*verticalTrasform, Tex2Coord.y);
    FragColor = mix(texture(textura1, Tex1Coord), texture(textura2, finalTex2Coord*verticalTrasform*2)*verticalTrasform, 0.5)* vec4(ourColor, 0.02);
}