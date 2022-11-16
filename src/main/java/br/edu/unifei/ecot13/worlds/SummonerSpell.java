package br.edu.unifei.ecot13.worlds;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.edu.unifei.ecot13.worlds.enumeration.SummonerSpellEnum;
import lombok.Data;

@Data
@Entity
public class SummonerSpell implements Serializable {

	private static final long serialVersionUID = 6035084892461335100L;
	@Id
	private SummonerSpellEnum summonerSpell;
	private int cooldownSeconds;
	
	public SummonerSpell(SummonerSpellEnum summonerSpell, int cooldownSeconds) {
		super();
		this.summonerSpell = summonerSpell;
		this.cooldownSeconds = cooldownSeconds;
	}

	public SummonerSpell() {
		super();
	}
	
	
	
	
}
