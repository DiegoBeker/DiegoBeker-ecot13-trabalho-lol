package br.edu.unifei.ecot13.worlds;

import javax.persistence.Entity;

import br.edu.unifei.ecot13.worlds.enumeration.RoleEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Player extends Member {
    
	private static final long serialVersionUID = -2785920897581919441L;
	private double kda;
    private int totalGames;
    private RoleEnum role;
    
}
