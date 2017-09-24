/**
 * @author José Martins
 */

package quotasmanager;

import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.Observable;
import java.util.Iterator;

public class QuotasManager extends Observable {

    private HashMap<Integer,Aluno> members;
    
    public QuotasManager(){
        this.members = new HashMap<Integer,Aluno>();
    }
    
    public Map<Integer,Aluno> getAlunos(){
        return this.members.entrySet().stream()
                                                               .collect(Collectors.toMap( a -> a.getKey(), b -> b.getValue().clone()));
    }
    
    public void pagarQuota(Integer numero, Double valor){
        Quota q = null;
        Aluno aux;
        boolean notFound=true;
        
        Iterator<Aluno> i = this.members.values().iterator();
        while(i.hasNext() && notFound){
            aux = i.next();
            if(aux.getNumber()==numero) {
                q = aux.pagarQuota(valor);
                notFound = false;
            }
        }
        this.setChanged();
        this.notifyObservers(q);
    }
    
    public Aluno getAluno(int num) throws AlunoNotFoundException{
        for(Aluno a: this.members.values()){
            if(a.getNumber()==num) return a.clone();
        }
        throw new  AlunoNotFoundException();
    }
    
    public Aluno getAlunoByName(String name) throws AlunoNotFoundException{
        for(Aluno a: this.members.values()){
            if(a.getName().equals(name)) return a.clone();
        }
        throw new  AlunoNotFoundException();
    }
    
    public void addAluno(Aluno a){
        this.members.put(a.getNumber(),a.clone());
        this.setChanged();
        this.notifyObservers(a);
    }
    
    public void removeAluno(int number){
        this.members.remove(number);
        this.setChanged();
        this.notifyObservers(number);
    }
    
    public int size(){
        return this.members.size();
    }
}
