package will.seungho.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@Entity
public class Movie extends Item {

	private String director;

	private String actor;

}
