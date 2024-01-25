package com.test.consultorio.modules.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "consultorio")
public class Consultorio implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 6659822964560322400L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero_consultorio", nullable = false, unique = true)
	private Long numero_consultorio;
	
	@Column(name = "piso", nullable = false, unique = true)
	private String piso;
	
}
