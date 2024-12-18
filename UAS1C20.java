import java.util.Scanner;

public class UAS1C20 {
    static Scanner scanner20 = new Scanner(System.in);
    static String[][] dataTim20 = new String[5][4];

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n================================");
            System.out.println("           MENU UTAMA           ");
            System.out.println("================================");
            System.out.println("1. Input Data Skor Tim");
            System.out.println("2. Tampilkan Tabel Skor");
            System.out.println("3. Tentukan Juara");
            System.out.println("4. Keluar");

            String pilihan20;

            while (true) {
                System.out.print("\nPilih menu (1-4) : ");
                pilihan20 = scanner20.nextLine();

                if (pilihan20.equals("1") || pilihan20.equals("2") || pilihan20.equals("3") || pilihan20.equals("4")) {
                    break;
                } else {
                    System.out.println("Pilihan menu tidak valid. Coba lagi!");
                }
            }

            if (pilihan20.equals("1")) {
                inputAja20();
            } else if (pilihan20.equals("2")) {
                showSkor20();
            } else if (pilihan20.equals("3")) {
                tentukanJuara20();
            } else if (pilihan20.equals("4")) {
                System.out.println("\nKeluar dari sistem.");
                break;
            }
        }
    }

    static void inputAja20() {
        System.out.println("\n====================================");
        System.out.println("            FORM INPUT DATA          ");
        System.out.println("=====================================");
        String namaTim20;
        int level120, level220;

        for (int i = 0; i < dataTim20.length; i++) {
            System.out.print("\nMasukkan Nama Tim ke-" + (i + 1) + ": ");
            namaTim20 = scanner20.nextLine();

            while (true) {
                System.out.print("Masukkan Skor " + namaTim20 + " untuk Level 1 : ");
                level120 = scanner20.nextInt();

                if (level120 < 1) {
                    System.out.println("Skor tidak boleh negatif. Coba lagi");
                } else if (level120 < 35) {
                    level120 = 0;
                    break;
                } else {
                    break;
                }
            }
            while (true) {
                System.out.print("Masukkan Skor " + namaTim20 + " untuk Level 2 : ");
                level220 = scanner20.nextInt();

                if (level220 < 1) {
                    System.out.println("Skor tidak boleh negatif. Coba lagi");
                } else {
                    break;
                }
            }
            scanner20.nextLine();

            int totalSkor20 = level120 + level220;
            if (totalSkor20 % 2 == 0) {
                totalSkor20 -= 15;
            } else if (level120 > 50 && level220 > 50) {
                totalSkor20 += 50;
            }

            dataTim20[i][0] = namaTim20;
            dataTim20[i][1] = String.valueOf(level120);
            dataTim20[i][2] = String.valueOf(level220);
            dataTim20[i][3] = String.valueOf(totalSkor20);
        }
    }

    static void showSkor20() {
        System.out.println("\n=========================================");
        System.out.println("            TABEL SKOR TURNAMEN          ");
        System.out.println("=========================================");
        System.out.println();
        if (dataTim20[0][0] == null) {
            System.out.println("Tabel masih kosong. Mohon input data terlebih dahulu");
        } else {
            System.out.println("Nama Tim\tLevel 1\tLevel 2\tTotal Skor");
            for (int i = 0; i < dataTim20.length; i++) {
                String nmTim20 = dataTim20[i][0];
                String lvl120 = dataTim20[i][1];
                String lvl220 = dataTim20[i][2];
                String totalSkor20 = dataTim20[i][3];

                System.out.println(nmTim20 + "\t\t  " + lvl120 + "\t  " + lvl220 + "\t  " + totalSkor20);
            }
        }
    }

    static void tentukanJuara20() {
        System.out.println("\n=========================================");
        System.out.println("           PENENTUAN JUARA              ");
        System.out.println("=========================================");

        if (dataTim20[0][0] == null) {
            System.out.println("Tabel masih kosong. Mohon input data terlebih dahulu.");
        } else {
            int maxSkor20 = -1;
            String juara20 = "";
            int level2Juara20 = -1;
            boolean seri20 = false;

            for (int i = 0; i < dataTim20.length; i++) {
                String nmTim20 = dataTim20[i][0];
                int lvl120 = Integer.parseInt(dataTim20[i][1]);
                int lvl220 = Integer.parseInt(dataTim20[i][2]);
                int totalSkor20 = Integer.parseInt(dataTim20[i][3]);

                if (totalSkor20 > maxSkor20) {
                    maxSkor20 = totalSkor20;
                    juara20 = nmTim20;
                    level2Juara20 = lvl220;
                    seri20 = false;
                } else if (totalSkor20 == maxSkor20) {
                    if (lvl220 > level2Juara20) {
                        juara20 = nmTim20;
                        level2Juara20 = lvl220;
                        seri20 = false;
                    } else if (lvl220 == level2Juara20) {
                        seri20 = true;
                    }
                }
            }

            if (seri20) {
                System.out.println("Pertandingan berakhir dengan hasil seri.");
            } else {
                System.out.println("Juara Turnamen: " + juara20 + " dengan Total Skor: " + maxSkor20);
            }
        }
    }
}
