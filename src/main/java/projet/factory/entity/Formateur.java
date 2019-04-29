package projet.factory.entity;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

import projet.factory.entity.view.JsonViews;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonView;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@Entity
@SequenceGenerator(name = "seqFormateur", sequenceName = "seq_formateur", initialValue = 100, allocationSize = 1)
public class Formateur {
	@JsonView(JsonViews.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFormateur")
	private Integer id;
	@JsonView(JsonViews.Common.class)
	private String nom;
	@JsonView(JsonViews.Common.class)
	private String prenom;
	@Embedded
	@JsonView(JsonViews.FormateurWithCoordonnee.class)
	private Coordonnee coord;
	@JsonView(JsonViews.FormateurWithEnseigner.class)
	@OneToMany(mappedBy="key.formateur")
	private List<Enseigner> enseignements;
	@JsonView(JsonViews.FormateurWithIndisponibilites.class)
	@OneToMany(mappedBy="formateur")
	private List<Indisponibilite> indisponibilites;
	@Version
	private Integer version;
	
	
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	public Formateur() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Coordonnee getCoord() {
		return coord;
	}
	public void setCoord(Coordonnee coord) {
		this.coord = coord;
	}
	public List<Enseigner> getEnseignements() {
		return enseignements;
	}
	public void setEnseignements(List<Enseigner> enseignements) {
		this.enseignements = enseignements;
	}
	public List<Indisponibilite> getIndisponibilites() {
		return indisponibilites;
	}
	public void setIndisponibilites(List<Indisponibilite> indisponibilites) {
		this.indisponibilites = indisponibilites;
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
		Formateur other = (Formateur) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
