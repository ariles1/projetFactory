package projet.factory.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

import projet.factory.entity.view.JsonViews;

@Entity
@SequenceGenerator(name = "seqOrdinateur", sequenceName = "seq_ordinateur", initialValue = 100, allocationSize = 1)
public class Ordinateur {
	@JsonView(JsonViews.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqOrdinateur")
	private Integer id;
	@JsonView(JsonViews.Common.class)
	private String processeur;
	@JsonView(JsonViews.Common.class)
	private String RAM;
	@JsonView(JsonViews.Common.class)
	private Integer DD;
	@JsonView(JsonViews.Common.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date anneeAchat;
	@JsonView(JsonViews.OrdinateurWithStagiaire.class)
	@OneToOne(mappedBy="ordinateur")
	private Stagiaire stagiaire;
	
	public Ordinateur() {
		super();
	}
	public Stagiaire getStagiaire() {
		return stagiaire;
	}
	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProcesseur() {
		return processeur;
	}
	public void setProcesseur(String processeur) {
		this.processeur = processeur;
	}
	public String getRAM() {
		return RAM;
	}
	public void setRAM(String rAM) {
		RAM = rAM;
	}
	public Integer getDD() {
		return DD;
	}
	public void setDD(Integer dD) {
		DD = dD;
	}
	public Date getAnneeAchat() {
		return anneeAchat;
	}
	public void setAnneeAchat(Date anneeAchat) {
		this.anneeAchat = anneeAchat;
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
		Ordinateur other = (Ordinateur) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
