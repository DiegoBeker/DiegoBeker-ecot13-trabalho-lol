package br.edu.unifei.ecot13.worlds;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Game implements Serializable {

	private static final long serialVersionUID = -1065725512304642531L;
	@Id
	@GeneratedValue
	private long id;
	@Temporal(TemporalType.DATE)
	private Date date;
	@OneToOne
	private Draft draft1 = new Draft();
	@OneToOne
	private Draft draft2 = new Draft();
	@ManyToOne
	private Organization org1 = new Organization();
	@ManyToOne
	private Organization org2 = new Organization();
	
}
