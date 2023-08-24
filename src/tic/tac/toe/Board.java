
package tic.tac.toe;

import static java.lang.Math.random;

public class Board {
    private char player;
    private char com;
    private final int n = 3;
    public void setPlayer(char player) {
        this.player = player;
        if(player == 'O')
            this.com = 'X';
        else
            this.com = 'O';
    }
    
    public char getPlayer() {
        return player;
    }
    
    public char getCom() {
        return com;
    }
    
    public int ComPlay(char[][] board){
        int index = ComCloseWin(board);
        if(index!=-1) return index;
        index = playerCloseWin(board);
        if(index!=-1) return index;
        return Random(board);
    }

    private int ComCloseWin(char[][] board) {
        int index = -1,ComCount=0;
        // Scan the rows to check if the COM have a possible win
        for(int i=0;i<n;i++){
           ComCount=0;
           for(int j=0;j<n;j++)
                if(board[i][j] == this.com)
                    ComCount++;
           if(ComCount > 1)
               for(int j=0;j<n;j++)
                   if(board[i][j] == '-')
                       return ((i*3)+j+1);
        }

        // Scan the Columns to check if the COM have a possible win
        for(int i=0;i<n;i++){
           ComCount=0;
           for(int j=0;j<n;j++)
                if(board[j][i] == this.com)
                    ComCount++;
           if(ComCount > 1)
               for(int j=0;j<n;j++)
                   if(board[j][i] == '-')
                       return ((j*3)+i+1);
        }
        
        // Scan the X shaped to check if the COM have a possible win
        ComCount=0;
        for(int i=0;i<n;i++){
            if(board[i][i] == this.com)
                 ComCount++;
            if(ComCount > 1)
               for(int j=0;j<n;j++)
                   if(board[j][j] == '-')
                       return ((j*3)+j+1);
        }
        ComCount=0;
        for(int i=n-1;i>=0;i--){
            if(board[i][2-i] == this.com)
                 ComCount++;
            if(ComCount > 1)
               for(int j=n-1;j>=0;j--)
                   if(board[j][2-j] == '-')
                       return ((j*3)+(2-j)+1);
        }       
        return index;
    }
    
    private int playerCloseWin(char[][] board){
        int index = -1,PlayerCount=0;
        // Scan the rows to check if the player have a possible win
        for(int i=0;i<n;i++){
           PlayerCount=0;
           for(int j=0;j<n;j++)
                if(board[i][j] == this.player)
                    PlayerCount++;
           if(PlayerCount > 1)
               for(int j=0;j<n;j++)
                   if(board[i][j] == '-')
                       return ((i*3)+j+1);
        }

        // Scan the Columns to check if the player have a possible win
        for(int i=0;i<n;i++){
           PlayerCount=0;
           for(int j=0;j<n;j++)
                if(board[j][i] == this.player)
                    PlayerCount++;
           if(PlayerCount > 1)
               for(int j=0;j<n;j++)
                   if(board[j][i] == '-')
                       return ((j*3)+i+1);
        }
        
        // Scan the X shaped to check if the player have a possible win
        PlayerCount=0;
        for(int i=0;i<n;i++){
            if(board[i][i] == this.player)
                 PlayerCount++;
            if(PlayerCount > 1)
               for(int j=0;j<n;j++)
                   if(board[j][j] == '-')
                       return ((j*3)+j+1);
        }
        PlayerCount=0;
        for(int i=n-1;i>=0;i--){
            if(board[i][2-i] == this.player)
                 PlayerCount++;
            if(PlayerCount > 1)
               for(int j=n-1;j>=0;j--)
                   if(board[j][2-j] == '-')
                       return ((j*3)+(2-j)+1);
        }       
        return index;
    }

    private int Random(char[][] board) {
        int i,j;
        if(board[1][1]=='-')
            return 5;
        else{
            while(true){
                i =  (int) (Math.random()*3);
                j =  (int) (Math.random()*3);
                if(board[i][j]=='-')
                    break;
            }
        }
        return ((i*3)+j+1);
    }
}
