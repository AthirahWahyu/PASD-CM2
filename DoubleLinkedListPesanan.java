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

    public void sortingPesanan() {
        if (isEmpty()) {
            return;
        }

        boolean tukarData;

        do {
            tukarData = false;
            NodePesanan current = head;

            while (current.next != null) {

                if (current.data.namaPesanan.compareToIgnoreCase(current.next.data.namaPesanan) > 0) {

                    Pesanan temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;

                    tukarData = true;
                }

                current = current.next;
            }
        } while (tukarData);
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
