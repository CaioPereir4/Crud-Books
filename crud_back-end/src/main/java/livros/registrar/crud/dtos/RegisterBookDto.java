package livros.registrar.crud.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import livros.registrar.crud.models.RegisterBook;


public record RegisterBookDto(

        Long id,

        @NotBlank String nameUser,
        @NotBlank String nameBook,

        @NotBlank String nameAuthor,

        @NotNull int rate,

        @NotBlank String  review,
        @NotBlank String imageUrl,
        @NotBlank String category

) {
    public RegisterBookDto(RegisterBook registroNovo) {
        this(registroNovo.getId(), registroNovo.getNameUser(), registroNovo.getNameBook(), registroNovo.getNameAuthor(), registroNovo.getRate(), registroNovo.getReview(), registroNovo.getImageUrl(), registroNovo.getCategory());
    }
}
