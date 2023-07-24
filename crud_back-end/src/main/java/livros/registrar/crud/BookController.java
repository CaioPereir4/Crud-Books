package livros.registrar.crud;

import livros.registrar.crud.dtos.RegisterBookDto;
import livros.registrar.crud.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @Transactional
    @PostMapping()
    public ResponseEntity<RegisterBookDto> register(@RequestBody RegisterBookDto registerBookDto, UriComponentsBuilder uriBuilder){
        var response = bookService.registerBook(registerBookDto);
        var uri = uriBuilder.path("/books/{id}").buildAndExpand(response.id()).toUri();

        return  ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegisterBookDto> listOneById(@PathVariable(value = "id") Long id){
        var response = bookService.getOne(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping()
    public ResponseEntity<Page<RegisterBookDto>> listAll(@PageableDefault(size = 5) Pageable pageable){
        var response = bookService.listAll(pageable);
        return ResponseEntity.ok(response);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id ){
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    @PutMapping
    public ResponseEntity<RegisterBookDto> updateBook(@RequestBody RegisterBookDto registerBookDto){
        var response = bookService.update(registerBookDto);
        return ResponseEntity.ok(response);
    }

}
