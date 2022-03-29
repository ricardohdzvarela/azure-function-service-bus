package com.globant;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.ServiceBusQueueTrigger;

public class QueueTriggerFunction {

    @FunctionName("sbprocessor")
    public void serviceBusProcess(
            @ServiceBusQueueTrigger(name = "msg",
                    queueName = "users",
                    connection = "AzureWebJobsServiceBus") String message,
            final ExecutionContext context
    ) {
        context.getLogger().info(message);
    }

}
