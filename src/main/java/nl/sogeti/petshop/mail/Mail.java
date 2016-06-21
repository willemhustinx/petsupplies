package nl.sogeti.petshop.mail;

import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class Mail {

    private Session session;

    public void send(String addresses, String topic, String textMessage) {

        try {
            session = (Session) new InitialContext().lookup("java:jboss/mail/Gmail");
            Message message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(addresses));
            message.setSubject(topic);
            message.setText(textMessage);

            Transport.send(message);

        } catch (MessagingException e) {
            Logger.getLogger(Mail.class.getName()).log(Level.WARNING, "Cannot send mail", e);
        } catch (NamingException e) {
            Logger.getLogger(Mail.class.getName()).log(Level.WARNING, "Name issue", e);
        }
    }

}