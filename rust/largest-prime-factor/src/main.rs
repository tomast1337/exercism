fn main() {
    let n = 605143u64;
    let fatores = prime_factors(n);
    println!(
        "Os fatores primoes de {} são\n {:?}\n E o maior é {:?}",
        n,
        fatores,
        fatores.iter().max()
    )
}
fn prime_factors(mut number: u64) -> Vec<u64> {
    let mut result: Vec<u64> = Vec::new();
    while number != 1 {
        for primo in 1..number {
            if number == 1 {break;}
            if number % primo == 0 && is_prime(primo) {
                number = number / primo;
                result.push(primo);
            }
        }
    }
    result
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
