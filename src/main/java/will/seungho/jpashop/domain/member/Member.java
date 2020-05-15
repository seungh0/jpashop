package will.seungho.jpashop.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import will.seungho.jpashop.BaseEntity;
import will.seungho.jpashop.domain.order.Order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBER_ID")
	private Long id;

	private String name;

	private String city;

	private String street;

	private String zipCode;

	/**
	 * 설계면으로 여기서는 양방향 안하는게 좋은데 테스트할겸 추가
	 */
	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<>();

	@Builder
	public Member(String name, String city, String street, String zipCode) {
		this.name = name;
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
	}

}
