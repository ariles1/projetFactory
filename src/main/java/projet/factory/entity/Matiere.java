package projet.factory.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

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
	@JsonView(JsonViews.MatiereWithEnseigner.class)
	@OneToMany(mappedBy="key.matiere")
	private List<Enseigner> enseignements;
	
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
