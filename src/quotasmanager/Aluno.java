/**
 * @author José Martins
 */

package quotasmanager;

import java.util.TreeSet;
import java.util.Set;
import java.lang.StringBuilder;
import java.time.LocalDate;

public class Aluno implements Comparable<Aluno> {
    
    //instance variavels
    private String name;
    private int number;
    private String course;
    private int year;
    private String adress;
    private TreeSet<Quota> quotas;
    
    //constructors
    public Aluno(){
        this.name="";
        this.number=0;
        this.course="";
        this.year=0;
        this.adress="";
        this.quotas=new TreeSet<Quota>();
    }
    public Aluno(int num, String n, String c, int y, String a, TreeSet<Quota> q){
        this.name=n;
        this.number=num;
        this.course=c;
        this.year=y;
        this.adress=a;
        this.setQuotas(q);
    }
    
    //gets
    public String getName() {
        return this.name;
    }
    public int getNumber() {
        return this.number;
    }
    public String getCourse() {
        return this.course;
    }
    public int getYear() {
        return this.year;
    }
    public String getAdress() {
        return this.adress;
    }
    public TreeSet<Quota> getQuotas() {
        TreeSet<Quota> r = new TreeSet<Quota>();
        for(Quota d : this.quotas){
            r.add(d.clone());
        }
        return r;
    }
    
    //sets
    public void setName(String n) {
        this.name=n;
    }
    public void setNumber(int num) {
        this.number=num;
    }
    public void setCourse(String c) {
        this.course=c;
    }
    public void setYear(int y) {
        this.year=y;
    }
    public void setAdress(String a) {
        this.adress=a;
    }
    public void setQuotas(TreeSet<Quota> q) {
        this.quotas = new TreeSet<Quota>();
        for(Quota d : q){
            this.quotas.add(d.clone());
        }
    }
    
    //clone
    public Aluno clone(){
        return new Aluno(this.number,this.name,this.course,this.year,this.adress,this.quotas);
    }
    
    //equals
    public boolean equals(Object o){
        if(this==o) return true;
        if((o==null) || (this.getClass()!=o.getClass())) return false;
        Aluno x = (Aluno)o;
        return (this.name.equals(x.getName()) && this.number==x.getNumber() && this.course.equals(x.getCourse()) 
                && this.year==x.getYear() && this.adress.equals(x.getAdress()) && this.quotas.equals(x.getQuotas()));
    }
    
    //toString
    public String toString(){
        StringBuilder st = new StringBuilder();
        st.append("Name: ").append(this.name);
        st.append("\nNumber: ").append(this.number);
        st.append("\nCourse: ").append(this.course);
        st.append("\nYear: ").append(this.year);
        st.append("\nAdress: ").append(this.adress);
        st.append("\nQuotas: ").append(this.quotas.toString());
        return st.toString();
    }
    
    //hashCode
    public int hashCode(){
        int r = 13;
        
        r = r*23 + this.name.hashCode();
        r = r*23 + this.number;
        r = r*23 + this.course.hashCode();
        r = r*23 + this.year;
        r = r*23 + this.adress.hashCode();
        r = r*23 + this.quotas.hashCode();
        return r;
    }

    //compareTo
    public int compareTo(Aluno a) {
        return this.name.compareTo(a.getName());
    }
    
    //Pay quota
    public Quota pagarQuota(Double value){
        Quota q;
        if(this.quotas.isEmpty())  q = new Quota(LocalDate.now(),value);
        else q = new Quota(this.quotas.last().getDate().plusMonths(1),value);
        this.quotas.add(q.clone());
        return q;
    }
}
