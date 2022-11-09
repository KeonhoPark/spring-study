package hello.itemservice.config;

import hello.itemservice.repository.jdbctemplate.JdbcTemplateItemRepositoryV1;
import hello.itemservice.repository.jdbctemplate.JdbcTemplateItemRepositoryV2;
import hello.itemservice.service.ItemServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class JdbcTemplateV2Config {

    private final DataSource dataSource;

    @Bean
    public ItemServiceV1 itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public JdbcTemplateItemRepositoryV2 itemRepository() {
        return new JdbcTemplateItemRepositoryV2(dataSource);
    }
}
