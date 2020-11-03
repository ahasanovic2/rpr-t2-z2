package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double prva;
    private double druga;
    private boolean prvi_bool;
    private boolean drugi_bool;
    public Interval() {
        prva=0;
        druga=0;
        prvi_bool=false;
        drugi_bool=false;
    }
    public Interval(double prva, double druga, boolean prvi_bool, boolean drugi_bool) {
        if (prva>druga) throw new IllegalArgumentException("Ne valjaju parametri");
        this.prva = prva;
        this.druga = druga;
        this.prvi_bool = prvi_bool;
        this.drugi_bool = drugi_bool;
    }
    public boolean isNull () {
        return prva == 0 && druga == 0 && !prvi_bool && !drugi_bool;
    }
    public boolean isIn (double tacka) {
        if (prvi_bool && drugi_bool) {
            if (tacka>=prva && tacka<=druga) return true;
        }
        else if (prvi_bool && !drugi_bool)
        {
            if (tacka>=prva && tacka<druga) return true;
        }
        else if (!prvi_bool && drugi_bool) {
            if (tacka>prva && tacka<=druga) return true;
        }
        else if (!prvi_bool && !drugi_bool) {
            if (tacka>prva && tacka<druga) return true;
        }
        return false;
    }
    public Interval intersect (double prva, double druga, boolean prvi_bool, boolean drugi_bool) {
        Interval novi = new Interval();
        novi.prva = Math.max(this.prva,prva);
        novi.druga = Math.min(this.druga,druga);

    }
}
