package br.edu.unifei.ecot13.worlds;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public abstract class Member implements Serializable {

	private static final long serialVersionUID = 8502609459299730616L;
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String nickname;

}
