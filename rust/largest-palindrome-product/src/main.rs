fn main() {
    println!("\n\n\n\n\n\n\n\n\n\n\n\n");
    test(1);
    test(2);
    test(3);
    test(4);
    test(5);
}
fn test(number: u64) {
    let start = std::time::Instant::now();
    let result = largest_palidrome(number);
    let duration = start.elapsed();
    println!(
        "\n\tMaior produto palíndromo entre 2 numeros de {} digitos é {}. Tempo Execução: {:?}",
        number,
        result,
        duration.as_secs_f32()
    )
}
fn largest_palidrome(digits: u64) -> u64 {
    let mut coeficiente_max = 0u64;
    for _ in 0..digits {
        coeficiente_max *= 10;
        coeficiente_max += 9;
    }
    let coeficiente_min = 1 + coeficiente_max / 10;
    
    let mut maior:u64 = 0;
    for i in (coeficiente_min..=coeficiente_max).rev() {
        for j in (i..=coeficiente_max).rev() {
            let produto = i * j;
            if is_palidrome(produto) && produto > maior{
                maior = produto
            }
        }
    }
    maior
}
fn is_palidrome(num: u64) -> bool {
    if num <= 9 {return true}
    let mut num_t = num;
    let mut digits: Vec<u64> = Vec::new();
    while num_t >= 1 {
        digits.push(num_t % 10);
        num_t = num_t / 10;
    }
    while digits.len() > 1 {
        let first_digit: u64 = *digits.first().unwrap();
        let last_digit: u64 = *digits.last().unwrap();
        if  first_digit != last_digit {
            return false;
        }else {
            digits = digits.drain(1..digits.len()-1).collect();
        }
    }
    true
}
