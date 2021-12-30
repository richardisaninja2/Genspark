public class GuiPlayerMovement {
    Gui gui;


    public GuiPlayerMovement(Gui g){
        gui = g;
    }

    //to move the players location
    public void moveOutOfBounds(){
        gui.combatLabel.setText("This move goes out of bounds... try again");
    }
    //end public area..
    public void moveRight(){
        int[] loc = gui.board.getChadLoc();
        int x = loc[0]; int y = loc[1];
        String space = gui.board.place.getName();

        if(gui.board.land[x][y+1] == gui.board.monster1.getName()){
            gui.combatLabel.setText(gui.board.combat());
            gui.hpLabelNumber.setText(""+gui.board.chad.getHealth());
        }
        gui.board.land[x][y+1] = gui.board.land[x][y];
        gui.board.land[x][y] = space;
        gui.mainTextArea.setText(gui.board.showLand());

    }
    public void moveLeft(){
        int[] loc = gui.board.getChadLoc();
        int x = loc[0]; int y = loc[1];
        String space = gui.board.place.getName();

        if(gui.board.land[x][y-1] == gui.board.monster1.getName()){
            gui.combatLabel.setText(gui.board.combat());
            gui.hpLabelNumber.setText(""+gui.board.chad.getHealth());
        }
        gui.board.land[x][y-1] = gui.board.land[x][y];
        gui.board.land[x][y] = space;
        gui.mainTextArea.setText(gui.board.showLand());

    }
    public void moveUp(){
        int[] loc = gui.board.getChadLoc();
        int x = loc[0]; int y = loc[1];
        String space = gui.board.place.getName();

        if(gui.board.land[x-1][y] == gui.board.monster1.getName()){
            gui.combatLabel.setText(gui.board.combat());
            gui.hpLabelNumber.setText(""+gui.board.chad.getHealth());
        }
        gui.board.land[x-1][y] = gui.board.land[x][y];
        gui.board.land[x][y] = space;
        gui.mainTextArea.setText(gui.board.showLand());

    }
    public void moveDown(){
        int[] loc = gui.board.getChadLoc();
        int x = loc[0]; int y = loc[1];
        String space = gui.board.place.getName();

        if(gui.board.land[x+1][y] == gui.board.monster1.getName()){
            gui.combatLabel.setText(gui.board.combat());
            gui.hpLabelNumber.setText(""+gui.board.chad.getHealth());
        }
        gui.board.land[x+1][y] = gui.board.land[x][y];
        gui.board.land[x][y] = space;
        gui.mainTextArea.setText(gui.board.showLand());

    }
}
