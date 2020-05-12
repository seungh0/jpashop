package will.seungho.jpashop.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBER_ID")
	private Long id;

	private String name;

	private String city;

	private String street;

	private String zipCode;

	@Builder
	public Member(String name, String city, String street, String zipCode) {
		this.name = name;
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
	}

}
