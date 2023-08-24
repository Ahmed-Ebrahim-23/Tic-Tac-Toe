
package tic.tac.toe;

import java.awt.Color;
import java.awt.Toolkit;

public class MainBoard extends javax.swing.JFrame{

    /**
     * Creates new form MainBoard
     */
   
    Board mainBoard = new Board();
    boolean Filled[] = new boolean[10];
    boolean Win = false;
    int n=3,Full=0,player=0,com=0;
    char board[][] = new char [n][n];
    
    public MainBoard(char player) {
        initComponents();
        mainBoard.setPlayer(player); 
        Empty();
    }
    
    private void Empty(){
         for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                board[i][j]='-';
         for(int i=1;i<=n*n;i++)
              Filled[i]=false;
         btn1.setText("");btn2.setText("");btn3.setText("");
         btn4.setText("");btn5.setText("");btn6.setText("");
         btn7.setText("");btn8.setText("");btn9.setText("");
         WinLabel.setText("");
         btn1.setEnabled(true);btn2.setEnabled(true);btn3.setEnabled(true);
         btn4.setEnabled(true);btn5.setEnabled(true);btn6.setEnabled(true);
         btn7.setEnabled(true);btn8.setEnabled(true);btn9.setEnabled(true);
         Full=0;
         Win = false;
         PlayAgain.setVisible(false);
    }
    
    private void Fill(char x,int pos){
        String s = "";
        s=s+x;
        Filled[pos]=true;
        switch(pos){
            case 1:
                btn1.setText(s);
                btn1.setForeground((x=='X'?Color.red:Color.blue));
                board[0][0]=x;
                break;
            case 2:
                btn2.setText(s);
                btn2.setForeground((x=='X'?Color.red:Color.blue));
                board[0][1]=x;
                break;
            case 3:
                btn3.setText(s);
                btn3.setForeground((x=='X'?Color.red:Color.blue));
                board[0][2]=x;
                break;
            case 4:
                btn4.setText(s);
                btn4.setForeground((x=='X'?Color.red:Color.blue));
                board[1][0]=x;
                break;
            case 5:
                btn5.setText(s);
                btn5.setForeground((x=='X'?Color.red:Color.blue));
                board[1][1]=x;
                break;
            case 6:
                btn6.setText(s);
                btn6.setForeground((x=='X'?Color.red:Color.blue));
                board[1][2]=x;
                break;
            case 7:
                btn7.setText(s);
                btn7.setForeground((x=='X'?Color.red:Color.blue));
                board[2][0]=x;
                break;
            case 8:
                btn8.setText(s);
                btn8.setForeground((x=='X'?Color.red:Color.blue));
                board[2][1]=x;
                break;
            case 9:
                btn9.setText(s);
                btn9.setForeground((x=='X'?Color.red:Color.blue));
                board[2][2]=x;
                break;
        }
    }
    
    private void disable(int pos){
        switch(pos){
            case 1:
                btn1.setEnabled(false);break;
            case 2:
                btn2.setEnabled(false);break;
            case 3:
                btn3.setEnabled(false);break;
            case 4:
                btn4.setEnabled(false);break;
            case 5:
                btn5.setEnabled(false);break;
            case 6:
                btn6.setEnabled(false);break;
            case 7:
                btn7.setEnabled(false);break;
            case 8:
                btn8.setEnabled(false);break;
            case 9:
                btn9.setEnabled(false);break;
        }
    }
    
    private boolean WinScan(){
        int Count=0;
        boolean Found = false;
        char s = 0;
        if(Full==5){
            WinLabel.setText("It's a Tie");
            PlayAgain.setVisible(true);
        }
        
        // Scan the rows to check if the COM have a possible win
        for(int i=0;i<n;i++){
           Count=0;
           char x = board[i][0];
           for(int j=0;j<n;j++)
                if(board[i][j] == x && x!='-')
                    Count++;
           if(Count == 3){
               for(int j=0;j<n;j++)
                       disable ((i*3)+j+1);
               Found = true; s=x;
            }
        }

        // Scan the Columns to check if the COM have a possible win
        for(int i=0;i<n;i++){
           Count=0;
           char x = board[0][i];
           for(int j=0;j<n;j++)
                if(board[j][i] == x && x!='-')
                    Count++;
           if(Count == 3){
               for(int j=0;j<n;j++)
                       disable ((j*3)+i+1);
               Found = true; s=x;
            }
        }
        
        // Scan the X shaped to check if the COM have a possible win
        Count=0;
        char x = board[1][1];
        for(int i=0;i<n;i++){
            if(board[i][i] == x && x!='-')
                 Count++;
            if(Count == 3){
               for(int j=0;j<n;j++)                    
                       disable ((j*3)+j+1);
               Found = true; s=x;
            }
        }
        Count=0;
        x = board[1][1];
        for(int i=n-1;i>=0;i--){
            if(board[i][2-i] == x && x!='-')
                 Count++;
            if(Count == 3){
               for(int j=n-1;j>=0;j--)
                  disable((j*3)+(2-j)+1);
               Found = true; s=x;
            }
        }     
        if(Found){
            if(s==mainBoard.getPlayer()){
                WinLabel.setText("You Won!!");
                player++;
                PlayerScore.setText(player+"");
            }
            else{
                WinLabel.setText("COM Won!!");
                com++;
                ComScore.setText(com+"");
            }
            PlayAgain.setVisible(true);
            return true;
        }
        return false;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Button3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btn3 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        PlayerLabel = new javax.swing.JLabel();
        PlayerScore = new javax.swing.JLabel();
        ComScore = new javax.swing.JLabel();
        ComLabel = new javax.swing.JLabel();
        WinLabel = new javax.swing.JLabel();
        PlayAgain = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        Button3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tic-Tac-Toe");
        setLocation(new java.awt.Point(350, 225));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        btn3.setBackground(new java.awt.Color(255, 255, 255));
        btn3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        btn3.setForeground(new java.awt.Color(0, 0, 0));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn1.setBackground(new java.awt.Color(255, 255, 255));
        btn1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        btn1.setForeground(new java.awt.Color(0, 0, 0));
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setBackground(new java.awt.Color(255, 255, 255));
        btn2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        btn2.setForeground(new java.awt.Color(0, 0, 0));
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn4.setBackground(new java.awt.Color(255, 255, 255));
        btn4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        btn4.setForeground(new java.awt.Color(0, 0, 0));
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn5.setBackground(new java.awt.Color(255, 255, 255));
        btn5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        btn5.setForeground(new java.awt.Color(0, 0, 0));
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn6.setBackground(new java.awt.Color(255, 255, 255));
        btn6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        btn6.setForeground(new java.awt.Color(0, 0, 0));
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn7.setBackground(new java.awt.Color(255, 255, 255));
        btn7.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        btn7.setForeground(new java.awt.Color(0, 0, 0));
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn8.setBackground(new java.awt.Color(255, 255, 255));
        btn8.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        btn8.setForeground(new java.awt.Color(0, 0, 0));
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btn9.setBackground(new java.awt.Color(255, 255, 255));
        btn9.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        btn9.setForeground(new java.awt.Color(0, 0, 0));
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        PlayerLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        PlayerLabel.setForeground(new java.awt.Color(255, 255, 255));
        PlayerLabel.setText("Player");

        PlayerScore.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        PlayerScore.setForeground(new java.awt.Color(255, 255, 255));
        PlayerScore.setText("0");

        ComScore.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        ComScore.setForeground(new java.awt.Color(255, 255, 255));
        ComScore.setText("0");

        ComLabel.setBackground(new java.awt.Color(255, 255, 255));
        ComLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        ComLabel.setForeground(new java.awt.Color(255, 255, 255));
        ComLabel.setText("Com");

        WinLabel.setBackground(new java.awt.Color(255, 255, 255));
        WinLabel.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        WinLabel.setForeground(new java.awt.Color(255, 255, 255));

        PlayAgain.setBackground(new java.awt.Color(255, 255, 255));
        PlayAgain.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PlayAgain.setForeground(new java.awt.Color(0, 0, 0));
        PlayAgain.setText("Play Again");
        PlayAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayAgainActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("powered by AI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(WinLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PlayAgain, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComLabel)
                    .addComponent(PlayerScore)
                    .addComponent(ComScore)
                    .addComponent(PlayerLabel))
                .addGap(115, 115, 115))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addComponent(WinLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PlayerLabel)
                        .addGap(0, 0, 0)
                        .addComponent(PlayerScore)
                        .addGap(34, 34, 34)
                        .addComponent(ComLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(ComScore)
                        .addGap(60, 60, 60)
                        .addComponent(PlayAgain, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void Button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Button3ActionPerformed

    private void PlayAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayAgainActionPerformed
        Empty();
    }//GEN-LAST:event_PlayAgainActionPerformed
    
    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
       if(!Filled[9] && !Win){
            Fill(mainBoard.getPlayer(),9);
            Full++;
             Win=WinScan();
            if(Full<=4 && !Win){
                Fill(mainBoard.getCom(),mainBoard.ComPlay(board));
                Win=WinScan();
            }
       }
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
       if(!Filled[8] && !Win){
            Fill(mainBoard.getPlayer(),8);
            Full++;
            Win=WinScan();
            if(Full<=4 && !Win){
                Fill(mainBoard.getCom(),mainBoard.ComPlay(board));
                Win=WinScan();
            }
       }
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        if(!Filled[7] && !Win){
            Fill(mainBoard.getPlayer(),7);
            Full++;
            Win=WinScan();
            if(Full<=4 && !Win){
                Fill(mainBoard.getCom(),mainBoard.ComPlay(board));
                Win=WinScan();
            }
       }
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        if(!Filled[6] && !Win){
            Fill(mainBoard.getPlayer(),6);
             Full++;
             Win=WinScan();
            if(Full<=4 && !Win){
                Fill(mainBoard.getCom(),mainBoard.ComPlay(board));
                Win=WinScan();
            }
       }
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        if(!Filled[5] && !Win){
            Fill(mainBoard.getPlayer(),5);
             Full++;
             Win=WinScan();
            if(Full<=4 && !Win){
                Fill(mainBoard.getCom(),mainBoard.ComPlay(board));
                Win=WinScan();
            }
       }
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        if(!Filled[4] && !Win){
            Fill(mainBoard.getPlayer(),4);
             Full++;
             Win=WinScan();
            if(Full<=4 && !Win){
                Fill(mainBoard.getCom(),mainBoard.ComPlay(board));
                Win=WinScan();
            }
       }
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        if(!Filled[2] && !Win){
            Fill(mainBoard.getPlayer(),2);
             Full++;
             Win=WinScan();
            if(Full<=4 && !Win){
                Fill(mainBoard.getCom(),mainBoard.ComPlay(board));
                Win=WinScan();
            }
       }
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        if(!Filled[1] && !Win){
            Fill(mainBoard.getPlayer(),1);
             Full++;
             Win=WinScan();
            if(Full<=4 && !Win){
                Fill(mainBoard.getCom(),mainBoard.ComPlay(board));
                Win=WinScan();
            }
       }
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        if(!Filled[3] && !Win){
            Fill(mainBoard.getPlayer(),3);
             Full++;
             Win=WinScan();
            if(Full<=4 && !Win){
                Fill(mainBoard.getCom(),mainBoard.ComPlay(board));
                Win=WinScan();
            }
       }
    }//GEN-LAST:event_btn3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainBoard page = new MainBoard(' ');
                page.setVisible(true);
                page.setLocationRelativeTo(null);
                page.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/icon.png")));
            }
        });
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button3;
    private javax.swing.JLabel ComLabel;
    private javax.swing.JLabel ComScore;
    private javax.swing.JButton PlayAgain;
    private javax.swing.JLabel PlayerLabel;
    private javax.swing.JLabel PlayerScore;
    private javax.swing.JLabel WinLabel;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
