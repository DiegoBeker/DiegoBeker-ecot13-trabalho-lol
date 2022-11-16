package br.edu.unifei.ecot13.worlds;

import javax.persistence.Entity;

import br.edu.unifei.ecot13.worlds.enumeration.KnockoutEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Knockout extends Stage {
	private KnockoutEnum knockout;
	
}
