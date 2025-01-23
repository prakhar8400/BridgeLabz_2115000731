
public class SpringSeason {

    public static void main(String[] args) {
        // Get month and day from command line arguments
        int month = Integer.parseInt(args[0]); 
        int day = Integer.parseInt(args[1]);

        // Check if it's within the Spring season (March 20 - June 20)
        if ((month == 3 && day >= 20) || 
            (month == 4) || 
            (month == 5) || 
            (month == 6 && day <= 20)) { 
            System.out.println("It's a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}


