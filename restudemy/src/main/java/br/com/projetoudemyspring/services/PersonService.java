package br.com.projetoudemyspring.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.projetoudemyspring.converter.DozerConverter;
import br.com.projetoudemyspring.handlerexception.EntityNotFoundException;
import br.com.projetoudemyspring.model.entities.Person;
import br.com.projetoudemyspring.model.vo.PersonVO;
import br.com.projetoudemyspring.repositories.PersonRepository;

@Service
public class PersonService {

	private final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public List<PersonVO> findAll() {
		return DozerConverter.parseListObjects(personRepository.findAll(), PersonVO.class);
	}
	
	public PersonVO create(PersonVO person) {
		Person entity = DozerConverter.parseObject(person, Person.class);
		PersonVO vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
		return vo;
	}

	public PersonVO findById(Long id) {
		Person entity = personRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("No records found for this ID"));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}

	public PersonVO update(PersonVO person) {
		Person entity = personRepository.findById(person.getId())
				.orElseThrow(() -> new EntityNotFoundException("No records found for this ID"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		PersonVO vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
		return vo;
	}
	
	@Transactional
	public PersonVO disablePerson(Long id) {
		personRepository.disablePersons(id);
		Person entity = personRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("No records found for this ID"));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}

	public void delete(Long id) {
		Person entity = personRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("No records found for this ID"));
		personRepository.delete(entity);
	}

}
