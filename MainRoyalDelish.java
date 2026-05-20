import java.util.Scanner;

public class MainRoyalDelish {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        DoubleLinkedListPembeli daftarAntrian = new DoubleLinkedListPembeli();

        DoubleLinkedListPesanan daftarpesanan =new DoubleLinkedListPesanan();

        // 4 data ini disimpan ke double linked list antrean
        daftarAntrian.tambahAntrian(new Pembeli(1, "Ainra", "08224500000"));
        daftarAntrian.tambahAntrian(new Pembeli(2, "Danra", "08224511111"));
        daftarAntrian.tambahAntrian(new Pembeli(3, "Sanri", "08224522222"));
        daftarAntrian.tambahAntrian(new Pembeli(4, "Vania", "08422234556"));

        int nomorAntrianOtomatis = 5;
        int pilihanMenu;

        do {

            System.out.println();
            System.out.println("============================================");
            System.out.println("             ROYAL DELISH RESTO             ");
            System.out.println("============================================");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian dan Pesan");
            System.out.println("4. Laporan Pesanan");
            System.out.println("5. Batalkan Antrian");
            System.out.println("6. Keluar");
            System.out.println("============================================");

            System.out.print("Pilih Menu : ");
            pilihanMenu = input.nextInt();
            input.nextLine();

            switch (pilihanMenu) {
                case 1:
                    System.out.println();
                    System.out.println("===== TAMBAH ANTRIAN =====");

                    System.out.print("Nama Pembeli    : ");
                    String namaPembeli = input.nextLine();

                    System.out.print("Nomor HP        : ");
                    String nomorHP = input.nextLine();

                    // membuat object baru dan dimasukkan ke linked list antrean
                    Pembeli pembeliBaru = new Pembeli(nomorAntrianOtomatis, namaPembeli, nomorHP);

                    daftarAntrian.tambahAntrian(pembeliBaru);

                    System.out.println();
                    System.out.println("Antrian berhasil ditambahkan");
                    System.out.println("Nomor Antrian : " + nomorAntrianOtomatis);

                    nomorAntrianOtomatis++;
                    break;
                case 2:
                    System.out.println();
                    // menampilkan seluruh antrean dari head sampai tail menggunakan traversal (print)
                    // traversal digunakan untuk mengakses seluruh node dalam list
                    daftarAntrian.cetakAntrian();

                    System.out.println("Jumlah Antrian : " + daftarAntrian.jumlahAntrian());
                    break;
                
                case 3:
                    System.out.println();
                    System.out.println("===== HAPUS ANTRIAN =====");

                    Pembeli pembeliDilayani = daftarAntrian.hapusAntrian();

                    if (pembeliDilayani != null) {
                        System.out.println();
                        System.out.println("Pembeli dipanggil");
                        
                        
                        System.out.println("Nomor Antrian   : " + pembeliDilayani.nomorAntrian);
                        System.out.println("Nama Pembeli    : " + pembeliDilayani.namaPembeli);

                    System.out.println();

                    System.out.print("Kode Pesanan    : ");
                    int kodePesanan = input.nextInt();
                    input.nextLine();
                    
                    System.out.print("Nama Pesanan    : ");
                    String namaPesanan = input.nextLine();

                    System.out.print("Harga Pesanan   : ");
                    int hargaPesanan = input.nextInt();
                    
                    // membuat object pesanan dan disimpan ke linked list pesanan
                    Pesanan pesananBaru = new Pesanan(kodePesanan, namaPesanan, hargaPesanan, pembeliDilayani.namaPembeli);

                    daftarpesanan.tambahPesanan(pesananBaru);

                    System.out.println();
                    System.out.println(pembeliDilayani.namaPembeli + " telah memesan " + namaPesanan);
                    System.out.println("Pesanan berhasil ditambahkan");
                    System.out.println("Sisa Antrian : " + daftarAntrian.jumlahAntrian());
                }
                
                    break;

                case 4:
                    System.out.println();
                    daftarpesanan.tampilLaporanPesanan();
                    // daftarpesanan.sortingHargaDescending();

                    break;
                
                case 5:
                    System.out.println();
                    System.out.println("============================================");
                    System.out.println("              BATALKAN ANTRIAN              ");
                    System.out.println("============================================");
                    System.out.print("Masukkan nomor antrian : ");
                    int nomorBatal = input.nextInt();

                    daftarAntrian.batalAntrian(nomorBatal);

                    System.out.println();
                    daftarAntrian.cetakAntrian();
                    System.out.println("Jumlah Antrian : " + daftarAntrian.jumlahAntrian());

                    break;
                case 6:
                    System.out.println();
                    System.out.println("Terima kasih telah berkunjung.");

                    break; 

                default:
                    System.out.println();
                    System.out.println("Menu tidak tersedia");
            }
        } while (pilihanMenu != 6);

        input.close();
    }
}