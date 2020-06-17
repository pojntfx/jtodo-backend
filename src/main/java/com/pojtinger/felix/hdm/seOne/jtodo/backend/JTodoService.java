package com.pojtinger.felicitas.hdm.seOne.jtodo.backend;

import com.google.protobuf.Empty;
import com.pojtinger.felicitas.hdm.seOne.jtodo.backend.Jtodo.NewTodo;
import com.pojtinger.felicitas.hdm.seOne.jtodo.backend.Jtodo.Todo;
import com.pojtinger.felicitas.hdm.seOne.jtodo.backend.Jtodo.TodoList;

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

    @Override
    public void listTodos(Empty request, StreamObserver<TodoList> responseObserver) {
        var todos = this.core.getTodos();

        var response = Jtodo.TodoList.newBuilder();

        for (var internalTodo : todos) {
            var externalTodo = Jtodo.Todo.newBuilder().setId(internalTodo.getId()).setTitle(internalTodo.getTitle())
                    .setBody(internalTodo.getBody()).build();

            response.addTodos(externalTodo);
        }

        responseObserver.onNext(response.build());

        responseObserver.onCompleted();
    }
}