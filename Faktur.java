// implementasi interface dan exception handling
class Faktur implements HitungTotalBayar {
    private String noFaktur;
    private String namaPelanggan;
    private Barang barang;
    private double totalBayar;

    public Faktur(String noFaktur, String namaPelanggan, Barang barang) {
        this.noFaktur = noFaktur;
        this.namaPelanggan = namaPelanggan;
        this.barang = barang;
    }

    public void setTotalBayar(double totalBayar) {
        if (totalBayar < 0) {
            throw new IllegalArgumentException("Total bayar tidak boleh negatif");
        }
        this.totalBayar = totalBayar;
    }

    @Override
    public double hitungTotalBayar() {
        return barang.hargaBarang * barang.jumlahBarang;
    }

    public void display() {
        System.out.println("=============================================");
        System.out.println("No. Faktur      : " + noFaktur);
        System.out.println("Nama Pelanggan  : " + namaPelanggan);
        barang.display();
        System.out.println("Total Bayar     : " + totalBayar);
        System.out.println("-----------------------------------------------");
    }
}

