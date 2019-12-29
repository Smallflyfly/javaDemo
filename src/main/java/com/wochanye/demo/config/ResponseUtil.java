package com.wochanye.demo.config;

import com.wochanye.demo.constant.meta.ResponseEnum;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author fangpf
 * @data 2019/12/27 15:34
 */
public class ResponseUtil {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(ResponseUtil.class);

    private static final String LIST_KEY = "list";

    /**
     * 操作成功默认返回
     */
    public static Result operateSuccess(){
        Result result = new Result(true);
        result.setCode(ResponseEnum.OPERATION_SUCCESS.getCode());
        result.setMessage(ResponseEnum.OPERATION_SUCCESS.getMessage());
        return result;
    }

    /**
     * 操作成功返回具体数据
     */
    public static <T> Result<T> operateSuccess(T data){
        Result<T> result = new Result<>(true);
        result.setCode(ResponseEnum.OPERATION_SUCCESS.getCode());
        result.setMessage(ResponseEnum.OPERATION_SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    /**
     * 操作失败返回
     */
    public static Result operateFail(){
        Result result = new Result(false);
        result.setCode(ResponseEnum.OPERATION_FAIL.getCode());
        result.setMessage(ResponseEnum.OPERATION_FAIL.getMessage());
        return result;
    }

    /**
     * 操作失败 自定义返回错误代码 和 错误信息
     */
    public static Result operateFail(int code, String errorMessage){
        Result result = new Result(false);
        result.setCode(code);
        result.setMessage(errorMessage);
        return result;
    }

    /**
     * 数组数据返回 再封装一层对象
     */
    public static <T> Map<String, T> getListResultData(String key, T data){
        Map<String, T> result = new HashMap<>(1<<2);
        result.put(key, data);
        return result;
    }

    /**
     * 返回数据指定具体Key值
     */
    public static <T> Result<Map<String, T>> getInfoListSuccess(String key, T data){
        Result<Map<String, T>> result = new Result<>(true);
        result.setCode(ResponseEnum.OPERATION_SUCCESS.getCode());
        result.setMessage(ResponseEnum.OPERATION_SUCCESS.getMessage());
        result.setData(getListResultData(key, data));
        return result;
    }

    /**
     * 分页查询结果封装
     */
    public static <T> PageResult<Map<String, T>> getInfoPageListSuccess(int total, String key, T data){
        PageResult<Map<String, T>> pageResult = new PageResult<>(true);
        pageResult.setTotal(total);
        pageResult.setCode(ResponseEnum.OPERATION_SUCCESS.getCode());
        pageResult.setMessage(ResponseEnum.OPERATION_SUCCESS.getMessage());
        pageResult.setData(getListResultData(key, data));
        return pageResult;
    }

    /**
     * 分页查询结果封装 key统一用
     */
    public static <T> PageResult<Map<String, T>> getInfoPageListSuccess(int total, T data){
        return getInfoPageListSuccess(total, LIST_KEY, data);
    }
}
