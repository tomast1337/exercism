fn main() {
    println!("Sum of the frist primes below 10:{}",prime_summation(10));
    println!("Sum of the frist primes below 20:{}",prime_summation(20));
    println!("Sum of the frist primes below 50:{}",prime_summation(50));

    println!("Sum of the frist primes below 100:{}",prime_summation(100));
    println!("Sum of the frist primes below 200:{}",prime_summation(200));
    println!("Sum of the frist primes below 500:{}",prime_summation(500));

    println!("Sum of the frist primes below 1.000:{}",prime_summation(1000));
    println!("Sum of the frist primes below 2.000:{}",prime_summation(2000));
    println!("Sum of the frist primes below 5.000:{}",prime_summation(5000));

    println!("Sum of the frist primes below 100.000:{}",prime_summation(100000));
    println!("Sum of the frist primes below 200.000:{}",prime_summation(200000));
    println!("Sum of the frist primes below 500.000:{}",prime_summation(500000));

    println!("Sum of the frist primes below 1.000.000:{}",prime_summation(1000000));
    println!("Sum of the frist primes below 2.000.000:{}",prime_summation(2000000));
}
fn prime_summation(n: u64) -> u64 {
    let mut elements: Vec<u64> = Vec::new();
    for i in 2..n{
        if is_prime(i) {
            elements.push(i);
        }
    }
    elements.iter().sum()
}
fn is_prime(n: u64) -> bool {
    if n % 2 == 0 {
        return n == 2;
    }
    if n % 3 == 0 {
        return n == 3;
    }
    for i in 3..(n as f64).sqrt() as u64 {
        if n % i == 0 {
            return false
        }
    }
    true
}
