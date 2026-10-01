package domain.entity;

/** Entity tamu: nama dan tujuan kunjungan. */
public class Guest {
    /** ID unik tamu, tidak boleh diubah setelah dibuat. */
    private final int id;
    private String name;
    private String purpose;

    public Guest(int id, String name, String purpose) {
        this.id = id;
        this.name = name;
        this.purpose = purpose;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPurpose() {
        return purpose;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void changePurpose(String purpose) {
        this.purpose = purpose;
    }
}
