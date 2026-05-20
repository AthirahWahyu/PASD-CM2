public class DoubleLinkedListPesanan {

    NodePesanan head;
    NodePesanan tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void tambahPesanan(Pesanan dataPesanan) {

        NodePesanan nodeBaru = new NodePesanan(null, dataPesanan, null);

        if (isEmpty()) {
            head = tail = nodeBaru;
        } else {
            tail.next = nodeBaru;
            nodeBaru.prev = tail;
            tail = nodeBaru;
        }
    }

    // menggunakan algoritma Bubble Sort 
    public void sortingPesanan() {
        // apakah linked list kosong
        if (isEmpty()) {

            // keluar dari method. kalau tidak ada data, sorting tidak perlu dijalankan 
            return;
        }

        // sebagai penanda apakah ada data yang ditukar atau tidak ada pertukaran
        // true / false
        boolean tukarData;

        // perulangan do while : mengulang proses sorting sampai data benar-benar urut
        // kenapa pakai do while? karena bubble sort harus memeriksa berkali-kali sampai tidak ada pertukaran data lagi
        do {
            // menganggap pada awalnya belum ada pertukaran data
            tukarData = false;
            // membuat current (node yang sedang diperiksa saat ini)
            // current : node yang sedang dicek
            NodePesanan current = head;

            // fungsi berjalan selama masih ada node setelah current
            while (current.next != null) {

                // jika > 0 ditukan. Contoh M > B = ditukar
                if (current.data.namaPesanan.compareToIgnoreCase(current.next.data.namaPesanan) > 0) {
                    // temp untuk tempat penyimpanan sementara saat swap data
                    // kalau ditukar langsung ditukan tanpa temp data lama bisa hilang
                    Pesanan temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;

                    tukarData = true;
                }

                // membandingkan data sekarang dengan data setelahnya
                // berpindah ke node berikutnya
                current = current.next;
            }
            // jika tukarData == true berarti masih ada data yang belum urut jadi sorting diluang lagi
        } while (tukarData);

        // sorting berhenti jika tukarData == false jadi tidak ada pertukaran lagi yang berarti data sudah urut semua
    }
    
    public void tampilLaporanPesanan() {
        if (isEmpty()) {
            System.out.println("Belum ada pesanan");
            return;
        }

        sortingPesanan();

        int totalPendapatan = 0;

        System.out.println("============================================");
        System.out.println("                LAPORAN PESANAN             ");
        System.out.println("============================================");

        NodePesanan current = head;

        while (current != null) {
            System.out.println("Kode Pesanan    : " + current.data.kodePesanan);
            System.out.println("Nama Pesanan    : " + current.data.namaPesanan);
            System.out.println("Harga           : Rp " + current.data.hargaPesanan);
            System.out.println("Pemesan         : " + current.data.namaPemesan);

            System.out.println("-------------------------------------------");

            totalPendapatan += current.data.hargaPesanan;

            current = current.next;
        }

        System.out.println("Total Pendapatan    : Rp " + totalPendapatan);
    }
    
}
