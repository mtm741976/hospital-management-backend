package tn.imed.jaberi.hospitalmanagement.error;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice 
public class ApiExceptionsHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(ApiBaseException.class) // put all ex traited by this method .. 
	public ResponseEntity<ErrorDetails> handleApiExceptions(ApiBaseException ex, WebRequest request) {
		
		ErrorDetails details = new ErrorDetails(ex.getMessage(), request.getDescription(false)); // you can pass true .. 
		
		return new ResponseEntity<>(details, ex.getStatusCode());
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ValidationBodyError validationBodyError = new ValidationBodyError();
		validationBodyError.setUri(request.getDescription(false));

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        for(FieldError f: fieldErrors) {
        	validationBodyError.addError(f.getDefaultMessage());
        }
        
        return new ResponseEntity<>(validationBodyError, HttpStatus.BAD_REQUEST);
	}

	
}
