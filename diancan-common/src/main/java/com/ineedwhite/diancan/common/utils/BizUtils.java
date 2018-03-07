package com.ineedwhite.diancan.common.utils;

import com.ineedwhite.diancan.common.ErrorCodeEnum;
import com.ineedwhite.diancan.common.constants.DcException;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author ruanxin
 * @create 2018-03-07
 * @desc
 */
public class BizUtils {

    private final static Logger logger = Logger.getLogger(BizUtils.class);
    /**
     * 检查必须的入参是否满足不可空
     * @param paramMap 参数列表
     */
    public static void checkMustParam(Map<String, String> paramMap, String[] mustParaArr) {
        if (mustParaArr == null || mustParaArr.length == 0) {
            return ;
        }

        for (String param : mustParaArr) {
            if (StringUtils.isEmpty(param)) {
                continue;
            }
            if (StringUtils.isEmpty(paramMap.get(param))) {
                logger.warn("checkMustParam failed for:" + param);
                throw new DcException(ErrorCodeEnum.DC00001, param);
            }
        }
    }
    /**
     * 把HttpServletRequest对象的getParameterMap返回对象转换为java.util.Map对象
     * @param requestPara
     * @return
     */
    public static Map<String, String> getMapFromRequestMap(Map<String, String[]> requestPara) {
        Map<String, String> paraMap = new HashMap<String, String>();
        Iterator<Map.Entry<String, String[]>> it = requestPara.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String[]> entry = it.next();
            String key = entry.getKey();
            String[] values = entry.getValue();
            if (values != null && values.length >= 1) {
                paraMap.put(key, values[0]);
            }
        }

        return paraMap;
    }
}