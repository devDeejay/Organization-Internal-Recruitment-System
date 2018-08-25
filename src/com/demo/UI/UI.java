package com.demo.UI;

import com.demo.Model.User;
import com.demo.Service.AdminServiceInterfaceImplementation;
import com.demo.Service.RMGExecutiveImplementation;
import com.demo.Service.UserServiceInterfaceImplementation;
import com.demo.Util.IRSValues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class UI {

    public static Scanner input;

    public static void main(String[] args) {

        input = new Scanner(System.in);

        System.out.println("Welcome To Internal Recruitment System");
        System.out.println("Please Press 1. To Login");
        System.out.println("Please Press 0. To Exit");

        Scanner input = new Scanner(System.in);

        int userInput = input.nextInt();

        switch (userInput) {
            case 1:
                loginUser();
                break;
            case 2:
                System.out.println("Have a great day!");
                System.exit(0);
        }
    }

    private static void loginUser() {
        Scanner input = new Scanner(System.in);
        System.out.print("Username : ");
        String username = input.next();
        System.out.print("Password : ");
        String password = input.next();

        /*
         * Creating User Object For Login.
         */

        User newUser = new User(username, password);

        /*
         * Getting LoggedInUser Object Back From Database.
         */

        User loggedInUser = checkUserCredentials(newUser);

        /*
         * Checking User Grade (User Access) And Logging-In User Further According To Their Grade.
         */

        int userGrade = loggedInUser.getUserGrade();
        switch (userGrade) {
            case IRSValues.ADMIN:
                loginAsAdmin(loggedInUser);
                break;

            case IRSValues.RMG_EXECUTIVE:
                loginAsRMGExecutive(loggedInUser);
                break;

            case IRSValues.RESOURCE_MANAGER:
                loginAsResourceManager(loggedInUser);
                break;

            default:
                System.out.println("Invalid User Login");
                break;
        }
    }

    private static void loginAsResourceManager(User loggedInUser) {

        // ==============================================================
        // =======     When User Logged In As Resource Manager    =======
        // ==============================================================

        greetUser(loggedInUser);

        /*
         * TODO : Raise Requisition Requests For Concerned People.
         * TODO : View All The Suggestions Made By RMGExecutiveDAOInterface.
         * TODO : Accept / Reject The Suggested Resources Against Requisitions.
         * TODO : If Accepted, Update The Project Status For Project ID, UserID.
         * TODO : Manually Update The Project Name, Code.
         * TODO : Generate Reports For Pending As Well As Closed Requests of his projects.
         */
    }

    // ==============================================================
    // =======     When User Logged In As RMG Executive       =======
    // ==============================================================

    private static void loginAsRMGExecutive(User loggedInUser) {



        greetUser(loggedInUser);

        System.out.println("Please Press 1 To Search Employee");
        System.out.println("Please Press 2 To Assign RMG Project To Employee");
        System.out.println("Please Press 3 To View All Requisition Requests");
        System.out.println("Please Press 4 To Generate Reports");
        System.out.println("Please Press 0 To Exit Program");

        RMGExecutiveImplementation rmgExecutiveService = new RMGExecutiveImplementation();

        input = new Scanner(System.in);
        int rmgInput = input.nextInt();

        switch (rmgInput) {
            case 1:
                //  TODO : Search Employee On Domain / Skill / Experience / ID.
                searchEmployee(rmgExecutiveService);
                break;
            case 2:
                //  TODO : Assign RMG Project To Employee.
                assignProjectToRM(rmgExecutiveService);
                break;
            case 3:
                //  TODO : View All Requisition Requests.
                viewAllRequisitionRequests(rmgExecutiveService);
                break;
            case 4:
                //  TODO : Generate Reports For Closed / Pending Requests from all Resource Managers for specific Date / Time / Closed / Pending.
                generateReports(rmgExecutiveService);
                break;

            default:
                exitProgram();
        }

    }

    // =====================================
    // =======     RMG Methods       =======
    // =====================================


    //Search Employee
    private static void searchEmployee(RMGExecutiveImplementation rmgExecutiveService) {

        System.out.println("Press 1 To Search By ID");
        System.out.println("Press 2 To Search By Domain");
        System.out.println("Press 3 To Search By Experience");
        System.out.println("Press 4 To Search By Skills");
        System.out.println("Press -1 To Go Back To Previous Section");

        int adminInput = input.nextInt();

        switch (adminInput) {
            case 1:
                int ID = input.nextInt();
                rmgExecutiveService.searchEmployeByID(ID);
                break;
            case 2:
                String domain = input.next();
                rmgExecutiveService.searchEmployeeByDomain(domain);
                break;
            case 3:
                int yearsOfExperience = input.nextInt();
                rmgExecutiveService.searchEmployeeByExperience(yearsOfExperience);
                break;
            case 4:
                String skills = input.nextLine();
                String[] skillsArray = skills.split(" ");
                ArrayList<String> skillsArrayList = new ArrayList<String>(Arrays.asList(skillsArray));
                Collections.sort(skillsArrayList);
                rmgExecutiveService.searchEmployeeBySkills(skillsArrayList);
                break;

            default:
                exitProgram();
        }


    }

    //Assign Project To Employee
    private static void assignProjectToRM(RMGExecutiveImplementation rmgExecutiveService) {
        System.out.println("Enter The Project ID");
        int projectID = input.nextInt();

        System.out.println("Enter The Employee ID Seperated By Space");
        int employeeID = input.nextInt();

        //TODO : Allocate the project

    }

    //View All Requests
    private static void viewAllRequisitionRequests(RMGExecutiveImplementation rmgExecutiveService) {

    }

    //Generate Reports
    private static void generateReports(RMGExecutiveImplementation rmgExecutiveService) {

    }

    // ======================================================
    // =======     When User Logged In As Admin       =======
    // ======================================================

    private static void loginAsAdmin(User loggedInUser) {



        greetUser(loggedInUser);

        System.out.println("Welcome " + loggedInUser.getName());
        /*
         * TODO : Add Users and their Roles.
         * TODO : Modify Users and their Roles.
         * TODO : Delete Users.
         */

        System.out.println("Please Press 1 To Add User");
        System.out.println("Please Press 2 To View Users");
        System.out.println("Please Press 3 To Modify User");
        System.out.println("Please Press 4 To Delete User");
        System.out.println("Please Press 0 To Exit Program");

        AdminServiceInterfaceImplementation adminService = new AdminServiceInterfaceImplementation();

        int adminInput = input.nextInt();

        switch (adminInput) {
            case 1:
                addUserToDatabase(adminService);
                break;
            case 2:
                viewUsersInDatabase(adminService);
                break;
            case 3:
                modifyUserInDatabase(adminService);
                break;
            case 4:
                deleteUserFromDatabase(adminService);
                break;

            default:
                exitProgram();
        }
    }

    // =======================================
    // =======     Admin Methods       =======
    // =======================================

    private static boolean addUserToDatabase(AdminServiceInterfaceImplementation adminService) {

        String name = input.next();
        String username = input.nextLine();
        String password = input.next();
        int userRole = input.nextInt();

        User userToBeAdded = new User(name, username, password, userRole);
        boolean status = adminService.addUser(userToBeAdded);

        return status;

    }

    private static boolean viewUsersInDatabase(AdminServiceInterfaceImplementation adminService) {
        ArrayList<User> users = adminService.viewUsers();

        for (User user : users) {
            System.out.println(
                    "Name : " + user.getName() +
                            " Grade : " + user.getUserGrade() +
                            "User ID " + user.getUserID());
        }

        return true;

    }

    private static boolean modifyUserInDatabase(AdminServiceInterfaceImplementation adminService) {
        String name = input.next();
        String username = input.nextLine();
        String password = input.next();
        int userRole = input.nextInt();

        User userToBeAdded = new User(name, username, password, userRole);
        boolean status = adminService.addUser(userToBeAdded);

        return status;
    }

    private static boolean deleteUserFromDatabase(AdminServiceInterfaceImplementation adminService) {

        System.out.println("Enter User ID Of User To Be Deleted");

        int userID = input.nextInt();

        User userToBeDeleted = new User(userID);
        boolean status = adminService.deleteUser(userToBeDeleted);

        return status;
    }


    // ============================================
    // =======     Login User Methods       =======
    // ============================================


    private static User checkUserCredentials(User newUser) {
        UserServiceInterfaceImplementation userService = new UserServiceInterfaceImplementation();
        User loggedInUser = userService.loginUser(newUser);
        return loggedInUser;
    }

    // ========================================
    // =======     Common Methods       =======
    // ========================================


    private static void exitProgram() {
        System.out.println("Thankyou, Have A Great Day!");
        System.exit(0);
    }

    private static void greetUser(User loggedInUser) {
        System.out.println("Welcome " + loggedInUser.getName());
    }


}
