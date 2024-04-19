import java.util.Scanner;

public class Project5 {
    public static void main(String[] args) {
    PolyList polyList = new PolyList();
    Scanner scanner = new Scanner(System.in);

    while (true) {
        String input = scanner.nextLine().trim();
        String[] parts = input.split("\\s+", 2);
        String command = parts[0];

        if (command.equals("INSERT")) {
            String[] polynomialParts = parts[1].split("\\s+");
            String name = polynomialParts[0];
            Polynomial existing = polyList.searchPolynomial(name);
            if (existing != null) {
                System.out.println("POLYNOMIAL " + name + " ALREADY INSERTED");
            } else {
                Polynomial polynomial = new Polynomial(name);
                for (int i = 1; i < polynomialParts.length; i++) {
                    String[] termParts = polynomialParts[i].split(",");
                    int coefficient = Integer.parseInt(termParts[0]);
                    int exponentX = Integer.parseInt(termParts[1]);
                    int exponentY = Integer.parseInt(termParts[2]);
                    int exponentZ = Integer.parseInt(termParts[3]);
                    polynomial.insertTerm(new Term(coefficient, exponentX, exponentY, exponentZ));
                }
                polyList.insertPolynomial(polynomial);
                System.out.println(polynomial);
            }
        } else if (command.equals("DELETE")) {
            String name = parts[1];
            Polynomial existing = polyList.searchPolynomial(name);
            if (existing != null) {
                polyList.deletePolynomial(name);
                System.out.println("POLYNOMIAL " + name + " SUCCESSFULLY DELETED");
            } else {
                System.out.println("POLYNOMIAL " + name + " DOES NOT EXIST");
            }
        } else if (command.equals("SEARCH")) {
            String name = parts[1];
            Polynomial existing = polyList.searchPolynomial(name);
            if (existing != null) {
                System.out.println(existing);
            } else {
                System.out.println("POLYNOMIAL " + name + " DOES NOT EXIST");
            }
        } else if (command.equals("QUIT")) {
            polyList = new PolyList(); // clear polynomials
        }

        // Check if the command is QUIT before continuing the loop
        if (command.equals("QUIT")) {
            break;
        }
    }

    // Close the scanner
    scanner.close();
}
}
