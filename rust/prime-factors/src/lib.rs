pub fn factors(n: u64) -> Vec<u64> {
    let mut result:Vec<u64> = Vec::new();
    let mut curent_num:u64 = n;
    while curent_num != 1{
        let mut d = 1;
        //=curent_num  inclusive end wont work, dont know why
        for i in 2 .. (curent_num+1) {
            if is_prime(i) && curent_num % i == 0 {
                result.push(i);
                d = i;
                break;
            }
        }
        curent_num = curent_num / d;
    }
    return result;
}
fn is_prime(n: u64) -> bool {
    (2..n)
    .take_while(|divisor| divisor * divisor <= n)
    .all(|divisor| n % divisor != 0)
}
