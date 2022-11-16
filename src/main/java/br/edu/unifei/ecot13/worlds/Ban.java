package br.edu.unifei.ecot13.worlds;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Ban implements Serializable {

	private static final long serialVersionUID = -9144692358711729981L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int banOrder;
	@OneToOne
	private Champion champion;

	public Ban(int banOrder, Champion champion) {
		super();
		this.banOrder = banOrder;
		this.champion = champion;
	}

	public Ban() {
		super();
	}
	

}
