
fn main() {
    println!("\t\tProduto do trio: {}\n\n",pythagorean_triplet_product(10000));
}

fn pythagorean_triplet_product(value: i64)-> i64{
    for r in 1..=value{
        for s in 1..r{
            if (r*r / 2)%s == 0 {
                let t = (r*r / 2)/s;
                if r+s+r+t+r+t+s == value {
                    println!("\n\n\t\t{}² + {}² + {}² = {}²",(r+s), (r+t), (r+t+s), (r+s)*(r+s) + (r+t)*(r+t) + (r+t+s)*(r+t+s));
                    return (r+s)*(r+t)*(r+t+s);
                }
            }
        }
    }
    0
}
