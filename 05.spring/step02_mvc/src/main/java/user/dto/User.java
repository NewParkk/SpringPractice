package user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString

public class User {
	private String id;
	private int age;
	
	@Builder
	public User(String id, int age) {
		super();
		this.id = id;
		this.age = age;
	}
	
	
}
