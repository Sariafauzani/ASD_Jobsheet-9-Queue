package Tugas;
import java.util.Scanner;

public class QueueMain {
    public static void menu() {
        System.out.println("Pilih menu: ");
        System.out.println("1. Antrian baru");
        System.out.println("2. Antrian keluar");
        System.out.println("3. Cek Antrian terdepan");
        System.out.println("4. Cek Semua Antrian");
        System.out.println("5. Cek Antrian paling belakang");
        System.out.println("6. Cek posisi antrian pasien");
        System.out.println("7. Daftar pasien");
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        Scanner sc26 = new Scanner(System.in);

        System.out.print("Masukkan kapasitas queue: ");
        int jumlah = sc26.nextInt();
        Queue antri = new Queue(jumlah);
        int pilih;

        do {
            menu();
            pilih = sc26.nextInt();
            sc26.nextLine();
            switch (pilih){
                case 1:
                    System.out.print("Nama: ");
                    String nama = sc26.nextLine();
                    System.out.print("No. ID: ");
                    int noID = sc26.nextInt();
                    System.out.print("Jenis Kelamin [P/L]: ");
                    char jenisKelamin = sc26.next().charAt(0);
                    System.out.print("Umur: ");
                    int umur = sc26.nextInt();
                    Pasien26 ps = new Pasien26(nama, noID, jenisKelamin, umur);
                    sc26.nextLine();
                    antri.Enqueue(ps);
                    break;
                case 2:
                    Pasien26 antrian = antri.Dequeue();
                    if (antrian != null && !"".equals(antrian.nama) && antrian.noID != 0 && !"".equals(antrian.jenisKelamin) && antrian.umur != 0) {
                    System.out.println("Antrian yang keluar: " + antrian.nama + " " + antrian.noID + " " + antrian.jenisKelamin + " " + antrian.umur);
                    }
                    break;
                case 3:
                    antri.peek();
                    break;
                case 4:
                    antri.print();
                    break;
                case 5:
                    antri.peekRear();
                    break;
                case 6:
                    System.out.print("Nama pasien: ");
                    String namaPasien = sc26.nextLine();
                    antri.peekPosition(namaPasien);
                    break;
                case 7:
                    antri.daftarPasien();
                    break;
                }
        } while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5
         || pilih == 6 || pilih == 7);
    }
}