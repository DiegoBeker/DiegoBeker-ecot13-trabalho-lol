package br.edu.unifei.ecot13.worlds;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.edu.unifei.ecot13.worlds.enumeration.GroupEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class GroupStage extends Stage {
	private GroupEnum groupeName;
	@OneToOne
	private Organization org1;
	@OneToOne
	private Organization org2;
	@OneToOne
	private Organization org3;
	@OneToOne
	private Organization org4;
	
}
