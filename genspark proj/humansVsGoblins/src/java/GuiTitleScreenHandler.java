import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiTitleScreenHandler {
    Gui gui;
    GuiTitleScreenHandler(Gui g){
        gui = g;
    }
    public class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event){
            gui.createGameScreen();
        }
    }
}
