#include <iostream>

#include <glad/glad.h>

class Texture {
private:
    unsigned int texture;
public:
    explicit Texture(const char *texture_path,int type);

    unsigned int GetTexture();
};
