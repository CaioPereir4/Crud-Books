package livros.registrar.crud.models;

import jakarta.persistence.*;
import livros.registrar.crud.dtos.RegisterBookDto;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "registries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class RegisterBook implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nameUser;

    @Column(nullable = false)
    private String nameBook;

    @Column(nullable = false)
    private String nameAuthor;

    @Column(nullable = false)
    private int rate;

    @Column(nullable = false)
    private String review;

    private String imageUrl;

    private String category;

    public RegisterBook(RegisterBookDto registerBookDto){
        this.nameAuthor= registerBookDto.nameAuthor();
        this.review = registerBookDto.review();
        this.nameBook = registerBookDto.nameBook();
        this.rate = registerBookDto.rate();
        this.nameUser = registerBookDto.nameUser();
        this.imageUrl = registerBookDto.imageUrl();
        this.category = registerBookDto.category();
    }



}
