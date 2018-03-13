package at.kuchel.controller.global;

import at.kuchel.exception.KuchelException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionControllerAdvice {

    @ExceptionHandler(KuchelException.class)
    protected ModelAndView handleException(KuchelException ex) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.setViewName("error/error");
        return modelAndView;
    }

    //todo use error code to show on errorpage

//    ErrorResponse errorResponse = errorResponseMapper.mapHttpStatusAndErrorMessage(ex.getErrorCode().getHttpStatus(),
//            ex.getLocalizedMessage(), new ErrorResponse());
//
//        return new ResponseEntity<>(errorResponse, new HttpHeaders(), ex.getErrorCode().getHttpStatus());

}
