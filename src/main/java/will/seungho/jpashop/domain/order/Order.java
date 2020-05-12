package will.seungho.jpashop.domain.order;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import will.seungho.jpashop.domain.delivery.Delivery;
import will.seungho.jpashop.domain.member.Member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member member;

	private LocalDateTime orderDateTime;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@OneToOne
	@JoinColumn(name = "DELIVERY_ID")
	private Delivery delivery;

	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems;

	@Builder
	public Order(Member member, LocalDateTime orderDateTime, OrderStatus status) {
		this.member = member;
		this.orderDateTime = orderDateTime;
		this.status = status;
	}

	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
		orderItem.changeOrder(this);
	}

}
