package com.utils;

import java.util.Random;

public class Util {

    private static final String EMAIL_DOMAINS = "yopmail.com";
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random RANDOM = new Random();
	
 
	    //FirstName
	    public static String generateRandomFirstName(int len) {
	    	
	    	StringBuilder sb = new StringBuilder(len);
	        for (int i = 0; i < len; i++) {
	            int index = RANDOM.nextInt(ALPHA_NUMERIC_STRING.length());
	            sb.append(ALPHA_NUMERIC_STRING.charAt(index));
	        }
	        return sb.toString();
	    }

	    
	    //LastName
	    public static String generateRandomLastName(int len) {
	    	StringBuilder sb = new StringBuilder(len);
	        for (int i = 0; i < len; i++) {
	            int index = RANDOM.nextInt(ALPHA_NUMERIC_STRING.length());
	            sb.append(ALPHA_NUMERIC_STRING.charAt(index));
	        }
	        return sb.toString();
	    }

	    //Email
	    public static String generateRandomEmail(int len) {
	    	StringBuilder sb = new StringBuilder(len);
	        for (int i = 0; i < len; i++) {
	            int index = RANDOM.nextInt(ALPHA_NUMERIC_STRING.length());
	            sb.append(ALPHA_NUMERIC_STRING.charAt(index));
	        }
	        return  sb.toString() + "@" + EMAIL_DOMAINS;
	    }

	    //UserName
	    public static String generateRandomUsername(String firstName, String lastName) {
	        return firstName.toLowerCase() + "_" + lastName.toLowerCase() + RANDOM.nextInt(1000);
	    }

	    //Password
	    public static String generateRandomPassword() {
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < 10; i++) {
	            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
	        }
	        return sb.toString();
	    }

	    public static void main(String[] args) {
	        String firstName = generateRandomFirstName(6);
	        String lastName = generateRandomLastName(6);
	        String email = generateRandomEmail(8);
	        String username = generateRandomUsername(firstName, lastName);
	        String password = generateRandomPassword();

	        System.out.println("First Name: " + firstName);
	        System.out.println("Last Name: " + lastName);
	        System.out.println("Email: " + email);
	        System.out.println("Username: " + username);
	        System.out.println("Password: " + password);
	    }
	}

