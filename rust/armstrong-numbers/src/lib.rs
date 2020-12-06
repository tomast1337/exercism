pub fn is_armstrong_number(num: u32) -> bool {
    let size = num.to_string().len() as u32;
    let mut result = Vec::<u32>::new();
    return num.to_string().chars().map(|c| c.to_digit(10).unwrap_or(0).pow(size)).sum::<u32>() == num;
}
