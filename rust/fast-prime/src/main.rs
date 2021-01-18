use std::time::{SystemTime};

fn main() {
    let num = 3322255777;
    let mut time;
    let mut elapsed;
    let mut result;

    println!("Testando:{}",num);

    time = SystemTime::now();
    result = is_prime_great_root(num);
    elapsed = time.elapsed().unwrap();
    println!("1° Tempo: {:#?} , is_prime_great_root({}) -> {}", elapsed , num , result);

    time = SystemTime::now();
    result = is_prime_better_division(num);
    elapsed = time.elapsed().unwrap();
    println!("2° Tempo: {:#?} , is_prime_better_division({}) -> {}", elapsed , num , result);

    time = SystemTime::now();
    result = is_prime_even_check(num);
    elapsed = time.elapsed().unwrap();
    println!("3° Tempo: {:#?} , is_prime_even_check({}) -> {}", elapsed , num , result);

    time = SystemTime::now();
    result = is_prime(num);
    elapsed = time.elapsed().unwrap();
    println!("4° Tempo: {:#?} , is_prime({}) -> {}", elapsed , num , result);

    

}
fn is_prime(n: u64) -> bool {
    let mut counter = 0;
    for i in (2..n + 1).rev() {
        if n % i == 0 {
            counter += 1;
        }
    }
    return counter == 1;
}

fn is_prime_even_check(n: u64) -> bool { 
    if n % 2 == 0 {
        return n == 2;
    }
    if n % 3 == 0 {
        return n == 3;
    }
    let mut counter = 0;
    for i in (2..n + 1).rev() {
        if n % i == 0 {
            counter += 1;
        }
    }
    return counter == 1;
}

fn is_prime_better_division(n: u64) -> bool {
    if n % 2 == 0 {
        return n == 2;
    }
    if n % 3 == 0 {
        return n == 3;
    }
    let mut counter = 0;
    let mut divisor = 1;
    let mut num = n;
    while num != divisor {
        divisor += 1;
        if num % divisor == 0 {
            num = num / divisor;
            counter+=1;
            divisor= 1;
        }
        if counter > 1 {
            return false;
        }
    }
    return counter == 1;
}

fn is_prime_great_root(n: u64) -> bool {
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