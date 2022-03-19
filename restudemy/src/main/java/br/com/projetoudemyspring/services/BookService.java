package br.com.projetoudemyspring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.projetoudemyspring.converter.DozerConverter;
import br.com.projetoudemyspring.handlerexception.EntityNotFoundException;
import br.com.projetoudemyspring.model.entities.Book;
import br.com.projetoudemyspring.model.vo.BookVO;
import br.com.projetoudemyspring.repositories.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<BookVO> findAll() {
		return DozerConverter.parseListObjects(bookRepository.findAll(), BookVO.class);
	}

	public BookVO create(BookVO book) {
		Book entity = DozerConverter.parseObject(book, Book.class);
		BookVO vo = DozerConverter.parseObject(bookRepository.save(entity), BookVO.class);
		return vo;
	}

	public BookVO findById(Long id) {
		Book entity = bookRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("No records found for this ID"));
		return DozerConverter.parseObject(entity, BookVO.class);
	}

	public BookVO update(BookVO book) {
		Book entity = bookRepository.findById(book.getId())
				.orElseThrow(() -> new EntityNotFoundException("No records found for this ID"));

		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());

		BookVO vo = DozerConverter.parseObject(bookRepository.save(entity), BookVO.class);
		return vo;
	}

	public void delete(Long id) {
		Book entity = bookRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("No records found for this ID"));
		bookRepository.delete(entity);
	}

}
