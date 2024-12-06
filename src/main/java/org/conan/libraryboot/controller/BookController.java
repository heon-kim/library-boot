package org.conan.libraryboot.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.conan.libraryboot.domain.Book;
import org.conan.libraryboot.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/book/*")
@AllArgsConstructor
public class BookController {
    private BookService bookService;

    @GetMapping("/list")
    public void list(Model model) {
        List<Book> bList = bookService.getList();
        model.addAttribute("bList", bList);
        log.info("bList: " + bList);
    }

    @GetMapping("/write")
    public void registerPage() {
        log.info("write");
    }

    @PostMapping("/write")
    public String register(Book book, RedirectAttributes rttr) {
        log.info("write: {}", book);
        bookService.write(book);
        rttr.addFlashAttribute("result", book.getBno());
        return "redirect:/book/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(@RequestParam("bno") Integer bno, Model model) {
        log.info("/read or /write");
        model.addAttribute("book", bookService.read(bno));
    }

    @PostMapping("/modify")
    public String modify(Book book, RedirectAttributes rttr) {
        log.info("modify: {}", book);
        if (bookService.modify(book)) {
            rttr.addFlashAttribute("result", "success");
            return "redirect:/book/list";
        }
        return "/book/modify";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("bno") Integer bno, RedirectAttributes rttr) {
        log.info("remove..........{}", bno);
        if (bookService.remove(bno)) {
            rttr.addFlashAttribute("result", "success");
        }
        return "redirect:/book/list";
    }
}