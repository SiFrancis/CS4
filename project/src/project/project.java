/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.Scanner;
/**
 *
 * @author d4rkc
 */
public class project {
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean isActive = true;
        boolean automActive = true;
        do {
            System.out.println("[1] Automations");
            System.out.println("[2] Game");
            System.out.println("[0] Exit");
            System.out.print("Choose a thing: ");
            int input = scan.nextInt();
            switch (input) {
                case 1:
                    do {
                        System.out.println("-----------------------------");
                        System.out.println("AUTOMATIONS");
                        System.out.println("[1] Find Hypotenuse Length");
                        System.out.println("[2] Find Leg Length");
                        System.out.println("[0] Exit Automations");
                        System.out.print("Choose automations: ");
                        int input2 = scan.nextInt();
                        switch (input2) {
                            case 1:
                                System.out.print("Enter length of Leg A: ");
                                double a = scan.nextDouble();
                                double a2 = a * a;
                                System.out.print("Enter length of Leg B: ");
                                double b = scan.nextDouble();
                                double b2 = b * b;
                                double c2 = a2 + b2;
                                System.out.println("Computation:");
                                System.out.println("c^2 = a^2 + b^2");
                                System.out.println("c^2 = " + a + "^2 + " + b + "^2");
                                System.out.println("c^2 = " + a2 + " + " + b2);
                                System.out.println("c^2 = " + c2);
                                System.out.println("c = sqrt(" + c2 + ")");
                                int root = (int)Math.sqrt(c2);
                                for (int i = root; i > 1; i--) {
                                    if (c2 == (i*i)) {
                                        System.out.println("c = " + i);
                                        break;
                                    }
                                    else if (c2 % (i*i) == 0) {
                                        System.out.println("c = " + i + "sqrt(" + (c2/(i*i)) + ")");
                                        break;
                                    }
                                }
                                break;
                            case 2:
                                System.out.print("Enter Leg A length: ");
                                double leg = scan.nextDouble();
                                double leg2 = leg * leg;
                                System.out.print("Enter hypotenuse length: ");
                                double hypo = scan.nextDouble();
                                double hypo2 = hypo * hypo;
                                System.out.println("Leg A^2: " + leg2);
                                System.out.println("Hypotenuse^2: " + hypo2);
                                System.out.println("Leg B length = sqrt(Hypotenuse^2 - Leg A^2)");
                                double legb2 = hypo2 - leg2;
                                System.out.println("Hypotenuse^2 - Leg A^2: " + legb2);
                                System.out.println("Leg B Length: " + Math.sqrt(legb2));
                                break;
                            case 0:
                                System.out.println("-----------------------------");
                                automActive = false;
                                break;
                            default:
                                System.out.println("ERROR: Input not recognized");
                                break;
                        }
                    }
                    while (automActive == true);
                    break;
                case 2:
                    // game stuff
                    break;
                case 0:
                    isActive = false;
                    break;
                default:
                    System.out.println("ERROR: Input not recognized");
                    break;
            }
        }
        while (isActive == true);
    }   
}
    