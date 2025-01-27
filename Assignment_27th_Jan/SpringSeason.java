public class SpringSeason {

    public static void main(String[] args) {
        // Check for correct number of command-line arguments
        if (args.length != 2) {
            System.err.println("Usage: java SpringSeason <month> <day>");
            System.exit(1); 
        }

        // Parse month and day from command-line arguments
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        // Check if the given date falls within the spring season
        if (isSpringSeason(month, day)) {
            System.out.println("It's a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }

    /**
     * Checks if the given date falls within the spring season (March 20 - June 20).
     *
     * @param month the month (1-12)
     * @param day the day of the month (1-31)
     * @return true if it's within the spring season, false otherwise
     */
    public static boolean isSpringSeason(int month, int day) {
        if (month == 3 && day >= 20) { // March 20 - March 31
            return true;
        } else if (month == 4) { // April
            return true;
        } else if (month == 5) { // May
            return true;
        } else if (month == 6 && day <= 20) { // June 1 - June 20
            return true;
        } else {
            return false;
        }
    }
}