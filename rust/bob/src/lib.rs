pub fn reply(message: &str) -> &str {
    let var = &message.replace(&[' ','\t','\r'][..], "");
    if var.is_empty() { return "Fine. Be that way!" }
    let is_question = var.chars().last() == Some('?');
    let is_all_caps = (var.to_uppercase() == var.to_string())&& var.chars().any(|c| matches!(c, 'A'..='Z'));
    if is_all_caps && is_question { return "Calm down, I know what I'm doing!" }
    if is_question { return "Sure." }
    if is_all_caps { return "Whoa, chill out!" }
    return "Whatever.";
}