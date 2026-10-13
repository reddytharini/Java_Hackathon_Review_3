class MovieBooking {
    private String customerName;
    private String movieName;
    private double ticketPrice;
    private int numberOfTickets;
    private boolean isBookingSuccessful;

    
    public MovieBooking() {
        this.customerName = "UNKNOWN";
        this.movieName = "UNKNOWN";
        this.ticketPrice = 0.0;
        this.numberOfTickets = 0;
        this.isBookingSuccessful = false;
    }

    
    public MovieBooking(String customerName, String movieName, double ticketPrice, int numberOfTickets) {
        // String Manipulation: Convert names to uppercase
        this.customerName = customerName != null ? customerName.toUpperCase() : "UNKNOWN";
        this.movieName = movieName != null ? movieName.toUpperCase() : "UNKNOWN";
        this.ticketPrice = ticketPrice;
        
        
        if (numberOfTickets > 0) {
            this.numberOfTickets = numberOfTickets;
            this.isBookingSuccessful = true;
        } else {
            this.numberOfTickets = 0;
            this.isBookingSuccessful = false;
        }
    }


    public void bookTicket(String customerName, String movieName, double ticketPrice, int numberOfTickets) {
        this.customerName = customerName != null ? customerName.toUpperCase() : "UNKNOWN";
        this.movieName = movieName != null ? movieName.toUpperCase() : "UNKNOWN";
        this.ticketPrice = ticketPrice;
        
        if (numberOfTickets > 0) {
            this.numberOfTickets = numberOfTickets;
            this.isBookingSuccessful = true;
        } else {
            this.numberOfTickets = 0;
            this.isBookingSuccessful = false;
        }
    }

    
    public void bookTicket(String customerName, String movieName, int numberOfTickets) {
        bookTicket(customerName, movieName, 150.0, numberOfTickets);
    }

    
    public void displaySummary() {
        System.out.println("Customer Name     : " + this.customerName);
        System.out.println("Movie Name        : " + this.movieName);
        
        if (!isBookingSuccessful) {
            System.out.println("Booking Status    : Booking Failed (Invalid number of tickets)");
            System.out.println("----------------------------------------");
            return;
        }

        System.out.printf("Ticket Price      : Rs. %.2f\n", this.ticketPrice);
        System.out.println("Number of Tickets : " + this.numberOfTickets);
        System.out.println("Booking Status    : Booking Successful");

        double totalAmount = this.ticketPrice * this.numberOfTickets;
        double discount = 0.0;

        
        if (this.numberOfTickets >= 5) {
            discount = totalAmount * 0.10;
        }

        double finalAmount = totalAmount - discount;

        System.out.printf("Total Amount      : Rs. %.2f\n", totalAmount);
        System.out.printf("Discount          : Rs. %.2f\n", discount);
        System.out.printf("Final Amount      : Rs. %.2f\n", finalAmount);
        System.out.println("----------------------------------------");
    }

    
    public boolean verifyBooking(MovieBooking otherBooking) {
        if (otherBooking == null) return false;
        return this.customerName.equalsIgnoreCase(otherBooking.customerName);
    }
}

public class CinemaTicketBookingSystem {
    public static void main(String[] args) {
        System.out.println("========== CINEMA TICKET BOOKING ==========");

        
        MovieBooking booking1 = new MovieBooking("Sneha", "Avatar", 200.0, 5);
        booking1.displaySummary();

        
        MovieBooking booking2 = new MovieBooking();
        booking2.bookTicket("Arjun", "Avatar", 2);
        booking2.displaySummary();
    }
}
