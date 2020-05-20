package will.seungho.jpashop.domain.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import will.seungho.jpashop.BaseEntity;
import will.seungho.jpashop.domain.item.Item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor
@Entity
public class Category extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CATEGORY_ID")
	private Long id;

	private String name;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "PARENT_ID")
	private Category parent;

	@OneToMany(mappedBy = "parent")
	private List<Category> child = new ArrayList<>();

	/**
	 * 이거 원래는 다대다는 일대다 vs 다대일로 풀어야함
	 */
	@ManyToMany
	@JoinTable(name = "CATEGORY_ITEM",
			joinColumns = @JoinColumn(name = "CATEGORY_ID"),
			inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
	)
	private List<Item> items = new ArrayList<>();

}
