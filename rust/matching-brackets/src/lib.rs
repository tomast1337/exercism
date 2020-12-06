pub fn brackets_are_balanced(string: &str) -> bool {
    let (mut bracket, mut braces, mut parentheses,mut brackets) = (0i32, 0i32, 0i32,String::new());
    string.chars().for_each(|x| match x {
        '{' => brackets.push(x),
        '}' => brackets.push(x),
        '[' => brackets.push(x),
        ']' => brackets.push(x),
        '(' => brackets.push(x),
        ')' => brackets.push(x),
        _ => (),
    });
    for c in brackets.chars() {
        match c {
            '{' => braces += 1,
            '}' => braces += -1,
            '[' => bracket += 1,
            ']' => bracket += -1,
            '(' => parentheses += 1,
            ')' => parentheses += -1,
            _ => (),
        }
    }
    bracket == 0 && braces == 0 && parentheses == 0
}
