import java.util.*;
public class tictactoe{
    public static void main(String[] args){
        Scanner SC = new Scanner(System.in);

        String[][] array = new String[3][3];
        boolean offer = true;
        int row = 0, turn = 0, col = 0;

        for (int q=0; q<9; q++) {
            for(int c=0; c<array.length; c++){
                for(int d=0; d<array[c].length; d++){
                    if(array[c][d]==null){
                        array[c][d] = " ";
                    }
                }
            }

            System.out.println();

            for(int a=0; a<array.length; a++){
                for(int b=0; b<array[a].length; b++){
                    System.out.print(array[a][b]);
                    if(b<2){
                        System.out.print("| ");

                    }
                }
                if(a<2){
                    System.out.print("\n---------");
                }
                System.out.println();
            }
            
            String play = "";
            String ble = "";
            if(turn%2==0){
                play = "Player 1";
                ble = "X";
            }else{
                play = "Player 2";
                ble = "O";
            }

            System.out.println("Turn: "+play);
            do{ 
                System.out.print("Input Row and Column (0,0): ");
                String rc = SC.nextLine();

                String[] sp = rc.split(",");
                
                row = Integer.parseInt(sp[0]);
                col = Integer.parseInt(sp[1]);
                if((row>=3 || col>=3 || !(array[row][col].equals(" ")))){
                    System.out.println("Invalid index!");
                }
            }while(row>=3 || col>=3 || !(array[row][col].equals(" ")));

            array[row][col] = ble;

            turn++;
            String winss = "";
            boolean destiny = false;
            if((array[0][0]=="X" && array[0][1]=="X" && array[0][2]=="X")||(array[1][0]=="X" && array[1][1]=="X" && array[1][2]=="X")
            ||(array[2][0]=="X" && array[2][1]=="X" && array[2][2]=="X")||(array[0][0]=="X" && array[1][0]=="X" && array[2][0]=="X")
            ||(array[0][1]=="X" && array[1][1]=="X" && array[2][1]=="X")||(array[0][2]=="X" && array[1][2]=="X" && array[2][2]=="X")
            ||(array[0][2]=="X" && array[1][2]=="X" && array[2][2]=="X")||(array[0][0]=="X" && array[1][1]=="X" && array[2][2]=="X")
            ||(array[0][2]=="X" && array[1][1]=="X" && array[2][0]=="X")){
                winss = "PLAYER 1 WINS!";
                destiny = true;
            }else if((array[0][0]=="O" && array[0][1]=="O" && array[0][2]=="O")||(array[1][0]=="O" && array[1][1]=="O" && array[1][2]=="O")
            ||(array[2][0]=="O" && array[2][1]=="O" && array[2][2]=="O")||(array[0][0]=="O" && array[1][0]=="O" && array[2][0]=="O")
            ||(array[0][1]=="O" && array[1][1]=="O" && array[2][1]=="O")||(array[0][2]=="O" && array[1][2]=="O" && array[2][2]=="O")
            ||(array[0][2]=="O" && array[1][2]=="O" && array[2][2]=="O")||(array[0][0]=="O" && array[1][1]=="O" && array[2][2]=="O")
            ||(array[0][2]=="O" && array[1][1]=="O" && array[2][0]=="O")){
                winss = "PLAYER 2 WINS!";
                destiny = true;
            }

            if(destiny==true){
                System.out.println();
                for(int a=0; a<array.length; a++){
                    for(int b=0; b<array[a].length; b++){
                        System.out.print(array[a][b]);
                        if(b<2){
                            System.out.print("| ");
                        }
                    }
                    if(a<2){
                        System.out.print("\n-------");
                    }
                    System.out.println();
                }
                System.out.println(winss);
                break;
            }
        }
    }
}