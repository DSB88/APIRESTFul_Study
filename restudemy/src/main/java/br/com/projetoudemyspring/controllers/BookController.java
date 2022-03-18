package br.com.projetoudemyspring.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoudemyspring.data.vo.BookVO;
import br.com.projetoudemyspring.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="BookEndpoint", description = "Book, Description Of Methods",tags = {"BookEndpoint"})
@RestController
@RequestMapping("/api/book/v1")
public class BookController {

	private final BookService bookServices;

	public BookController(BookService bookServices) {
		this.bookServices = bookServices;
	}

	@ApiOperation(value = "Returns a list of all registered books")
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<BookVO> findAll() {
		List<BookVO> books = bookServices.findAll();
		books.stream().forEach(p -> p.add(linkTo(methodOn(BookController.class).findById(p.getId())).withSelfRel()));
		return books;
	}

	@ApiOperation(value = "Returns a single book, by your id")
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public BookVO findById(@PathVariable("id") Long id) {
		BookVO bookVO = bookServices.findById(id);
		bookVO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		return bookVO;
	}

	@ApiOperation(value = "Add (save) a book")
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public BookVO create(@RequestBody BookVO book) {
		BookVO bookVO = bookServices.create(book);
		bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getId())).withSelfRel());
		return bookVO;
	}

	@ApiOperation(value = "Updates the attributes of a book")
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public BookVO update(@RequestBody BookVO book) {
		BookVO bookVO = bookServices.update(book);
		bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getId())).withSelfRel());
		return bookVO;
	}

	@ApiOperation(value = "Delete a book")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		bookServices.delete(id);
		return ResponseEntity.ok().build();
	}

}
