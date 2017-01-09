package fr.trackandshine.JdbcTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by developer on 1/9/17.
 */
public class TestMyDriverConnexion {
    private String url;
    private Properties props;
    private String driverpath;

    public TestMyDriverConnexion(String adriverpath, String user, String password, String ssl, String aurl) {
        driverpath = adriverpath;
        url = aurl;
        props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);
        props.setProperty("ssl", ssl);
    }

    public boolean doTest() {
        URL u = null;
        try {
            u = new URL("jar:file:" + driverpath);

            String classname = "org.postgresql.Driver";
            URLClassLoader ucl = new URLClassLoader(new URL[]{u});
            Driver d = (Driver) Class.forName(classname, true, ucl).newInstance();
            DriverManager.registerDriver(new ProxyDriver(d));


            Connection conn = DriverManager.getConnection(url, props);

            return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return false;
    }
}
