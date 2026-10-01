package domain.repository;

import domain.entity.Guest;
import java.util.List;
import java.util.Optional;

/** Port (kontrak) penyimpanan data tamu. */
public interface IGuestRepository {
    List<Guest> findAll();

    Optional<Guest> findById(int id);

    /** Menyimpan tamu baru. Repository bertanggung jawab membuat ID unik. */
    Guest save(String name, String purpose);

    /** Menghapus tamu berdasarkan ID. Mengembalikan true jika berhasil. */
    boolean deleteById(int id);
}
