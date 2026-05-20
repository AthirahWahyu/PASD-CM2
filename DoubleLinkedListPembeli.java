public class DoubleLinkedListPembeli {

    NodePembeli head;
    NodePembeli tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void tambahAntrian(Pembeli dataPembeli) {

        NodePembeli nodeBaru = new NodePembeli(null, dataPembeli, null);

        if (isEmpty()) {
            head = tail = nodeBaru;
        } else {
            tail.next = nodeBaru;
            nodeBaru.prev = tail;
            tail = nodeBaru;
        }
    }

    public void cetakAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian masih kosong.");
            return;
        }

        System.out.println("============================================");
        System.out.println("                DAFTAR ANTRIAN              ");
        System.out.println("============================================");

        NodePembeli current = head;

        while (current != null) {
            
            System.out.println("Nomor Antrian   : " + current.data.nomorAntrian);
            System.out.println("Nama Pembeli    : " + current.data.namaPembeli);
            System.out.println("Nomor HP        : " + current.data.nomorHP);

            System.out.println("-------------------------------------------");

            // Proses traversal dilakukan menggunakan pointer next hingga mencapai node terakhir
            current = current.next;
        }
    }

    public Pembeli hapusAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return null;   
        }

        Pembeli dataDihapus = head.data;

        if (head == tail) {
            head = tail = null;
        } else {
            // antrian paling depan dihapus
            // Pembeli paling depan sedang memesan makanan/minuman
            head = head.next;
            head.prev = null;
        }

        return dataDihapus;
    }

    public int jumlahAntrian() {
        int jumlah = 0;
        NodePembeli current = head;
        while (current != null) {
            jumlah++;
            current = current.next;
        }

        return jumlah;
    } 

    public void batalAntrian(int nomorAntrian) {

        if (isEmpty()) {

            System.out.println("Antrian kosong");
            return;
    }

        NodePembeli current = head;

        while (current != null) {

            if (current.data.nomorAntrian == nomorAntrian) {

                if (head == tail) {

                    head = tail = null;
            }
            // jika node di pertama atau head
            else if (current == head) {

                head = head.next;
                head.prev = null;
            }
            // jika node di terakhir atau tail
            else if (current == tail) {

                tail = tail.prev;
                tail.next = null;
            }

            else {

                current.prev.next = current.next;
                current.next.prev = current.prev;
            }

            System.out.println("Antrian atas nama " + current.data.namaPembeli + " berhasil dibatalkan.");

            return;
        }

        current = current.next;
    }

    System.out.println("Nomor antrian tidak ditemukan.");
}

}
