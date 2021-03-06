package projet.factory.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

import projet.factory.entity.view.JsonViews;

@Entity
@SequenceGenerator(name = "seqCours", sequenceName = "seq_cours", initialValue = 100, allocationSize = 1)
public class Cours {
	@JsonView(JsonViews.CoursView.class)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCours")
	private Integer id;
	@JsonView(JsonViews.CoursView.class)
	private String nom;
	@JsonView(JsonViews.CoursView.class)
	private Integer duree;
	@JsonView(JsonViews.CoursView.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@JsonView(JsonViews.CoursView.class)
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_salle")
	private Salle salle;
	@JsonView(JsonViews.CoursView.class)
	@ManyToOne
	@JoinColumns({@JoinColumn(name="id_formateur"),@JoinColumn(name="id_matiere")})
	private Enseigner enseignement;
	@JsonView({JsonViews.CoursWithFormation.class,JsonViews.CoursView.class})
	@ManyToOne
	@JoinColumn(name = "id_formation")
	private Formation formation;
	@Version
	private Integer version;
	
	
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Cours() {
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

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Enseigner getEnseignement() {
		return enseignement;
	}

	public void setEnseignement(Enseigner enseignement) {
		this.enseignement = enseignement;
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
		Cours other = (Cours) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
