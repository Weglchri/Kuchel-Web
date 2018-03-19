package at.kuchel.controller.global;

import at.kuchel.exception.KuchelException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(KuchelException.class)
    protected ModelAndView handleKuchelException(KuchelException klex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", klex);
        modelAndView.setViewName("error/kuchelerror");
        return modelAndView;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleNotFoundException(final NoHandlerFoundException nhfex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", nhfex);
        modelAndView.setViewName("error/notfoundexception");
        return modelAndView;
    }

    @ExceptionHandler(Throwable.class)
    public ModelAndView handleGeneralException(final Throwable throwable) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("throwable", throwable);
        modelAndView.setViewName("error/generalerror");
        return modelAndView;
    }

}
