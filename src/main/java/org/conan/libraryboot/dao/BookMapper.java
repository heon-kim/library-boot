package org.conan.libraryboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.conan.libraryboot.domain.Book;

import java.util.List;

@Mapper
public interface BookMapper {
    //    @Select("SELECT * FROM BOARD WHERE BNO > 0")
    public List<Book> getList();

    public int insert(Book board);

    public int insertSelectKey(Book board);

    public Book read(int bno);

    public int increaseHit(int bno);

    public int delete(int bno);

    public int update(Book board);
}
