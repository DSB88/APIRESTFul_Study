package br.com.projetoudemyspring.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tb_books")
@Entity
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Author field cannot be null")
	@Column(name = "author")
	private String author;
	
	@NotNull(message = "Launch Date field cannot be null")
	@Column(name = "launch_date")
	@Temporal(TemporalType.DATE)
	private Date launchDate;
	
	@NotNull(message = "Price field cannot be null")
	@Column(name = "price")
	private Double price;

	@NotNull(message = "Title field cannot be null")
	@Column(name = "title")
	private String title;
}
