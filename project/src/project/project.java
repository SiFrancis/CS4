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
                    System.out.println();
                    System.out.println("\nNOTE: Press Enter to move to the next dialogue.");
                    System.out.println("\n============================================================\n");
                    System.out.print("You're out walking in the grass (for reasons), when you find a mysterious object. ");
                    scan.nextLine(); 
                    //this is the "Press Enter to progress" mechanic
                    System.out.println("\nIt's like an odd geometric looking... thing...");
                    System.out.print("\nIf it is what you think it is... there's only one place to go to. ");
                    scan.nextLine();
                    System.out.println("\n[AT THE PYGOMON CENTER]\n");
                    
                    System.out.print("???: Hello, welcome to the PYGOMON CENTER! How may I help you? ");
                    scan.nextLine();
                    System.out.print("\n     Oh, I see... it does appear to be a PYGOMON to me... but it's not fully grown just yet. ");
                    scan.nextLine();
                    System.out.print("\n     You wanna take care of it, huh? Well, are you ready to handle the responsibility of having a PYGOMON? ");
                    scan.nextLine();
                    System.out.print("\n???: Yes? That's good to hear! ");
                    scan.nextLine();
                    System.out.println("\n???: By the way, my name's PROFESSOR PYTHA, I'm the PYGOMON researcher in this local facility!\n");
                    System.out.print("PROF. PYTHA: Anyways, come to the training area with me, and take the PYGOMON with you! ");
                    scan.nextLine();
                    System.out.println("\n-----[At the TRAINING AREA]-----\n");
                    System.out.print("PROF. PYTHA: Alright, let's get you growing your own PYGOMON! ");
                    scan.nextLine();
                    System.out.print("\nPROF. PYTHA: Right now, you still have an INCOMPLETE PYGOMON, ");
                    System.out.println("so you'll have to construct its missing geometry to complete it!\n");
                    System.out.print("             You know the basics of the Pythagorean theorem now, don't you? Try it out! ");
                    scan.nextLine();
                    System.out.println("\nPROF. PYTHA: Oh look, this is an easy one! Solve for the missing side to construct the PYGOMON!");
                    int evol_soln = 0;
                    while (evol_soln != 5) {
                        System.out.println("");
                        System.out.println("          .");
                        System.out.println("          &???");
                        System.out.println("  a = 3   ?   ??.    c = ???");
                        System.out.println("          ?     ?O.");
                        System.out.println("          &?oo?ooO??o.");
                        System.out.println("             b = 4\n");
                        System.out.print("Enter the value of c: ");
                        evol_soln = scan.nextInt();
                        scan.nextLine();
                        if (evol_soln == 5) break;
                        else {
                            System.out.print("\nPROF. PYTHA: Looks like you constructed it incorrectly... ");
                            System.out.print("Don't worry, you can always try again! ");
                            scan.nextLine();
                            System.out.println("\n             Just remember the formula a^2 + b^2 = c^2!");
                        }
                    }
                    int pygo_lvl = 1;
                    int pygo_hp = 15 + 5 * (pygo_lvl - 1);
                    int pygo_atk = 4;
                    System.out.println("\nPROF PYTHA: Congratulations!! You've now got yourself a [Lvl. 1 PYGOMON]!\n");
                    System.out.println(".------------------------.");
                    System.out.println("|   ????                 |");
                    System.out.println("|------------------------|");
                    System.out.println(String.format("|   [Lvl. %d PYGOMON]     |", pygo_lvl));
                    System.out.print(String.format("|   HP: %d   ", pygo_hp));
                    System.out.println(String.format("    ATK: %d  |", pygo_atk));
                    System.out.println("|   ATTACKS:             |");
                    System.out.println("|    [1] LEG SWEEP       |");
                    System.out.println("|    [2] HYPO-DASH       |");
                    System.out.println("*------------------------*");
                    scan.nextLine();
                    System.out.print("PROF. PYTHA: Oh, hang on, there seems to be something missing... ");
                    scan.nextLine();
                    System.out.println("\n             Oh right, we need to give your PYGOMON a name!\n");
                    System.out.println("             Well, what would you like to name it?\n");
                    System.out.print("Enter the name of your PYGOMON here: ");
                    String pygo_name = scan.nextLine().toUpperCase();
                    System.out.println("\nPROF. PYTHA: " + pygo_name + ", such a nice name! Good job!\n");
                    System.out.println("              Hang on, it should update now...\n");
                    System.out.println(".------------------------.");
                    System.out.print("|   " + pygo_name);
                    for (int i = 0; i < 21 - pygo_name.length(); i++) System.out.print(" ");
                    System.out.println("|");
                    System.out.println("|------------------------|");
                    System.out.println(String.format("|   [Lvl. %d PYGOMON]     |", pygo_lvl));
                    System.out.print(String.format("|   HP: %d   ", pygo_hp));
                    System.out.println(String.format("    ATK: %d  |", pygo_atk));
                    System.out.println("|   ATTACKS:             |");
                    System.out.println("|    [1] LEG SWEEP       |");
                    System.out.println("|    [2] HYPO-DASH       |");
                    System.out.println("*------------------------*");
                    System.out.print("\nPROF. PYTHA: There, now that's better! ");
                    scan.nextLine();
                    System.out.println("\n[Someone else enters the training area.]\n");
                    System.out.print("????: Hey Prof, good morning! ");
                    scan.nextLine();
                    System.out.println("\nPROF. PYTHA: Oh, hey Goras! Nice timing, someone new just came in!");
                    System.out.print("\n             This is Goras, by the way; he's the one who trains aspiring PYGOMON champions, like yourself! ");
                    scan.nextLine();
                    System.out.println("\nTRAINER GORAS: Hey there, newbie! I'm Goras, the trainer of this facility.\n");
                    System.out.print("               I'll be teaching you when it comes to your PYGOMON, and battling with it. Got that? ");
                    scan.nextLine();
                    System.out.println("\nTRAINER GORAS: Good. Alright, let's give your new PYGOMON a little warm-up!\n");
                    System.out.print("               Don't worry! Mine won't hurt you! ");
                    scan.nextLine();
                    int enemy_lvl = 1;
                    int enemy_hp = 11;
                    int enemy_atk = 0;
                    System.out.println("\n=======[TIME TO BATTLE!!]=======\n\n");
                    while (enemy_hp > 0) {
                        System.out.println(".------------------------.");
                        System.out.print("|   " + pygo_name);
                        for (int i = 0; i < 21 - pygo_name.length(); i++) System.out.print(" ");
                        System.out.println("|");
                        System.out.println("|------------------------|");
                        System.out.println(String.format("|   [Lvl. %d PYGOMON]     |", pygo_lvl));
                        System.out.print(String.format("|   HP: %d   ", pygo_hp));
                        System.out.println(String.format("    ATK: %d  |", pygo_atk));
                        System.out.println("|   ATTACKS:             |");
                        System.out.println("|    [1] LEG SWEEP       |");
                        System.out.println("|    [2] HYPO-DASH       |");
                        System.out.println("*------------------------*");
                        System.out.println("\n------------VS------------\n");
                        System.out.println(".------------------------.");
                        System.out.println("|   LITERAL TEST DUMMY   |");
                        System.out.println("|------------------------|");
                        System.out.println(String.format("|   [Lvl. %d PYGOMON]     |", enemy_lvl));
                        System.out.print(String.format("|   HP: %d   ", enemy_hp));
                        if (enemy_hp >= 10) System.out.println(String.format("    ATK: %d  |", enemy_atk));
                        else System.out.println(String.format("     ATK: %d  |", enemy_atk));
                        System.out.println("|   ATTACKS:             |");
                        System.out.println("|    [1] STAND THERE     |");
                        System.out.println("*------------------------*\n");    
                        System.out.println("It's your turn! What do you do?");
                        int choice = 0;
                        while (choice != 1 && choice != 2) {
                            System.out.println("[1] LEG SWEEP");
                            System.out.println("[2] HYPO-DASH");
                            System.out.print("Enter your choice: ");
                            choice = scan.nextInt();
                            if (choice != 1 && choice != 2) System.out.println("\nERROR: Invalid input; try again!\n");
                        }
                        switch (choice) {
                            case 1:
                                System.out.println("\nFind the enemy's geometry in order to successfully target it!");
                                int leg_soln = 0;
                                while (leg_soln != 15) {
                                    System.out.println("");
                                    System.out.println("          .");
                                    System.out.println("          &???");
                                    System.out.println("  a = ??? ?   ??.    c = 17");
                                    System.out.println("          ?     ?O.");
                                    System.out.println("          &?oo?ooO??o.");
                                    System.out.println("             b = 8\n");
                                    System.out.print("Enter the value of c: ");
                                    leg_soln = scan.nextInt();
                                    if (leg_soln == 15) break;
                                    else {
                                        System.out.print("\nTRAINER GORAS: Ooh, you missed that one! Come on buddy, you can do it! ");
                                        scan.nextLine();
                                        System.out.println("\n               Just remember the formula a^2 + b^2 = c^2!");
                                    }
                                }
                                System.out.println("\n" + pygo_name + " does LEG SWEEP!\n");
                                System.out.println("It deals " + pygo_atk + " damage!\n");
                                enemy_hp -= pygo_atk;
                                break;
                            case 2:
                                System.out.println("\nFind the enemy's geometry to target them with your attack!");
                                int hypo_soln = 0;
                                while (hypo_soln != 17) {
                                    System.out.println("");
                                    System.out.println("          .");
                                    System.out.println("          &???");
                                    System.out.println("  a = 15  ?   ??.    c = ???");
                                    System.out.println("          ?     ?O.");
                                    System.out.println("          &?oo?ooO??o.");
                                    System.out.println("             b = 8\n");
                                    System.out.print("Enter the value of c: ");
                                    hypo_soln = scan.nextInt();
                                    if (hypo_soln == 17) break;
                                    else {
                                        System.out.print("\nTRAINER GORAS: Ooh, you missed that one! Come on buddy, you can do it! ");
                                        scan.nextLine();
                                        System.out.println("\n               Just remember the formula a^2 + b^2 = c^2!");
                                    }
                                }
                                System.out.println("\n" + pygo_name + " does HYPO-DASH!\n");
                                System.out.println("It deals " + pygo_atk + " damage!\n");
                                enemy_hp -= pygo_atk;
                                break;
                        }
                    }
                    System.out.print("\nTRAINER GORAS: Nice one, kid! Now that you know how to do proper PYGOMON battle, you're ready to go out and explore! ");
                    scan.nextLine();
                    scan.nextLine();
                    System.out.print("\nPROF. PYTHA: That's right! Just keep growing and evolving your PYGOMON, and you'll be winning battles in no time! ");
                    scan.nextLine();
                    System.out.print("\nPROF. PYTHA: Oh, looks like I'm needed for something.. guess I'll see you again sometime. Bye!! ");
                    scan.nextLine();
                    System.out.print("\nTRAINER GORAS: Alright, now go on and explore with your new PYGOMON! You can do this, kid! ");
                    scan.nextLine();
                    System.out.println("\n               Oh, looks like I also have other stuff to take care of... Well, see ya soon!");
                    System.out.println("\n========[GAME END :DD]========\n");
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