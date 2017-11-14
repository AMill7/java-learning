package javalernen.panzerhq;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GameWindow extends JFrame {
    
    /**
     * default serial
     */
    private static final long serialVersionUID = 1L;
    
    private final GamePanel panzerGamePanel;
    
    public GameWindow() {
        
        this.panzerGamePanel = new GamePanel();
        
//        JPanel panel = new JPanel();
//        panel.setPreferredSize(new Dimension(600, 400));
        
        registerWindowListener();
        createMenu();

//        this.add(panel);
        this.add(panzerGamePanel);
        this.pack();
        
        this.setTitle("PanzerHQ");
        this.setLocation(10, 10);
        this.setResizable(false);
        
        this.setVisible(true);
        
    }
    
    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        JMenu gameMenu = new JMenu("Game");
        JMenu prefMenu = new JMenu("Preferences");
        
        menuBar.add(fileMenu);
        menuBar.add(gameMenu);
        menuBar.add(prefMenu);
        
        addFileMenuItems(fileMenu);
        addGameMenuItems(gameMenu);
        addPrefMenuItems(prefMenu);
    }
    
    private void addFileMenuItems(JMenu fileMenu) {
        JMenuItem quitItem = new JMenuItem("Quit");
        fileMenu.add(quitItem);
        
        quitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    
    private void addGameMenuItems(JMenu gameMenu) {
        JMenuItem pauseItem = new JMenuItem("Pause");
        gameMenu.add(pauseItem);
        pauseItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panzerGamePanel.pauseGame();
            }
        });
        
        JMenuItem continuetItem = new JMenuItem("Continue");
        gameMenu.add(continuetItem);
        continuetItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panzerGamePanel.continueGame();
            }
        });
        
        JMenuItem restartItem = new JMenuItem("Restart");
        gameMenu.add(restartItem);
        restartItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panzerGamePanel.restartGame();
            }
        });
    }
    
    private void addPrefMenuItems(JMenu prefMenu) {
        JMenu submenu = new JMenu("Choose Background");
        prefMenu.add(submenu);
        
        JMenuItem menuItem = new JMenuItem("Mud Area");
        submenu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panzerGamePanel.setBackgroundImage(0);
                repaint();
            }
        });
        
        menuItem = new JMenuItem("Snow Area");
        submenu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panzerGamePanel.setBackgroundImage(1);
                repaint();
            }
        });
        
        menuItem = new JMenuItem("Desert Area");
        submenu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panzerGamePanel.setBackgroundImage(2);
                repaint();
            }
        });
    }
    
    private void registerWindowListener() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
            
            @Override
            public void windowDeactivated(WindowEvent e) {
                //TODO: deactivate game -> pausieren
                panzerGamePanel.pauseGame();
            }
            
            @Override
            public void windowActivated(WindowEvent e) {
                //TODO: actovate game -> pause ende
                panzerGamePanel.continueGame();
            }
        });
    }
}
