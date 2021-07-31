package com.dojo.greatideas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.dojo.greatideas.models.Idea;

public interface IdeaRepo extends CrudRepository<Idea, Integer> {

}
