fn main() {
    let time = std::time::SystemTime::now();
    for i in 1..=100 {
        println!("Soma do digito do fatorial de {} é {}.",i,factorial_digit_sum(i));
    }
    println!("\n\nTempo de execução: {:?}\n\n", time.elapsed().unwrap());
}
fn factorial_digit_sum(n:u64) -> u64{
    (1..n).sum()
}