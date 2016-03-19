package de.exp.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the price database table.
 * 
 */
@Entity
@NamedQuery(name="Price.findAll", query="SELECT p FROM Price p")
public class Price implements Serializable {
	private static final long serialVersionUID = 1L;

	@javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	private UUID id;

	@Column(name="currency_iso_code")
	private String currencyIsoCode;

	@Column(name="price_general")
	private double priceGeneral;

	@Column(name="price_per_hour")
	private double pricePerHour;

	//bi-directional many-to-one association to Location
	@OneToMany(mappedBy="price", cascade={CascadeType.ALL})
	private List<Location> locations;

	public Price() {
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Object getCurrencyIsoCode() {
		return this.currencyIsoCode;
	}

	public void setCurrencyIsoCode(String currencyIsoCode) {
		this.currencyIsoCode = currencyIsoCode;
	}

	public double getPriceGeneral() {
		return this.priceGeneral;
	}

	public void setPriceGeneral(double priceGeneral) {
		this.priceGeneral = priceGeneral;
	}

	public double getPricePerHour() {
		return this.pricePerHour;
	}

	public void setPricePerHour(double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public List<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Location addLocation(Location location) {
		getLocations().add(location);
		location.setPrice(this);

		return location;
	}

	public Location removeLocation(Location location) {
		getLocations().remove(location);
		location.setPrice(null);

		return location;
	}

}