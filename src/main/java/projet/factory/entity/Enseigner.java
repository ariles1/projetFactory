package projet.factory.entity;

import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import projet.factory.entity.view.JsonViews;

@Entity
public class Enseigner {
	@EmbeddedId
	@JsonView(JsonViews.CoursView.class)
	private EnseignerPk key;
	@JsonView({JsonViews.EnseignerWithNiveau.class, JsonViews.CoursView.class})
	@Enumerated(EnumType.STRING)
	private Niveau niveau;
	@JsonView(JsonViews.EnseignerWithCours.class)
	@OneToMany(mappedBy="enseignement")
	private List<Cours> courses;
	@Version
	private Integer version;
	
	
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
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

	
	
}
