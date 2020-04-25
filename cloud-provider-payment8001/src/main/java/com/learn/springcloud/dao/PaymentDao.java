package com.learn.springcloud.dao;

import com.learn.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author :   chenlong
 * @version :   1.0
 * @ClassName :    PaymentDao$
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
@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}