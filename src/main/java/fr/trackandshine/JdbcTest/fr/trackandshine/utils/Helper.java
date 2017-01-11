package fr.trackandshine.JdbcTest.fr.trackandshine.utils;

import jdk.nashorn.internal.runtime.options.Option;

import java.io.File;
import java.util.Optional;

/**
 * Created by developer on 1/11/17.
 */
public class Helper {

    public static Optional<String> findFileInPath(String path, String name){
        System.out.println(path);
        File f = new File(path);
        //  System.out.println("--"+f.getName()+"|||||||||"+name);
        if (f.getName().compareToIgnoreCase(name)==0)
            return Optional.of(f.getAbsolutePath());


        if (f.isDirectory()) {
            File files[] = f.listFiles();
            for  (int i=0;i<files.length;i++){
                Optional<String> ret =  findFileInPath(files[i].getAbsolutePath(),name);
                if ((ret.isPresent())&&(ret.get().compareTo("")!=0))
                    return ret;
            }
        }
        return Optional.empty();
    }

}
