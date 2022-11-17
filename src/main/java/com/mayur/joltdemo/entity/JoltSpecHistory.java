package com.mayur.joltdemo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "JOLT_SPEC_HISTORY")
@NoArgsConstructor
public class JoltSpecHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "spec_history_seq_generator")
	@SequenceGenerator(name="spec_history_seq_generator", sequenceName = "JOLT_SPEC_HISTORY_SEQ")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "spec_json")
	private String specJson;

	@Column(name = "comments")
	private String comments;

	@Column(name = "update_date")
	private Timestamp updateDate;

	@Column(name = "updated_by")
	private Timestamp updatedBy;

	@Column(name = "update_notes")
	private String updateNotes;
}
