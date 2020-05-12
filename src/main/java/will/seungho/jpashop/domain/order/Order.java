package will.seungho.jpashop.domain.order;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ID")
	private Long id;

	@Column(name = "MEMBER_ID")
	private Long memberId;

	private LocalDateTime orderDateTime;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@Builder
	public Order(Long memberId, LocalDateTime orderDateTime, OrderStatus status) {
		this.memberId = memberId;
		this.orderDateTime = orderDateTime;
		this.status = status;
	}

}
