package domain.entity;

import java.util.Comparator;

/**
 * Kriteria pengurutan transaksi.
 * Setiap opsi membawa comparator-nya sendiri sehingga logika pengurutan
 * terpusat di domain.
 */
public enum SortOption {
    /** Jumlah dari yang terbesar ke terkecil. */
    AMOUNT_DESC(Comparator.comparingLong(Transaction::getAmount).reversed()),

    /** Jumlah dari yang terkecil ke terbesar. */
    AMOUNT_ASC(Comparator.comparingLong(Transaction::getAmount)),

    /** Pemasukan ditampilkan terlebih dahulu. */
    INCOME_FIRST(Comparator.comparing(Transaction::getType)),

    /** Pengeluaran ditampilkan terlebih dahulu. */
    EXPENSE_FIRST(Comparator.comparing(Transaction::getType).reversed());

    private final Comparator<Transaction> comparator;

    SortOption(Comparator<Transaction> comparator) {
        this.comparator = comparator;
    }

    /** Mengembalikan comparator yang sesuai dengan opsi ini. */
    public Comparator<Transaction> comparator() {
        return comparator;
    }
}
