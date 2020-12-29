package pl.sda.librarymanagementapp.model.book;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.librarymanagementapp.domain.book.Book;
import pl.sda.librarymanagementapp.model.mapper.BookMapper;

@RestController
@RequiredArgsConstructor
@Validated
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @GetMapping("/book/{title}")

    public BookDto getBook(@PathVariable String title) {
        Book book = bookService.getBook(title);
        BookDto bookDto = bookMapper.toBookDto(book);
        bookDto.setTitle(book.getTitle());
        return bookDto;
    }
}
