package com.globant;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.ServiceBusTopicTrigger;

public class TopicTriggerFunction {

    @FunctionName("sbtopicprocessor")
    public void run(
            @ServiceBusTopicTrigger(
                    name = "message",
                    topicName = "users-topic",
                    subscriptionName = "user-subscription",
                    connection = "AzureWebJobsServiceBus"
            ) String message,
            final ExecutionContext context
    ) {
        context.getLogger().info(message);
    }

}