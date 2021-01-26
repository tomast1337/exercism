fn caminho_com_maior_soma(mut triangulo:Vec<Vec<u64>>) -> u64{
    for row in (0..triangulo.len()-1).rev() {
        let mut new_row:Vec<u64> = Vec::new();
        for i in 0..triangulo[row].len() {
            new_row.push(maior_soma_triangulo_2x2(triangulo[row][i],triangulo[row+1][i],triangulo[row+1][i+1])) 
        }
        triangulo[row] = new_row;
    } 
    triangulo[0][0]
}

fn maior_soma_triangulo_2x2(ponta:u64,base_a:u64,base_b:u64) -> u64{
    let soma_left:u64 = ponta + base_a;
    let soma_right:u64 = ponta+ base_b;
    return  if soma_left > soma_right { soma_left } else{ soma_right}
}

fn open_triangulo_resource(name: &str) -> Vec<Vec<u64>>{
    let mut resource = std::path::PathBuf::from(env!("CARGO_MANIFEST_DIR"));
    resource.push("resources/");
    resource.push(name);

    let mut triangulo:Vec<Vec<u64>> = Vec::new();
    for floor in std::fs::read_to_string(resource).expect("Erro ao abrir recurso").split("\n").collect::<Vec<&str>>(){
        let mut floor_vec: Vec<u64> = Vec::new();
        for element in floor.split_whitespace() {
            floor_vec.push(element.parse::<u64>().unwrap());
        }
        triangulo.push(floor_vec)
    }
    
    triangulo
}

fn solve_triangulo(file: &str){
    let triangulo_path = caminho_com_maior_soma(open_triangulo_resource(file));
    println!("\nA maior soma do {} é {}",file,triangulo_path);
}

fn main() {
    let time = std::time::SystemTime::now();

    solve_triangulo("triangle4.txt");
    solve_triangulo("triangle15.txt");
    solve_triangulo("triangle100.txt");
    
    println!("\n\nTempo de execução: {:?}\n\n", time.elapsed().unwrap());
}