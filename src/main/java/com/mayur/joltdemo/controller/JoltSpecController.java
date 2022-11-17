package com.mayur.joltdemo.controller;

import com.mayur.joltdemo.entity.JoltSpec;
import com.mayur.joltdemo.exception.ResourceNotFoundException;
import com.mayur.joltdemo.repository.JoltSpecRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;

/**
 * This is Spec controller for Jolt
 * responsibility
 * 1. save/Update Jolt Spec
 * 2. keep History of Jolt Spec changes
 * 3. get jolt Spec on basis of name
 * 4. get History of Jolt Spec on basis of Name
 */
@RestController
@RequestMapping("/api/spec/")
public class JoltSpecController {

	@Autowired
	private JoltSpecRepository joltSpecRepository;

	@Autowired
	private EntityManager entityManager;

	@GetMapping("/{name}")
	public String getSpec(@PathVariable(value = "name") String name) {

		Session session = entityManager.unwrap(Session.class);

		String hql = "FROM JoltSpec J WHERE J.name = :name";

		Query<JoltSpec> query = session.createQuery(hql);
		query.setParameter("name", name);
		JoltSpec joltSpec = query.getSingleResult();

		return joltSpec.getSpecJson();
	}

	@PostMapping
	public JoltSpec addJoltSpec(@RequestParam ("name") String name,@RequestParam ("specJson") String specJson,@RequestParam ("comment") String comment) {
		JoltSpec joltSpec = new JoltSpec();
		joltSpec.setName(name);
		joltSpec.setSpecJson(specJson);
		joltSpec.setComments(comment);
		return this.joltSpecRepository.save(joltSpec);
	}
}
