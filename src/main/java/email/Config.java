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

            System.out.println("————————————–————————————–————————————–—————————————–");
            System.out.println("Email");

            mail_smtp_host = "smtp.gmail.com";
            mail_smtp_socketFactory_port = "465";
            mail_smtp_socketFactory_class = "javax.net.ssl.SSLSocketFactory";
            mail_smtp_auth = "true";
            mail_smtp_port = "465";
            mail_userAuthentication = "thiago.sc.devops@gmail.com";
            mail_passwordAuthentication = "Nexxera2020";
            mail_sender = "thiago.sc.devops@gmail.com";
            mail_to_user = "thiago.sc@outlook.com";

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
