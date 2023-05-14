package com.java.CYJ_Board.exception;

import lombok.Getter;

public enum ExceptionCode {

    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    BOARD_NOT_FOUND(404, "Board Not Found"),
    BOARD_EXISTS(409, "Board exists");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
