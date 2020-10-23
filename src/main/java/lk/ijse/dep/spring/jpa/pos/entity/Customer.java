package lk.ijse.dep.spring.jpa.pos.entity;

import lombok.*;

import javax.persistence.*;
@NamedQuery(name = "Customer.getCustomersViaNamedQuery",
        query = "SELECT c.address FROM Customer c WHERE c.address LIKE 'G%'")
@NamedNativeQuery(name = "Customer.getCustomersViaNamedNativeQuery",
        query = "SELECT c.address FROM Customer AS c WHERE c.address LIKE 'G%'")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Customer implements SuperEntity {
    @Id
    private String id;
    private String name;
    private String address;


    }


