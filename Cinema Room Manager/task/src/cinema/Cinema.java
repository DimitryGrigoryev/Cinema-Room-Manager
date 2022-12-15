package cinema;

import java.util.Scanner;

public class Cinema {

    private int row;
    private int seatInRow;

    private char[][] allSeat;

    public Cinema() {
    }

    public Cinema(char[][] allSeat) {
        this.allSeat = allSeat;
    }
    public void setRow(int row) {
        this.row = row;
    }

    public void setSeatInRow(int seatInRow) {
        this.seatInRow = seatInRow;
    }

    public int getRow() {
        return row;
    }

    public int getSeatInRow() {
        return seatInRow;
    }

    public char[][] getAllSeat() {
        return allSeat;
    }

    public char getStatusSeat(int i, int j) {
        return this.allSeat[i][j];
    }

    public void setAllSeat(char[][] allSeat) {
        this.allSeat = allSeat;
    }

    public void setStatusSeat (int i, int j, char S) {
        this.allSeat[i][j] = S;
    }


    public static void initSeatCinema(Cinema cinema) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows:\n" + "> ");
        cinema.setRow(scanner.nextInt());
        System.out.print("Enter the number of seats in each row:\n" + "> ");
        cinema.setSeatInRow(scanner.nextInt());
        char[][] allSeat = new char[cinema.getRow()][cinema.getSeatInRow()];
        cinema.setAllSeat(allSeat);

        for (int i = 0; i < cinema.getRow(); i++) {
            for (int j = 0; j < cinema.getSeatInRow(); j++) {
                cinema.setStatusSeat(i, j, 'S');
            }
        }
    }




}