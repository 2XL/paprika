package lineal.stack.ops;

import lineal.stack.*;
import lineal.stack.pre.Clean;
import lineal.stack.pre.Dirty;
import lineal.stack.pre.Empty;
import lineal.stack.pre.RobotLocation;

import java.util.List;

/**
 * Created by j on 16/01/2016.
 */
public class CleanOffice extends O {


    String o;

    public CleanOffice(){
        this.type = "CleanOffice";
        // constructor vacio
    }

    public CleanOffice(String o){
        this.type = "CleanOffice";
        this.o = o;
        this.defined = true;
    }

    public String getO() {
        return o;
    }

    public void setO(String o) {
        this.o = o;
    }

    @Override
    public String toString() {

        // return super.toString();
        return "CleanOffice(" + this.o + ")";
    }

    public boolean check(List<P> p){
        String precond = "Empty("+this.o+"):Robot-location("+this.o+"):Dirty("+this.o+")";
        for(String prec : precond.split(":")){
            if(p.contains(prec)){
                // ok
            }else{
                return false;
            }
        }
        return true;
    }

    @Override
    public void add(State e){
        // String str =  "Clean("+this.o+")";
        Clean clean = new Clean(this.o);
        e.addPre(clean);
    }

    @Override
    public void remove(State e){
        // String str = "Dirty("+this.o+")";
        Dirty dirty = new Dirty(this.o);
        e.removePre(dirty);
    }

    @Override
    public PList getPredList(){
        PList pl = new PList();

        pl.addCond(new RobotLocation(this.o));
        pl.addCond(new Dirty(this.o));
        pl.addCond(new Empty(this.o));

        return pl;
    }



    public void apply(State s){
        System.out.println("Apply Clean Office");
        this.add(s);
        this.remove(s);
    }

}
