package test;

import base.BaseTest;
import base.HomePage;

public class Case1 {
    public static void main(String[] args) {
        try {
            BaseTest.setUp();

            HomePage homePage = new HomePage(BaseTest.driver);

            String title = homePage.getPageTitle();
            if (title.contains("Chat") || title.contains("AI")) {
                System.out.println("PASS: Page title is correct -> " + title);
            } else {
                System.out.println("FAIL: Unexpected page title -> " + title);
            }

            homePage.writeAndSendMessage("Hello, this is an automated test message!");
            Thread.sleep(5000);

        } catch (Exception e) {
            System.out.println("ERROR OCCURRED: " + e.getMessage());
        } finally {
            BaseTest.tearDown();
        }
    }
}