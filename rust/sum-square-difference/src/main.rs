fn main() {
    println!("Sum square difference 1 to 10 = {}",sum_square_difference(1,10));
    println!("Sum square difference 1 to 20 = {}",sum_square_difference(1,20));
    println!("Sum square difference 1 to 50 = {}",sum_square_difference(1,50));
    println!("Sum square difference 1 to 100 = {}",sum_square_difference(1,100));
}

fn sum_square_difference (start:u64, end:u64) -> u64 {
    let (mut sq_sum, mut sum_sq) = (0u64,0u64);
    for i in start..=end {
        sq_sum = sq_sum + i*i;
        sum_sq = sum_sq + i;
    }
    sum_sq = sum_sq * sum_sq;
    sum_sq - sq_sum
}
