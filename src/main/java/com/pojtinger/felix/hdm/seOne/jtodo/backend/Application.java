package com.pojtinger.felix.hdm.seOne.jtodo.backend;

import java.io.IOException;

import io.grpc.ServerBuilder;

public class Application {
    public static void main(String[] args) throws InterruptedException, IOException {
        var portFlag = System.getenv("PORT");

        final int port;
        if (portFlag == null) {
            port = 1999;
        } else {
            port = Integer.valueOf(portFlag);
        }

        System.out.printf("Starting JTodo Backend on port %d\n", port);

        ServerBuilder.forPort(port).addService(new JTodoService()).build().start().awaitTermination();
    }
}