interface HitungTotalBayar {
    double hitungTotalBayar();
}

class Barang {
    protected String namaBarang;
    protected double hargaBarang;
    protected int jumlahBarang;

    public Barang(String namaBarang, double hargaBarang, int jumlahBarang) {
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.jumlahBarang = jumlahBarang;
    }

    public void display() {
        System.out.println("Nama Barang     : " + namaBarang);
        System.out.println("Harga Barang    : " + hargaBarang);
        System.out.println("Jumlah Barang   : " + jumlahBarang);
    }
}

class BarangRumahTangga extends Barang {
    public BarangRumahTangga(String namaBarang, double hargaBarang, int jumlahBarang) {
        super(namaBarang, hargaBarang, jumlahBarang);
    }

    @Override
    public void display() {
        System.out.println("Barang Rumah Tangga");
        super.display();
    }
}
