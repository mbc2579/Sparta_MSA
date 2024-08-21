package com.example.locking.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public void updateItemQuantity(Long itemId, Integer newQuantity) {
        Item item = itemRepository.findByIdWithLock(itemId);

        item.setQuantity(newQuantity);

        itemRepository.save(item);
    }

    @Transactional(timeout = 1, isolation = Isolation.SERIALIZABLE)
    public Item findItemById(Long itemId) {
        return itemRepository.findById(itemId).orElse(null);
    }

    public void updateItemsQuantity(Long itemId1, Long itemId2) {
        Item item1 = itemRepository.findByIdWithLock(itemId1);
        item1.setQuantity(item1.getQuantity() + 10);
        itemRepository.save(item1);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Item item2 = itemRepository.findByIdWithLock(itemId2);
        item2.setQuantity(item2.getQuantity() + 10);
        itemRepository.save(item2);
    }
}
