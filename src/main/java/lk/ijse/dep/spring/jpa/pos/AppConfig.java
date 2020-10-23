package lk.ijse.dep.spring.jpa.pos;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Import(JPAConfig.class)
@ComponentScan("lk.ijse.dep.spring.jpa.pos")
@Component
public class AppConfig {
}
