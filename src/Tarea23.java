import java.net.*;

import java.util.List;
import java.util.Scanner;

public class Tarea23 extends Thread {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Dame una página web: ");
            String pagina = scanner.nextLine();

            if (!pagina.equals("salir")) {
                try {
                    for (InetAddress ip: InetAddress.getAllByName(pagina)) {
                        System.out.println(ip.getHostAddress());
                    }

                    InetAddress p = Inet4Address.getLocalHost();
                    InetAddress i = Inet6Address.getLocalHost();
                    System.out.println("IPv4: " + p + " IPv6: " + i);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            else {
                scanner.close();
                System.out.println("Saliendo...");
                break;
            }
        }
    }
}
