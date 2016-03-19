package de.exp.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the location database table.
 * 
 */
@Entity
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	private UUID id;

	@Column(name="gps_latiture")
	private double gpsLatiture;

	@Column(name="gps_longtitude")
	private double gpsLongtitude;

	@Column(name="location_type")
	private String locationType;

	@Column(name="max_guests")
	private Integer maxGuests;

	//bi-directional many-to-one association to FotoDescribtion
	@ManyToOne
	@JoinColumn(name="id_describtion")
	private FotoDescribtion fotoDescribtion;

	//bi-directional many-to-one association to Price
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="id_price")
	private Price price;

	//bi-directional many-to-one association to Ranking
	@OneToMany(mappedBy="location")
	private List<Ranking> rankings;

	public Location() {
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public double getGpsLatiture() {
		return this.gpsLatiture;
	}

	public void setGpsLatiture(double gpsLatiture) {
		this.gpsLatiture = gpsLatiture;
	}

	public double getGpsLongtitude() {
		return this.gpsLongtitude;
	}

	public void setGpsLongtitude(double gpsLongtitude) {
		this.gpsLongtitude = gpsLongtitude;
	}

	public String getLocationType() {
		return this.locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public Integer getMaxGuests() {
		return this.maxGuests;
	}

	public void setMaxGuests(Integer maxGuests) {
		this.maxGuests = maxGuests;
	}

	public FotoDescribtion getFotoDescribtion() {
		return this.fotoDescribtion;
	}

	public void setFotoDescribtion(FotoDescribtion fotoDescribtion) {
		this.fotoDescribtion = fotoDescribtion;
	}

	public Price getPrice() {
		return this.price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public List<Ranking> getRankings() {
		return this.rankings;
	}

	public void setRankings(List<Ranking> rankings) {
		this.rankings = rankings;
	}

	public Ranking addRanking(Ranking ranking) {
		getRankings().add(ranking);
		ranking.setLocation(this);

		return ranking;
	}

	public Ranking removeRanking(Ranking ranking) {
		getRankings().remove(ranking);
		ranking.setLocation(null);

		return ranking;
	}

}