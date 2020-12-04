pub fn nth(n: u32) -> u32 {
    let mut current_number: u32 = 1;
    let mut primer_count: u32 = 0;
    while primer_count <= n{
        current_number += 1;
        if is_prime(current_number){
            primer_count += 1;
        }
    }
    return current_number;
}
fn is_prime(n: u32) -> bool {
    let mut counter = 0;
    for i in (2..n+1).rev() {
        if n % i == 0{counter += 1;}
    }
    return counter == 1;
}
