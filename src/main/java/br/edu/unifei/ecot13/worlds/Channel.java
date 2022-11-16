package br.edu.unifei.ecot13.worlds;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Channel implements Serializable {
	
	private static final long serialVersionUID = 7352345104049018630L;
	@Id
	@GeneratedValue
	private long id;
	private String platform;
	private String url;
}
