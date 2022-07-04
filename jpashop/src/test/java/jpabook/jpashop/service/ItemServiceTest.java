package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemServiceTest {

    @Autowired ItemService itemService;
    @Autowired ItemRepository itemRepository;


    @Test
    public void saveItem() throws Exception{
        //given
        Book book = new Book();
        book.setAuthor("park");

        //when
        itemService.saveItem(book);
        Item findItem = itemService.findOne(book.getId());
        //then

        Assertions.assertThat(findItem).isEqualTo(book);


    }

    @Test
    public void findItems() throws Exception{
        //given

        Book book1 = new Book();
        book1.setAuthor("park");
        Book book2 = new Book();
        book2.setAuthor("kim");

        //when

        itemService.saveItem(book1);
        itemService.saveItem(book2);
        List<Item> items = itemService.findItems();
        //then

        Assertions.assertThat(items.size()).isEqualTo(2);
        Assertions.assertThat(items).contains(book1, book2);

    }

    @Test
    public void findOne() throws Exception{
        //given

        Book book = new Book();
        book.setAuthor("park");
        itemService.saveItem(book);

        //when

        Item findItem = itemService.findOne(book.getId());

        //then

        Assertions.assertThat(findItem).isEqualTo(book);


    }
}