package com.example.challengealkemy.service.impl;

import com.example.challengealkemy.service.EmailService;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    Environment environment;

    @Value("${challengeAlkemy.movies.email.sender}")
    private String emailSender;

    @Value("${challengeAlkemy.movies.email.enable}")
    private boolean enable;

    public void sendWelcomeEmailTo(String username) {
        if(!enable){
            return;
        }

        Email fromEmail = new Email(emailSender);
        Email toEmail = new Email(username);

        creationOfMail(fromEmail,toEmail);
    }

    private void creationOfMail(Email fromEmail, Email toEmail){

        String apiKey = environment.getProperty("EMAIL_API_KEY");

        Content content = new Content(
                "text/plain","Bienvenido/a a Disney!!"
        );
        String subject = "Disney Alkemy";

        Mail mail = new Mail(fromEmail,subject,toEmail,content);
        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();

        functionalCheck(mail,sg,request);
    }

    private void functionalCheck(Mail mail, SendGrid sendGrid, Request request){
        try{
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            //Response response = sendGrid.api(request);

            //comprobar con una libreria log4j para sacar estos printl
            //System.out.println(response.getStatusCode());
            //System.out.println(response.getBody());
            //System.out.println(response.getHeaders());

        } catch (IOException e) {
            System.out.println("error trying to send mail");
            e.printStackTrace();
        }
    }
}
