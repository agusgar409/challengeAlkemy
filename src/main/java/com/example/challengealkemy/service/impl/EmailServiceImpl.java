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

import java.io.IOException;


public class EmailServiceImpl implements EmailService {
    @Autowired
    Environment environment;

    @Value("$(challengealkemy.movies.email.sender)")
    private String emailSender;

    @Value("$(challengealkemy.movies.email.enable)")
    private boolean enable;

    @Override
    public void sendWelcomeEmailTo(String username) {
        if(!enable){
            return;
        }
                                                //preguntar al prfe como agregar el codigo de send grid a la palabra
        String apiKey = environment.getProperty("EMAIL_API_KEY");

        Email fromEmail = new Email();
        Email toEmail = new Email();
        Content content = new Content(
                "text/plain","Bienvenido/a a Disney!!"
        );
        String subject = "Disney Alkemy";

        Mail mail = new Mail(fromEmail,subject,toEmail,content);
        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();
        try{
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
        } catch (IOException e) {
            System.out.println("error trying to send mail");
            e.printStackTrace();
        }
    }
}
