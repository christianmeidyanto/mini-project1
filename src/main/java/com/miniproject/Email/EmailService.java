package com.miniproject.Email;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // Send email
    public void sendEmailAttachment(final String subject, final String message,
            final String toEmailAddresses, final boolean isHtmlMail, final File attachment) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom("christianmeidyanto214@gmail.com");
            helper.setTo(toEmailAddresses);
            helper.setSubject(subject);

            if (isHtmlMail) {
                helper.setText("<html><body>" + message + "</html></body>", true);
            } else {
                helper.setText(message);
            }

            // attach the file into email body
            FileSystemResource file = new FileSystemResource(attachment);
            helper.addAttachment(attachment.getName(), file);

            mailSender.send(mimeMessage);

            System.out.println("Email sending complete.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
