import java.util.*;
public class tictactoe_Baurs_Version{
    public static void main(String[] args){
        Scanner SC = new Scanner(System.in);

        boolean result = false;
        int row = 0, playerTurn = 0, col = 0, counter = 0;
        String tieBreaker = "y",winner,turn,content;

        do { 
            String[][] array = new String[3][3];
            for (int q=0; q<9; q++) { 
                for(int c=0; c<array.length; c++){
                    for(int d=0; d<array[c].length; d++){
                        if(array[c][d]==null)   array[c][d] = " ";
                    }
                }
                System.out.println();
                for(int a=0; a<array.length; a++){
                    for(int b=0; b<array[a].length; b++){
                        System.out.print(array[a][b]);
                        if(b<2) System.out.print("| ");
                    }
                    if (a<2)    System.out.print("\n---------");
                    System.out.println();
                }
                turn = "";
                content = "";
                if (playerTurn%2==0){
                    turn = "Player 1";
                    content = "X";
                }else{
                    turn = "Player 2";
                    content = "O";
                }
                System.out.println("Turn: "+turn);
                do { 
                    System.out.print("Input Row and Column (0,0): ");
                    String rc = SC.nextLine();

                    String[] sp = rc.split(",");
                    
                    row = Integer.parseInt(sp[0]);
                    col = Integer.parseInt(sp[1]);

                    if ( ( row>=3 || col>=3 || !( array[row][col].equals(" ") ) ) ) System.out.println("Invalid index!");

                } while(row>=3 || col>=3 || !(array[row][col].equals(" ")));

                array[row][col] = content;

                playerTurn++;

                winner = "";

                result = false;

                if((array[0][0]=="X" && array[0][1]=="X" && array[0][2]=="X")||(array[1][0]=="X" && array[1][1]=="X" && array[1][2]=="X")
                ||(array[2][0]=="X" && array[2][1]=="X" && array[2][2]=="X")||(array[0][0]=="X" && array[1][0]=="X" && array[2][0]=="X")
                ||(array[0][1]=="X" && array[1][1]=="X" && array[2][1]=="X")||(array[0][2]=="X" && array[1][2]=="X" && array[2][2]=="X")
                ||(array[0][2]=="X" && array[1][2]=="X" && array[2][2]=="X")||(array[0][0]=="X" && array[1][1]=="X" && array[2][2]=="X")
                ||(array[0][2]=="X" && array[1][1]=="X" && array[2][0]=="X")){
                    winner = "PLAYER 1 WINS!";
                    result = true;
                }else if((array[0][0]=="O" && array[0][1]=="O" && array[0][2]=="O")||(array[1][0]=="O" && array[1][1]=="O" && array[1][2]=="O")
                ||(array[2][0]=="O" && array[2][1]=="O" && array[2][2]=="O")||(array[0][0]=="O" && array[1][0]=="O" && array[2][0]=="O")
                ||(array[0][1]=="O" && array[1][1]=="O" && array[2][1]=="O")||(array[0][2]=="O" && array[1][2]=="O" && array[2][2]=="O")
                ||(array[0][2]=="O" && array[1][2]=="O" && array[2][2]=="O")||(array[0][0]=="O" && array[1][1]=="O" && array[2][2]=="O")
                ||(array[0][2]=="O" && array[1][1]=="O" && array[2][0]=="O")){
                    winner = "PLAYER 2 WINS!";
                    result = true;
                }

                if(result==true){
                    System.out.println();
                    for(int a=0; a<array.length; a++){
                        for(int b=0; b<array[a].length; b++){
                            System.out.print(array[a][b]);
                            if(b<2){
                                System.out.print("| ");
                            }
                        }
                        if(a<2) System.out.print("\n-------");
                        System.out.println();
                    }
                    System.out.println(winner);
                    break;
                }
            }
            SC = new Scanner(System.in);
            System.out.println("Play Again? ");
            System.out.println("y = yes");
            System.out.println("n = no");
            tieBreaker = SC.nextLine();
            if ( tieBreaker.equalsIgnoreCase("y") ) counter = 1;
            else break;
        } while (counter==1);
    }
}