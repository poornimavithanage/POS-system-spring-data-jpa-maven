package lk.ijse.dep.spring.jpa.pos.repository;

import lk.ijse.dep.spring.jpa.pos.entity.CustomEntity;
import lk.ijse.dep.spring.jpa.pos.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, String> {

    Item getFirstLastItemCodeByOrderByCodeDesc() throws Exception;

    List<Item> findAllItemsByUnitPriceGreaterThan(BigDecimal price) throws Exception;

    List<Item> findAllItemsByQtyOnHandLessThanAndUnitPriceGreaterThan(int qtyOnHand, BigDecimal unitPrice) throws Exception;

    //    @Query(value = "SELECT * FROM Item i WHERE i.qtyOnHand<50",nativeQuery = true)
    @Query(value = "SELECT i FROM Item i WHERE i.qtyOnHand<50")
    //JPQL
    List<Item> findAllItemsLessThan50() throws Exception;

    //    @Query(value = "SELECT i.description FROM Item i WHERE i.unitPrice > ?1",nativeQuery = true) //normal way in positional parameter
    //    @Query(value = "SELECT i.description FROM Item i WHERE i.unitPrice > :abc",nativeQuery = true)//normal way in name parameters
    //    List<String>getItems2(BigDecimal unitPrice)throws Exception;
    //    @Query(value = "SELECT i.description FROM Item i WHERE i.unitPrice > :#{#abc}",nativeQuery = true)// SpEL way in name parameters
    @Query(value = "SELECT i.description FROM Item i WHERE i.unitPrice > ?#{[0]}", nativeQuery = true) //SpEL way in positional parameters
    List<String> getItems2(@Param("abc") BigDecimal unitPrice) throws Exception;

    @Query(value = "SELECT * FROM Item i WHERE i.qtyOnHand < ?#{T(lk.ijse.dep.spring.jpa.pos.util.DEPUtil).getQtyOnHand()}",nativeQuery = true)
    List<Item> getItems3()throws Exception;

    List<String> getItemsViaNativeQuery(@Param("query") String description, @Param("qty") int qty) throws Exception;

    List<String> getItemsViaNamedQuery(String description, int qty) throws Exception;

    List<CustomEntity> getItemsViaNamedQuery2(String description, int qtyOnHand) throws Exception;
}
