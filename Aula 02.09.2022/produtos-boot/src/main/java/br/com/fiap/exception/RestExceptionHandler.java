package br.com.fiap.exception;

import java.util.HashMap;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
	
	private static final String UNEXPECTED_ERROR = 
			"Um erro inesperado aconteceu, contate o suporte em suporte-api@fiap.com.br";

	private static final String RESOURCE_NOT_FOUND = "Recurso n?o encontrado";
	
	@ExceptionHandler(value = {NoSuchElementException.class})
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseException notFoundException(HttpServletRequest request, Exception exception){
			return new ResponseException(request, RESOURCE_NOT_FOUND, exception.getMessage());}
	
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseException handleException(HttpServletRequest request, Exception exception){
		return new ResponseException(request, UNEXPECTED_ERROR, exception.getMessage());
		
	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)	
	public ResponseException badRequestException(HttpsServletRequest request, HttpMessageNotReadableException exception) {
		return new ResponseException(request, INVALID_JSON, exception.getMessage());
	}
	
	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseException badRequestException(HttpServletRequest request, HttpRequestMethodNotSupportedException exception){
		return new ResponseException(request, METHOD_NOT_SUPORTED, exception.getMessage());
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseException badRequestException(HttpServletRequest request,
			MethodArgumentNotValidException exception) {
	
		List<FieldError> errors = exception.getBindingResult().get
	}
}
}

