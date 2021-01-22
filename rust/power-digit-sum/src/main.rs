fn main() {
    let time = std::time::SystemTime::now();
    println!("\n\n\t\t2¹⁰ ---> {}",power_digit_sum(2,10));
    println!("\t\t2¹⁵ ---> {}",power_digit_sum(2,15));
    println!("\t\t2¹⁰⁰ --> {}",power_digit_sum(2,100));
    println!("\t\t2¹⁰⁰⁰ -> {}",power_digit_sum(2,1000));
    println!("\n\nTempo de execução: {:?}\n\n", time.elapsed().unwrap());
}

fn power_digit_sum(base:u32,expoente:u32) -> u64{
    let base: num_bigint::BigInt = num_traits::FromPrimitive::from_u32(base).unwrap(); 
    num_traits::pow(base,expoente as usize)
            .to_string()
            .chars()
            .map(|d| d.to_digit(10).unwrap_or(0) as u64)
            .sum::<u64>()
}