package will.seungho.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@Entity
public class Album extends Item {

	private String artist;

	private String etc;

}
