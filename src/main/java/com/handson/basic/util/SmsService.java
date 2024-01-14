package com.handson.basic.util;

import com.handson.basic.model.MessageAndPhones;
import okhttp3.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


// copied from documentation https://www.sms4free.co.il/outcome-sms-api.html
@Service
public class SmsService {
    //Overloaded constructor to send a message to both a phone number and an email address.
    @Value("${sms.ms.url}")
    String SMS_MS_URL;
    protected final Log logger = LogFactory.getLog(getClass());
    @Autowired
    RestTemplate rTemplate;

    public String send(MessageAndPhones messageAndPhones) {
        return rTemplate.postForObject(SMS_MS_URL + "/api/sms/", messageAndPhones, String.class);
    }

}