package org.conan.libraryboot.service;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.conan.libraryboot.dao.BookMapper;
import org.conan.libraryboot.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class BookService {
    @Setter(onMethod_ = @Autowired)
    private BookMapper bookMapper;

    public List<Book> getList() {
        log.info("getList............");
        List<Book> list = bookMapper.getList();
        return list != null ? list : List.of();
    }

    public void write(Book book) {
        log.info("write.......{}", book.getBno());
        bookMapper.insertSelectKey(book);
    }

    public Book read(Integer bno) {
        log.info("get..........{}", bno);
        return bookMapper.read(bno);
    }

    public boolean modify(Book book) {
        log.info("modify............{}", book);
        return bookMapper.update(book) == 1;
    }

    public boolean remove(Integer bno) {
        log.info("remove.......{}", bno);
        return bookMapper.delete(bno) == 1;
    }
}
