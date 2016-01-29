package lineal.stack;
/**
 * Created by j on 16/01/2016.
 */
public abstract class O implements E {

    protected PList pl;
    protected String type = "O";
    protected boolean defined = false;
    protected boolean precondition(){
        // lista de condiciones que deben de ser cumplidas para aplicar el operador

        return false;
    }

    protected boolean isDefined(){
        return this.defined;
    }


    protected void apply(State s){
        //
        
    }

    protected void add(State e){

    }

    protected void remove(State e){

    }


    public PList getPredList(){
        // return the addlist predcondition
        return this.pl;
    }

    public void setPredList(PList pl){
        this.pl = pl;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
