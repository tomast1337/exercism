fn sum_even_fibonacci(n: u64) -> u64 {
    let (mut last, mut curent) = (1u64, 1u64);
    let mut list: Vec<u64> = Vec::new();
    while curent <= n {
        let test = curent;
        if test % 2 == 0 { list.push(curent); }
        curent = test + last;
        last = test;
    }
    list.iter().sum()
}
fn main() {
    let quant:u64 = 4_000_000;
    println!("\n\n\n\n\n\n\t\t\tSomatorio dos primeiros numeros Fibonacci pares menores que {} é iqual a {}\n\n\n\n\n\n\n",quant,sum_even_fibonacci(quant));
}