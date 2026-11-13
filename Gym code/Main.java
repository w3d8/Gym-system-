package projectgymsystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static ArrayList<Subscription> list = new ArrayList<Subscription>();
    static ArrayList<Registration> registrations = new ArrayList<Registration>();
    static ArrayList<Trainer> trainer = new ArrayList<Trainer>();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        fillList();
        System.out.println("***** WELCOME TO OUR GYM SYSTEM *****");
        int choice = 0;
        do {
            try {
                menu();
                choice = input.nextInt();
                switch (choice) {

                    case 1://Add Subscription
                        System.out.println(
                                "1. General Subscription\n"
                                + "2. VIP Subscription\n"
                                + "Select type of the subscription to add >> ");
                        int subscriptionType = input.nextInt();

                        if (subscriptionType < 1 || subscriptionType > 2) {
                            System.out.println("Invalid choice.");
                        } else {

                            Subscription subscription;
                            System.out.println("Enter subscription id: ");
                            String subscriptionId = input.next();
                            System.out.println("Enter subscription name: ");
                            input.nextLine();
                            String name = input.nextLine();
                            System.out.println("Enter price per month:");
                            double pricePerMonth = input.nextDouble();
                            System.out.println("Enter number of months: ");
                            int TimeInMonth = input.nextInt();

                            if (subscriptionType == 1) {
                                System.out.println("Max GYM accesstimes per month is 30 times! ");
                                
                                subscription = new General(30, name, subscriptionId, pricePerMonth, TimeInMonth);
                                list.add(subscription);
                                System.out.println("your subscription has been added to the list.");

                            } else if (subscriptionType == 2) {

                                System.out.println("For Trainers :");
                                System.out.println("Enter trainer year of experience: ");
                                int experience = input.nextInt();//سنوات الخبره 
                                System.out.println("Enter main specialization: ");
                                input.nextLine();
                                String mainSpecialization = input.nextLine();
                                
                                

                                subscription = new VIP(new Trainer(experience, mainSpecialization), name, subscriptionId, pricePerMonth, TimeInMonth);
                                list.add(subscription);
                                System.out.println("subscription has been added to the list.");

                            } else {
                                System.err.println(" Invalid Choice!! ");
                            }

                            break;
                        }
                    case 2://Display subscribtion.

                        for (Subscription s : list) {
                            System.out.println(s);
                            System.out.printf("Price is: %.2f SAR\n", s.calcPrice());
                            System.out.println("Trainer Type: "+ s.trainerType());

                            if (s instanceof VIP) {
                                System.out.println(((VIP) s).VIPfreeParking());
                            } else if (s instanceof General) {
                                System.out.println(((General) s).inviteFriend());
                            }
                            System.out.println("---------------------------------");
                        }

                        System.out.println("Total subscriptions is: " + Subscription.getTotalSubscriptions());

                        break;
                    case 3://Remove subscription
                        System.out.print("Enter subscription id to remove: ");
                        String subscriptionId = input.next();
                        boolean removed = false;
                        for (int i = 0; i < list.size(); i++) {
                            Subscription ele = list.get(i);
                            if (ele.getId() == subscriptionId) {
                                list.remove(i);
                                removed = true;

                            }
                            break;
                        }
                        if (removed == true) {
                            System.out.println("Subscription with id (" + subscriptionId + ") has been removed.");
                        } else {
                            System.out.println("No subscription with id (" + subscriptionId + ") is found.");
                        }
                        break;

                    case 4://New Registration

                        System.out.println("Enter your name: ");
                       input.nextLine();
                        String name = input.nextLine();
                        System.out.println("Enter your id: ");
                        int id = input.nextInt();
                        System.out.println("Enter your phone number: ");
                        String phoneNumber = input.next();
                        Member member = new Member(id, name, phoneNumber);
                        //Subscription Information:

                        System.out.println("If you want <<General Registration>> Registration Id is : s101");
                        System.out.println("If you want <<VIP Registration>> Registration Id is : s102");
                        System.out.println("Enter subscription id: ");
                        subscriptionId = input.next();
                        //search for Subscription

                        Subscription sub = null;
                        for (Subscription ele : list) {
                            if (ele.getId().equals(subscriptionId)) {
                                sub = ele;
                            }
                        }

                        if (sub == null) {
                            System.out.println("Subscription not found.");
                            continue;
                        }

                        int regId = (int) (Math.random() * 99999);
                        Registration r = new Registration(regId, sub, member, "New");

                        System.out.println("Confirm Registration? (Y for yes /N for no): ");
                        char answer = input.next().charAt(0);
                        if (answer == 'y' || answer == 'Y') {
                            r.confirmReg();
                            System.out.println(r);
                            registrations.add(r);
                            System.out.println("your Registration with number (" + r.getId() + ") has been confirmed.");

                        } else if (answer == 'N' || answer == 'n') {
                            System.out.println("UnConfirm, thank you  ");
                        } else {
                            System.err.println("  !Invalid Choice!  ");
                        }
                        break;

                    case 5://Show registration
                        System.out.print("Enter registration number (ID) : ");
                        int Id = input.nextInt();
                        boolean found = false;
                        for (Registration ele : registrations) {
                            if (ele.getId() == Id) {
                                System.out.println(ele);
                                found = true;
                                break;
                            }
                        }//end loop
                        if (found == false) {
                            System.out.println("Registration with ID (" + Id + ") not found");
                        }
                        break;
                    case 6://Cancel registration
                        System.out.println("Enter your registration ID: ");
                        Id = input.nextInt();
                        boolean isfound = false;
                        for (Registration ele : registrations) {
                            if (ele.getId() == Id) {
                                System.out.println("your Registration  ID (" + ele.getId() + ") has been canceled ");

                                ele.canceReg();
                                System.out.println(ele);
                                isfound = true;
                                break;

                            }

                        }
                        if (isfound == false) {
                            System.out.println("Registration with id " + Id + " is not found");
                        }
                        break;
                    case 7: //join as Trainer 
                        System.out.println("Enter your main Specialization: ");
                        input.nextLine();
                        String mainSpecialization = input.nextLine();
                        System.out.println("Enter your id: ");
                        int idT = input.nextInt();
                        System.out.println("Enter years of experince : ");
                        int year = input.nextInt();

                        input.nextLine();
                        System.out.println("Enter your name: ");
                        name = input.nextLine();

//                       
                        System.out.println("Enter the number of certificate do you have : ");
                        int num = input.nextInt();
                        Certificate[] Certificate1 = new Certificate[num];
                        for (int i = 0; i < Certificate1.length; i++) {
                            input.nextLine();
                            System.out.print("for certificate " + (i + 1) + " enter certificate name: ");
                            String n = input.nextLine();
                            System.out.print("for certificate " + (i + 1) + " enter certificate year: ");
                            int y = input.nextInt();
                            if (y < 1990) {
                                System.err.println("Invalid year ");
                                break;
                            } else {
                                Certificate1[i] = new Certificate(n, y);
                            }
                        }
                        Trainer t = new Trainer(year, idT, name, mainSpecialization, Certificate1);
                        trainer.add(t);
                        System.out.println("Thanks for joining us.");

                        break;

                    case 8:// about meals and extra sirvice
                        System.out.println(" 1. Calculate Calories\n"
                                + " 2. Meals we have");
                        int ch = input.nextInt();

                        if (ch == 1) {
                            System.out.println(" your Wight :");
                            double W = input.nextDouble();
                            System.out.println(" your Hight :");
                            int H = input.nextInt();
                            System.out.println(" your Age :");
                            int A = input.nextInt();
                            ExtraService es = new ExtraService(W, H, A);
                            System.out.println("The price for calculaite your calories :" + es.pay());

                            System.out.println("the calories you need: " + es.calcCalories());

                        } else if (ch == 2) {

                            ArrayList<MEALS> Meals = new ArrayList<MEALS>();
                            Meals.add(new MEALS(" Chicken pasta ", 34.5));
                            Meals.add(new MEALS(" Rice ", 20.0));
                            Meals.add(new MEALS(" Pizza ", 26.5));
                            Meals.add(new MEALS(" Fruir salad ", 16.75));
                            Meals.add(new MEALS(" Salad ", 11.5));

                            for (int i = 0; i < Meals.size(); i++) {
                                System.out.print((i + 1) + " - " + Meals.get(i));
                                System.out.println("----------------");
                            }
                            System.out.print("Enter the meal number :");
                            int mealsN = input.nextInt();
                            mealsN = mealsN - 1;

                            if (mealsN < 0 || mealsN > Meals.size()) {
                                System.err.println(" Invalid Choice! ");

                            } else {
                                System.out.println("Our Gym chefs are waiting for you !");
                            }

                        } else {
                            System.err.println(" Invalid Choice! ");
                        }
                        break;

                    case 9:
                        WriteText wf = new WriteText();
                        wf.TextFile("Gym.txt");
                        if (trainer.isEmpty()) {
                            ////////////////////////////////////////
                            System.out.println("No trainers yet.");
                        } else {
                            for (Trainer ele : trainer) {
                                wf.writeFile(ele);
                            }
                        }
                        wf.closeFile();
                        System.out.println("All trainers saved to the text file Gym.txt");
                        break;

                    case 10://Read from text file
                        ReadText rt = new ReadText();
                        rt.TextFile("Gym.txt");
                        rt.readFile();
                        rt.closeFile();
                        break;

                    case 11://GUI
                        UI.main(null);
                        break;

                    case 12: //Exit
                        System.out.println("Thank you for using our system.\n ***** HAVE A NICE DAY ***** ");
                        break;
                    default:
                        System.err.println("Invalid Choice!");
                }
            } catch (InputMismatchException ex) {
                System.err.println(" Invalid input ! ");
                input.nextLine();
            } catch (NullPointerException ex) {
                System.err.println(ex);
            } catch (ClassCastException ex) {
                System.err.println(ex);
            } catch (Exception ex) {
                System.err.println(ex);
            }
        } while (12 != choice);

    }

    public static void menu() {
        System.out.print(
                "\n1.  Add subscribtion.\n"
                + "2.  Display subscribtion.\n"
                + "3.  Remove subscribtion.\n"
                + "4.  New Registration.\n"
                + "5.  Show Registration.\n"
                + "6.  Cancel Registration.\n"
                + "7.  join as a trainer.\n"
                + "8.  Extra Service. \n"
                + "9.  Save Trainers.\n"
                + "10. Read Trainers.\n"
                + "11. GUI.\n"
                + "12. Exit.\n"
                + ">> ");
    }

    public static void fillList() {

        Certificate[] Certificate1 = new Certificate[1];
        Certificate1[0] = new Certificate("ACE", 2005);
        Trainer trainer1 = new Trainer(5, 105, "Sara", "Yoga", Certificate1);

        
        Certificate[] Certificate2 = new Certificate[2];
        Certificate2[0] = new Certificate("ACE", 1990);
        Certificate2[1] = new Certificate("ISSA", 1996);
        Trainer trainer2 = new Trainer(3, 106, "Shaden", "Boxing", Certificate2);

        
        Certificate[] Certificate3 = new Certificate[3];
        Certificate3[0] = new Certificate("ACE", 2007);
        Certificate3[1] = new Certificate("ISSA", 2024);
        Certificate3[2] = new Certificate("NASM", 2021);
        Trainer trainer3 = new Trainer(6, 107, "Waad", "Fitness Coach ", Certificate3);

        trainer.add(trainer1);
        trainer.add(trainer2);
        trainer.add(trainer3);
        list.add(new General(30, "3 Months Package", "s101", 1200, 3));
        list.add(new VIP(trainer1, "1 Month VIP", "s102", 2500, 1));

    }
}
