package org.conan.libraryboot.domain;

import lombok.Data;

import java.time.LocalDateTime;

//@Data
//public class Book {
//    //    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer bno;
//    //    @NonNull
//    private String title;
//    //    @NonNull
//    private String author;
//    //    @NonNull
//    private String publisher;
//    //    @NonNull
//    private String description;
//    //    @NonNull
//    private String isbn;
//    private Integer availability;
//    private String borrowerId;
//    private LocalDateTime startDate;
//    private LocalDateTime endDate;
//}

@Data
public class Book {
    private Integer bno;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate;
    private Integer hit;
}