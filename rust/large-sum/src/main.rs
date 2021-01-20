fn main() {
    use std::time::SystemTime;
    let time = SystemTime::now();
    let number_file = std::fs::read_to_string("./numbers.txt").expect("Erro ao abrir series.txt");
    let result = large_sum(number_file);
    let elapsed = time.elapsed().unwrap();
    println!("Os 10 primeiro numero da grande some são: {}\n\n", result);
    println!("Tempo de execução: {:?}\n\n", elapsed)
}
fn large_sum(number_file:String) -> String {
    let numbers: Vec<&str> = number_file.split("\n").collect();
    let mut sum:u128 = 0;
    for n in numbers{ 
        sum += n[..36].to_string().parse::<u128>().unwrap();
    }
    sum = sum / 10u128.pow(28);
    sum.to_string()
} 
