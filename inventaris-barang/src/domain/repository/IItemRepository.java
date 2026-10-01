package domain.repository;

import domain.entity.Item;
import java.util.List;
import java.util.Optional;

/** Port (kontrak) penyimpanan data barang. */
public interface IItemRepository {
    List<Item> findAll();

    Optional<Item> findById(int id);

    /** Menyimpan barang baru. Repository bertanggung jawab membuat ID unik. */
    Item save(String name, int quantity, String category);

    boolean deleteById(int id);

    /** Menyimpan perubahan pada barang yang sudah ada. */
    void update(Item item);
}
