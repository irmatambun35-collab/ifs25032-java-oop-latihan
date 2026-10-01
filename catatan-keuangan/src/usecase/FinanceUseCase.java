package usecase;

import domain.entity.SortOption;
import domain.entity.Transaction;
import domain.entity.TransactionType;
import domain.repository.ITransactionRepository;
import java.util.List;

/**
 * Use case yang menangani logika bisnis catatan keuangan.
 * Tidak melakukan I/O — hanya memproses data dan mengembalikan hasil.
 */
public class FinanceUseCase {
    private final ITransactionRepository repository;

    public FinanceUseCase(ITransactionRepository repository) {
        this.repository = repository;
    }

    /** Mengambil semua transaksi. */
    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    /** Menambahkan transaksi baru (pemasukan atau pengeluaran). */
    public Transaction addTransaction(String description, long amount, TransactionType type) {
        return repository.save(description, amount, type);
    }

    /** Menghapus transaksi berdasarkan ID. */
    public boolean removeTransaction(int id) {
        return repository.deleteById(id);
    }

    /** Mencari transaksi berdasarkan keterangan (case-insensitive). */
    public List<Transaction> searchTransactions(String keyword) {
        String lower = keyword.toLowerCase();
        return repository.findAll().stream()
                .filter(t -> t.getDescription().toLowerCase().contains(lower))
                .toList();
    }

    /** Mengurutkan transaksi sesuai {@link SortOption}. */
    public List<Transaction> sortTransactions(SortOption option) {
        return repository.findAll().stream()
                .sorted(option.comparator())
                .toList();
    }

    /** Menghitung saldo = total pemasukan - total pengeluaran. */
    public long getBalance() {
        long balance = 0;
        for (Transaction t : repository.findAll()) {
            if (t.getType() == TransactionType.INCOME) {
                balance += t.getAmount();
            } else {
                balance -= t.getAmount();
            }
        }
        return balance;
    }
}
