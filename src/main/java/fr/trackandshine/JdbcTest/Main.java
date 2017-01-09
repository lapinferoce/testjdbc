package fr.trackandshine.JdbcTest;

import java.awt.peer.SystemTrayPeer;
/**
 * Created by developer on 1/9/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("**\t Posgresql connexion test ");
    String adriverpath = "///home/developer/jdbc/postgresql-9.4.1212.jar!/";
    String ssl = "false";
        String user="root";
        String passwd="";
        String aurl = "jdbc:postgresql://db:5432/db";


        DoMyTest dmt = new DoMyTest(adriverpath, user, passwd, ssl ,aurl);
        if (dmt.doTest()) {

            System.out.println("SUCCESS ");
            System.exit(0);
        }else{
                System.out.println("FAIL ");
                System.exit(1);
        }
    }


}
