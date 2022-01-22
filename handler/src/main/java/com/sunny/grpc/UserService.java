package com.sunny.grpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class UserService extends userGrpc.userImplBase {
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    public void login(Request request, StreamObserver<Response> responseObserver) {

        logger.info("Request --> " + request);
        Response response = null;
        if (request.getUsername().equals(request.getPassword())) {
            response = Response.newBuilder()
                    .setStatusCode(200)
                    .setStatusDescription("Successfully LoggedIn")
                    .build();
        } else {
            response = Response.newBuilder()
                    .setStatusCode(401)
                    .setStatusDescription("Invalid Credentials")
                    .build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}