package adapter.repository;

import domain.entity.Contact;
import domain.repository.IContactRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/** Implementasi repository kontak menggunakan penyimpanan in-memory berbasis List. */
public class ContactRepository implements IContactRepository {
    private final List<Contact> data = new ArrayList<>();
    private int idCounter = 0;

    @Override
    public List<Contact> findAll() {
        // Salinan defensif agar data internal tidak bisa diubah dari luar
        return new ArrayList<>(data);
    }

    @Override
    public Optional<Contact> findById(int id) {
        return data.stream().filter(c -> c.getId() == id).findFirst();
    }

    @Override
    public Contact save(String name, String phone, String email) {
        Contact contact = new Contact(++idCounter, name, phone, email);
        data.add(contact);
        return contact;
    }

    @Override
    public boolean deleteById(int id) {
        return data.removeIf(c -> c.getId() == id);
    }

    @Override
    public void update(Contact contact) {
        // Entity disimpan by-reference sehingga perubahan sudah tercermin di memori.
    }
}
