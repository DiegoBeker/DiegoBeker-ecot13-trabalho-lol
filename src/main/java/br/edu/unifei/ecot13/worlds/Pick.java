package br.edu.unifei.ecot13.worlds;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Pick implements Serializable {

	private static final long serialVersionUID = 2859220816946737259L;
	@Id
	@GeneratedValue
	private long id;
	private int pickOrder;
	private String skin;
	@ManyToOne
	private SummonerSpell spell1 = new SummonerSpell();
	@ManyToOne
	private SummonerSpell spell2 = new SummonerSpell();
	@OneToOne
	private Player player;
	@OneToOne
	private Champion champion;
	
	public Pick(int pickOrder, String skin, SummonerSpell spell1, SummonerSpell spell2, Player player,
			Champion champion) {
		super();
		this.pickOrder = pickOrder;
		this.skin = skin;
		this.spell1 = spell1;
		this.spell2 = spell2;
		this.player = player;
		this.champion = champion;
	}

	public Pick() {
		super();
	}
	
	
	
	

}
