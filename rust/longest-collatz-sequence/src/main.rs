fn main() {
    let time = std::time::SystemTime::now();
    println!("Numero entre 1 e 1.000.000 com maior sequencia de collatz é {}",bignest_collatz_sequence(1,1_000_000));
    println!("\n\nTempo de execução: {:?}\n\n", time.elapsed().unwrap());
}
fn bignest_collatz_sequence(start:u64, end:u64) -> u64 {
    let mut biggest = 0;
    let mut biggest_sequence:Vec<u64> = Vec::new();
    for n in start..=end {
        let sequence = collatz_sequence(n);
        if sequence.len() > biggest_sequence.len(){
            biggest = n;
            biggest_sequence = sequence;
        } 
    }
    biggest
}

fn collatz_sequence(mut n:u64) -> Vec<u64>{
    let mut sequence:Vec<u64> = Vec::new();
    sequence.push(n);
    while n != 1 {
        if n % 2 == 0{
            n = n/2 
        }else {
            n = 3*n + 1
        }
        sequence.push(n)
    }
    sequence
}