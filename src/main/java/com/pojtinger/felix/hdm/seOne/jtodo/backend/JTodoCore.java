package com.pojtinger.felicitas.hdm.seOne.jtodo.backend;

import java.util.ArrayList;
import java.util.List;

public class JTodoCore {
    private List<Todo> todos = new ArrayList<Todo>();

    public Todo createTodo(String title, String body) {
        var newTodo = new Todo(title, body);

        this.todos.add(newTodo);

        return newTodo;
    }
}