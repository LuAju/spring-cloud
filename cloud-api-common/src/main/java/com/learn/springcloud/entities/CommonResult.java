package com.learn.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author :   chenlong
 * @version :   1.0
 * @ClassName :    CommonResult$
 * @Description :   TODO(用一句话描述该类做什么)
 * @projectname :   nebula
 * @DATE :   Created in 11:36$ 2020/3/18$
 *
 * <pre>       Copyright: Copyright(c)2019     </pre>
 * <pre>       Company :   unittec             </pre>
 * Modification  History:
 * Date         Author        Version        Discription
 * -----------------------------------------------------------------------------------
 * 2020/3/18$       chenlong        1.0             1.0
 * Why & What is modified: <修改原因描述>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>  {
    private Integer code;
    private String message;
    private T data;

    public CommonResult ( Integer code, String message) {
        this(code, message, null);
    }
}