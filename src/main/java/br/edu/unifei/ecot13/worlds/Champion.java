package br.edu.unifei.ecot13.worlds;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Champion implements Serializable {

	private static final long serialVersionUID = 3890119457681133853L;
	@Id
	private String name;
	
	public Champion(String name) {
		super();
		this.name = name;
	}

	public Champion() {
		super();
	}
	
	
	
	
}
