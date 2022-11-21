package hello.itemservice.repository.jpa;

import hello.itemservice.domain.Item;
import hello.itemservice.repository.ItemRepository;
import hello.itemservice.repository.ItemSearchCond;
import hello.itemservice.repository.ItemUpdateDto;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

public class JpaItemRepositoryV2 implements ItemRepository {

    private final SpringDataJpaItemRepository repository;

    public JpaItemRepositoryV2(SpringDataJpaItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public Item save(Item item) {
        return repository.save(item);
    }

    @Override
    public void update(Long itemId, ItemUpdateDto updateParam) {
        Optional<Item> findItem = repository.findById(itemId);
        findItem.orElseThrow().setItemName(updateParam.getItemName());
        findItem.orElseThrow().setPrice(updateParam.getPrice());
        findItem.orElseThrow().setQuantity(updateParam.getQuantity());
    }

    @Override
    public Optional<Item> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Item> findAll(ItemSearchCond cond) {
        String name = cond.getItemName();
        Integer maxprice = cond.getMaxPrice();

        if (StringUtils.hasText(name) && maxprice != null) {
            return repository.findItems("%"+name+"%", maxprice);
        } else if (maxprice != null) {
            return repository.findByPriceLessThanEqual(maxprice);
        } else if (StringUtils.hasText(name)) {
            return repository.findByItemNameLike("%"+name+"%");
        } else {
            return repository.findAll();
        }
    }
}
