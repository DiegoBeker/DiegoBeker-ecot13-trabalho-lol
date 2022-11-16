package br.edu.unifei.ecot13.worlds;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
@Data
@Entity
public class Organization implements Serializable {
    
	private static final long serialVersionUID = -6232567026741651223L;
	@Id
	@GeneratedValue
	private long id;
	private String name;
    private String shortname;
    private int totalwin;
    private int totalLose;
    @ManyToOne
    private League league;
    @OneToMany
    private List<Member> members = new ArrayList<Member>();
    
    
}
