package org.conan.libraryboot;

import lombok.extern.log4j.Log4j2;
import org.conan.libraryboot.domain.BookDTO;
import org.conan.libraryboot.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class BookServiceTests {
    @Autowired
    BookService bookService;

    @Test
    public void write() {
        BookDTO bookDTO = BookDTO.builder()
                .title("Test title1")
                .content("Test Content1")
                .writer("user001")
                .build();
        log.info(bookService.write(bookDTO));
    }
}