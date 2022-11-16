package br.edu.unifei.ecot13.worlds;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.edu.unifei.ecot13.worlds.enumeration.LeagueEnum;
import lombok.Data;

@Data
@Entity
public class League implements Serializable {
    
	private static final long serialVersionUID = 6630458497847589783L;
	@Id
	private LeagueEnum leagueName;
    private String Region;
    
   
}
