package livros.registrar.crud.services;

import livros.registrar.crud.dtos.RegisterBookDto;

import livros.registrar.crud.infra.ValidatorException;
import livros.registrar.crud.models.RegisterBook;
import livros.registrar.crud.repositories.RegisterRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    RegisterRepository repository;

    public RegisterBookDto registerBook(RegisterBookDto registerBookDto){
        var registroNovo = new RegisterBook(registerBookDto);
        System.out.println(registroNovo);
        repository.save(registroNovo);
        return new RegisterBookDto(registroNovo);
    }

    public RegisterBookDto getOne(Long id){
        var registroNovo = new RegisterBookDto(repository.getReferenceById(id));
        return registroNovo;
    }

    public Page<RegisterBookDto> listAll(Pageable pageable){
        return repository.findAll(pageable).map(RegisterBookDto::new);
    }

    public void deleteById(Long id){

        System.out.println(repository.existsById(id));
        if(!repository.existsById(id)){

            throw new ValidatorException("Não existe nenhum livro com este id");
        }else{
            repository.deleteById(id);

        }
    }

    public RegisterBookDto update(RegisterBookDto registerBookDto){

        if(!repository.existsById(registerBookDto.id())){
            throw new ValidatorException("Não existe nenhum para deletar com este id");

        }else{
            var livroParaAtualizar = new RegisterBook();
            BeanUtils.copyProperties(registerBookDto,livroParaAtualizar);
            repository.save(livroParaAtualizar);
            return new RegisterBookDto(livroParaAtualizar);

        }
    }

}
