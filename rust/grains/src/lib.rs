/*
pub fn main() {
    println!("Grains🌾 in {}th square:{}...",2,square(2));
    println!("Grains🌾 in {}th square:{}...",7,square(7));
    println!("Grains🌾 in {}th square:{}...",10,square(10));
    println!("Grains🌾 total in all 64 squares: {:?} 😯",total());
}
*/
pub fn square(s: u32) -> u64 {
    return if s < 1 || s > 64 { panic!("Square must be between 1 and 64")} else{2u64.pow(s-1)}
}

pub fn total() -> u64 {
    (1..=64).map(square).sum::<u64>()
}
