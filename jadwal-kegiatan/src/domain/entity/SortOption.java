package domain.entity;

import java.util.Comparator;
import java.util.List;

/**
 * Kriteria pengurutan kegiatan.
 * Hari diurutkan menurut urutan pekan (Senin..Minggu), bukan abjad.
 */
public enum SortOption {
    DAY(Comparator.comparingInt((Activity a) -> dayIndex(a.getDay()))
            .thenComparing(Activity::getTime)),
    TIME(Comparator.comparing(Activity::getTime)
            .thenComparingInt(a -> dayIndex(a.getDay()))),
    TITLE_ASC(Comparator.comparing(Activity::getTitle, String.CASE_INSENSITIVE_ORDER)),
    TITLE_DESC(Comparator.comparing(Activity::getTitle, String.CASE_INSENSITIVE_ORDER).reversed());

    private static final List<String> DAYS =
            List.of("senin", "selasa", "rabu", "kamis", "jumat", "sabtu", "minggu");

    private final Comparator<Activity> comparator;

    SortOption(Comparator<Activity> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Activity> comparator() {
        return comparator;
    }

    /** Posisi hari dalam pekan; hari yang tidak dikenal ditaruh paling akhir. */
    private static int dayIndex(String day) {
        int index = DAYS.indexOf(day.trim().toLowerCase());
        return index == -1 ? DAYS.size() : index;
    }
}
