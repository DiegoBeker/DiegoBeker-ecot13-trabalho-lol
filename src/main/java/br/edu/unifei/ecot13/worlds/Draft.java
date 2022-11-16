package br.edu.unifei.ecot13.worlds;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.edu.unifei.ecot13.worlds.enumeration.SideEnum;
import lombok.Data;
@Data
@Entity
public class Draft implements Serializable {

	private static final long serialVersionUID = -8861080181442029270L;
	@Id
	@GeneratedValue
	private long id;
	private SideEnum side;
	@ManyToOne
	private Coach coach;
	@OneToOne
	private Ban ban1 = new Ban();
	@OneToOne
	private Ban ban2 = new Ban();
	@OneToOne
	private Ban ban3 = new Ban();
	@OneToOne
	private Ban ban4 = new Ban();
	@OneToOne
	private Ban ban5 = new Ban();
	@OneToOne
	private Pick pick1 = new Pick();
	@OneToOne
	private Pick pick2 = new Pick();
	@OneToOne
	private Pick pick3 = new Pick();
	@OneToOne
	private Pick pick4 = new Pick();
	@OneToOne
	private Pick pick5 = new Pick();
	

}
