package fr.trackandshine.JdbcTest;

import java.io.File;


/**
 * Created by developer on 1/9/17.
 */
public class Main {
    public static String findDriver(String path,String name){
            System.out.println(path);
            File f = new File(path);
         //  System.out.println("--"+f.getName()+"|||||||||"+name);
            if (f.getName().compareToIgnoreCase(name)==0)
                return f.getAbsolutePath();


            if (f.isDirectory()) {
                File files[] = f.listFiles();
                for  (int i=0;i<files.length;i++){
                  String ret =  findDriver(files[i].getAbsolutePath(),name);
                    if (ret.compareTo("")!=0)
                        return ret;
            }
        }
        return "";
    }
    public static void main(String[] args) {
        String driverpath = findDriver("..","postgresql-9.4.1212.jar");
        System.out.println("Using driver:--->"+ driverpath);

        System.out.println("**\t Posgresql connexion test ");
    String adriverpath = "//"+driverpath+"!/";
    String ssl = "false";
        String user="rdiusr02";
        String passwd="esuidt02";
        String aurl = "jdbc:postgresql://192.168.32.141:5432/pgres_rdi02";

        TestMyDriverConnexion dmt = new TestMyDriverConnexion(adriverpath, user, passwd, ssl ,aurl);
        if (dmt.doTest()) {

            System.out.println("SUCCESS ");
            System.exit(0);
        }else{
                System.out.println("FAIL ");
                System.exit(1);
        }
    }


}
