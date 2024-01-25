package com.test.consultorio.modules.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "cita")
public class Cita implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -382477152176029231L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "consultorio_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Consultorio consultorio;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "doctor_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Doctor doctor;
	
	@Column(name = "horario_consulta", nullable = false, unique = true, length = 10)
	private String horario_consulta;
	
	@Valid
	@Nonnull
	@Column(name = "nombre_paciente", nullable = false, unique = true, length = 100)
    private String nombre_paciente;
	
}
