pub fn brackets_are_balanced(string: &str) -> bool {
    let mut counter:Vec<char> = Vec::new();
    for c in string.chars(){
        match c {
            '[' | '{' | '(' => counter.push(c),
            ']' => if counter.pop() != Some('[') {return false },
            '}' => if counter.pop() != Some('{') {return false },
            ')' => if counter.pop() != Some('(') {return false },
            _ => {}
        }
    }
    /*string.chars().for_each(|c| //It didn't work, but it would be cool if it worked
        match c {
            '[' | '{' | '(' => counter.push(c),
            ']' => if counter.pop() != Some('[') {return false },
            '}' => if counter.pop() != Some('{') {return false },
            ')' => if counter.pop() != Some('(') {return false },
            _ => {}
    });*/
    counter.is_empty()
}
