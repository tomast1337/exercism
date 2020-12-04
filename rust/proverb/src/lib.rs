pub fn build_proverb(list: &[&str]) -> String {
    let mut proverb = String::new();
    if list.len() == 0 {return proverb;}
    for i in 0 ..list.len() {
        if i < list.len()-1 {
            proverb += "For want of a ";
            proverb +=list[i];
            proverb +=" the ";
            proverb +=list[i+1];
            proverb +=" was lost.\n";    
        }
    }
    proverb +="And all for the want of a ";
    proverb +=list[0];
    proverb +=".";
    return proverb;
}
