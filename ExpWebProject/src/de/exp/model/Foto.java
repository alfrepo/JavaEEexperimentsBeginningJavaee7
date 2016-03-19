package de.exp.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the foto database table.
 * 
 */
@Entity
@NamedQuery(name="Foto.findAll", query="SELECT f FROM Foto f")
public class Foto implements Serializable {
	private static final long serialVersionUID = 1L;

	@javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	private UUID id;

	private String pathfullsizefoto;

	private String pathpreviewfoto;

	private Integer priority;

	//bi-directional many-to-many association to FotoDescribtion
	@ManyToMany
	@JoinTable(
		name="describtion_to_foto"
		, joinColumns={
			@JoinColumn(name="id_foto")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_describtion")
			}
		)
	private List<FotoDescribtion> fotoDescribtions;


	public Foto() {
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getPathfullsizefoto() {
		return this.pathfullsizefoto;
	}

	public void setPathfullsizefoto(String pathfullsizefoto) {
		this.pathfullsizefoto = pathfullsizefoto;
	}

	public String getPathpreviewfoto() {
		return this.pathpreviewfoto;
	}

	public void setPathpreviewfoto(String pathpreviewfoto) {
		this.pathpreviewfoto = pathpreviewfoto;
	}

	public Integer getPriority() {
		return this.priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public List<FotoDescribtion> getfotoDescribtions() {
		return this.fotoDescribtions;
	}

	public void setfotoDescribtions(List<FotoDescribtion> fotoDescribtions) {
		this.fotoDescribtions = fotoDescribtions;
	}


}