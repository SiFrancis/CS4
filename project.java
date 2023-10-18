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
                                System.out.println("a^2: " + a2);
                                System.out.println("b^2: " + b2);
                                System.out.println("Hypotenuse Length = sqrt(a^2 + b^2)");
                                double c2 = a2 + b2;
                                System.out.println("a^2 + b^2: " + c2);
                                System.out.println("Hypotenuse Length: " + Math.sqrt(c2));
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
                    System.out.println("Defeat the triangles by solving their missing side");
                    int player_hp = 100;
                    System.out.println("Oh no the first triangles here");
                    System.out.println("Defeat him or hes gonna screw ur mother");
                    int enemy1_hp = (int)(Math.random() * 19 + 1);
                    int enemy1_leg1 = 12;
                    int enemy1_leg2 = 9;
                    System.out.println("Leg A of Enemy 1 is " + enemy1_leg1 + "units");
                    System.out.println("Leg B of Enemy 1 is " + enemy1_leg2 + "units");
                    System.out.print("Find the hypotenuse: ");
                    double ans1 = scan.nextDouble();
                    if (ans1 == Math.sqrt((enemy1_leg1*enemy1_leg1) + (enemy1_leg2*enemy1_leg2))) {
                        System.out.println("yipeeee");
                    } else {
                        System.out.println("L bozo u lost");
                    }
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
    