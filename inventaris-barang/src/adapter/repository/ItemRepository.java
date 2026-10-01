package adapter.repository;

import domain.entity.Item;
import domain.repository.IItemRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/** Implementasi repository barang menggunakan penyimpanan in-memory berbasis List. */
public class ItemRepository implements IItemRepository {
    private final List<Item> data = new ArrayList<>();
    private int idCounter = 0;

    @Override
    public List<Item> findAll() {
        // Salinan defensif agar data internal tidak bisa diubah dari luar
        return new ArrayList<>(data);
    }

    @Override
    public Optional<Item> findById(int id) {
        return data.stream().filter(i -> i.getId() == id).findFirst();
    }

    @Override
    public Item save(String name, int quantity, String category) {
        Item item = new Item(++idCounter, name, quantity, category);
        data.add(item);
        return item;
    }

    @Override
    public boolean deleteById(int id) {
        return data.removeIf(i -> i.getId() == id);
    }

    @Override
    public void update(Item item) {
        // Entity disimpan by-reference sehingga perubahan sudah tercermin di memori.
        // Method tetap ada agar kontrak port valid untuk implementasi lain (mis. database).
    }
}
