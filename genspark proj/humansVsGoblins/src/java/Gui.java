import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {
    Board board = new Board();
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, combatPanel, playAgainPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName, combatLabel;
    Font titleFont = new Font("JetBrains Mono font", Font.PLAIN, 60);
    Font normalFont = new Font("JetBrains Mono font", Font.PLAIN, 20);
    JButton startButton, choice1, choice2, choice3, choice4, exit, playAgainNo;
    JTextArea mainTextArea;
    int playerHP;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

//    public static void Gui(){
//        new Gui();
//    }

    public Gui(){
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);

        con = window.getContentPane();



        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,100,600,150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Human vs Zombies");
        titleNameLabel.setForeground(Color.white);//font color
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);


        startButton = new JButton("START"); //for button
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);
        window.setVisible(true);
    }

    public void createGameScreen(){



        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,120,600,150);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea(board.showLand());
        mainTextArea.setBounds(100,120,600,150);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        //exit game button
        playAgainPanel = new JPanel();
        playAgainPanel.setBounds(100, 120, 600, 150);
        playAgainPanel.setBackground(Color.black);
        con.add(playAgainPanel);

            exit = new JButton("Okay");
            exit.setBackground(Color.BLACK);
            exit.setForeground(Color.white);
            exit.setFont(normalFont);
            playAgainPanel.add(exit);
            exit.addActionListener(choiceHandler);
            exit.setActionCommand("exit");

         //panel for direction buttons
         choiceButtonPanel = new JPanel();
         choiceButtonPanel.setBounds(250,350,255,150);
         choiceButtonPanel.setBackground(Color.black);
         //choiceButtonPanel.setLayout(new GridLayout(4, 1)); //grid layout for buttons
         con.add(choiceButtonPanel);

        choice3 = new JButton("left"); //button3
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choiceButtonPanel.add(choice3);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");

             choice1 = new JButton("up"); //button1
             choice1.setBackground(Color.black);
             choice1.setForeground(Color.white);
             choice1.setFont(normalFont);
             choiceButtonPanel.add(choice1);
             choice1.setFocusPainted(false);
             choice1.addActionListener(choiceHandler);
             choice1.setActionCommand("c1");

        choice4 = new JButton("right"); //button 4
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choiceButtonPanel.add(choice4);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");

            choice2 = new JButton("down"); //button2
            choice2.setBackground(Color.black);
            choice2.setForeground(Color.white);
            choice2.setFont(normalFont);
            choiceButtonPanel.add(choice2);
            choice2.setFocusPainted(false);
            choice2.addActionListener(choiceHandler);
            choice2.setActionCommand("c2");

        combatPanel = new JPanel();
        combatPanel.setBounds(100,55,600,50);
        combatPanel.setBackground(Color.black);
        combatPanel.setLayout(new GridLayout(1,4));
        con.add(combatPanel);

        combatLabel = new JLabel("Pick a direction to move");//puts hp panel label in the upper JPanel
        combatLabel.setFont(normalFont);
        combatLabel.setForeground(Color.white);
        combatPanel.add(combatLabel);

        playerPanel = new JPanel();
        playerPanel.setBounds(100,15,600,50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);
        hpLabel = new JLabel("HP:");//puts hp panel label in the upper JPanel
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);

            hpLabelNumber = new JLabel();
            hpLabelNumber.setFont(normalFont);
            hpLabelNumber.setForeground(Color.white);
            playerPanel.add(hpLabelNumber);

        setUp.playerSetup();
    }
    GuiPlayerSetupBar setUp = new GuiPlayerSetupBar(this);


    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            createGameScreen();
        }
    }

    GuiPlayerMovement gp = new GuiPlayerMovement(this);

    public class ChoiceHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String yourChoice = event.getActionCommand();
            int[] loc = board.getChadLoc();
            int x = loc[0]; int y = loc[1];
            String space = board.place.getName();
            String monster = board.m1;

            if(yourChoice == "c1" && x > 0){
                gp.moveUp();
            }
            if(yourChoice == "c1" && x == 0){
                gp.moveOutOfBounds();
            }
            if(yourChoice == "c2" && x < 3){
                gp.moveDown();
            }
            if(yourChoice == "c2" && x == 3){
                gp.moveOutOfBounds();
            }
            if(yourChoice == "c3" && y > 0){
                gp.moveLeft();
            }
            if(yourChoice == "c3" && y == 0){
                gp.moveOutOfBounds();
            }
            if(yourChoice == "c4" && y < 2){
                gp.moveRight();
            }
            if(yourChoice == "c4" && y == 2){
                gp.moveOutOfBounds();
            }
            int health = board.chad.getHealth();

            if(health <= 0){
                combatLabel.setText("Your health is at or less than 0; Please hit \n okay and run the game again to retry");
               exitGameHandler(yourChoice);
            }
            else if(!board.showLand().contains(monster)){
                combatLabel.setText("CONGRATULATIONS!! You beat all the monsters... \n Please hit okay to exit and try again");
               exitGameHandler(yourChoice);
            }
        }
    }
    public void exitGameHandler(String yourChoice){
        mainTextPanel.setVisible(false);
        if(yourChoice == "exit"){
            System.exit(0);
        }
    }

}
