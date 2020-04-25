package com.learn.springcloud.service.impl;

import com.learn.springcloud.dao.PaymentDao;
import com.learn.springcloud.entities.Payment;
import com.learn.springcloud.service.PaymentService;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author :   chenlong
 * @version :   1.0
 * @ClassName :    PaymentService$
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
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}