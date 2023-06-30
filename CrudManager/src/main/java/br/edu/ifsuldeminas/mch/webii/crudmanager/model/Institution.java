package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.List;
import javax.persistence.OneToMany;

@Entity
@Table(name="institutions")
public class Institution {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotBlank(message= "Nome não pode ser vazio")
	private String name;
	@NotNull(message= "Telefone não pode ser vazio")
	private Integer phone;
	@NotBlank(message= "Endereço não pode ser vazio")
	private String address;
	
	@OneToMany(mappedBy="institution", cascade = CascadeType.REMOVE)
	private List<Student> students;
	
	public Institution() {};
	
	public Institution(Integer id)
	{
		this.id = id;
		setName("");
		setPhone(null);
		setAddress("");
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
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

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
	
}
