package com.example.demo.exceptionhandler;



import com.example.demo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("全局异常处理");
    }

    /**
     * 特定异常处理
     * @param e
     * @return
     */

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e){
        e.printStackTrace();
        return R.error().message("执行了ArithmeticException异常");
    }


    @ExceptionHandler(DiyException.class)
    @ResponseBody
    public R error(DiyException e){
        log.error(e.getMessage());
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }
}
