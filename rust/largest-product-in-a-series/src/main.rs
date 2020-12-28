fn main() {
    let series = std::fs::read_to_string("./series.txt").expect("Erro ao abrir series.txt");
    println!("\n\n\nSerie:\n{}",series);
    println!("\n\tO maior produto dos 13 valores vizinhos dessa serie:{}",serie_product(series,13));
}
fn serie_product(serie: String,size:u32) -> u128{
    let mut numbers:Vec<u16> = Vec::new(); 
    for i in serie.chars() {numbers.push(i.to_digit(10).unwrap_or(0) as u16)}
    let (mut greatest_product,mut greatest_product_factors) = (1u128,Vec::new());
    let (mut start_index,last_index) = (0,numbers.len() as u32);
    while start_index < last_index {
        let (mut product,mut product_factors) = (1u128,Vec::new());
        for i in 0..size {
            let current_number = numbers[(start_index+i)as usize]; 
            if current_number == 0 {break}
            product_factors.push(current_number as u16);
            product = product * current_number as u128;
        }
        if greatest_product < product {
            greatest_product = product;
            greatest_product_factors = product_factors;
        }
        start_index +=1;
    }
    println!("\n\n\t{:?}",greatest_product_factors);
    greatest_product
}