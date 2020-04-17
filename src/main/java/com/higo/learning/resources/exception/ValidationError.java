package com.higo.learning.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    public static final long serialVersionUID = 1L;

    private final List<FieldMessage> list = new ArrayList<>();

    public ValidationError(Integer status, String msg, Long timeStamp) {
        super(status, msg, timeStamp);
    }

    public List<FieldMessage> getErros() {
        return list;
    }

    public void addError(String fieldName, String message) {
        list.add(new FieldMessage(fieldName, message));
    }
}
