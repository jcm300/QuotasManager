/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quotascesium;

import java.util.HashMap;
import java.util.Map;
import java.lang.StringBuilder;

/**
 *
 * @author José Martins
 */
public class Aluno  {
    
    //instance variavels
    private String name;
    private int number;
    private String course;
    private int year;
    private String adress;
    private HashMap<String,Double> quotas;
    
    //constructors
    public Aluno(){
        this.name="";
        this.number=0;
        this.course="";
        this.year=0;
        this.adress="";
        this.quotas=new HashMap<String,Double>();
    }
    public Aluno(String n, int num, String c, int y, String a, HashMap<String,Double> q){
        this.name=n;
        this.number=num;
        this.course=c;
        this.year=y;
        this.adress=a;
        this.quotas= new HashMap<String,Double>();
        for(HashMap.Entry<String,Double> d : q.entrySet()){
            this.quotas.put(d.getKey(),d.getValue());
        }
    }
    
    //gets
    public String getName() {return this.name;}
    public int getNumber() {return this.number;}
    public String getCourse() {return this.course;}
    public int getYear() {return this.year;}
    public String getAdress() {return this.adress;}
    public Map<String,Double> getQuotas() {
        HashMap<String,Double> r = new HashMap<String,Double>();
        for(HashMap.Entry<String,Double> d : this.quotas.entrySet()){
            r.put(d.getKey(),d.getValue());
        }
        return r;
    }
    
    //sets
    public void setName(String n) {this.name=n;}
    public void setNumber(int num) {this.number=num;}
    public void setCourse(String c) {this.course=c;}
    public void setYear(int y) {this.year=y;}
    public void setAdress(String a) {this.adress=a;}
    public void setQuotas(HashMap<String,Double> q) {
        this.quotas = new HashMap<String,Double>();
        for(HashMap.Entry<String,Double> d : q.entrySet()){
            this.quotas.put(d.getKey(),d.getValue());
        }
    }
    
    //clone
    public Aluno clone(){
        return new Aluno(this.name,this.number,this.course,this.year,this.adress,this.quotas);
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
}
