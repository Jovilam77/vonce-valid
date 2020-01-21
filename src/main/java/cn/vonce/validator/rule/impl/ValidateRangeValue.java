package cn.vonce.validator.rule.impl;

import cn.vonce.validator.annotation.VRangeValue;
import cn.vonce.validator.helper.ValidFieldHelper;
import cn.vonce.validator.model.FieldInfo;
import cn.vonce.validator.model.FieldResult;
import cn.vonce.validator.rule.ValidateRule;
import cn.vonce.validator.utils.ValidFieldUtil;
import org.apache.commons.lang.math.NumberUtils;

/**
 * 校验字段设置的值范围
 *
 * @author Jovi
 * @version 1.0
 * @email imjovi@qq.com
 * @date 2020/1/19 15:30
 */
public class ValidateRangeValue implements ValidateRule<VRangeValue> {

    @Override
    public FieldResult handle(VRangeValue valid, FieldInfo fieldInfo) {
        String anticipate = String.format("'设置的值范围max{%f},min{%f}'", valid.max(), valid.min());
        String tips = ValidFieldUtil.getTips(fieldInfo.getName(), valid.value(), anticipate);
        if (fieldInfo.getValue() == null) {
            return new FieldResult(fieldInfo.getName(), tips, "等于null");
        }
        ValidFieldHelper.WhatType whatType = ValidFieldHelper.whatType(fieldInfo.getValue().getClass().getSimpleName());
        if (whatType != ValidFieldHelper.WhatType.STRING_TYPE && whatType != ValidFieldHelper.WhatType.VALUE_TYPE) {
            return new FieldResult(fieldInfo.getName(), tips, "仅支持String和数值类型校验");
        }
        if (!NumberUtils.isNumber(fieldInfo.getValue().toString())) {
            return new FieldResult(fieldInfo.getName(), tips, "字符串内容为非法数值");
        }
        double value = Double.parseDouble(fieldInfo.getValue().toString());
        if (value > valid.max() || value < valid.min()) {
            return new FieldResult(fieldInfo.getName(), tips, ValidFieldUtil.getError(anticipate));
        }
        return new FieldResult(true, fieldInfo.getName());
    }

}
