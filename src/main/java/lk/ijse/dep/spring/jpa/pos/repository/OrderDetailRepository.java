package lk.ijse.dep.spring.jpa.pos.repository;

import lk.ijse.dep.spring.jpa.pos.entity.OrderDetail;
import lk.ijse.dep.spring.jpa.pos.entity.OrderDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailPK> {

}
