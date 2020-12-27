fn main() {
    println!("Result:{}",smaler_multiple(1,20));
}
fn smaler_multiple (mut min:u64,max:u64) -> u64 {
    if min == 1 { min = 2}
    let mut result:u64 = 1;
    'search: loop{
        let mut flag = true;
        for i in min..=max{
            if result % i != 0{
                flag = false;
                break;
            }
        }
        if flag {
            break 'search;
        }
        result +=1;
    }
    result
}
