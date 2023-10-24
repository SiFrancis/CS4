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
                                int a = scan.nextInt();
                                int a2 = a * a;
                                System.out.print("Enter length of Leg B: ");
                                int b = scan.nextInt();
                                int b2 = b * b;
                                int c2 = a2 + b2;
                                System.out.println("Computation:");
                                System.out.println("    c^2 = a^2 + b^2");
                                System.out.println("    c^2 = " + a + "^2 + " + b + "^2");
                                System.out.println("    c^2 = " + a2 + " + " + b2);
                                System.out.println("    c^2 = " + c2);
                                System.out.println("    c = sqrt(" + c2 + ")");
                                int root = (int)Math.sqrt(c2);
                                boolean simplifiable = false;
                                for (int i = root; i > 1; i--) {
                                    if (c2 == (i*i)) {
                                        System.out.println("    c = " + i);
                                        System.out.println("Checking:");
                                        System.out.println("    c^2 = a^2 + b^2");
                                        System.out.println("    " + i + "^2 = " + a + "^2 + " + b + "^2");
                                        System.out.println("    " + c2 + " = " + a2 + " + " + b2);
                                        System.out.println("    " + c2 + " = " + (a2 + b2));
                                        simplifiable = true;
                                        break;
                                    }
                                    else if (c2 % (i*i) == 0) {
                                        System.out.println("    c = " + i + "sqrt(" + (c2/(i*i)) + ")");
                                        System.out.println("Checking:");
                                        System.out.println("    c^2 = a^2 + b^2");
                                        System.out.println("    (" + i + "sqrt(" + (c2/(i*i)) + "))^2 = " + a + "^2 + " + b + "^2");
                                        System.out.println("    " + i + "^2(" + (c2/(i*i)) + ") = " + a2 + " + " + b2);
                                        System.out.println("    " + (i*i) + "(" + (c2/(i*i)) + ") = " + a2 + " + " + b2);
                                        System.out.println("    " + c2 + " = " + (a2 + b2));
                                        simplifiable = true;
                                        break;
                                    }
                                }
                                if (simplifiable != true) {
                                    System.out.println("Checking: ");
                                    System.out.println("    c^2 = a^2 + b^2");
                                    System.out.println("    (sqrt(" + c2 + "))^2 = " + a + "^2 + " + b + "^2");
                                    System.out.println("    " + c2 + " = " + a2 + " + " + b2);
                                    System.out.println("    " + c2 + " = " + (a2 + b2));
                                }
                                break;
                            case 2:
                                System.out.print("Enter Leg A length: ");
                                int a1 = scan.nextInt();
                                int a1_2 = a1 * a1;
                                System.out.print("Enter hypotenuse (C) length: ");
                                int c1 = scan.nextInt();
                                int c1_2 = c1 * c1;
                                int b1_2 = c1_2 - a1_2;
                                System.out.println("Computation:");
                                System.out.println("    c^2 = a^2 + b^2");
                                System.out.println("    b^2 = c^2 - a^2");
                                System.out.println("    b^2 = " + c1 + "^2 - " + a1 + "^2");
                                System.out.println("    b^2 = " + c1_2 + " - " + a1_2);
                                System.out.println("    b^2 = " + b1_2);
                                System.out.println("    b = sqrt(" + b1_2 + ")");
                                int root1 = (int)Math.sqrt(b1_2);
                                boolean simplifiable_1 = false;
                                for (int i = root1; i > 1; i--) {
                                    if (b1_2 == (i*i)) {
                                        System.out.println("    b = " + i);
                                        System.out.println("Checking:");
                                        System.out.println("    c^2 = a^2 + b^2");
                                        System.out.println("    " + c1 + "^2 = " + a1 + "^2 + " + i + "^2");
                                        System.out.println("    " + c1_2 + " = " + a1_2 + " + " + i);
                                        System.out.println("    " + c1_2 + " = " + (a1_2 + b1_2));
                                        simplifiable_1 = true;
                                        break;
                                    }
                                    else if (b1_2 % (i*i) == 0) {
                                        System.out.println("    b = " + i + "sqrt(" + (b1_2/(i*i)) + ")");
                                        System.out.println("Checking:");
                                        System.out.println("    c^2 = a^2 + b^2");
                                        System.out.println("    " + c1 + "^2 = " + a1 + "^2 + " + i + "sqrt(" + (b1_2/(i*i)) + ")" + "^2");
                                        System.out.println("    " + c1_2 + " = " + a1_2 + " + " + i + "^2(" + (b1_2/(i*i)) + ")");
                                        System.out.println("    " + c1_2 + " = " + a1_2 + " + " + (i*i) + "(" + (b1_2/(i*i)) + ")");
                                        System.out.println("    " + c1_2 + " = " + (a1_2 + b1_2));
                                        simplifiable_1 = true;
                                        break;
                                    }
                                }
                                if (simplifiable_1 != true) {
                                    System.out.println("Checking: ");
                                    System.out.println("    c^2 = a^2 + b^2");
                                    System.out.println("    " + c1_2 + "))^2 = " + a1 + "^2 + sqrt(" + b1_2 + ")" + "^2");
                                    System.out.println("    " + c1_2 + " = " + a1_2 + " + " + b1_2);
                                    System.out.println("    " + c1_2 + " = " + (a1_2 + b1_2));
                                }
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
                    scan.nextLine();
                    System.out.println("==========PYGOMON (name pending)==========");
                    System.out.println("pokemon but triangle or something like that\n");
                    System.out.println("======[At the Pygomon Institute]======");
                    System.out.println("DR. PYTHA: Ah, welcome to the Institute! I see we have another first-timer over here, eh?");
                    System.out.println("[Press Enter to move to the next dialogue.]");
                    scan.nextLine();
                    System.out.println("YOU: Um, good morning! Yes, I actually found this thing blah blah blah");
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