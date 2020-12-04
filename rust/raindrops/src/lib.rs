pub fn raindrops(n: u32) -> String {
    let mut r_drop = String::from("");
    if n%3==0 {r_drop.push_str("Pling")}
    if n%5==0 {r_drop.push_str("Plang")}
    if n%7==0 {r_drop.push_str("Plong")}
    if r_drop == "" {return n.to_string()} 
    return r_drop;
}
