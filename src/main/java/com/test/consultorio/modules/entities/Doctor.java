package com.test.consultorio.modules.entities;

import java.io.Serializable;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "doctor")
public class Doctor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5853648599952927159L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	
	
	@Valid
	@Nonnull
	@Column(name = "nombre", nullable = false, unique = true, length = 30)
	private String nombre;
	
	@Valid
	@Nonnull
	@Column(name = "apellido_paterno", nullable = false, unique = false, length = 30)
	private String apellido_paterno;
	
	@Valid
	@Nonnull
	@Column(name = "apellido_materno", nullable = false, unique = false, length = 30)
	private String apellido_materno;
	
	@Valid
	@Nonnull
	@Column(name = "especialidad", nullable = false, unique = false, length = 30)
	private String especialidad;

	
}
