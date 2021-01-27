use num_bigint::BigUint;
use num_traits::{Zero, One};
use std::mem::replace;

fn fibonacci(n: usize) -> BigUint {
    let mut f0: BigUint = Zero::zero();
    let mut f1: BigUint = One::one();
    for _ in 0..n {
        let f2 = f0 + &f1;
        
        f0 = replace(&mut f1, f2);
    }
    f0
}

fn frist_n_digiti_fibonacci_index(n: usize) -> usize {
    let mut i = 1;
    loop{
        let num = fibonacci(i);
        if num.to_string().chars().count() == n{
            break;
        }
        i +=1;
    }
    return i;
}

fn main() {
    let time = std::time::SystemTime::now();
    println!("\n\nO {}° numero da sequencia fibonacci tem 2 digitos",frist_n_digiti_fibonacci_index(2));
    println!("O {}° numero da sequencia fibonacci tem 10 digitos",frist_n_digiti_fibonacci_index(10));
    println!("O {}° numero da sequencia fibonacci tem 1000 digitos",frist_n_digiti_fibonacci_index(1000));
    println!("\n\nTempo de execução: {:?}\n\n", time.elapsed().unwrap());
}
