package bradesco_java_bootcamp.controller.exception;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GlobalExceptionHandler {

	private final Logger logger  = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handlebussinessException(IllegalArgumentException bussinessException){
		return new ResponseEntity<>(bussinessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handle(NoSuchElementException bussinessException){
		return new ResponseEntity<>("Resource ID not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> handleunexpectedException(Throwable unexpectedException){
		var message = "Unexpected server error, see the logs.";
		logger.error(" " , unexpectedException );
		return new ResponseEntity<>("unexpected server error, see the logs", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
