package com.demo.UI;

import com.demo.Model.RequisitionSuggestions;
import com.demo.Model.RequsitionRequest;
import com.demo.Model.User;
import com.demo.Service.AdminServiceInterfaceImplementation;
import com.demo.Service.RMGExecutiveImplementation;
import com.demo.Service.ResouceManagerImplementation;
import com.demo.Service.UserServiceInterfaceImplementation;
import com.demo.Util.IRSValues;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class UI {

    private static Scanner input;

    public static void main(String[] args) {

        input = new Scanner(System.in);

        startTheProgram();
    }

    private static void startTheProgram() {
        printSpaces();
        System.out.println("Welcome To Internal Recruitment System");
        System.out.println("Press 1. To Login");
        System.out.println("Press 2. To Exit");

        int userInput = input.nextInt();

        switch (userInput) {
            case 1:
                loginUser();
                break;
            case 2:
                System.out.println("Have a great day!");
                System.exit(0);
        }
        startTheProgram();
    }

    private static void loginUser() {
        printSpaces();
        input = new Scanner(System.in);
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
                System.out.println("Logging In As Admin");
                loginAsAdmin(loggedInUser);
                break;

            case IRSValues.RMG_EXECUTIVE:
                System.out.println("Logging In As Executive");
                loginAsRMGExecutive(loggedInUser);
                break;

            case IRSValues.RESOURCE_MANAGER:
                System.out.println("Loggin In As Manager");
                loginAsResourceManager(loggedInUser);
                break;

            default:
                System.out.println("Invalid User Login");
                break;
        }
    }

    // ======================================================
    // =======           Login User Methods           =======
    // ======================================================

    private static User checkUserCredentials(User newUser) {
        UserServiceInterfaceImplementation userService = new UserServiceInterfaceImplementation();
        User loggedInUser = userService.loginUser(newUser);
        return loggedInUser;
    }

    // =========================================================
    // =======                                           =======
    // =======     1. When User Logged In As Admin       =======
    // =======                                           =======
    // =========================================================

    private static void loginAsAdmin(User loggedInUser) {
        printSpaces();
        greetUser(loggedInUser);

        /*
         * TODO : Add Users and their Roles.
         * TODO : Modify Users and their Roles.
         * TODO : Delete Users.
         */

        System.out.println("Please Press 1 To Add User");
        System.out.println("Please Press 2 To View Users");
        System.out.println("Please Press 3 To Modify User");
        System.out.println("Please Press 4 To Delete User");
        System.out.println("Please Press -1 To Log Out");

        AdminServiceInterfaceImplementation adminService = new AdminServiceInterfaceImplementation();

        int adminInput = input.nextInt();

        switch (adminInput) {
            case 1:
                addUser(adminService);
                break;
            case 2:
                viewUsers(adminService);
                break;
            case 3:
                modifyUser(adminService);
                break;
            case 4:
                deleteUserFromDatabase(adminService);
                break;
            case -1:
                return;

            default:
                System.out.println("Please enter a valid input.");
        }

        loginAsAdmin(loggedInUser);

    }

    // =========================================================
    // =======           Admin Functionality             =======
    // =========================================================

    //  1.1 - Adding User
    private static void addUser(AdminServiceInterfaceImplementation adminService) {
        printSpaces();
        System.out.println("Adding Users To Database");
        System.out.println("Enter Name");
        String name = input.next();
        System.out.println("Enter Username");
        String username = input.nextLine();
        System.out.println("Enter Password");
        String password = input.next();
        System.out.println(
                "Enter User Role Code : \n" +
                        "101 For RESOURCE_MANAGER \n" +
                        "102 For RMG_EXECUTIVE\n" +
                        "103 For Admin\n"
        );

        int userRole = input.nextInt();

        //Creating User Object To Be Passed Further
        User userToBeAdded = new User(name, username, password, userRole);

        //Calling The Method and Getting Its Return Status
        boolean status = adminService.addUser(userToBeAdded);

        //Printing Out Relevant Message
        if (status) {
            System.out.println("User Added Successfully");
        } else {
            System.out.println("Failed To Add User");
        }
    }

    //  1.2 - Viewing Users
    private static void viewUsers(AdminServiceInterfaceImplementation adminService) {

        printSpaces();
        System.out.println("Viewing Users In Database");
        ArrayList<User> users = adminService.viewUsers();

        for (User user : users) {
            System.out.println(
                    "Name : " + user.getName() +
                            " Grade : " + user.getUserGrade() +
                            "User ID " + user.getUserID());
        }
    }

    //  1.3 - Modify User
    private static void modifyUser(AdminServiceInterfaceImplementation adminService) {
        printSpaces();
        System.out.println("Modifying A User, Start With Entering the user ID");

        int userID = input.nextInt();

        System.out.println("Enter The New Name");
        String name = input.next();
        System.out.println("Enter The New UserName");
        String username = input.nextLine();
        System.out.println("Enter The New Password");
        String password = input.next();
        System.out.println(
                "Enter New User Role Code : \n" +
                        "101 For RESOURCE_MANAGER \n" +
                        "102 For RMG_EXECUTIVE\n" +
                        "103 For Admin\n"
        );

        int userRole = input.nextInt();

        User userToBeAdded = new User(userID, name, username, password, userRole);
        boolean status = adminService.addUser(userToBeAdded);

        //Printing Out Relevant Message
        if (status) {
            System.out.println("User Modified Successfully");
        } else {
            System.out.println("Failed To Modify User, No Changes Were Saved");
        }

    }

    //  1.4 - Delete User
    private static void deleteUserFromDatabase(AdminServiceInterfaceImplementation adminService) {

        printSpaces();
        System.out.println("Delete An Existing User");
        System.out.println("Enter User ID Of User To Be Deleted");

        int userID = input.nextInt();

        User userToBeDeleted = new User(userID);
        boolean status = adminService.deleteUser(userToBeDeleted);

        //Printing Out Relevant Message
        if (status) {
            System.out.println("User Deleted Successfully");
        } else {
            System.out.println("Failed To Delete User, Maybe the User doesn't exists?");
        }
    }

    // ===================================================================
    // ======                                                      =======
    // ======     2. When User is Logged In As Resource Manager    =======
    // ======                                                      =======
    // ===================================================================

    private static void loginAsResourceManager(User loggedInUser) {

        printSpaces();
        greetUser(loggedInUser);
        int managerID = loggedInUser.getUserID();

        /*
         * TODO : Raise Requisition Requests For Concerned People.
         * TODO : View All The Suggestions Made By RMGExecutiveDAOInterface.
         * TODO : Accept / Reject The Suggested Resources Against Requisitions.
         * TODO : If Accepted, Update The Project Status For Project ID, UserID.
         * TODO : Manually Update The Project Name, Code.
         * TODO : Generate Reports For Pending As Well As Closed Requests of his projects.
         */

        System.out.println("Press 1 To Raise New Requisition Request");
        System.out.println("Press 2 To View All Suggestion Made By RMG Executive");
        System.out.println("Press 3 To Accept / Reject Requests");
        System.out.println("Press 4 To Update Project Allocation For Employee");
        System.out.println("Press 5 To Update Project Details");
        System.out.println("Press 6 To See Reports");
        System.out.println("Press -1 To Go Logout");

        ResouceManagerImplementation resourceManagerService = new ResouceManagerImplementation();

        input = new Scanner(System.in);
        int rmgInput = input.nextInt();

        switch (rmgInput) {
            case 1:
                raiseNewRequisitionRequest(resourceManagerService, managerID);
                break;

            case 2:
                viewExecutivesSuggestions(resourceManagerService, managerID);
                break;

            case 3:
                acceptRejectRequests(resourceManagerService, managerID);
                break;

            case 4:
                updateProjectAllocationForEmployee(resourceManagerService, managerID);
                break;

            case 5:
                updateProjectDetails(resourceManagerService, managerID);
                break;

            case 6:
                generateReportsForResourceManager(resourceManagerService, managerID);
                break;

            case -1:
                startTheProgram();
                break;

            default:
                System.out.println("Enter Valid Input, Please Try Again");
                loginAsResourceManager(loggedInUser);
                break;
        }

        //Re-run This Menu
        loginAsResourceManager(loggedInUser);

    }

    // ====================================================================
    // =======            Resource Manager Functionality             ======
    // ====================================================================


    // 2.1 - Raise New Requisition Request
    private static void raiseNewRequisitionRequest(ResouceManagerImplementation resourceManagerService, int managerID) {

        printSpaces();
        System.out.println("Raising Requisition Request");

        System.out.println("Enter Your Project ID");
        int projectID = input.nextInt();

        Date dateCreated = new java.sql.Date(System.currentTimeMillis());
        int requestStatus = IRSValues.REQUISISTION_REQUEST_OPEN;

        System.out.println("Enter Vacancy Of People In Numbers");
        int vacancy = input.nextInt();

        System.out.println("Enter The Skills Space Seperated");
        String skillsString = input.nextLine();
        String[] skillsArray = skillsString.split(" ");
        ArrayList<String> skills = new ArrayList<>(Arrays.asList(skillsArray));

        System.out.println("Enter Domain Name");
        String domainName = input.next();

        System.out.println("Enter Number Of People Required");
        int numberOfPeopleRequired = input.nextInt();

        RequsitionRequest newRequisitionRequest = new RequsitionRequest(managerID, projectID, requestStatus, vacancy, skills, domainName, numberOfPeopleRequired);
        int requisitionRequestID = resourceManagerService.raiseRequisitionRequest(newRequisitionRequest);

        if (requisitionRequestID != 0) {
            System.out.println("Requisition Request Raised With ID " + requisitionRequestID);
        } else {
            System.out.println("Failed To Raise Requistion Request ");
        }
    }

    // 2.2 - View Suggestion Made By Executives
    private static void viewExecutivesSuggestions(ResouceManagerImplementation resourceManagerService, int managerID) {
        System.out.println("Viewing RMG Executive Suggestions");

        ArrayList<RequisitionSuggestions> requisitionSuggestions = resourceManagerService.viewSuggestionsMadeByExecutive(managerID);

        for (RequisitionSuggestions suggestion : requisitionSuggestions) {
            System.out.println("{ \n" +
                    "Request ID : " + suggestion.getRequisitionSuggestionID() + "\n" +
                    "Name : " + suggestion.getEmployeeName() + "\n" +
                    "For Project ID : " + suggestion.getSuggestedProjectID() + "\n" +
                    "Skills : " + suggestion.getSkills() + "\n" +
                    "Domain : " + suggestion.getDomain() + "\n" +
                    "Name : " + suggestion.getYearsOfExperience() + "\n" + "}"
            );
        }
    }

    // 2.3 - Accept / Reject Suggestions Made By Executives
    private static void acceptRejectRequests(ResouceManagerImplementation resourceManagerService, int managerID) {

        printSpaces();
        System.out.println("Accept / Reject Suggestions, You have the following suggestions");
        viewExecutivesSuggestions(resourceManagerService, managerID);

        System.out.println("Enter The Requisition Suggestion ID You Want To Accept / Reject ");
        int requisitionIDToAcceptReject = input.nextInt();

        System.out.println("Please Enter 1 to Accept 2 to Reject The Request");
        int acceptRejectCode = input.nextInt();

        if (resourceManagerService.acceptRejectSuggestions(managerID, requisitionIDToAcceptReject, acceptRejectCode)) {
            if (acceptRejectCode == 1) {
                System.out.println("Suggestion Accepted");
            } else if (acceptRejectCode == 2) {
                System.out.println("Suggestion Declined");
            }
        }
    }

    // 2.4 - Update Project Allocation For Employee
    private static void updateProjectAllocationForEmployee(ResouceManagerImplementation resourceManagerService, int managerID) {

        printSpaces();
        System.out.println("Updating Project Allocation For Employee");
        System.out.println("Enter EmployeeID");
        int empID = input.nextInt();

        System.out.println("Enter Project ID");
        int projectID = input.nextInt();

        if (resourceManagerService.updateProjectForEmployee(managerID, empID, projectID)) {
            System.out.println("Details Updated Successfully");
        }
        else{
            System.out.println("Failed To Update Any Deatails");
        }
    }

    // 2.5 - Update Project Details
    private static void updateProjectDetails(ResouceManagerImplementation resourceManagerService, int managerID) {

        printSpaces();
        System.out.println("Updating Project Details");

        System.out.println("Enter Project ID");

        if (resourceManagerService.updateProjectDetails(managerID, input.nextInt())) {
            System.out.println("Details Updated Successfully");
        }
    }

    // 2.6 - Generate Reports For Resource Manager
    private static void generateReportsForResourceManager(ResouceManagerImplementation resourceManagerService, int managerID) {
        printSpaces();
        System.out.println("Generating Reports");
        System.out.println(resourceManagerService.generateReportForAllRequests(managerID));
    }

    // ================================================================
    // ======                                                   =======
    // ======     3. When User is Logged In As RMG Executive    =======
    // ======                                                   =======
    // ================================================================

    private static void loginAsRMGExecutive(User loggedInUser) {

        printSpaces();
        greetUser(loggedInUser);

        int RMGExecutiveID = loggedInUser.getUserID();

        System.out.println("Please Press 1 To Search Employee");
        System.out.println("Please Press 2 To Assign RMG Project To Employee");
        System.out.println("Please Press 3 To View All Requisition Requests");
        System.out.println("Please Press 4 To Generate Reports");
        System.out.println("Please Press -1 To Logout");

        RMGExecutiveImplementation rmgExecutiveService = new RMGExecutiveImplementation();

        input = new Scanner(System.in);
        int rmgInput = input.nextInt();

        switch (rmgInput) {
            case 1:
                //  TODO : Search Employee On Domain / Skill / Experience / ID.
                searchEmployee(rmgExecutiveService, RMGExecutiveID);
                break;
            case 2:
                //  TODO : Assign RMG Project To Employee.
                assignProjectToRM(rmgExecutiveService, RMGExecutiveID);
                break;
            case 3:
                //  TODO : View All Requisition Requests.
                viewAllRequisitionRequests(rmgExecutiveService, RMGExecutiveID);
                break;
            case 4:
                //  TODO : Generate Reports For Closed / Pending Requests from all Resource Managers for specific Date / Time / Closed / Pending.
                generateReports(rmgExecutiveService, RMGExecutiveID);
                break;
            case -1:
                startTheProgram();
                break;

            default:
                System.out.println("Incorrect Input, Try Again");
                loginAsRMGExecutive(loggedInUser);
        }
        loginAsRMGExecutive(loggedInUser);
    }

    // ================================================================
    // =======               RMG Executive Methods             ========
    // ================================================================

    //  3.1 - Search Employee
    private static void searchEmployee(RMGExecutiveImplementation rmgExecutiveService, int rmgExecutiveID) {

        printSpaces();
        System.out.println("Press 1 To Search By ID");
        System.out.println("Press 2 To Search By Domain");
        System.out.println("Press 3 To Search By Experience");
        System.out.println("Press 4 To Search By Skills");
        System.out.println("Press -1 To Go Back To Previous Menu");

        int rmgExecutiveInput = input.nextInt();

        switch (rmgExecutiveInput) {

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

            case -1:
                return;

            default:
                searchEmployee(rmgExecutiveService, rmgExecutiveID);

        }
    }

    //  3.2 - Assign Project To Employee
    private static void assignProjectToRM(RMGExecutiveImplementation rmgExecutiveService, int RMGExecutiveID) {

        printSpaces();
        System.out.println("Enter The Project ID");
        int projectID = input.nextInt();

        System.out.println("Enter The Employee ID Seperated By Space");
        int employeeID = input.nextInt();

        //TODO : Allocate the project

        rmgExecutiveService.assignProjectToEmployee(projectID, employeeID);
    }

    //  3.2 - View All Requests
    private static void viewAllRequisitionRequests(RMGExecutiveImplementation rmgExecutiveService, int RMGExecutiveID) {

        printSpaces();
        ArrayList<RequsitionRequest> listOfRequests = rmgExecutiveService.viewAllRequisitionRequests(RMGExecutiveID);

        System.out.println("{");
        for (RequsitionRequest request : listOfRequests) {
            System.out.println(
                    "Raised By : " + request.getResourceManagerID() +
                            "Date Created : " + request.getDateCreated() + "\n" +
                            "Date Closed : " + request.getDateClosed() + "\n" +
                            "Domain : " + request.getDomainName() + "\n" +
                            "Request Status : " + request.getRequestStatus() + "\n" +
                            "Vacancy : " + request.getVacancy() + "\n" +
                            "Skills Required : " + request.getSkills() + "\n" +   // TODO : Need to Format Skills
                            "People Required : " + request.getNumberOfPeopleRequired() + "\n");
        }
        System.out.println("}");
    }

    //  3.4 - Generate Reports
    private static void generateReports(RMGExecutiveImplementation rmgExecutiveService, int rmgExecutiveID) {

        printSpaces();
        System.out.println("Press 1 To Get All Closed Requests");
        System.out.println("Press 2 To Get All Closed Request By Some Date");
        System.out.println("Press 3 To Get All Open Request");
        System.out.println("Press 4 To Get All Open Request By Some Date");
        System.out.println("Press -1 To Go Back To Previous Section");

        int adminInput = input.nextInt();

        switch (adminInput) {
            case 1:
                rmgExecutiveService.getAllClosedRequest(rmgExecutiveID);
                break;
            case 2:
                System.out.println("Enter Date In Format YYYY-MM-DD");
                LocalDate date = LocalDate.parse(input.nextLine());
                Date dateCreated = new java.sql.Date(date.toEpochDay());
                rmgExecutiveService.getAllClosedRequestAfterDate(rmgExecutiveID, date);
                break;
            case 3:
                rmgExecutiveService.getAllPendingRequest(rmgExecutiveID);
                break;
            case 4:
                System.out.println("Enter Date In Format YYYY-MM-DD");
                date = LocalDate.parse(input.nextLine());
                rmgExecutiveService.getAllPendingRequestAfterDate(rmgExecutiveID, date);
                break;
            case -1:
                return;
            default:
                System.out.println("Invalid Input, Try Again");
                break;
        }
    }

    // =======================================
    // =======                         =======
    // =======    Other Methods        =======
    // =======                         =======
    // =======================================

    private static void exitProgram() {
        System.out.println("Thank You, Have A Great Day!");
        System.exit(0);
    }

    private static void printSpaces() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    private static void greetUser(User loggedInUser) {
        System.out.println("Welcome " + loggedInUser.getName());
    }
}
