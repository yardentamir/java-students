package com.handson.basic.util;

import java.io.IOException;

import com.handson.basic.model.EmailMessage;
import com.postmarkapp.postmark.client.ApiClient;
import com.postmarkapp.postmark.client.data.model.message.Message;
import com.postmarkapp.postmark.client.data.model.message.MessageResponse;
import com.postmarkapp.postmark.client.exception.PostmarkException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
    private static final String FROM = "yarden.tamir@walla.co.il";
    private static final String TO = "yarden.tamir@walla.co.il";
    private final ApiClient apiClient;

    @Autowired
    public EmailService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public String sendEmail(EmailMessage emailMessage) {
            Message message = new Message(FROM, TO, emailMessage.getSubject(), emailMessage.getMessage());
        try {
            MessageResponse response = apiClient.deliverMessage(message);
            return response.getMessage();
        } catch (PostmarkException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
