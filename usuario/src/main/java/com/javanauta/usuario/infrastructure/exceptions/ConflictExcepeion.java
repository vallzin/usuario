package com.javanauta.usuario.infrastructure.exceptions;

public class ConflictExcepeion extends RuntimeException {
    public ConflictExcepeion(String msg) {
        super(msg);
    }
    public ConflictExcepeion(String msg, Throwable throwable){super(msg);};
}
