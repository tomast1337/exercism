from random import shuffle
meses = ["janeiro","fevereiro","março","abril","maio","junho","julho","agosto","setembro","outubro"]
materias = ['Razão, Proporção e Porcentagem', 'Funções', 'Geometria plana', 'Geometria Espacial', 'Análise combinatória e Probabilidade', 'Estatística', 'Trigonometria', 
            'Progressões', 'Propriedades ', 'Matrizes  Sistema Linear', 'Geometria analitica ', 'Dinâmica', 'Ondas', 'Eletrodinâmica', 'Termodinâmica', 'Estática e hidrostática',
            'Óptica', 'Cinemática ', 'Eletromagnetismo ', 'Moderna', 'Eletrostática ', 'Química Ambiental', 'Química orgânica', 'Estequiometria ', 'Química inorgânica ', 'Eletroquímica',
            'Separação de misturas', 'Termoquímica', 'Ligações químicas ', 'Radioatividade', 'Soluções', 'Bioquímica', 'Equilíbrio químico  ', 'Propriedade coligativas',
            'Tabela periódica', 'Cinética química ', 'Densidade', 'Matéria', 'Ecologia', 'Citologia', 'Genética', 'Microbiologia', 'Biotecnia ', 'Botânica ', 'Evolução', 'Zoologia',
            'Classificação', 'Imunologia', 'Parasitologia', 'História do brasil', 'Historia contemporánea ', 'História moderna ', 'História antiga', 'História medieval ',
            'História americana ', 'História África', 'Impactos ambientais ', 'Geografia econômica ', 'Geografia Urbana ', 'Geografia agrária ', 'Geografia cultural ',
            'Geopolítica ', 'Biogeografia ', 'Demografia', 'Climatologia', 'Geologia','Energia', 'Cartografia ', 'Geografia Brasil', 'Geomorfologia', 'Interpretação',
            'Literatura', 'Gramática', 'Gênero', 'Linguagem', 'Razão, Proporção e Porcentagem', 'Funções', 'Geometria plana', 'Geometria Espacial',
            'Análise combinatória e Probabilidade', 'Estatística', 'Trigonometria', 'Progressões', 'Propriedades ', 'Matrizes  Sistema Linear', 'Geometria analitica ', 'Dinâmica',
            'Ondas', 'Eletrodinâmica', 'Termodinâmica', 'Estática e hidrostática', 'Óptica', 'Cinemática ', 'Eletromagnetismo ', 'Moderna', 'Eletrostática ', 'Química Ambiental',
            'Química orgânica', 'Estequiometria ', 'Química inorgânica ', 'Eletroquímica', 'Separação de misturas', 'Termoquímica', 'Ligações químicas ', 'Radioatividade',
            'Soluções', 'Bioquímica', 'Equilíbrio químico  ', 'Propriedade coligativas', 'Tabela periódica', 'Cinética química ', 'Densidade', 'Matéria', 'Ecologia',
            'Citologia', 'Genética', 'Microbiologia', 'Biotecnia ', 'Botânica ', 'Evolução', 'Zoologia', 'Classificação', 'Imunologia', 'Parasitologia','História do brasil',
            'Historia contemporánea ', 'História moderna ', 'História antiga', 'História medieval ', 'História americana ', 'História África', 'Impactos ambientais ',
            'Geografia econômica ', 'Geografia Urbana ', 'Geografia agrária ', 'Geografia cultural ', 'Geopolítica ', 'Biogeografia ', 'Demografia', 'Climatologia',
            'Geologia', 'Energia', 'Cartografia ', 'Geografia Brasil', 'Geomorfologia', 'Interpretação', 'Literatura', 'Gramática', 'Gênero', 'Linguagem']
shuffle(materias) 
last = 0
total = 0
for i in meses:
    print(i.upper())
    n = 0
    while n < 15:
        print("-"+materias[n+last])
        n = n + 1
        total = total + 1
    last = last + 15
    print("\n")
print("Total:",total,"materias")