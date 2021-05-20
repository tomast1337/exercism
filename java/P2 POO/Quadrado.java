public class Quadrado {
	private double alt;
	private double larg;
	public double getAlt() {
		return alt;
	}
	public void setAlt(double alt) {
		this.alt = alt;
	}
	public double getLarg() {
		return larg;
	}
	public void setLarg(double larg) {
		this.larg = larg;
	}
    //equals
    @Override
    public boolean equals(Object o){
        Quadrado quad = (Quadrado) o;
        if (o == this) return true;
        if (!(o instanceof Quadrado)) return false;
        return this.alt + this.larg == quad.getAlt() + quad.getLarg();
    }	
}
