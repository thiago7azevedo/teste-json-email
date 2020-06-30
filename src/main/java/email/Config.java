package email;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    public static String mail_smtp_host;
    public static String mail_smtp_socketFactory_port;
    public static String mail_smtp_socketFactory_class;
    public static String mail_smtp_auth;
    public static String mail_smtp_port;
    public static String mail_userAuthentication;
    public static String mail_passwordAuthentication;
    public static String mail_sender;
    public static String mail_to_user;

    public static void loadConfig() {

        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("/tmp/config.properties");

            prop.load(input);

            System.out.println("————————————–————————————–————————————–—————————————–");
            System.out.println("Email");

            mail_smtp_host = prop.getProperty("mail_smtp_host");
            mail_smtp_socketFactory_port = prop.getProperty("mail_smtp_socketFactory_port");
            mail_smtp_socketFactory_class = prop.getProperty("mail_smtp_socketFactory_class");
            mail_smtp_auth = prop.getProperty("mail_smtp_auth");
            mail_smtp_port = prop.getProperty("mail_smtp_port");
            mail_userAuthentication = prop.getProperty("mail_userAuthentication");
            mail_passwordAuthentication = prop.getProperty("mail_passwordAuthentication");
            mail_sender = prop.getProperty("mail_sender");
            mail_to_user = prop.getProperty("mail_to_user");

            System.out.println(mail_smtp_host);
            System.out.println(mail_smtp_socketFactory_port);
            System.out.println(mail_smtp_socketFactory_class);
            System.out.println(mail_smtp_auth);
            System.out.println(mail_smtp_port);
            System.out.println(mail_userAuthentication);
            System.out.println(mail_passwordAuthentication);
            System.out.println(mail_sender);
            System.out.println(mail_to_user);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
