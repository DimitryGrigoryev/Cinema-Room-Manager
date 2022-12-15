
class ArrayOperations {

    public static void printCorners(int[][] twoDimArray) {
        // write your code here
        try {
            System.out.println(twoDimArray[0][0] + " " + twoDimArray[0][twoDimArray[0].length - 1]);
            System.out.print(twoDimArray[twoDimArray.length - 1][0] + " ");
            System.out.print(twoDimArray[twoDimArray.length - 1][twoDimArray[twoDimArray.length - 1].length - 1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException");
        }
    }

}

