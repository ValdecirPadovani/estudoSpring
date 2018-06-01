package br.com.devmedia.curso.exception;

public class IdNaoValidoServerException extends RuntimeException {

    public IdNaoValidoServerException(String message) {
        super(message);
    }
}
