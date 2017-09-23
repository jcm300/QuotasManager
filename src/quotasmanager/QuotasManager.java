/**
 * @author José Martins
 */

package quotasmanager;

import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.Observable;

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
        for(Aluno a: this.members.values()){
            if(a.getNumber()==numero)  a.pagarQuota(valor);
        }
    }
    
    public Aluno getAluno(int num) throws AlunoNotFoundException{
        for(Aluno a: this.members.values()){
            if(a.getNumber()==num) return a.clone();
        }
        throw new  AlunoNotFoundException();
    }
    
    public void addAluno(Aluno a){
        this.members.put(a.getNumber(),a.clone());
    }
}
