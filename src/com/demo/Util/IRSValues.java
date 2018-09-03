package com.demo.Util;

public interface IRSValues {
    int RESOURCE_MANAGER = 101;
    int RMG_EXECUTIVE = 102;
    int ADMIN = 103;
    int INVALID_USER = 104;

    int ALLOCATED_IN_PROJECT = 201;
    int UNALLOCATED = 202;

    int REQUISISTION_REQUEST_OPEN = 300;
    int REQUISISTION_REQUEST_CLOSED = 301;

    int REQUISITION_SUGGESTION_ACCEPTED = 400;
    int REQUISITION_SUGGESTION_REJECTED = 401;
    int REQUISITION_SUGGESTION_SUGGESTED = 402;

    int ALL_REQUESTS = 500;
    int ALL_OPEN_REQUESTS = 501;
    int ALL_CLOSED_REQUESTS = 502;

    int ALL_SUGGESTIONS = 503;
    int ALL_OPEN_SUGGESTIONS = 504;
    int ALL_ACCEPTED_SUGGESTIONS = 505;
    int ALL_REJECTED_SUGGESTIONS = 506;

    // Database Configuration
    
    String DB_URL = "jdbc:oracle:thin:@10.219.34.3:1521:orcl";
    String DB_USERNAME = "trg230";
    String DB_PASSWORD = "training230";
    
}
