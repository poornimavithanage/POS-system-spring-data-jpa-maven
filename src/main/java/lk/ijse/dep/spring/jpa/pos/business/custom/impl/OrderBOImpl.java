package lk.ijse.dep.spring.jpa.pos.business.custom.impl;


import lk.ijse.dep.spring.jpa.pos.business.custom.OrderBO;
import lk.ijse.dep.spring.jpa.pos.repository.CustomerRepository;
import lk.ijse.dep.spring.jpa.pos.repository.ItemRepository;
import lk.ijse.dep.spring.jpa.pos.repository.OrderRepository;
import lk.ijse.dep.spring.jpa.pos.repository.OrderDetailRepository;

import lk.ijse.dep.spring.jpa.pos.entity.Item;
import lk.ijse.dep.spring.jpa.pos.entity.Order;
import lk.ijse.dep.spring.jpa.pos.entity.OrderDetail;
import lk.ijse.dep.spring.jpa.pos.util.OrderDetailTM;
import lk.ijse.dep.spring.jpa.pos.util.OrderTM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Component
@Transactional
public class OrderBOImpl implements OrderBO { // , Temp
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CustomerRepository customerRepository;

    // Interface through injection
/*    @Override
    public void injection() {
        this.orderRepository = DAOFactory.getInstance().getDAO(DAOType.ORDER);
    }  */

    // Setter method injection
/*    private void setOrderDAO(){
        this.orderRepository = DAOFactory.getInstance().getDAO(DAOType.ORDER);
    }*/
    @Transactional(readOnly = true)
    public String getNewOrderId() throws Exception {
        String lastOrderId = orderRepository.getFirstLastOrderIdByOrderByIdDesc().getId();
        if (lastOrderId == null) {
            return "OD001";
        } else {
            int maxId = Integer.parseInt(lastOrderId.replace("OD", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "OD00" + maxId;
            } else if (maxId < 100) {
                id = "OD0" + maxId;
            } else {
                id = "OD" + maxId;
            }
            return id;
        }
    }

    public void placeOrder(OrderTM order, List<OrderDetailTM> orderDetails) throws Exception {
        orderRepository.save(new Order(order.getOrderId(),
                Date.valueOf(order.getOrderDate()),
                customerRepository.findById(order.getCustomerId()).get()));

        for (OrderDetailTM orderDetail : orderDetails) {
            orderDetailRepository.save(new OrderDetail(
                    order.getOrderId(), orderDetail.getCode(),
                    orderDetail.getQty(), BigDecimal.valueOf(orderDetail.getUnitPrice())
            ));

            Item item = itemRepository.findById(orderDetail.getCode()).get();
            item.setQtyOnHand(item.getQtyOnHand() - orderDetail.getQty());

        }

    }
}
