package com.sunny.grpc.client;

import com.sunny.grpc.Request;
import com.sunny.grpc.Response;
import com.sunny.grpc.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GRPCClientController {
    private static  final Logger LOGGER = LoggerFactory.getLogger(GRPCClientController.class);

    @GetMapping("/")
    public String getGrpcResponse() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();
        userGrpc.userBlockingStub userBlockingStub = userGrpc.newBlockingStub(managedChannel);
        Request request = Request.newBuilder().setUsername("Admin").setPassword("Admin").build();
        Response response = userBlockingStub.login(request);
        LOGGER.info("Response -->  ", request, response);
        return response.getStatusCode()+" : "+response.getStatusDescription();
    }
}
