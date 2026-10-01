## Cara menjalankan (contoh: catatan-keuangan)

    cd catatan-keuangan
    javac -d output -sourcepath src src/App.java
    java -cp output App

Ganti `catatan-keuangan` dengan `buku-tamu`, `inventaris-barang`, `jadwal-kegiatan`, atau `kontak-teman`.

## Menjalankan test case

Satu TC:   java -cp output App < test-cases/TC-01.tc
Semua TC:  bash run-all-tests.sh   (hasil tersimpan sebagai TC-0X.out)
