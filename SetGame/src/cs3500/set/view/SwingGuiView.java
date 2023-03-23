package cs3500.set.view;

import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;

import cs3500.set.controller.FeaturesInterface;
import cs3500.set.model.hw02.Card;
import cs3500.set.model.hw02.SetGameModelState;

/**
 * Represents a GUI view that is implemented using Java
 * Swing. GUI formats the view into the following shape
 * +----------------------------+
 * |                            |
 * |                            |
 * |     boardPanel             |
 * |                            |
 * |                            |
 * |                            |
 * +----------------------------+
 * | scoreLabel | messageLabel  |
 * |            |               |
 * +----------------------------+
 * where the boardPanel is the representation of the grid of cards.
 */
public class SwingGuiView extends JFrame implements SetGameGuiView {

  //the custom panel on which the board will be drawn
  private final IBoardPanel boardPanel;
  //the model state
  private final SetGameModelState<Card> modelState;
  //a label to display the score
  private final JLabel scoreLabel;
  //a label to display any messages to the user
  private final JLabel messageLabel;

  /**
   * Constructs the gui view for the game of Set. Will visually show
   * the current state of the game as described in overall class documentation.
   * @param state the current state of the game
   */
  public SwingGuiView(SetGameModelState<Card> state) {
    super("Set");
    
    this.modelState = state;
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    /* main frame uses a border layout. Read about it here:
    *  https://docs.oracle.com/javase/10/docs/api/java/awt/BorderLayout.html
    *
    */

    this.setLayout(new BorderLayout());
    //initialize the custom board with the model state
    boardPanel = new BoardPanel(this.modelState);
    //add custom board to the center of the frame
    this.add((Component) boardPanel,BorderLayout.CENTER);
    //create the score label
    this.scoreLabel = new JLabel("Score: " + this.modelState.getScore());
    //create the message label
    this.messageLabel = new JLabel();
    //put them both in a panel. This is done mostly to arrange them properly
    JPanel panel = new JPanel();
    /*
    the panel uses a grid layout with two columns. The gridlayout
    will stretch the labels so that they are exactly half of the width
    of this panel.

    Since we mention that we want a grid of 2 columns, and we
    add exactly two things to it, it will use one row.
     */

    panel.setLayout(new GridLayout(0,2));
    panel.add(scoreLabel);
    panel.add(messageLabel);
    //add this panel to the bottom of the frame
    this.add(panel,BorderLayout.PAGE_END);
    pack();
    setVisible(true);
  }

  @Override
  public void refresh() {
    //refresh the score
    this.scoreLabel.setText("Score: " + modelState.getScore());
    //this repaints the frame, which cascades to everything added
    //in the frame
    this.repaint();
  }

  @Override
  public void renderMessage(String message) {
    this.messageLabel.setText(message);
  }

  @Override
  public void addFeatures(FeaturesInterface features) {
    //add the features to the board panel
    this.boardPanel.addFeatures(features);
  }
}

