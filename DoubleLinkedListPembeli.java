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
}
