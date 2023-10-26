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
                    System.out.println("\n===================[[Welcome to PYGOMON]]===================\n");
                    System.out.println("(pokemon but triangles or something like that)");
                    System.out.print("\n\nEnter your name: ");
                    String name = scan.nextLine().toUpperCase();
                    String fname = name.split(" ")[0];
                    System.out.println("\nNOTE: Press Enter to move to the next dialogue.");
                    System.out.println("\n============================================================\n");
                    System.out.print("You're out walking in the grass (for reasons), when you find a mysterious object. ");
                    scan.nextLine(); 
                    //this is the "Press Enter to progress" mechanic
                    System.out.println("\nIt's like an odd geometric looking... thing...");
                    System.out.print("\nIf it is what you think it is... there's only one place to go to. ");
                    scan.nextLine();
                    System.out.println("\n[AT THE PYGOMON CENTER]\n");
                    System.out.println("dialogue");
                    
                    System.out.print("\nPROF. PYGO: Alright " + fname + ", let's get you growing your own PYGOMON! ");
                    scan.nextLine();
                    System.out.print("\nPROF. PYGO: Right now, you still have an INCOMPLETE PYGOMON, ");
                    System.out.println("so you'll have to CONSTRUCT its missing geometry to complete it!\n");
                    System.out.print("            You know the basics of the Pythagorean theorem now, don't you? Try it out! ");
                    scan.nextLine();
                    System.out.println("\nPROF. PYGO: Oh look, this is an easy one! Solve for the missing side to construct the PYGOMON!");
                    int evol_soln = 0;
                    while (evol_soln != 5) {
                        System.out.println("");
                        System.out.println("        .");
                        System.out.println("        &*O.");
                        System.out.println("a = 3   &  *O.    c = ???");
                        System.out.println("        &     *O.");
                        System.out.println("        &ooooooO&Oo.");
                        System.out.println("           b = 4\n");
                        System.out.print("Enter the value of c: ");
                        evol_soln = scan.nextInt();
                        scan.nextLine();
                        if (evol_soln == 5) break;
                        else {
                            System.out.print("\nPROF. PYGO: Looks like you constructed it incorrectly... ");
                            System.out.print("Don't worry, you can always try again! ");
                            scan.nextLine();
                            System.out.println("\n            Just remember the formula a^2 + b^2 = c^2!");
                        }
                    }
                    int pygo_lvl = 1;
                    int pygo_hp = 5;
                    System.out.println("\nPROF PYGO: Congratulations!! You've now got yourself a [Lvl. 1 PYGOMON]!");
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