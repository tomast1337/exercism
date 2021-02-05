pub fn series(digits: &str, len: usize) -> Vec<String> {
    let mut result:Vec<String> = Vec::new();
    if digits.len() == len{
        result.push(String::from(digits))
    }
    if digits.len() > len{
        for i in 0..digits.len()-len+1 {
            result.push(String::from(&digits[i..i+len]))       
        }
    }
    result
}
