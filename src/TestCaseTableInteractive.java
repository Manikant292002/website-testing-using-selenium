public class TestCaseTableInteractive {
    public static void main(String[] args) throws InterruptedException {
        String[][] testCaseTable = {
            {"Test Case ID", "TC001"},
            {"Test Case Description", "Open Flipkart website and close login popup"},
            {"Test Steps", "1. Open Flipkart website\n2. Close login popup if it appears"},
            {"Expected Outcome", "1. Flipkart website is opened\n2. Login popup is closed if it appears"},
            {"Actual Outcome", "Website opened and popup closed"},
            {"Pass/Fail", "✔"},

            {"Test Case ID", "TC002"},
            {"Test Case Description", "Search for a product"},
            {"Test Steps", "1. Open Flipkart website\n2. Close login popup if it appears\n3. Search for a product"},
            {"Expected Outcome", "1. Flipkart website is opened\n2. Login popup is closed if it appears\n3. Product is searched"},
            {"Actual Outcome", "Website opened, popup closed, product searched"},
            {"Pass/Fail", "✔"},

            {"Test Case ID", "TC003"},
            {"Test Case Description", "Select a product from search results"},
            {"Test Steps", "1. Open Flipkart website\n2. Close login popup if it appears\n3. Search for a product\n4. Select the first product"},
            {"Expected Outcome", "1. Flipkart website is opened\n2. Login popup is closed if it appears\n3. Product is searched\n4. First product is selected"},
            {"Actual Outcome", "Website opened, popup closed, product searched, first product selected"},
            {"Pass/Fail", "✔"},

            {"Test Case ID", "TC004"},
            {"Test Case Description", "Add the product to the cart"},
            {"Test Steps", "1. Open Flipkart website\n2. Close login popup if it appears\n3. Search for a product\n4. Select the first product\n5. Add the product to the cart"},
            {"Expected Outcome", "1. Flipkart website is opened\n2. Login popup is closed if it appears\n3. Product is searched\n4. First product is selected\n5. Product is added to the cart"},
            {"Actual Outcome", "Website opened, popup closed, product searched, first product selected, product added to cart"},
            {"Pass/Fail", "✔"},

            {"Test Case ID", "TC005"},
            {"Test Case Description", "Verify that the product is in the cart"},
            {"Test Steps", "1. Open Flipkart website\n2. Close login popup if it appears\n3. Search for a product\n4. Select the first product\n5. Add the product to the cart\n6. Go to the cart and verify the product"},
            {"Expected Outcome", "1. Flipkart website is opened\n2. Login popup is closed if it appears\n3. Product is searched\n4. First product is selected\n5. Product is added to the cart\n6. Product is present in the cart"},
            {"Actual Outcome", "Website opened, popup closed, product searched, first product selected, product added to cart, product present in cart"},
            {"Pass/Fail", "✔"}
        };

        // Simulate loading spinner
        String[] spinner = {"|", "/", "-", "\\"};
        for (int i = 0; i < 20; i++) {
            System.out.print("\r" + spinner[i % spinner.length] + " Running Tests...");
            Thread.sleep(100);  // Pause for 100 milliseconds
        }
        System.out.print("\rDone!                 \n\n");  // Print done message

        // Print the table
        for (int i = 0; i < testCaseTable.length; i += 6) {
            System.out.println("=========================================");
            System.out.printf("%-20s : %s%n", testCaseTable[i][0], testCaseTable[i][1]);
            System.out.printf("%-20s : %s%n", testCaseTable[i+1][0], testCaseTable[i+1][1]);
            System.out.printf("%-20s : %s%n", testCaseTable[i+2][0], testCaseTable[i+2][1].replace("\n", "\n                    "));
            System.out.printf("%-20s : %s%n", testCaseTable[i+3][0], testCaseTable[i+3][1].replace("\n", "\n                    "));
            System.out.printf("%-20s : %s%n", testCaseTable[i+4][0], testCaseTable[i+4][1]);
            System.out.printf("%-20s : %s%n", testCaseTable[i+5][0], testCaseTable[i+5][1]);
            System.out.println("=========================================\n");
        }
    }
}
