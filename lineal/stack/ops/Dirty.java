package lineal.stack.ops;

import lineal.stack.P;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by j on 16/01/2016.
 */
public class Dirty extends P {

    String o;

    public Dirty(){

    }

    public Dirty(String o){
        this.o = o;
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
        return "Dirty(" + this.o + ")";
    }


    public void setAttr(String str) {
        Pattern pattern = Pattern.compile("\\((.*?)\\)");
        Matcher match = pattern.matcher(str);
        if (match.find()) {
            String[] methodArgs = (match.group(1)).split(",");
            this.o = methodArgs[0];
        }
    }
}
