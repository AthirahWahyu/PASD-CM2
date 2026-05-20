public class Pesanan {

    int kodePesanan;
    String namaPesanan;
    int hargaPesanan;
    String namaPemesan;

    // yang di dalam kurung adalah parameter
    public Pesanan(int kodePesanan, String namaPesanan, int hargaPesanan, String namaPemesan) {

        // konstruktor 
        this.kodePesanan = kodePesanan;
        this.namaPesanan = namaPesanan;
        this.hargaPesanan = hargaPesanan;
        this.namaPemesan = namaPemesan;
    }  
}
