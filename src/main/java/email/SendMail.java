package email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail {

    public void send(String subject, String text) {

        Properties props = new Properties();

        props.put("mail.smtp.host", Config.mail_smtp_host);
        props.put("mail.smtp.socketFactory.port", Config.mail_smtp_socketFactory_port);
        props.put("mail.smtp.socketFactory.class", Config.mail_smtp_socketFactory_class);
        props.put("mail.smtp.auth", Config.mail_smtp_auth);
        props.put("mail.smtp.port", Config.mail_smtp_port);

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Config.mail_userAuthentication, Config.mail_passwordAuthentication);
            }
        });

        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Config.mail_sender));
            Address[] toUser = InternetAddress.parse(Config.mail_to_user);
            message.setRecipients(Message.RecipientType.TO, toUser);

            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);

            System.out.println();
            System.out.println("Email enviado com sucesso para: "+ Config.mail_sender);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

}