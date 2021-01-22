fn main() {
    let time = std::time::SystemTime::now();
    println!("O primeiro numero triangular com mais de {} divisores é {}",500,trianglar_numbers_with_n_divisor(500));
    println!("Tempo de execução: {:?}\n\n", time.elapsed().unwrap());
}
fn trianglar_numbers_with_n_divisor(n_divisor: u64) -> u64 {
    let mut trianglar = 1;
    let mut i = 2;
    loop {
        trianglar += i;
        if divisor(trianglar) >= 500{
            break;
        }
        i+=1;
    }
    trianglar
}
fn divisor(n:u64) -> u64{
    let mut divisor_count = 0;
    for i in 1..=(n as f64).sqrt() as u64{
        if n % i == 0{
            divisor_count +=2
        }
        if i*i==n{
            divisor_count -=1
        }
    }
    divisor_count
}
