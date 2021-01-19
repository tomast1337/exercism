use std::time::{SystemTime};

fn main() {
    let num = 3322255777;
    let time = SystemTime::now();
    let result = is_prime(num);
    let elapsed = time.elapsed().unwrap();
    println!("Tempo de execução: {:#?} , is_prime({}) -> {}", elapsed , num , result);
}
fn is_prime(n: u64) -> bool {
    (2..n)
    .take_while(|divisor| divisor * divisor <= n)
    .all(|divisor| n % divisor != 0)
}
