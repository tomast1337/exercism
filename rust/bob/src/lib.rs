pub fn reply(message: &str) -> &str {
    let var = &message.replace(&[' ','\t','\r',':','}','{','(',')'][..], "");
    println!("{}",var);
    if var.is_empty() {
        return "Fine. Be that way!"
    }else{
        if var.to_uppercase() == var.to_string() && var.len() > 1{
            if var.chars().last() == Some('?') {
                return "Calm down, I know what I'm doing!"
            }
            return "Whoa, chill out!"
        }
        if var.chars().last() == Some('?') {
            return "Sure."
        }
    }
    return "Whatever.";
}