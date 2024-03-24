package com.ffp.demo;
import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleException(Exception e) {
        Response r = new Response();
        r.setErrCode("1000");
        r.setErrMessage("error Exception");
        return new ResponseEntity<>(r, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ResponseEntity<Object> handleException404(Exception e) {
        Response r = new Response();
        r.setErrCode("404");
        r.setErrMessage("error Exception");
        return new ResponseEntity<>(r, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 你可以为特定的异常定义单独的处理器
//    @ExceptionHandler(value = CustomException.class)
//    @ResponseBody
//    public ResponseEntity<Object> handleCustomException(CustomException e) {
//        return new ResponseEntity<>(new ApiError("Custom Error", e.getMessage()), HttpStatus.BAD_REQUEST);
//    }
}
