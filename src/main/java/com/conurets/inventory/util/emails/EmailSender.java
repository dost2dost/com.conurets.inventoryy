package com.conurets.inventory.util.emails;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Dost M. Soomro on 4/25/2019.
 */
public class EmailSender {

    public String sendemail(String emailaddress, String Date)
    {

        final String username = "support@conurets.com";
        final String password = "koolkat4@";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "secure.emailsrvr.com");
        props.put("mail.smtp.port", "587");
        String result="";
//587
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("support@conurets.com"));
            // message.setRecipients(Message.RecipientType.CC,
            //          InternetAddress.parse("shujaat.khan@conurets.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailaddress));
            message.setSubject("Conure Marta");
            message.setContent(message, "text/html");




            Multipart multipart = new MimeMultipart();

            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText("The test","UTF-8");

            MimeBodyPart attachmentBodyPart= new MimeBodyPart();


            //FileSystemResource file = new FileSystemResource("C:\\log.txt");
            File file1=new File("E:\\Marta\\sample import file.xlsx");

            try {
                attachmentBodyPart.attachFile(file1);
            } catch (IOException e) {
                e.printStackTrace();
            }


            multipart.addBodyPart(textBodyPart);  // add the text part
            //multipart.addBodyPart(attachmentBodyPart); // add the attachement part
           // multipart.addBodyPart(attachmentBodyPart); // add the attachement part

            message.setContent(multipart);




            Transport.send(message);

            result="Ok";


            System.out.println("Done");
            /*
            conurets conditioned
             */



        } catch (MessagingException e) {
            result = "Authenticaion problem. Check email configuration.";
            throw new RuntimeException(e);


        }

        return result;
    }


}
