package fr.trackandshine.JdbcTest;

import fr.trackandshine.JdbcTest.fr.trackandshine.utils.Helper;


/**
 * Created by developer on 1/9/17.
 */
public class Main {

    public static void main(String[] args) {
        String driverpath = Helper.findFileInPath("../..","postgresql-9.4.1212.jar").get();
        System.out.println("Using driver:--->"+ driverpath);

        System.out.println("**\t Posgresql connexion test ");
    String adriverpath = "//"+driverpath+"!/";
    String ssl = "false";
        String user="rdiusr02";
        String passwd="esuidt02";
        String aurl = "jdbc:postgresql://192.168.32.141:5432/pgres_rdi02";

        TestMyDriverConnexion dmt = new TestMyDriverConnexion();
        dmt.init(adriverpath, user, passwd, ssl ,aurl);
        if (dmt.doTest()) {

            System.out.println("SUCCESS ");
            System.exit(0);
        }else{
                System.out.println("FAIL ");
                System.exit(1);
        }
    }


}
