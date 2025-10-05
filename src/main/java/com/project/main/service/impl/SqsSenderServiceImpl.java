package com.project.main.service.impl;

import com.project.main.service.SqsSenderService;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@Service
@RequiredArgsConstructor
public class SqsSenderServiceImpl implements SqsSenderService {

    private final SqsAsyncClient sqsAsyncClient;

    @Value("${cloud.aws.end-point.uri}")
    private String  queueUrl;
    

    @Override
    public void sendMessage(String message) {
        sqsAsyncClient.sendMessage(req -> req
                .queueUrl(queueUrl)
                .messageBody(message)
        );
    }

    @SqsListener("sqs-queue")
    void sqsListener(String message){
        System.out.println("received message from queue:"+message);
    }
}
