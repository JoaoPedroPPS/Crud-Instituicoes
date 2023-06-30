package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotBlank(message= "Nome não pode ser vazio")
	private String name;
	@NotNull(message= "IRA não pode ser vazio")
	private Float ira;
	@NotBlank(message= "Endereço não pode ser vazio")
	private String address;
	
	@ManyToOne
    @JoinColumn(name="institution_id", nullable=false)
	private Institution institution;
	
	public Student() {};
	
	
	public Student(Integer id)
	{
		this.id = id;
		setName("");
		setIra(null);
		setAddress("");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Float getIra() {
		return ira;
	}

	public void setIra(Float ira) {
		this.ira = ira;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	
	
	
}
