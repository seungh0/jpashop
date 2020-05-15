package will.seungho.jpashop;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

	private LocalDateTime createdDateTime;

	private LocalDateTime lastModifiedDateTime;

}
