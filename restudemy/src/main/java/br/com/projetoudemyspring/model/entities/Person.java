package br.com.projetoudemyspring.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "person")
@Entity
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 3, max = 20)
	@NotNull(message = "First Name field cannot be null")
	@Column(name = "first_name")
	private String firstName;

	@Size(min = 3, max = 30)
	@NotNull(message = "Last Name field cannot be null")
	@Column(name = "last_name")	
	private String lastName;

	@Size(min = 10, max = 100)
	@NotNull(message = "Address field cannot be null")
	@Column
	private String address;

	@Size(min = 3, max = 10)
	@NotNull(message = "Gender field cannot be null")
	@Column
	private String gender;
	
	@NotNull(message = "Enable field cannot be null")
	private Boolean enabled;

}
