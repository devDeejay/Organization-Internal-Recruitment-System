package com.demo.UI;

import com.demo.Model.Employee;
import com.demo.Model.RequisitionRequest;
import com.demo.Model.RequisitionSuggestions;
import com.demo.Model.User;
import com.demo.Service.Implementation.AdminServiceImplementation;
import com.demo.Service.Implementation.ExecutiveServiceImplementation;
import com.demo.Service.Implementation.ResouceManagerServiceImplementation;
import com.demo.Service.Implementation.UserServiceImplementation;
import com.demo.Util.IRSValues;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class UI {

    private static Scanner input;
    private static Scanner inputString;

    //	Main Method Method
    final public static void main(String[] args) {

        input = new Scanner(System.in);
        inputString = new Scanner(System.in);

        User.Builder builder = new User.Builder();
        builder.username("div96").password("timi123").userID(522).name("Divya Verma");
        User user = builder.build();

        loginAsExecutive(user);
    }

    //	Start The Program Method
    private static void startTheProgram() {

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

    //	Login user Method
    private static void loginUser() {

        System.out.println("Enter Your Credentials");
        System.out.println("Enter -1 To Go Back");

        System.out.println("Username : ");

        String username = inputString.next();

        if (username.equals("-1")) {
            startTheProgram();
        }

        System.out.println("Password : ");
        String password = inputString.next();

        /*
         * Creating User Object For Login.
         */

        User.Builder builder = new User.Builder();
        builder.username(username).password(password);
        User newUser = builder.build();

        /*
         * Getting LoggedInUser Object Back From Database.
         */

        User loggedInUser = checkUserCredentials(newUser);

        /*
         * Checking User Grade (User Access) And Logging-In User Further According To Their Grade.
         */

        if (loggedInUser.isValidUser()) {
            int userGrade = loggedInUser.getUserGrade();
            switch (userGrade) {
                case IRSValues.ADMIN:
                    System.out.println("Logging In As Admin");
                    loginAsAdmin(loggedInUser);
                    break;

                case IRSValues.EXECUTIVE:
                    System.out.println("Logging In As Executive");
                    loginAsExecutive(loggedInUser);
                    break;

                case IRSValues.RESOURCE_MANAGER:
                    System.out.println("Logging In As Manager");
                    loginAsResourceManager(loggedInUser);
                    break;

                default:
                    System.out.println("Invalid User Login");
                    break;
            }
        } else {
            System.out.println("Invalid Credentials");
            loginUser();
        }

    }

    // =========================================================
    // =                  Login User Methods                   =
    // =========================================================

    private static User checkUserCredentials(User newUser) {

        UserServiceImplementation userService = new UserServiceImplementation();
        User loggedInUser = userService.loginUser(newUser);
        return loggedInUser;
    }

    // =========================================================
    // =                                                       =
    // =           1. When User Logged In As Admin             =
    // =                                                       =
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

        AdminServiceImplementation adminService = new AdminServiceImplementation();

        String adminInput = input.next();

        switch (adminInput) {
            case "1":
                addUser(adminService);
                break;
            case "2":
                viewUsers(adminService);
                break;
            case "3":
                modifyUser(adminService);
                break;
            case "4":
                deleteUserFromDatabase(adminService);
                break;
            case "-1":
                startTheProgram();
                break;

            default:
                System.out.println("Please enter a valid input.");
        }

        loginAsAdmin(loggedInUser);

    }

    private static void printSpaces() {
        System.out.println("\n\n");
    }

    // =========================================================
    // =                 Admin Functionality                   =
    // =========================================================

    //  1.1 - Adding User
    private static void addUser(AdminServiceImplementation adminService) {

        System.out.println("Adding Users To Database, Enter -1 to Go Back");

        System.out.println("Enter Full Name");
        String name = inputString.nextLine();
        if (name == "-1") {
            return;
        }
        while (!name.matches("[a-zA-Z]+$")) {
            System.out.println("Please Enter A Valid Name");
            name = inputString.nextLine();
        }

        System.out.println("Enter Username");
        String username = inputString.nextLine();

        System.out.println("Enter Password");
        String password = inputString.nextLine();
        int userGrade = 0;
        while (userGrade == 0) {
            userGrade = takeUserGradeFromUser();
        }

        //Creating User Object To Be Passed Further

        User.Builder builder = new User.Builder();
        builder.username(username).password(password).userGrade(userGrade).name(name);
        User userToBeAdded = builder.build();

        //Calling The Method and Getting Its Return Status
        boolean status = adminService.addUser(userToBeAdded);

        //Printing Out Relevant Message
        if (status) {
            System.out.println("User Added Successfully");
        } else {
            System.out.println("Failed To Add User");
        }
    }

    private static int takeUserGradeFromUser() {

        System.out.println(
                "Enter User Role Code : \n" +
                        "101 For RESOURCE_MANAGER \n" +
                        "102 For EXECUTIVE\n" +
                        "103 For Admin\n"
        );

        String userGradeInput = input.next();

        int userGrade = 0;

        switch (userGradeInput) {
            case "101":
                userGrade = 101;
                break;

            case "102":
                userGrade = 102;
                break;

            case "103":
                userGrade = 103;
                break;

            default:
                System.out.println("Please enter a valid User Grade");

        }
        return userGrade;
    }

    //  1.2 - Viewing Users
    private static void viewUsers(AdminServiceImplementation adminService) {

        System.out.println("Viewing Users In Database");
        ArrayList<User> usersInDatabase = adminService.viewUsers();

        System.out.println();
        for (User user : usersInDatabase) {
            System.out.print("	{");

            System.out.print(
                    " Name : " + user.getName() + ", " +
                            "Grade : " + user.getUserGrade() + ", " +
                            "User ID : " + user.getUserID() + " ");

            System.out.println("}");
        }
        System.out.println();
    }

    //  1.3 - Modify User
    private static void modifyUser(AdminServiceImplementation adminService) {

        System.out.println("Modifying A User, Start With Entering the user ID");
        int userID = input.nextInt();
        input.nextLine();

        System.out.println("Enter The New Name");
        String name = input.nextLine();

        System.out.println("Enter The New UserName");
        String username = input.nextLine();

        System.out.println("Enter The New Password");
        String password = input.nextLine();

        int userGrade = 0;
        while (userGrade == 0) {
            userGrade = takeUserGradeFromUser();
        }

        User.Builder builder = new User.Builder();
        builder.userID(userID).name(name).username(username).password(password).userGrade(userGrade);
        User userToBeModified = builder.build();

        boolean status = adminService.modifyUser(userToBeModified);

        //Printing Out Relevant Message
        if (status) {
            System.out.println("User Modified Successfully");
        } else {
            System.out.println("Failed To Modify User, No Changes Were Saved");
        }

    }

    //  1.4 - Delete User
    private static void deleteUserFromDatabase(AdminServiceImplementation adminService) {

        System.out.println("Delete An Existing User...");

        System.out.println("Existing Users...");
        viewUsers(adminService);

        System.out.println("Enter -1 To Go Back");
        System.out.println("Enter User ID Of User To Be Deleted");

        int userID = input.nextInt();
        if (userID == -1) {
            return;
        }

        User.Builder builder = new User.Builder();
        builder.userID(userID);
        User userToBeDeleted = builder.build();

        boolean status = adminService.deleteUser(userToBeDeleted);

        //Printing Out Relevant Message
        if (status) {
            System.out.println("User Deleted Successfully");
        } else {
            System.out.println("Failed To Delete User, Maybe the User doesn't exists?");
        }
    }

    // ===================================================================
    // =                                                                 =
    // =          2. When User is Logged In As Resource Manager          =
    // =                                                                 =
    // ===================================================================

    private static void loginAsResourceManager(User loggedInUser) {

        printSpaces();
        greetUser(loggedInUser);
        int managerID = loggedInUser.getUserID();

        /*
         * TODO : Raise Requisition Requests For Concerned People.
         * TODO : View All The Suggestions Made By ExecutiveDAOInterface.
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

        ResouceManagerServiceImplementation resourceManagerService = new ResouceManagerServiceImplementation();

        input = new Scanner(System.in);
        String rmgInput = input.next();

        switch (rmgInput) {
            case "1":
                raiseNewRequisitionRequest(resourceManagerService, managerID);
                break;

            case "2":
                viewExecutivesSuggestions(resourceManagerService, managerID);
                break;

            case "3":
                acceptRejectRequests(resourceManagerService, managerID);
                break;

            case "4":
                updateProjectAllocationForEmployee(resourceManagerService, managerID);
                break;

            case "5":
                updateProjectDetails(resourceManagerService, managerID);
                break;

            case "6":
                generateReportsForResourceManager(resourceManagerService, managerID);
                break;

            case "-1":
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
    // =                  Resource Manager Functionality                  =
    // ====================================================================


    // 2.1 - Raise New Requisition Request - DONE - WORKING
    private static void raiseNewRequisitionRequest(ResouceManagerServiceImplementation resourceManagerService, int managerID) {

        System.out.println("Raising Requisition Request");

        System.out.println("Enter Vacancy Of People In Numbers");
        int vacancy = input.nextInt();

        System.out.println("Enter The Skills");
        String skillsAsString = inputString.nextLine();

        System.out.println("Enter Domain Name");
        String domainName = inputString.nextLine();

        System.out.println("Enter Number Of People Required");
        int numberOfPeopleRequired = input.nextInt();

        RequisitionRequest.Builder builder = new RequisitionRequest.Builder();
        builder
                .resourceManagerID(managerID)
                .vacancy(vacancy)
                .skillsAsString(skillsAsString)
                .domainName(domainName)
                .numberOfPeopleRequired(numberOfPeopleRequired);

        RequisitionRequest newRequisitionRequest = builder.build();

        int requisitionRequestID = resourceManagerService.raiseRequisitionRequest(newRequisitionRequest);

        if (requisitionRequestID != 0) {
            System.out.println("Requisition Request Raised With ID " + requisitionRequestID);
        } else {
            System.out.println("Failed To Raise Requistion Request ");
        }
    }

    // 2.2 - View Suggestion Made By Executives - DONE
    private static void viewExecutivesSuggestions(ResouceManagerServiceImplementation resourceManagerService, int managerID) {

        System.out.println("View Executive Suggestions");
        System.out.println(
                "Enter 1. To View All OPEN suggestions\n" +
                        "Enter 2. To View All ACCEPTED suggestions\n" +
                        "Enter 3. To View All REJECTED suggestions\n" +
                        "Enter 4. To View All suggestions\n" +
                        "Enter -1 To Go Back"
        );

        int inputCase = input.nextInt();
        switch (inputCase) {
            case 1:

                // ================================================================
                // =      			List Of All Open Suggestions     		      =
                // ================================================================

                System.out.println("ALL OPEN SUGGESTIONS");
                showSuggestion(resourceManagerService, managerID, IRSValues.ALL_OPEN_SUGGESTIONS);
                break;


            case 2:

                // ================================================================
                // =      		    List Of All Accepted Suggestions     		  =
                // ================================================================

                System.out.println("ALL ACCEPTED REQUESTS");
                showSuggestion(resourceManagerService, managerID, IRSValues.ALL_ACCEPTED_SUGGESTIONS);
                break;

            case 3:

                // ================================================================
                // =      		    List Of All Rejected Suggestions     		  =
                // ================================================================

                System.out.println("ALL REJECTED SUGGESTIONS");
                showSuggestion(resourceManagerService, managerID, IRSValues.ALL_REJECTED_SUGGESTIONS);
                break;

            case 4:

                // ================================================================
                // =      				List Of All Suggestions     			  =
                // ================================================================

                System.out.println("ALL SUGGESTIONS");
                showSuggestion(resourceManagerService, managerID, IRSValues.ALL_SUGGESTIONS);
                break;

            case -1:
                // Going Back To LoginAsRMG
                return;

            default:
                System.out.println("Please Enter A Valid Input");
                viewExecutivesSuggestions(resourceManagerService, managerID);
        }

        viewExecutivesSuggestions(resourceManagerService, managerID);

    }

    // 2.3 - Accept / Reject Suggestions Made By Executives - DONE
    private static void acceptRejectRequests(ResouceManagerServiceImplementation resourceManagerService, int managerID) {

        System.out.println("Accept / Reject Suggestions, You have the following suggestions");
        viewExecutivesSuggestions(resourceManagerService, managerID);

        System.out.println("Enter The Requisition Suggestion ID You Want To Accept / Reject ");
        int requisitionSuggestionID = input.nextInt();

        System.out.println("Please Enter 400 to Accept\n402 to Reject The Suggestion");
        int choice = input.nextInt();

        // Calling The Service Layer, Passing The Option, Getting  A Boolean in return if executed successfully
        if (resourceManagerService.acceptRejectSuggestions(managerID, requisitionSuggestionID, choice)) {
            if (choice == IRSValues.REQUISITION_SUGGESTION_ACCEPTED) {
                System.out.println("Suggestion Accepted");
            } else if (choice == IRSValues.REQUISITION_SUGGESTION_REJECTED) {
                System.out.println("Suggestion Declined");
            }
        }
    }

    // 2.4 - Update Project Allocation For Employee - DONE - WORKING
    private static void updateProjectAllocationForEmployee(ResouceManagerServiceImplementation resourceManagerService, int managerID) {

        System.out.println("Updating Project Allocation For Employee");
        System.out.println("Enter -1 To Go Back");
        System.out.println("Enter EmployeeID");
        int empID = input.nextInt();

        if (empID == -1) {
            return;
        }

        System.out.println("Enter Project ID");
        System.out.println("Enter 0 For No Project");
        int projectID = input.nextInt();
        if (resourceManagerService.updateProjectForEmployee(managerID, empID, projectID)) {
            System.out.println("Details Updated Successfully");
        } else {
            System.out.println("Failed To Update Any Details");
        }
    }

    // 2.5 - Update Project Details - DONE
    private static void updateProjectDetails(ResouceManagerServiceImplementation resourceManagerService, int managerID) {

        System.out.println("Updating Project Details");

        System.out.println("Enter Project ID");

        if (resourceManagerService.updateProjectDetails(managerID, input.nextInt())) {
            System.out.println("Details Updated Successfully");
        }
    }

    // 2.6 - Generate Reports For Resource Manager - DONE - PARTIALLY WORKING
    private static void generateReportsForResourceManager(ResouceManagerServiceImplementation resourceManagerService, int managerID) {

        System.out.println("Generating Reports For Requests");

        // ================================================================
        // =      			List Of All Open Requests     				  =
        // ================================================================

        printSpaces();
        System.out.println("ALL OPEN REQUESTS");
        showRequests(resourceManagerService, managerID, IRSValues.REQUISITION_REQUEST_OPEN);

        // ================================================================
        // =      			List Of All Closed Requests     		      =
        // ================================================================

        printSpaces();
        System.out.println("ALL CLOSED REQUESTS");
        showRequests(resourceManagerService, managerID, IRSValues.REQUISITION_REQUEST_CLOSED);

    }

    // 2.6.1 Show Requests According to Type - DONE
    private static void showRequests(ResouceManagerServiceImplementation resourceManagerService, int managerID, int requestCode) {
        getAndDisplayRequests(resourceManagerService, managerID, requestCode);
    }

    // 2.6.2 Show Suggestions According to Type - DONE
    private static void showSuggestion(ResouceManagerServiceImplementation resourceManagerService, int managerID, int suggestionsCode) {

        ArrayList<RequisitionSuggestions> requisitionSuggestions = resourceManagerService.viewSuggestionsMadeByExecutive(managerID, suggestionsCode);

        Iterator<RequisitionSuggestions> iterator = requisitionSuggestions.iterator();
        System.out.println("{");
        while (iterator.hasNext()) {
            RequisitionSuggestions suggestion = iterator.next();
            System.out.println("\n" +
                    "Request ID : " + suggestion.getRequisitionSuggestionID() + "\n" +
                    "Name : " + suggestion.getEmployeeName() + "\n" +
                    "For Project ID : " + suggestion.getSuggestedProjectID() + "\n" +
                    "Skills : " + suggestion.getEmployeeSkills() + "\n" +
                    "Domain : " + suggestion.getEmployeeDomain() + "\n" +
                    "Name : " + suggestion.getYearsOfExperience() + "\n"
            );
        }
        System.out.println("}");
    }

    // 2.6.3 Support Method For Manager Functionality
    private static void getAndDisplayRequests(ResouceManagerServiceImplementation resourceManagerService, int managerID, int requestCode) {

        ArrayList<RequisitionRequest> listOfAllRequests = resourceManagerService.viewAllRequests(managerID, requestCode);

        if (listOfAllRequests == null) {
            System.out.println("No Records Found");
            return;
        }

        // Calling Printing Method For This Request Object

        Iterator<RequisitionRequest> iterator = listOfAllRequests.iterator();
        while (iterator.hasNext()) {
            RequisitionRequest request = iterator.next();
            printRequestObject(request);
        }
    }

    // 2.6.4 Support Method For Manager Functionality
    private static void printRequestObject(RequisitionRequest request) {

        System.out.println("{ \n" +
                "	Request ID : " + request.getRequsitionID() + "\n" +
                "	Domain Name : " + request.getDomainName() + "\n" +
                "	Project ID : " + request.getProjectID() + "\n" +
                "	Vacancy Of People : " + request.getVacancy() + "\n" +
                "	Required People : " + request.getNumberOfPeopleRequired() + "\n" +
                "	Skills Required : " + request.getSkillsAsString() + "\n" +
                "	Request Status : " + request.getRequestStatus() + "\n" +
                "	Request Open Date : " + request.getDateCreated() + "\n" +
                "	Request Close Date : " + request.getDateClosed() + "\n}"
        );
    }

    // ================================================================
    // =                                                              =
    // =          3. When User is Logged In As RMG Executive          =
    // =                                                              =
    // ================================================================

    private static void loginAsExecutive(User loggedInUser) {

        greetUser(loggedInUser);

        int executiveID = loggedInUser.getUserID();

        System.out.println("Please Press 1 To Search Employee");
        System.out.println("Please Press 2 To Assign RMG Project To Employee");
        System.out.println("Please Press 3 To View All Requisition Requests");
        System.out.println("Please Press 4 To Generate Reports");
        System.out.println("Please Press 5 To Suggest For Requests");
        System.out.println("Please Press -1 To Logout");

        ExecutiveServiceImplementation executiveService = new ExecutiveServiceImplementation();

        input = new Scanner(System.in);
        int rmgInput = input.nextInt();

        switch (rmgInput) {
            case 1:
                //  TODO : Search Employee On Domain / Skill / Experience / ID.
                searchEmployee(executiveService);
                break;
            case 2:
                //  TODO : Assign RMG Project To Employee.
                assignProjectToRM(executiveService, executiveID);
                break;
            case 3:
                //  TODO : View All Requisition Requests.
                viewAllRequisitionRequests(executiveService, executiveID);
                break;
            case 4:
                //  TODO : Generate Reports For Closed / Pending Requests from all Resource Managers for specific Date / Time / Closed / Pending.
                generateReports(executiveService, executiveID);
                break;
            case 5:
                //  TODO : Generate Suggestions.
                giveSuggestionForRequest(executiveService, executiveID);
                break;
            case -1:
                startTheProgram();
                break;

            default:
                System.out.println("Incorrect Input, Try Again");
                loginAsExecutive(loggedInUser);
        }
        loginAsExecutive(loggedInUser);
    }

    // ================================================================
    // =      				RMG Executive Methods     				  =
    // ================================================================

    //  3.1 - Search Employee

    private static void searchEmployee(ExecutiveServiceImplementation executiveService) {

        System.out.println("Press 1 To Search By ID");
        System.out.println("Press 2 To Search By Domain");
        System.out.println("Press 3 To Search By Experience");
        System.out.println("Press 4 To Search By Skills");
        System.out.println("Press -1 To Go Back To Previous Menu");

        String executiveInput = input.next();

        switch (executiveInput) {

            case "1":
                searchEmployeeByID(executiveService);
                break;

            case "2":
                searchEmployeeByDomain(executiveService);
                break;

            case "3":
                searchEmployeeByExperience(executiveService);
                break;

            case "4":
               searchEmployeeBySkills(executiveService);
                break;

            case "-1":
                return;

            default:
                System.out.println("Please enter valid input");
                break;
        }
        searchEmployee(executiveService);
    }

    private static void searchEmployeeBySkills(ExecutiveServiceImplementation executiveService) {
        String skills = inputString.next();
        executiveService.searchEmployeeBySkills(skills);
    }

    private static void searchEmployeeByExperience(ExecutiveServiceImplementation executiveService) {
        System.out.println("Enter The Minimum Number Of Years of Experience");
        System.out.println("Enter -1 To Go Back");
        String experience = input.next();

        while (!experience.matches("[0-9]+")) {
            System.out.println("Please Give A Valid Number");
            experience = input.next();
            if (experience.equals("-1")) {
                return;
            }
        }
        int yearsOfExperience = Integer.parseInt(experience);

        executiveService.searchEmployeeByExperience(yearsOfExperience);
    }

    //  3.1.1 - Search Employee By Domain
    private static void searchEmployeeByDomain(ExecutiveServiceImplementation executiveService) {
        System.out.println("Enter The Domain Of Employee");
        System.out.println("Enter -1 To Go Back");

        String domainName = inputString.nextLine();
        if (domainName.equals("-1")) {
            return;
        }
        while (!domainName.matches("[a-zA-Z]+$")) {
            System.out.println("Please Enter A Valid Name");
            domainName = inputString.nextLine();
        }

        String domain = inputString.next();
        ArrayList<Employee> listOfEmployees = executiveService.searchEmployeeByDomain(domain);

        Iterator<Employee> iterator = listOfEmployees.iterator();

        while (iterator.hasNext()) {
            Employee e = iterator.next();
            printEmployeeObject(e);
        }
    }

    //  3.1.2 - Search Employee By ID
    private static void searchEmployeeByID(ExecutiveServiceImplementation executiveService) {
        System.out.println("Enter Employee ID To Be Searched");
        System.out.println("Enter -1 To Go Back");
        String inputID = input.next();

        while (!inputID.matches("[0-9]+")) {
            System.out.println("Please Give A Valid Employee ID");
            inputID = input.next().trim();
            if (inputID.equals("-1")) {
                return;
            }
        }

        // Loop Will Break If User Enters a Number ID
        Employee e = null;
        int ID = Integer.valueOf(inputID);
        if (ID > 0) {
            e = executiveService.searchEmployeeByID(ID);
        }

        if (e != null) {
            printEmployeeObject(e);
        } else {
            System.out.println("Employee With ID " + ID + " not found in the database.");
        }
    }

    //  3.2 - Assign Project To Employee
    private static void assignProjectToRM(ExecutiveServiceImplementation executiveService, int executiveID) {

        System.out.println("Enter The Project ID");
        int projectID = input.nextInt();

        System.out.println("Enter The Employee ID");
        int employeeID = input.nextInt();

        //TODO : Allocate the project

        executiveService.assignProjectToEmployee(projectID, employeeID);
    }

    //  3.2 - View All Requests
    private static void viewAllRequisitionRequests(ExecutiveServiceImplementation executiveService, int executiveID) {
        getRequest(executiveService, executiveID, IRSValues.REQUISITION_REQUEST_OPEN);
    }

    //  3.3 - Give Suggestion On Basis Of Requests

    private static void giveSuggestionForRequest(ExecutiveServiceImplementation executiveService, int executiveID) {
        // SHOW OPEN REQUESTS

        // SEARCH EMPLOYEES


    }

    //  3.4 - Generate Reports
    private static void generateReports(ExecutiveServiceImplementation executiveService, int executiveID) {

        System.out.println("Press 1 To Get All Closed Requests");
        System.out.println("Press 2 To Get All Closed Request By Some Date");
        System.out.println("Press 3 To Get All Open Request");
        System.out.println("Press 4 To Get All Open Request By Some Date");
        System.out.println("Press -1 To Go Back To Previous Section");

        String executiveInput = input.next();
        Date date;
        switch (executiveInput) {
            case "1":
                getRequest(executiveService, executiveID, IRSValues.ALL_CLOSED_REQUESTS);
                break;

            case "2":
                date = getDateFromUserAndParseIt();
                getRequest(executiveService, executiveID, IRSValues.ALL_CLOSED_REQUESTS, date);
                break;

            case "3":
                getRequest(executiveService, executiveID, IRSValues.ALL_OPEN_REQUESTS);
                break;

            case "4":
                date = getDateFromUserAndParseIt();
                getRequest(executiveService, executiveID, IRSValues.ALL_OPEN_REQUESTS, date);
                break;

            case "-1":
                return;

            default:
                System.out.println("Invalid Input, Try Again");
                break;
        }
        generateReports(executiveService, executiveID);
    }

    private static Date getDateFromUserAndParseIt() {
        System.out.println("Enter Date In Format DD-MM-YYYY");
        String inputStringDate = inputString.next();

        SimpleDateFormat format = new SimpleDateFormat("DD-MM-YYYY");
        java.util.Date parsedDate = null;
        java.sql.Date sqlDate = null;
        try {
            parsedDate = format.parse(inputStringDate);
            sqlDate = new java.sql.Date(parsedDate.getTime() + 86400000);
        } catch (ParseException e) {
            System.out.println("Invalid Date Format");
            e.printStackTrace();
        }
        return sqlDate;
    }

    private static void getRequest(ExecutiveServiceImplementation executiveService, int executiveID, int requestCode, Date date) {
        ArrayList<RequisitionRequest> listOfRequests = executiveService.viewAllRequisitionRequests(executiveID, requestCode, date);

        Iterator<RequisitionRequest> iterator = listOfRequests.iterator();

        while (iterator.hasNext()) {
            RequisitionRequest request = iterator.next();
            printRequestObject(request);
        }
    }

    private static void getRequest(ExecutiveServiceImplementation executiveService, int executiveID, int requestCode) {
        ArrayList<RequisitionRequest> listOfRequests = executiveService.viewAllRequisitionRequests(
                executiveID,
                requestCode,
                new java.sql.Date(new java.util.Date(System.currentTimeMillis() + 86400000).getTime())
        );

        Iterator<RequisitionRequest> iterator = listOfRequests.iterator();

        while (iterator.hasNext()) {
            RequisitionRequest request = iterator.next();
            printRequestObject(request);
        }
    }

    private static void printEmployeeObject(Employee e) {
        if (e.getEmployeeStatus() == IRSValues.UNALLOCATED_IN_ANY_PROJECT) {
            System.out.println("Unallocated");
        } else {
            System.out.println("Allocated");
        }

        System.out.println(e.getEmployeeStatus() == IRSValues.UNALLOCATED_IN_ANY_PROJECT ? "Unallocated" : "Allocated");

        System.out.println(
                "   ID : " + e.getEmployeeID() + "\n" +
                        "   Name : " + e.getEmployeeName() + "\n" +
                        "   Project ID : " + e.getEmployeeProjectID() + "\n" +
                        "   Domain : " + e.getEmployeeDomain() + "\n" +
                        "   Skills : " + e.getEmployeeSkills() + "\n" +
                        "   Experience : " + e.getYearsOfExperience() + "\n" +
                        "   Allocation Status : " + (e.getEmployeeStatus() == IRSValues.ALLOCATED_IN_PROJECT ? "Allocated" : "Unallocated") +
                        "\n"
        );
    }

    // =================================
    // =                               =
    // =         Other Methods         =
    // =                               =
    // =================================

    //	Greet User
    private static void greetUser(User loggedInUser) {
        System.out.println("Welcome " + loggedInUser.getName());
    }
}
