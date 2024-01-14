package com.handson.basic.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class EmailMessage implements Serializable {
    @NotBlank
    @Size(min = 10, max = 200)
    private String subject;
    @NotBlank
    @Size(min = 10, max = 200)
    private String message;

    public EmailMessage(String subject, String message) {
        this.subject = subject;
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

}
