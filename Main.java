import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu();
    }
    public static void Menu() {
        String gl = "~Головне меню~";
        String play = "~1.Грати(Нова гра)~";
        String settings = "~2.Налаштування~";
        String perevirka = "~3.Статистика~";
        String exit = "~4.Вихід~";
        String str = gl + "\n" + play + "\n" + settings + "\n" + perevirka + "\n" + exit + "\n";
        System.out.println(str);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Оберіть функцію: ");
        boolean func = scanner.hasNextInt();
        while (!func) {
            System.out.println("Ви ввели не вірне значення.");
            scanner.next();
            func = true;
        }
        while (true) {
            int a = scanner.nextInt();
            if (a == 1) {
                System.out.println("Ви обрали: " + play);
                Pole();
            } else if (a == 2) {
                System.out.println("Ви обрали: " + settings);
                Pool1();
            } else if (a == 3) {
                System.out.println("Ви обрали: " + perevirka);
                Scanner sc = new Scanner(System.in);
                System.out.println("Введіть назву файла який хочете перевірити: ");
                String s = sc.nextLine();
                reader(s);
            } else if (a == 4) {
                System.out.println("Ви обрали :" + exit);
                break;
            }
        }
    }

    public static void Pole() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть куди записувати налаштування: ");
        String name = sc.nextLine();
        System.out.println("Введіть ім'я першого гравця(X): ");
        String kor = sc.nextLine();
        System.out.println("Введіть ім'я другого гравця(0): ");
        String kor2 = sc.nextLine();
        LocalDateTime now = LocalDateTime.now();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(name))){
        char[][] mass = new char[4][4];
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[i].length; j++) {
                mass[i][j] = ' ';
            }
        }
        bw.write("Розмір поля: 3" + "\n" + "Ім'я першого гравця:" + kor + "\n" + "Ім'я другого гравця:" + kor2 + "\n" + now);
        bw.close();
        set(mass,3,kor,kor2);
    } catch (IOException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
    public static void Win(String kor) {
        System.out.println("WINNER WINNER CHICKEN DINNER: " + kor);
    }
    public static void Win1(String kor2) {
        System.out.println("WINNER WINNER CHICKEN DINNER: " + kor2);
    }
    public static void Pool1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть куди записувати налаштування: ");
        String name = sc.nextLine();
        System.out.println("Введіть ім'я першого гравця(X): ");
        String kor = sc.nextLine();
        System.out.println("Введіть ім'я другого гравця(0): ");
        String kor2 = sc.nextLine();
        LocalDateTime now = LocalDateTime.now();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(name))){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Оберіть розмір(3x3, 5x5, 7x7, 9x9)");
        int size = scanner1.nextInt();
        char[][] mass = new char[size + 1][size + 1];
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[i].length; j++) {
                mass[i][j] = ' ';
            }
        }
        bw.write("Розмір поля: " + size + "\n" + "Ім'я першого граіця: " + kor + "\n" + "Ім'я другого гравця: " + kor2 + "\n" + "Дата гри: " + now);
        bw.close();
        set(mass, size, kor, kor2);
        } catch (IOException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
    public static void set(char mass[][],int size, String kor, String kor2) {
        Scanner sc = new Scanner(System.in);
        char X = 'X';
        int m = 0;
        while (true) {
            for (int c = 0; c < mass.length; c++) {
                System.out.print(c + " \t");
            }
            System.out.println();
            for (int i = 1; i < mass.length; i++) {
                System.out.print("  ");
                for (int j = 0; j < mass.length; j++) {
                    System.out.print("----");
                }
                System.out.println();

                System.out.print(i + " ");
                for (int j = 1; j < mass.length; j++) {
                    System.out.print("| " + mass[i][j] + " ");
                }
                System.out.println("|");
            }
            System.out.print("  ");
            for (int b = 0; b < mass.length; b++) {
                System.out.print("----");
            }
            System.out.println();
            System.out.println("Введіть стрічку куди поставити(якщо хочете повернутися на головне меню введіть 0): ");
            int f = sc.nextInt();
            System.out.println("Введіть стовбець куди поставити(якщо хочете повернутися на головне меню введіть 0): ");
            int s = sc.nextInt();
            boolean win = false;
            if (!win) {
                if (mass[f][s] == ' ') {
                    mass[f][s] = X;
                } else {
                    System.out.println("Ця клітина вже зайнята");
                    continue;
                }
                if (mass[f][1] == X && mass[f][2] == X && mass[f][3] == X) {
                    if(X == 'X') {
                        Win(kor);
                    } else {
                        Win1(kor2);
                    }
                } else if (mass[1][s] == X && mass[2][s] == X && mass[3][s] == X) {
                    if(X == 'X') {
                        Win(kor);
                    } else {
                        Win1(kor2);
                    }
                } else if (mass[1][1] == X && mass[2][2] == X && mass[3][3] == X) {
                    if(X == 'X') {
                        Win(kor);
                    } else {
                        Win1(kor2);
                    }
                } else if (mass[2][1] == X && mass[2][2] == X && mass[1][3] == X) {
                    if(X == 'X') {
                        Win(kor);
                    } else {
                        Win1(kor2);
                    }
                } else if (size == 3) {
                    if (m == 9)
                        System.out.println("Нічия");
                } else if (size == 5) {
                    if (m == 25)
                        System.out.println("Нічия");
                } else if (size == 7) {
                    if(m == 49)
                        System.out.println("Нічия");
                } else if(size == 9) {
                    if(m == 81) {
                        System.out.println("Нічия");
                    }
                }
                X = (X == 'X') ? '0' : 'X';
            }
            if (s == 0 && f == 0) {
                System.out.println("Ви обрали повернутися на головне меню ");
                Menu();
            }
        }
    }
    public static void reader(String name) {
        try (BufferedReader reader = new BufferedReader(new FileReader(name))) {
            String str;
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}