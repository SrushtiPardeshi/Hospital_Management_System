package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="COR_PATIENT")
public class Patient {

	@Id
	@SequenceGenerator(name="gen1",sequenceName="empno_seq1", initialValue=1000,allocationSize=1)
	@GeneratedValue(generator = "gen1" ,strategy = GenerationType.SEQUENCE)
	private Integer pid;
	private String pname;
	private String  paddrs;
	private Long mobileno;
	private boolean coronavirus;
}
