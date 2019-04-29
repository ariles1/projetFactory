package projet.factory.entity;

import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Enseigner {
	@EmbeddedId
	private EnseignerPk key;
	@Enumerated(EnumType.STRING)
	private Niveau niveau;
	@OneToMany(mappedBy="enseignement")
	private List<Cours> courses;
	@Version
	private Integer version;
	
	public Enseigner() {
	}

	public EnseignerPk getKey() {
		return key;
	}

	public void setKey(EnseignerPk key) {
		this.key = key;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public List<Cours> getCourses() {
		return courses;
	}

	public void setCourses(List<Cours> courses) {
		this.courses = courses;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	
	
}
