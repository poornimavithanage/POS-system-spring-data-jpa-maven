package lk.ijse.dep.spring.jpa.pos.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
@NamedNativeQuery(name = "Item.getItemsViaNativeQuery",query =
        "SELECT i.description FROM Item AS i WHERE i.description LIKE CONCAT(:query,'%') AND i.qtyOnHand> :qty")
@NamedQuery(name = "Item.getItemsViaNamedQuery",
        query = "SELECT i.description FROM lk.ijse.dep.spring.jpa.pos.entity.Item i WHERE i.description LIKE CONCAT(?1,'%') " +
                "AND i.qtyOnHand> ?2")
@NamedQuery(name = "Item.getItemsViaNamedQuery2",
        query = "SELECT i.code AS code,i.description AS description FROM lk.ijse.dep.spring.jpa.pos.entity.Item i WHERE i.description LIKE CONCAT(?1,'%') " +
                "AND i.qtyOnHand> ?2")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Item implements SuperEntity {
    @Id
    private String code;
    private String description;
    private BigDecimal unitPrice;
    private int qtyOnHand;


}
