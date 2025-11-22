package io.github.fps.istore.orders.model.exception;

public class ItemNotFoundException extends  RuntimeException{
    public ItemNotFoundException(String message) {
        super(message);
    }
}
