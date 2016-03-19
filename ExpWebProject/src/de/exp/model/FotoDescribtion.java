package de.exp.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.List;


/**
 * The persistent class for the "fotoDescribtion" database table.
 * 
 */
@Entity
@Table(name="\"fotoDescribtion\"")
@NamedQuery(name="FotoDescribtion.findAll", query="SELECT f FROM FotoDescribtion f")
public class FotoDescribtion implements Serializable {
	private static final long serialVersionUID = 1L;

	@javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	private String id;

	private String text;

	//bi-directional many-to-one association to Location
	@OneToMany(mappedBy="fotoDescribtion")
	private List<Location> locations;

	//bi-directional many-to-many association to Foto
	@ManyToMany
	@JoinTable(
		name="describtion_to_foto"
		, joinColumns={
			@JoinColumn(name="id_describtion")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_foto")
			}
		)
	private List<Foto> fotos;

	public FotoDescribtion() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Foto> getFotos() {
		return this.fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public List<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Location addLocation(Location location) {
		getLocations().add(location);
		location.setFotoDescribtion(this);

		return location;
	}

	public Location removeLocation(Location location) {
		getLocations().remove(location);
		location.setFotoDescribtion(null);

		return location;
	}

}