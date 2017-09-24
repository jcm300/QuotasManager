/**
 * @author José Martins
 */

package quotasmanager;

import java.time.LocalDate;

public class Quota implements Comparable<Quota> {
    
    //instance variavels
    private LocalDate date;
    private double value;
    
    //constructors
    public Quota(LocalDate d, double v){
        this.date = d;
        this.value = v;
    }
    
    //gets
    public LocalDate getDate(){
        return this.date;
    }
    public double getValue(){
        return this.value;
    }
    
    //sets
    public void setDate(LocalDate d){
        this.date = d;
    }
    public void setValue(double v){
        this.value = v;
    }
    
    public Quota clone(){
        return new Quota(this.getDate(),this.getValue());
    }
    
    public boolean equals(Object o){
        if(o==this) return true;
        if((o==null) || (o.getClass()!=this.getClass())) return false;
        Quota q = (Quota)o;
        return (this.date.equals(q.getDate()) && this.value==q.getValue());
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Date: ").append(this.date);
        s.append("\nValue: ").append(this.value);
        return s.toString();
    }
    
    //compareTo
    public int compareTo(Quota q){
        return this.date.compareTo(q.getDate());
    }
    
    //hashCode
    public int hashCode(){
        int r = 13;
        
        r = r*23 + this.date.hashCode();
        r = r*23 + (int)this.value;
        return r;
    }
}
