public class MyMain {
    // This method returns true/false if there 
    // was a boat the specified coordinates. This
    // method also prints out an appropriate message
    public static boolean hit(boolean[][] board, int row, int col) { 
        boolean value = board[row][col];
        if (value) {
            System.out.println("There was a hit!");
            return true;
        } else {
            System.out.println("You missed a boat!");
            return false;
        }   
    }


    // Places a boat onto the board
    // The top-left piece of the board is located at (row, col)
    // The remaining pieces are placed in the direction given
    // by the direction input
    public static boolean[][] placeBoat(boolean[][] board, String direction, int boatLength, int row, int col) { 
        for (int i = 0; i < boatLength; i++) {

            if (direction == "right") {
                board[row][col+i] = true;
            } else if (direction == "left") {
                board[row][col-i] = true;
            } else if (direction == "up") {
                board[row-i][col] = true;
            } else if (direction == "down") {
                board[row+i][col] = true;
            }
            
        }
        return board;
    }

    // Returns true if the every row in the 2D array
    // is in both alphabetical order and in order of 
    // increasing length
    // You may assume that all Strings are lowercase 
    public static boolean inOrder(String[][] words) { 

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[0].length - 1; j++) {

                // check the order of increasing length
                if (words[i][j].length() > words[i][j+1].length()) {
                    return false;
                }

                // check the alphabetical order
                if ((int)words[i][j].charAt(0) > (int)words[i][j+1].charAt(0)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean[][] b1 = {{false, false, true}, 
                            {false, false, true}, 
                            {false, false, false}};
        boolean[][] b2 = {{false, false, false}, 
                            {false, false, false}, 
                            {false, false, false}};
        String[][] words = {{"chinese", "english", "spanish"}, 
                            {"france", "germany", "united kingdom"}};
        
        boolean re1 = hit(b1, 0, 1);
        System.out.println(re1);

        boolean[][] re2 = placeBoat(b2, "right", 2, 1, 1);
        for (int i = 0; i < re2.length; i++) {
            for (int j = 0; j < re2[0].length; j++) {
                System.out.print(re2[i][j] + " ");
            }
            System.out.print("\n");
        }

        System.out.println("\n" + inOrder(words));

        
    }
}
