package study.datajpa.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;

//인터페이스 기반 프로젝션
public interface UsernameOnly {

    //closed projection
    /*String getUsername();
    int getAge();*/

    //open projection
    @Value("#{target.username + ' ' + target.age}")
    String getUsername();
}
