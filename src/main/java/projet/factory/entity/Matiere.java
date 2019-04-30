package projet.factory.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import projet.factory.entity.view.JsonViews;

@Entity
@SequenceGenerator(name = "seqMatiere", sequenceName = "seq_matiere", initialValue = 100, allocationSize = 1)
public class Matiere {
	@JsonView(JsonViews.Common.class)
	@Id
	private Integer id;
	@JsonView(JsonViews.Common.class)
	private String nom;
	@JsonView(JsonViews.Common.class)
	private String prerequis;
	@JsonView(JsonViews.Common.class)
	private String objectif;
	@JsonView(JsonViews.Common.class)
	private String contenu;
	@JsonView(JsonViews.MatiereWithEnseigner.class)
	@OneToMany(mappedBy="key.matiere")
	private List<Enseigner> enseignements;
	
	@Version
	private Integer version;
	
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	public String getPrerequis() {
		return prerequis;
	}
	public void setPrerequis(String prerequis) {
		this.prerequis = prerequis;
	}
	public String getObjectif() {
		return objectif;
	}
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Matiere() {
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
	public List<Enseigner> getEnseignements() {
		return enseignements;
	}
	public void setEnseignements(List<Enseigner> enseignements) {
		this.enseignements = enseignements;
	}
	
	

}
