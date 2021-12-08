import java.util.Scanner;

public class Naloga_projekt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useDelimiter(System.getProperty("line.separator")); // odmiki v Stringu

        int N, S, l1 = 0, l2 = 0, l3 = 0, l4 = 0, l5 = 0, l6 = 0, l7 = 0, l8 = 0, l9 = 0, l10 = 0;

        System.out.println("Rezultati tekmovalcev ne smejo biti enaki!!!");
        System.out.println("Maksimalno stevilo skupin je 5!!!");

        System.out.print("Vnesi stevilo tekmovalcev: ");
        N = input.nextInt();
        System.out.println("-------------------------------");

        System.out.print("Vnesi stevilo skupin: ");
        S = input.nextInt();
        System.out.println("-------------------------------");

        // vnos podatkov za skupine oz. vnos letnica od do
        for (int i = 0; i < S; i++) {
            if (S < 6) {
                if (i == 0) {
                    System.out.println("Vnesi prvo skupino.");
                    System.out.print("Od letnika ");
                    l1 = input.nextInt();
                    System.out.print("Do letnika ");
                    l2 = input.nextInt();
                    System.out.println("-------------------------------");
                }
                if (i == 1) {
                    System.out.println("Vnesi drugo skupino.");
                    System.out.print("Od letnika ");
                    l3 = input.nextInt();
                    System.out.print("Do letnika ");
                    l4 = input.nextInt();
                    System.out.println("-------------------------------");
                }
                if (i == 2) {
                    System.out.println("Vnesi tretjo skupino.");
                    System.out.print("Od letnika ");
                    l5 = input.nextInt();
                    System.out.print("Do letnika ");
                    l6 = input.nextInt();
                    System.out.println("-------------------------------");
                }
                if (i == 3) {
                    System.out.println("Vnesi cetrto skupino.");
                    System.out.print("Od letnika ");
                    l7 = input.nextInt();
                    System.out.print("Do letnika ");
                    l8 = input.nextInt();
                    System.out.println("-------------------------------");
                }
                if (i == 4) {
                    System.out.println("Vnesi peto skupino.");
                    System.out.print("Od letnika ");
                    l9 = input.nextInt();
                    System.out.print("Do letnika ");
                    l10 = input.nextInt();
                    System.out.println("-------------------------------");
                }
            } else {
                System.out.println("Maksimalno stevilo skupin je 5!!!");
                System.exit(0); // konec programa
            }
        }

        String ime_priimek[] = new String[N]; // tabele - arrays
        int rojstvo[] = new int[N];
        float rez[] = new float[N];
        float skupina1[] = new float[N];
        float skupina2[] = new float[N];
        float skupina3[] = new float[N];
        float skupina4[] = new float[N];
        float skupina5[] = new float[N];

        for (int i = 0; i < N; i++) { // vnos podatkov tekmovalca
            System.out.print("Vnesi ime in priimek tekmovalca: ");
            ime_priimek[i] = input.next();

            System.out.print("Vnesi letnico rojstva: ");
            rojstvo[i] = input.nextInt();

            System.out.print("Vnesi rezultat: ");
            rez[i] = input.nextFloat();

            System.out.println("-------------------------------");
        }

        // tabela skupina1 dobi vrednost iz tabele rez, ce je if pravilen
        // to tudi velja za ostalo skupine (tabele)
        for (int i = 0; i < rojstvo.length; i++) { // vnos letnic v skupine v tabele
            if (l1 > rojstvo[i] && rojstvo[i] < l2 || rojstvo[i] == l1 || rojstvo[i] == l2) {
                skupina1[i] = rez[i];
            }
            if (l3 > rojstvo[i] && rojstvo[i] < l4 || rojstvo[i] == l3 || rojstvo[i] == l4) {
                skupina2[i] = rez[i];
            }
            if (l5 > rojstvo[i] && rojstvo[i] < l6 || rojstvo[i] == l5 || rojstvo[i] == l6) {
                skupina3[i] = rez[i];
            }
            if (l7 > rojstvo[i] && rojstvo[i] < l8 || rojstvo[i] == l7 || rojstvo[i] == l8) {
                skupina4[i] = rez[i];
            }
            if (l9 > rojstvo[i] && rojstvo[i] < l10 || rojstvo[i] == l9 || rojstvo[i] == l10) {
                skupina5[i] = rez[i];
            }
        }

        float max, max2, max3; // prvi, drugi, tretji najdaljsi skok
        max = max2 = max3 = Integer.MIN_VALUE;
        /*
         * max = rez[0]; max2 = rez[0]; max3 = rez[0];
         */

        int minLeto, maxLeto; // najstarejsi, najmlajsi
        /* minLeto = maxLeto = Integer.MIN_VALUE; */
        minLeto = rojstvo[0];
        maxLeto = rojstvo[0];

        float S1max, S2max, S3max, S4max, S5max; // najvecji in najmanjsi
        S1max = S2max = S3max = S4max = S5max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) { // preverjanje: 3 najvecja skoka, najmlajsi in najstarejsi
            if (max < rez[i]) { // 3 najvecja skoka
                max3 = max2;
                max2 = max;
                max = rez[i];
            } else if (max2 < rez[i]) {
                max3 = max2;
                max2 = rez[i];
            } else if (max3 < rez[i]) {
                max3 = rez[i];
            }

            // preverjanje najvecjega in najmanjsega stevila v tabeli rojstvo
            if (maxLeto < rojstvo[i]) { // najmlajsi in najstarejsi
                maxLeto = rojstvo[i];
            }
            if (minLeto > rojstvo[i]) {
                minLeto = rojstvo[i];
            }

            // dolocimo integeru S1max najvecjo vrednost iz tabele
            // enako za ostale integere S2max, S3max...
            if (S1max < skupina1[i]) { // zmagovalec posamezne skupine, najboljis rezultat
                S1max = skupina1[i];
            }
            if (S2max < skupina2[i]) {
                S2max = skupina2[i];
            }
            if (S3max < skupina3[i]) {
                S3max = skupina3[i];
            }
            if (S4max < skupina4[i]) {
                S4max = skupina4[i];
            }
            if (S5max < skupina5[i]) {
                S5max = skupina5[i];
            }
        }

        int m, m2, m3; // int za najdaljse skoke-vrstica
        m = m2 = m3 = 0;
        int maxL = 0; // mlajsi
        int minL = 0; // starejsi
        int s1, s2, s3, s4, s5; // int za zmagovalce skupin-vrstica
        s1 = s2 = s3 = s4 = s5 = 0;

        for (int i = 0; i < N; i++) { // preverjanje kateri je v vrstici v tabeli
            // preverimo ce je najvecje stevilo (max) ima to vrednost v tabeli rez in ko ga
            // najde integeru m dolocimo vrednost i-ja.
            // tudi isto za ostale v tem loopu
            if (max == rez[i]) {
                m = i;
            }
            if (max2 == rez[i]) {
                m2 = i;
            }
            if (max3 == rez[i]) {
                m3 = i;
            }
            if (maxLeto == rojstvo[i]) {
                maxL = i;
            }
            if (minLeto == rojstvo[i]) {
                minL = i;
            }
            if (S1max == rez[i]) {
                s1 = i;
            }
            if (S2max == rez[i]) {
                s2 = i;
            }
            if (S3max == rez[i]) {
                s3 = i;
            }
            if (S4max == rez[i]) {
                s4 = i;
            }
            if (S5max == rez[i]) {
                s5 = i;
            }
        }

        // izpis podatkov
        System.out.println("Najdaljsi skok je dosegel " + ime_priimek[m]);
        System.out.println("--------------------------------------------------");
        System.out.println(
                "Tri najdaljsa skoka so dosegli: " + ime_priimek[m] + ", " + ime_priimek[m2] + ", " + ime_priimek[m3]);
        System.out.println(
                "----------------------------------------------------------------------------------------------");
        System.out.println(
                "Najmlajsi tekmovalec je: " + ime_priimek[maxL] + " in njegova dolzina skoka je: " + rez[maxL]);
        System.out.println(
                "----------------------------------------------------------------------------------------------");
        System.out.println(
                "Najstarejsi tekmovalec je: " + ime_priimek[minL] + " in njegova dolzina skoka je: " + rez[minL]);
        System.out.println(
                "----------------------------------------------------------------------------------------------");

        for (int i = 0; i < S; i++) {
            if (i == 0) {
                System.out.println("Zmagovalec prve skupine je  " + ime_priimek[s1]);
                System.out.println("--------------------------------------------------");
            }
            if (i == 1) {
                System.out.println("Zmagovalec druge skupine je  " + ime_priimek[s2]);
                System.out.println("--------------------------------------------------");
            }
            if (i == 2) {
                System.out.println("Zmagovalec tretje skupine je  " + ime_priimek[s3]);
                System.out.println("--------------------------------------------------");
            }
            if (i == 3) {
                System.out.println("Zmagovalec cetrte skupine je  " + ime_priimek[s4]);
                System.out.println("--------------------------------------------------");
            }
            if (i == 4) {
                System.out.println("Zmagovalec pete skupine je  " + ime_priimek[s5]);
                System.out.println("--------------------------------------------------");
            }
        }
        input.close();
    }
}