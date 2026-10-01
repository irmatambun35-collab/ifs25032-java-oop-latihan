package domain.repository;

import domain.entity.Contact;
import java.util.List;
import java.util.Optional;

/** Port (kontrak) penyimpanan data kontak. */
public interface IContactRepository {
    List<Contact> findAll();

    Optional<Contact> findById(int id);

    /** Menyimpan kontak baru. Repository bertanggung jawab membuat ID unik. */
    Contact save(String name, String phone, String email);

    boolean deleteById(int id);

    /** Menyimpan perubahan pada kontak yang sudah ada. */
    void update(Contact contact);
}
