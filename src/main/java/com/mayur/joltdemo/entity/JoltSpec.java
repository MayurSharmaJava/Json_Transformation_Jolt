package com.mayur.joltdemo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "JOLT_SPEC")
@NoArgsConstructor
public class JoltSpec {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "spec_seq_generator")
	@SequenceGenerator(name="spec_seq_generator", sequenceName = "JOLT_SPEC_SEQ")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "spec_json")
	private String specJson;

	@Column(name = "comments")
	private String comments;
}
