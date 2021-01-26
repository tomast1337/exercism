fn main() {
    let time = std::time::SystemTime::now();
    for i in 1..=100 {
        println!("Soma do digito do fatorial de {} é {}.",i,factorial_digit_sum(i));
    }
    println!("\n\nTempo de execução: {:?}\n\n", time.elapsed().unwrap());
}
fn factorial_digit_sum(n:u32) -> u64{
    let mut factorial: num_bigint::BigInt = num_traits::FromPrimitive::from_u32(1).unwrap();
    for i in 1..n {
        factorial = factorial * i;
    }
    factorial.to_string()
            .chars()
            .map(|d| d.to_digit(10).unwrap_or(0) as u64)
            .sum::<u64>()
}