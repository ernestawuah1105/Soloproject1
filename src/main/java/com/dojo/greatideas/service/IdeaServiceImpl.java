package com.dojo.greatideas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.greatideas.models.Idea;
import com.dojo.greatideas.repositories.IdeaRepo;
@Service("IdeaService")
@Transactional
public class IdeaServiceImpl implements IdeaService {
	@Autowired
  private IdeaRepo repo;
  public void registerIdea(Idea idea) {
	 repo.save(idea);
  }
public List<Idea> getAllIdeas() {
	Iterable<Idea> iterable = repo.findAll();
	List<Idea> array = StreamSupport
	    .stream(iterable.spliterator(), false)
	    .collect(Collectors.toList());
	return array;

}
}
