package projet.factory.entity;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonView;

import projet.factory.entity.view.JsonViews;

@Embeddable
public class Coordonnee {

	@JsonView(JsonViews.Common.class)
	private String rue;
	@JsonView(JsonViews.Common.class)
	private Integer codePostal;
	@JsonView(JsonViews.Common.class)
	private String ville;
	@JsonView(JsonViews.Common.class)
	private String pays;
	@JsonView(JsonViews.Common.class)
	private String mail;
	@JsonView(JsonViews.Common.class)
	private Integer tel;
	
	public Coordonnee() {
		super();
	}


	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public Integer getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getTel() {
		return tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

	
	
	
	
	

}
