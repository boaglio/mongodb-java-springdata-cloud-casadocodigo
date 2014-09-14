package com.boaglio.casadocodigo.mongodb.repository;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.boaglio.casadocodigo.mongodb.model.Seriado;

@Repository
public class SeriadosRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Seriado> findAll() {

		List<Seriado> seriados = new ArrayList<Seriado>();
		seriados = mongoTemplate.findAll(Seriado.class);
		System.out.println("total de seriados = " + seriados.size());
		return seriados;
	}

	public Seriado findById(String id) {

		Seriado seriado = new Seriado();
		System.out.println("busca por id = " + id);

		Query queryDeBuscaPorID = new Query(Criteria.where("id").is(id));

		seriado = mongoTemplate.findOne(queryDeBuscaPorID,Seriado.class);

		return seriado;
	}

	public void insert(Seriado seriado) {

		mongoTemplate.insert(seriado);

		System.out.println("novo seriado = " + seriado);

	}

	public void update(Seriado seriado) {

		mongoTemplate.save(seriado);

		System.out.println("seriado alterado = " + seriado);

	}

	public void remove(String id) {

		Seriado seriadoParaRemover = new Seriado();
		seriadoParaRemover.setId(new ObjectId(id));
		mongoTemplate.remove(seriadoParaRemover);

		System.out.println("seriado removido = " + id);

	}

}
