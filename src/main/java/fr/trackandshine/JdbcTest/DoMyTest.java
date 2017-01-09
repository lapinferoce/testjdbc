package fr.trackandshine.JdbcTest;

import java.sql.Connection;
import java.util.Properties;

/**
 * Created by developer on 1/9/17.
 */
public class DoMyTest {
    private String url;
    private Properties props;


    public DoMyTest(String user, String password, String ssl, String aurl) {
        url = aurl
        props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);
        props.setProperty("ssl", ssl);
    }

    plublic Boolean

    DoMyTest() {
        // String url = "jdbc:postgresql://localhost/test";

        Connection conn = DriverManager.getConnection(url, props);

        String url = "jdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true";
        Connection conn = DriverManager.getConnection(url);

        return false;
    }
}
