package com.JuhAmil.Lista.de.Vendas.exception;

public class ApiResponse {
    private int status;
    private String message;
    private String error;

    public ApiResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }       	

	public ApiResponse(int status, String message, String error) {
		super();
		this.status = status;
		this.message = message;
		this.error = error;
	}


	public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
    public String getError() {
		return error;
	}
}
