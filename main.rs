pub fn multiply(x:i32,y:i32) -> i32 {
   let mut r:i32 = 0;
   for i in 1..y{
       r = r + x
   }
   r
}
fn main(){
   multiply(2,2);
}