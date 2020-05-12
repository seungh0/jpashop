package will.seungho.jpashop.domain.item;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import will.seungho.jpashop.domain.category.Category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ITEM_ID")
	private Long id;

	private String name;

	private int price;

	private int stockQuantity;

	@ManyToMany(mappedBy = "items")
	private List<Category> categories = new ArrayList<>();

	@Builder
	public Item(String name, int price, int stockQuantity) {
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

}
