fn main() {
    let time = std::time::SystemTime::now();
    
    println!("Grade 2x2 tem {} caminhos possiveis.",path_possibilities(2,2));
    println!("Grade 8x5 tem {} caminhos possiveis.",path_possibilities(8,5));
    println!("Grade 9x2 tem {} caminhos possiveis.",path_possibilities(9,2));
    println!("Grade 10x15 tem {} caminhos possiveis.",path_possibilities(10,15));
    println!("Grade 20x20 tem {} caminhos possiveis.",path_possibilities(20,20));
    
    println!("Tempo de execução: {:?}\n\n", time.elapsed().unwrap());
}

fn path_possibilities(height:i128, width:i128) -> i128{
    (height .. height + width).product::<i128>() / (1..width).product::<i128>()
}
