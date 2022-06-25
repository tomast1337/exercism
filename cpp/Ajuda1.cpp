#include <iostream>
#include <random>
#include <string>
#include <sstream>
#include <algorithm>

struct Conjunto
{
    int size;
    std::string *data;
    std::string print()
    {
        std::stringstream ss;
        ss << "{ ";
        for (int i = 0; i < size; i++)
            size == i + 1 ? ss << data[i] << "" : ss << data[i] << ", ";
        ss << " }";
        return ss.str();
    }

    void remove_duplicates()
    {
        int i = 0;
        while (i < size)
        {
            int j = i + 1;
            while (j < size)
            {
                if (data[i] == data[j])
                {
                    for (int k = j; k < size; k++)
                        data[k] = data[k + 1];
                    size--;
                }
                else
                    j++;
            }
            i++;
        }
    }

    void sort() { 
        this->remove_duplicates();    
        std::sort(data, data + size);
    }

    

    // atribuir operador * para produto cartesiano
    Conjunto operator*(Conjunto c)
    {
        Conjunto r;
        r.size = size * c.size;
        r.data = new std::string[r.size];
        int i = 0;
        std::for_each(data, data + size, [&c, &r, &i](std::string s)
                      { std::for_each(c.data, c.data + c.size, [&s, &r, &i](std::string t)
                                      { r.data[i++] = s + t; }); });
        r.sort();
        return r;
    }

    // atribuir operador + para união
    Conjunto operator+(Conjunto c)
    {
        Conjunto r;
        r.size = size + c.size;
        r.data = new std::string[r.size];
        std::copy(data, data + size, r.data);
        std::copy(c.data, c.data + c.size, r.data + size);
        
        r.sort();
        return r;
    }

    // atribuir operador == para is equals to
    bool operator==(Conjunto c) { return size == c.size && std::equal(data, data + size, c.data); }
};

void random_set(Conjunto *con, size_t tam)
{

    std::random_device rd;
    std::mt19937 gen(rd());
    std::uniform_int_distribution<> dis(65, 65 + 25); // A - Z

    con->size = tam;

    con->data = new std::string[con->size];

    for (int i = 0; i < con->size; i++)
        con->data[i] = std::string(1, (char)dis(gen));
    con->sort();

}
// Executado com "clang++ matdiscreta.cpp && ./a.out"
int main()
{
    Conjunto A, B, C;
    random_set(&A, 5);
    random_set(&B, 5);
    random_set(&C, 5);
    std::cout << "A: " << A.print() << "\n\n";
    std::cout << "B: " << B.print() << "\n\n";
    std::cout << "C: " << C.print() << "\n\n";

    Conjunto aux;

    std::cout << "A × (B ∪ C) = ";
    aux = A * (B + C);
    std::cout << aux.print() << "\n\n";

    std::cout << "(A × B) ∪ (A × C) = ";
    aux = (A * B) + (A * C);
    std::cout << aux.print() << "\n\n";

    std::cout << "A × (B ∪ C) = ";
    aux = A * (B + C);
    std::cout << aux.print() << "\n\n";

    std::cout << "A × (B ∪ C) == (A × B) ∪ (A × C)";

    (aux == (A * B) + (A * C)) ? std::cout << " = Verdadeiro " << std::endl
                               : std::cout << " = Falso " << std::endl;

    return EXIT_SUCCESS;
}
