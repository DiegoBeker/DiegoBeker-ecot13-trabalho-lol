package br.edu.unifei.ecot13.worlds;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Broadcast implements Serializable {

	private static final long serialVersionUID = 3033202110596402169L;
	@Id
	@GeneratedValue
	private long id;
	private int maximumViews;
	private int durationSeconds;
	private String language;
	@ManyToMany
	List<Game> games = new ArrayList<Game>();
	@ManyToMany
	private List<Channel> channel = new ArrayList<Channel>();

}
