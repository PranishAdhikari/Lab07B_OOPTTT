import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class TicTacToeFrame extends JFrame
{
    JPanel mainPnl, topPnl, centerPnl, bottomPnl;
    //JLabel turn, a;
    JButton quitBtn;
    JLabel turn;

    public TicTacToeFrame() {

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeigh = screenSize.height;
        int screenWidth = screenSize.width;

        setSize(screenWidth * 3/4,600);
        setLocation(screenWidth / 8, (screenHeigh - 600) / 2);

        setTitle("Tic Tac Toe Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        createGUI();
        setVisible(true);

    }

    public void createGUI()
    {
        mainPnl = new JPanel();
        topPnl = new JPanel();
        centerPnl = new JPanel();
        bottomPnl = new JPanel();

        mainPnl.setLayout(new BorderLayout());
        mainPnl.add(topPnl, BorderLayout.NORTH);
        mainPnl.add(centerPnl, BorderLayout.CENTER);
        mainPnl.add(bottomPnl,BorderLayout.SOUTH);

        add(mainPnl);
        createTopPnl();
        createGridPnl();
        createBottomPnl();

    }
    public void createTopPnl()
    {

        turn = new JLabel("Current Player: X");
        turn.setFont(new Font(Font.SERIF, Font.PLAIN, 35));

        topPnl.add(turn);

    }
    public void createGridPnl() {
        centerPnl.setLayout(new GridLayout(3, 3));

        TicTacToeBoard.createGame(centerPnl);
        TicTacToeBoard.onClick(turn);

    }
    public void createBottomPnl()
    {
        quitBtn = new JButton("Quit");
        quitBtn.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        bottomPnl.add(quitBtn);
    }
}