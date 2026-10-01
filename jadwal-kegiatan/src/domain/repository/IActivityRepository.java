package domain.repository;

import domain.entity.Activity;
import java.util.List;
import java.util.Optional;

/** Port (kontrak) penyimpanan data kegiatan. */
public interface IActivityRepository {
    List<Activity> findAll();

    Optional<Activity> findById(int id);

    /** Menyimpan kegiatan baru. Repository bertanggung jawab membuat ID unik. */
    Activity save(String title, String day, String time);

    boolean deleteById(int id);

    /** Menyimpan perubahan pada kegiatan yang sudah ada. */
    void update(Activity activity);
}
