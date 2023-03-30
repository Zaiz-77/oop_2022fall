package com.oop.review;

import java.util.*;

public class MyException extends Exception {
    private String msg;
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
