package com.ddf.cloud.handbook.core.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.ddf.cloud.handbook.core.config.GlobalProperties;
import com.ddf.cloud.handbook.core.helper.SpringContextHolder;

/**
 * ID生成器$
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
 * @date 2019/12/9 0009 11:35
 */
public class IdsUtil {

    private final static GlobalProperties GLOBAL_PROPERTIES = SpringContextHolder.getBean(GlobalProperties.class);

    /**
     * 获取string格式的id
     *
     * @return void
     * @author dongfang.ding
     * @date 2019/12/9 0009 11:38
     **/
    public static String getNextStrId() {
        Snowflake snowflake = IdUtil.getSnowflake(GLOBAL_PROPERTIES.getSnowflakeWorkerId(),
                GLOBAL_PROPERTIES.getSnowflakeDataCenterId());
        return snowflake.nextIdStr();
    }

    /**
     * 获取long类型的id
     * @return void
     * @author dongfang.ding
     * @date 2019/12/9 0009 11:39
     **/
    public static long getNextLongId() {
        Snowflake snowflake = IdUtil.getSnowflake(GLOBAL_PROPERTIES.getSnowflakeWorkerId(),
                GLOBAL_PROPERTIES.getSnowflakeDataCenterId());
        return snowflake.nextId();
    }

}
