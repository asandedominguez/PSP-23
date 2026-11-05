import java.net.*;
import java.util.Scanner;

public class Tarea23 extends Thread {
    public static void main(String[] args) {
        try {
            System.out.println(InetAddress.getLocalHost());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Dame una página web: ");
            String pagina = scanner.nextLine();

            if (!pagina.equals("salir")) {
                try {
                    for (InetAddress ip: InetAddress.getAllByName(pagina)) {
                        if (ip instanceof Inet4Address) {
                            System.out.println("IPv4: " + ip.getHostAddress());
                        } else if (ip instanceof Inet6Address) {
                            System.out.println("IPv6: " + ip.getHostAddress());
                        }
                    }

                } catch (UnknownHostException e) {
                    System.out.println("Dominio inexistente: " + e.getMessage());
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