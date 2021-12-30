public class GuiPlayerSetupBar{
    Gui gui;
    public GuiPlayerSetupBar(Gui g){
        gui = g;
    }
    public void playerSetup(){
        gui.playerHP = gui.board.chad.getHealth();
        System.out.println("hp = "+ gui.playerHP);
        gui.hpLabelNumber.setText(""+gui.playerHP);

    }
}
