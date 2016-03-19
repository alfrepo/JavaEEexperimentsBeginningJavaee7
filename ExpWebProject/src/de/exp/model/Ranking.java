package de.exp.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.GenericGenerator;


/**
 * The persistent class for the ranking database table.
 * 
 */
@Entity
@NamedQuery(name="Ranking.findAll", query="SELECT r FROM Ranking r")
public class Ranking implements Serializable {
	private static final long serialVersionUID = 1L;

	@javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	private UUID id;

	private Integer ranking;

	private Timestamp rankingdate;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="id_customer")
	private Customer customer;

	//bi-directional many-to-one association to Location
	@ManyToOne
	@JoinColumn(name="id_location")
	private Location location;

	public Ranking() {
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Integer getRanking() {
		return this.ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	public Timestamp getRankingdate() {
		return this.rankingdate;
	}

	public void setRankingdate(Timestamp rankingdate) {
		this.rankingdate = rankingdate;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}