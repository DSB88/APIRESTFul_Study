package br.com.projetoudemyspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projetoudemyspring.data.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
