#[derive(Debug)]
pub struct HighScores<'t>{
    scores: &'t[u32],
}
impl<'t> HighScores<'t> {
    pub fn new(scores: &'t[u32]) -> Self {
        HighScores{scores : scores}
    }

    pub fn scores(&self) -> &[u32] { 
        self.scores
    }

    pub fn latest(&self) -> Option<u32> {
        self.scores.last().copied()
    }

    pub fn personal_best(&self) -> Option<u32> {
        self.scores.iter().max().copied()
    }

    pub fn personal_top_three(&self) -> Vec<u32> {
        let mut result = self.scores.to_vec();
        result.sort();
        result.reverse();
        result.truncate(3);
        result
    }
}
