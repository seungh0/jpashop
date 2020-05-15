package will.seungho.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@Entity
public class Book extends Item {

	private String author;

	private String isbn;

}
