use std::time::{SystemTime};

fn main() {
    let num = 3322255777;
    let mut time;
    let mut elapsed;
    let mut result;

    println!("Testando:{}",num);

    time = SystemTime::now();
    result = is_prime(num);
    elapsed = time.elapsed().unwrap();
    println!("4° Tempo: {:#?} , is_prime({}) -> {}", elapsed , num , result);

    

}
fn is_prime(n: u64) -> bool {
    (2..n)
    .take_while(|divisor| divisor * divisor <= n)
    .all(|divisor| n % divisor != 0)
}
