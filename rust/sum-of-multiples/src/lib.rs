pub fn sum_of_multiples(limit: u32, factors: &[u32]) -> u32 {
    let mut sum:u32 = 0;
    for i in 0..limit{
        let mut used:bool = false;
        for f in factors{
            if *f != 0u32 {
                if i % f == 0 && !used{
                    sum +=i;
                    used = true;
                }
            }
        }
    }
    return sum;
}
