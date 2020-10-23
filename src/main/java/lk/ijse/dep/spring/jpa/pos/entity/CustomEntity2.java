package lk.ijse.dep.spring.jpa.pos.entity;

import java.math.BigDecimal;
import java.sql.Date;

public interface CustomEntity2 {
    String getOrderId();
    Date getOrderDate();
    String getCustomerId();
    String getCustomerName();
    BigDecimal getOrderTotal();
}
