use chrono::{DateTime, Utc};
// Returns a Utc DateTime one billion seconds after start.
pub fn after(start: DateTime<Utc>) -> DateTime<Utc> 
{
    start + chrono::Duration::seconds(1000000000)
}
