import java.net.InetAddress;
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
                    InetAddress web = InetAddress.getByName(pagina);
                    System.out.println("web: " + web.getHostName() + " - ip: " + web.getHostAddress());

                    for (InetAddress ip: InetAddress.getAllByName(pagina)) {
                        System.out.println(ip.getHostAddress());
                    }

                    InetAddress p = InetAddress.getLocalHost();
                    System.out.println(p);
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
