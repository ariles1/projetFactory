package projet.factory.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import projet.factory.entity.view.JsonViews;
@Entity
@SequenceGenerator(name = "seqStagiaire", sequenceName = "seq_stagiaire", initialValue = 100, allocationSize = 1)
public class Stagiaire {
	@JsonView(JsonViews.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqStagiaire")
	private Integer id;
	@JsonView({JsonViews.Common.class,JsonViews.FormationView.class})
	private String prenom;
	@JsonView({JsonViews.Common.class,JsonViews.FormationView.class})
	private String nom;
	@JsonView(JsonViews.Common.class)
	@Embedded
	private Coordonnee coord;
	@JsonView(JsonViews.StagiaireWithOrdinateur.class)
	@OneToOne
	@JoinColumn(name="id_ordinateur")
	private Ordinateur ordinateur;
	@JsonView(JsonViews.StagiaireWithFormation.class)
	@ManyToOne
	@JoinColumn(name="id_formation")
	private Formation formation;
	@Version
	private Integer version;
	
	
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	public Stagiaire() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Coordonnee getCoord() {
		return coord;
	}
	public void setCoord(Coordonnee coord) {
		this.coord = coord;
	}

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}
	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stagiaire other = (Stagiaire) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
