package com.sky.handler;

import com.sky.constant.MessageConstant;
import com.sky.exception.BaseException;
import com.sky.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler(BaseException ex, HttpServletRequest request){
        log.error("异常信息：{}", ex.getMessage());
        return errorResult(ex.getMessage(), request);
    }

    /*
    处理SQL异常
     */
    @ExceptionHandler
    public Result exceptionHandler(SQLIntegrityConstraintViolationException ex, HttpServletRequest request){
        String message = ex.getMessage();
        if (message.contains("Duplicate entry")) {
            String[] split = message.split(" ");
            String username = split[2];
            String msg = username+ MessageConstant.ALREADY_EXIST;
            return errorResult(msg, request);
        }else {
            return errorResult(MessageConstant.UNKNOWN_ERROR, request);
        }
    }

    /**
     * 小程序请求工具只在响应体 code 为 200 或 1 时 resolve，其余一律 reject；
     * 而页面的 .then 只在 code!=1 时弹窗展示 msg，且没有 .catch，reject 会被静默吞掉、按钮卡死。
     * 因此用户端(/user/**)的业务异常也返回 code=200，前端才能读到 msg 并弹窗提示。
     */
    private Result errorResult(String msg, HttpServletRequest request){
        Result result = Result.error(msg);
        if (request != null && request.getRequestURI() != null
                && request.getRequestURI().startsWith("/user/")) {
            result.setCode(200);
        }
        return result;
    }
}
