package study.datajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.datajpa.entity.Member;
import study.datajpa.repository.MemberJpaRepository;

@RestController
public class HelloController {

    @Autowired
    private MemberJpaRepository memberJpaRepository;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
