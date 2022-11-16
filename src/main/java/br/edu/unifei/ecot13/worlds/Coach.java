package br.edu.unifei.ecot13.worlds;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Coach extends Member {

	private static final long serialVersionUID = 5340791009599616369L;
	private int totalDrafts;
	private boolean mainCoach;

}
