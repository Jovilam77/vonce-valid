package cn.vonce.validator.annotation;

import cn.vonce.validator.rule.impl.ValidateMaxValue;

import java.lang.annotation.*;

/**
 * 校验设置的最大值
 * 
 * @author jovi
 * @email 766255988@qq.com
 * @version 1.0
 * @date 2017年4月21日上午10:47:13
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Documented
@Validate(type = ValidateMaxValue.class)
public @interface VMaxValue {

	/**
	 * 字段名称
	 * 
	 * @author jovi
	 * @date 2017年4月21日上午11:56:34
	 * @return
	 */
	String name() default "";

	/**
	 * 字段最大值
	 * 
	 * @author jovi
	 * @date 2017年4月21日上午10:48:19
	 * @return
	 */
	double val();

	/**
	 * 消息提示
	 * 
	 * @author jovi
	 * @date 2017年4月21日上午10:48:29
	 * @return
	 */
	String value() default "";
	
	/**
	 * 分组校验
	 * 
	 * @author Jovi
	 * @date 2017年6月21日下午12:07:25
	 * @return
	 */
	String[] group() default "";

}
