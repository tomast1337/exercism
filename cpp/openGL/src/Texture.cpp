#include "Texture.h"

#define STB_IMAGE_IMPLEMENTATION

#include "stb_image.h"


Texture::Texture(const char *texture_path, int type,int RGBType) {
    glGenTextures(1, &this->texture);
    glBindTexture(GL_TEXTURE_2D, this->texture);

    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, type);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, type);

    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, type);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, type);

    int width, height, nrChannels;
    unsigned char *data = stbi_load(texture_path, &width, &height, &nrChannels, 0);
    if (data) {
        glTexImage2D(GL_TEXTURE_2D, 0, RGBType, width, height, 0, RGBType, GL_UNSIGNED_BYTE, data);
        glGenerateMipmap(GL_TEXTURE_2D);
    } else
        std::cout << "Falha ao carregar texturas" << std::endl;

    stbi_image_free(data);
}

unsigned int Texture::GetTexture() {
    return this->texture;
}
