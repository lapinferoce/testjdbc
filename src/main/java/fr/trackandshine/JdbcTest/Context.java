package fr.trackandshine.JdbcTest;



import java.util.HashMap;
import java.util.Optional;

/**
 * Created by developer on 1/11/17.
 */
public class Context {
    private Optional<Context> parent;
    private HashMap<String,String> ctxframe;
    public Context(){
        ctxframe = new HashMap<String,String>();
        parent =  Optional.empty();
    }

    public Optional<String> lookup(String s){
        if (ctxframe.containsKey(s)) {
            return Optional.of(ctxframe.get(s));
        }
        else {
           if (parent.isPresent()) {
                return parent.get().lookup(s);
            }
           return Optional.empty();
        }
    }

    public void Set(String k,String v){
        ctxframe.put(k,v);
    }

    public void Global(String k,String v){
        if (ctxframe.containsKey(k)) {
            ctxframe.put(k,v);
        }
        else {
            if (parent.isPresent()) {
                parent.get().Global(k,v);
            }
        }
    }
}
