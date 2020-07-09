package com.ddf.cloud.handbook.core.response;

import com.ddf.cloud.handbook.core.exception.BaseErrorCallbackCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 统一响应内容类
 *
 * _ooOoo_
 * o8888888o
 * 88" . "88
 * (| -_- |)
 * O\ = /O
 * ___/`---'\____
 * .   ' \\| |// `.
 * / \\||| : |||// \
 * / _||||| -:- |||||- \
 * | | \\\ - /// | |
 * | \_| ''\---/'' | |
 * \ .-\__ `-` ___/-. /
 * ___`. .' /--.--\ `. . __
 * ."" '< `.___\_<|>_/___.' >'"".
 * | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * \ \ `-. \_ __\ /__ _/ .-` / /
 * ======`-.____`-.___\_____/___.-`____.-'======
 * `=---='
 * .............................................
 * 佛曰：bug泛滥，我已瘫痪！
 *
 * @author dongfang.ding
 * @date 2019/6/27 11:17
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ResponseData<T> {

    /**
     * 返回消息代码
     */
    private String code;
    /**
     * 返回消息
     */
    private String message;
    /**
     * 错误堆栈信息
     */
    private String stack;
    /**
     * 响应时间
     */
    private long timestamp;
    /**
     * 返回数据
     */
    private T data;


    public ResponseData(String code, String message, String stack, long timestamp, T data) {
        this.code = code;
        this.message = message;
        this.stack = stack;
        this.timestamp = timestamp;
        this.data = data;
    }

    /**
     * 带参数的成功返回值
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseData<T> success(T data) {
        return new ResponseData<>(BaseErrorCallbackCode.COMPLETE.getCode(), BaseErrorCallbackCode.COMPLETE.getDescription()
                , "", System.currentTimeMillis(), data);
    }

    /**
     * 带参数的成功返回值
     * @param <T>
     * @return
     */
    public static <T> ResponseData<T> success() {
        return new ResponseData<>(BaseErrorCallbackCode.COMPLETE.getCode(), BaseErrorCallbackCode.COMPLETE.getDescription()
                , "", System.currentTimeMillis(), null);
    }


    /**
     * 带失败原因的的返回值
     * @param code
     * @param message
     * @param stack
     * @param <T>
     * @return
     */
    public static <T> ResponseData<T> failure(String code, String message, String stack) {
        return new ResponseData<>(code, message, stack, System.currentTimeMillis(), null);
    }


    /**
     * 判断当前请求结果是否成功
     * @return
     */
    public boolean isSuccess() {
        return BaseErrorCallbackCode.COMPLETE.getCode().equals(code);
    }
}
