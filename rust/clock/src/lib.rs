use std::fmt;
#[derive(Debug)]
pub struct Clock{
    minutes: i32,
}
fn fix_time(hours: i32,mut minutes: i32) -> i32 {
    minutes = (hours * 60 + minutes)%1440;
    if minutes < 0 { 1440 + minutes }else { minutes }
}
impl Clock {   
    pub fn new(hours: i32, minutes: i32) -> Self {
        Clock {minutes: fix_time(hours, minutes) }
    }
    pub fn add_minutes(&self, minutes: i32) -> Self {
        Clock{minutes: fix_time(0,(self.minutes + minutes)%1440)} 
    }
}
impl PartialEq for Clock{
    fn eq(&self, other: &Clock) -> bool{
        self.minutes == other.minutes
    }
}
impl fmt::Display for Clock {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        return write!(f,"{:02}:{:02}",self.minutes/60,self.minutes%60);
    }
}