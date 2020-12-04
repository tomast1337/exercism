fn bottle(n: u32) -> String {
    if n > 1 || n == 0 {return " bottles".to_string()}
    else{return " bottle".to_string()}
}
fn n_bottle_of_beer(n: u32) -> String {
    let of_beer = String::from(" of beer");
    let mut bottle_of_beer = String::from("");
    if n == 0{bottle_of_beer += "no more"}
    else{bottle_of_beer += &n.to_string()}
    bottle_of_beer += &bottle(n);
    bottle_of_beer += &of_beer;
    return bottle_of_beer;
}
pub fn verse(n: u32) -> String {
    let mut verse = String::from("");
    let on_the_wall = String::from(" on the wall");
    if n == 0{verse += "No more bottles of beer on the wall, no more bottles of beer.\n"}
    else{
        verse += &n_bottle_of_beer(n);
        verse += &on_the_wall;
        verse +=", ";
        verse += &n_bottle_of_beer(n);
        verse +=".\n";
    }
    if n == 0 {
        verse +="Go to the store and buy some more, ";
        verse += &n_bottle_of_beer(99);
        verse += &on_the_wall; 
    }else{
        if n == 1{verse +="Take it down and pass it around, "}
        else{verse +="Take one down and pass it around, "}
        verse += &n_bottle_of_beer(n-1);
        verse += &on_the_wall; 
    }
    verse +=".\n";
    return verse;
}

pub fn sing(start: u32, end: u32) -> String {
    let mut song = String::from("");
    for i in (end .. start+1).rev(){
        song+=&verse(i);
        if i != end {song+= "\n"}     
    }
   return song;
}