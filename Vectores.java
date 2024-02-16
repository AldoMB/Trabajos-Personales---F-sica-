import java.util.Scanner;

public class vectores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vec2,vec3,vec2r,vec3r,a1,a2,a3,b1,b2,b3,vec2p,vec2rp,vec3p,vec3rp,vec3rp2,vec3p2;
        int opcion;
        
        do {
            System.out.println("Eliga un opcion");
            System.out.println("1. 2 vectores ");
            System.out.println("2. 3 vectores ");
            System.out.println("3. Salir");
                                 
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    2vectores();
                    break;
                case 2:
                    3vectores();
                    break;
                case 3:
                    System.out.println("¡Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 3);
        
        scanner.close();
    }
    
    public static void 2vectores() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ingrese el primer valor del vector 1");
        a1 = scanner.nextInt();
        System.out.println("Ingrese el segundo valor del vector 1");
        a2 = scanner.nextInt();
        System.out.println(" ingrese el primer valor del vector 2");
        b1 = scanner.nextInt();
        System.out.println("Ingrese el segundo valor del vector 2");
        b2 = scanner.nextInt();    
        vec2 = (a1+b1);
        vec2p = (a2+b2);
        vec2r=(a1-(b1);
        vec2rp=(a2-(b2);
        System.out.println("La suma de vectores es " + vec2 " ," +  vec2p "y la resta es " + vec2r "," + vec2rp);

    }
    
   public static void 3vectores() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ingrese el primer valor del vector 1");
        a1 = scanner.nextInt();
        System.out.println("Ingrese el segundo valor del vector 1");
        a2 = scanner.nextInt();
        System.out.println("Ingrese el tercer valor del vector 1");
        a3 = scanner.nextInt();
        System.out.println(" ingrese el primer valor del vector 2");
        b1 = scanner.nextInt();
        System.out.println("Ingrese el segundo valor del vector 2");
        b2 = scanner.nextInt();
        System.out.println("Ingrese el tercer valor del vector 2");
        b3 = scanner.nextInt(); 
        System.out.println(" ingrese el primer valor del vector 3");
        c1 = scanner.nextInt();
        System.out.println("Ingrese el segundo valor del vector 3");
        c2 = scanner.nextInt();
        System.out.println("Ingrese el tercer valor del vector 3");
        c3 = scanner.nextInt();
   
        vec3 = (a1+b1+c1);
        vec3p = (a2+b2+c2);
        vec3p2 = (a3+b3+c3);
        vec3r=(a1-(b1)-(c1));
        vec3rp=(a2-(b2)-(c2));
        vec3rp2=(a3-(b3)-(c3));
        System.out.println("La suma de vectores es " + vec3 " ," +  vec3p "," + vec3p2 "y la resta es " + vec3r "," + vec3rp "," + vec3rp2);

    }
    
  
}
