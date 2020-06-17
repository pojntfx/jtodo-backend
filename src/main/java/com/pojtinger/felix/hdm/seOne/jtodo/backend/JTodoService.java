package com.pojtinger.felicitas.hdm.seOne.jtodo.backend;

import com.pojtinger.felicitas.hdm.seOne.jtodo.backend.Jtodo.NewTodo;
import com.pojtinger.felicitas.hdm.seOne.jtodo.backend.Jtodo.Todo;

import io.grpc.stub.StreamObserver;

public class JTodoService extends JTodoGrpc.JTodoImplBase {
    private JTodoCore core = new JTodoCore();

    @Override
    public void createTodo(NewTodo request, StreamObserver<Todo> responseObserver) {
        var newTodo = this.core.createTodo(request.getTitle(), request.getBody());

        responseObserver.onNext(Jtodo.Todo.newBuilder().setId(newTodo.getId()).setTitle(newTodo.getTitle())
                .setBody(newTodo.getBody()).build());

        responseObserver.onCompleted();
    }
}