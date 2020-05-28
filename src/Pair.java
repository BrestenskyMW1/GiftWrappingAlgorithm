public class Pair<L,R> {
    private L l;
    private R r;
    private double angle;
    public Pair(L l, R r){
        this.l = l;
        this.r = r;
        angle = 0;
    }
    public L getL(){ return l; }
    public R getR(){ return r; }
    public double getAngle(){ return angle; }
    public void setL(L l){ this.l = l; }
    public void setR(R r){ this.r = r; }
    public void setAngle(double angle){ this.angle = angle; }
}