#!/bin/bash
# Compile semua studi kasus lalu jalankan TC-01..TC-04 dan simpan hasilnya ke <studi-kasus>/test-cases/TC-0X.out
cd "$(dirname "$0")"
for dir in catatan-keuangan buku-tamu inventaris-barang jadwal-kegiatan kontak-teman; do
  echo "=== $dir ==="
  (cd "$dir" && rm -rf output && javac -d output -sourcepath src src/App.java) || exit 1
  for tc in "$dir"/test-cases/TC-0*.tc; do
    java -cp "$dir/output" App < "$tc" > "${tc%.tc}.out"
    echo "  $(basename "$tc") -> $(basename "${tc%.tc}.out")"
  done
done
