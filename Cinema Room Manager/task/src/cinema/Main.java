package cinema;

import java.util.Scanner;

import static cinema.Cinema.initSeatCinema;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cinema cinema = new Cinema();
        initSeatCinema(cinema);
        int itemsMenu = -1;
        while (itemsMenu  != 0) {
            printMenu();
            itemsMenu = scanner.nextInt();
            if (itemsMenu == 1) {
                printAllSeat(cinema);
            } else if (itemsMenu == 2) {
                buyTicket(cinema);
            } else if (itemsMenu == 3) {
                statistics(cinema);
            }
        }
    }


    private static void printMenu() {
        System.out.println("""
                1. Show the seats
                2. Buy a ticket
                3. Statistics
                0. Exit""");
    }

    private static void statistics(Cinema cinema) {
        int tickets = countTickets(cinema);
        int seats = cinema.getRow() * cinema.getSeatInRow();
        double percentage = (double)tickets / (double) seats * 100;
        int currentIncome = countCurrentIncome(cinema, seats);
        int totalIncome = countTotalIncome(cinema, seats);

        System.out.printf("""
                Number of purchased tickets: %d
                Percentage: %.2f%%
                Current income: $%d
                Total income: $%d
                """, tickets, percentage, currentIncome, totalIncome);
        System.out.println();
    }

    private static int countTotalIncome(Cinema cinema, int seats) {
        int totalIncome;
        int checkKChangePrice = 60;
        if (seats > checkKChangePrice) {
            if (cinema.getRow() % 2 != 0) {
                totalIncome = (cinema.getRow() / 2 * 10 * cinema.getSeatInRow())
                        + ((cinema.getRow() / 2 + 1) * 8 * cinema.getSeatInRow());
            } else {
                totalIncome = (cinema.getRow() / 2 * 8 * cinema.getSeatInRow())
                        + (cinema.getRow() / 2 * 10 * cinema.getSeatInRow());
            }
        } else {
            totalIncome = seats * 10;
        }
        return totalIncome;
    }

    private static int countCurrentIncome(Cinema cinema, int seats) {
        int checkKChangePrice = 60;
        int currentIncome = 0;
        int priceOfSeat;
        for (int i = 0; i < cinema.getRow(); i++) {
            for (int j = 0; j < cinema.getSeatInRow(); j++) {
                if (cinema.getStatusSeat(i, j) == 'B') {
                    if (seats > checkKChangePrice) {
                        if (i < (cinema.getRow() / 2)) {
                            priceOfSeat = 10;
                        } else {
                            priceOfSeat = 8;
                        }
                    } else {
                        priceOfSeat = 10;
                    }
                    currentIncome += priceOfSeat;
                }
            }

        }
        return currentIncome;
    }

    private static int countTickets(Cinema cinema) {
        int count = 0;
        for (int i = 0; i < cinema.getRow(); i++) {
            for (int j = 0; j < cinema.getSeatInRow(); j++) {
                if (cinema.getStatusSeat(i, j) == 'B') count++;
            }
        }
        return count;
    }

    private static void buyTicket(Cinema cinema) {
        // добавить проверку данных на вход и на занятость места для покупки
        boolean verify = false;

        Scanner scanner = new Scanner(System.in);
        while (!verify) {
            System.out.print("Enter a row number:\n");
            int rowNumber = scanner.nextInt();
            System.out.print("Enter a seat number in that row:\n");
            int seatNumberOfRow = scanner.nextInt();
            System.out.println();
            try {
                char seatStatus = cinema.getStatusSeat(rowNumber - 1, seatNumberOfRow - 1);
                if (rowNumber <= 0 || seatNumberOfRow <= 0) {
                    System.out.println("Wrong input!\n");
                } else if (seatStatus == 'B') {
                    System.out.println("That ticket has already been purchased!\n");
                } else {
                    int checkKChangePrice = 60;
                    int seat;
                    int priceOfSeat;

                    seat = cinema.getRow() * cinema.getSeatInRow();
                    if (seat > checkKChangePrice) {
                        if (rowNumber <= (cinema.getRow() / 2)) {
                            priceOfSeat = 10;
                        } else {
                            priceOfSeat = 8;
                        }
                    } else {
                        priceOfSeat = 10;
                    }

                    cinema.setStatusSeat(rowNumber - 1, seatNumberOfRow - 1, 'B');
                    System.out.println("Ticket price: " + "$" + priceOfSeat);
                    System.out.println();
                    verify = true;
                }
            } catch (IndexOutOfBoundsException e ) {
                System.out.println("Wrong input!\n");
            }
        }
    }

    private static void printAllSeat(Cinema cinema) {
        System.out.println();
        System.out.println("Cinema: ");
        System.out.print("  ");
        for (int i = 1; i <= cinema.getSeatInRow(); i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i <= cinema.getRow(); i++) {
            System.out.print(i + " ");
            for (int j = 0; j < cinema.getSeatInRow(); j++) {
                System.out.print(cinema.getStatusSeat(i - 1, j) + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
}
