package will.seungho.jpashop.domain.order;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import will.seungho.jpashop.BaseEntity;
import will.seungho.jpashop.domain.item.Item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor
@Entity
public class OrderItem extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ITEM_ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_ID")
	private Order order;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM_ID")
	private Item item;

	private int orderPrice;

	private int count;

	@Builder
	public OrderItem(Order order, Item item, int orderPrice, int count) {
		this.order = order;
		this.item = item;
		this.orderPrice = orderPrice;
		this.count = count;
	}

	void changeOrder(Order order) {
		this.order = order;
	}

}
