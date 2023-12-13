import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Kelas utama (Driver Class)
public class MinimarketProgram {
    public static boolean validasiLogin(String enteredUsername, String enteredPassword ) {
        String validUsername = "hellorena";
        String validPassword = "RN040804";

        return validUsername.equals (enteredUsername) && validPassword.equals(enteredPassword);
    }
    public static String generateCaptcha(){
        return "RGNNTHMY0211";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isValidLogin = false;
        boolean isValidCaptcha = false;

        do {
            //Login
            System.out.println("");
            System.out.println("Selamat Datang di RENA Mart <3 ");
            System.out.println("===================================");
            System.out.println("");
            System.out.print("Username        : ");
            String username = scanner.nextLine();

            System.out.print("Password        : ");
            String password = scanner.nextLine();
            System.out.println("");
            System.out.println("----------------------------------");

            //Login dengan string equals
            isValidLogin = validasiLogin(username, password);

            if (!isValidLogin) {
                System.out.println("Login tidak berhasil. Silahkan coba kembali");
                System.out.println("------------------------------");
                System.out.println("");
            }
        }   while (!isValidLogin);

        do {
            //CAPTCHA
            String expectedCaptcha = generateCaptcha();
            System.out.println("");
            System.out.println("CAPTCHA                      : " + expectedCaptcha);

            System.out.println("Masukkan kode CAPTCHA        : ");
            String enteredCaptcha = scanner.nextLine();

            //Method String equalsIgnoreCase
            isValidCaptcha = expectedCaptcha.equalsIgnoreCase(enteredCaptcha);
            
            if (!isValidCaptcha) {
                System.out.println("");
                System.out.println("CAPTCHA yang anda masukkan salah. Silahkan coba kembali! ");
            }
        } while (!isValidCaptcha);

            System.out.println("");
            System.out.println("---------------------------------");
             System.out.println("");
            System.out.println("          LOGIN BERHASIL");
            System.out.println("");
            System.out.println("==================================");
            System.out.println("");
            System.out.println("Silahkan Masukkan Data");
            
        //Exception
        try {
            System.out.print("No. Faktur        : ");
            String noFaktur = scanner.nextLine();

            System.out.print("Nama Pelanggan    : ");
            String namaPelanggan = scanner.nextLine();

            System.out.print("No. HP            : ");
            String noHp = scanner.nextLine();

            System.out.print("Alamat            : ");
            String alamat = scanner.nextLine();


            System.out.print("Nama Barang       : ");
            String namaBarang = scanner.nextLine();

            System.out.print("Kode Barang       : ");
            String kodeBarang = scanner.nextLine();

            System.out.print("Harga Barang      : ");
            double hargaBarang = scanner.nextDouble();

            System.out.print("Jumlah Barang     : ");
            int jumlahBarang = scanner.nextInt();

            System.out.println("Total Bayar       : " + hargaBarang*jumlahBarang);

            if (jumlahBarang <= 0) {
                throw new IllegalArgumentException("Jumlah barang harus lebih dari 0");
            }

            BarangRumahTangga sembako = new BarangRumahTangga(namaBarang, hargaBarang, jumlahBarang);

            Faktur faktur = new Faktur(noFaktur, namaPelanggan, sembako);

            faktur.display();

            //Jam
            Date date = new Date();
            SimpleDateFormat hari = new SimpleDateFormat("'Hari/Tanggal \t:' EEEEEEEEEE dd-MM-yyyy");
            SimpleDateFormat jam = new SimpleDateFormat(" 'Waktu \t\t:' hh:mm:ss z");

            //Tampilan Struk
            System.out.println(" ");
            System.out.println("============RENA MART============");
            System.out.println(" ");
            System.out.println(hari.format(date));
            System.out.println(jam.format(date));
            System.out.println(" ");
            System.out.println("==================================");
            System.out.println(" ");
            System.out.println("           DATA PELANGGAN         ");
            System.out.println(" ");
            System.out.println("----------------------------------");
            System.out.println(" ");
            System.out.println("Nama Pelanggan        : " + namaPelanggan);
            System.out.println("No.Hp                 : " + noHp);
            System.out.println("Alamat                : " + alamat);
            System.out.println(" ");
            System.out.println("===================================");
            System.out.println(" ");
            System.out.println("          PEMBELIAN BARANG        ");
            System.out.println(" ");
            System.out.println("-----------------------------------");
            System.out.println(" ");
            System.out.println("Kode Barang           : " + kodeBarang);
            System.out.println("Nama Barang           : " + namaBarang);
            System.out.println("Harga Barang          : " + hargaBarang);
            System.out.println("Jumlah Barang         : " + jumlahBarang);
            System.out.println("Total Bayar           : " + jumlahBarang*hargaBarang);
            System.out.println(" ");
            System.out.println("----------------------------------");
            System.out.println(" ");
            System.out.println("Kasir                 : REGINA " );
            System.out.println(" ");
            System.out.println("====================================");
            
            //ToUpperCase
            System.out.println("toUpperCase\t           : " + namaPelanggan.toUpperCase());
            System.out.println(" ");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close(); 
        }
    }
}
