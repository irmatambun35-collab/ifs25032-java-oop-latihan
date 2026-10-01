package usecase;

import domain.entity.Guest;
import domain.repository.IGuestRepository;
import java.util.List;

/** Use case buku tamu: daftarkan, cari (case-insensitive), hapus. Tanpa I/O. */
public class GuestUseCase {
    private final IGuestRepository repository;

    public GuestUseCase(IGuestRepository repository) {
        this.repository = repository;
    }

    public List<Guest> getAllGuests() {
        return repository.findAll();
    }

    public Guest registerGuest(String name, String purpose) {
        return repository.save(name, purpose);
    }

    public boolean removeGuest(int id) {
        return repository.deleteById(id);
    }

    /** Mencari tamu berdasarkan nama (case-insensitive). */
    public List<Guest> searchGuests(String keyword) {
        String lower = keyword.toLowerCase();
        return repository.findAll().stream()
                .filter(g -> g.getName().toLowerCase().contains(lower))
                .toList();
    }
}
