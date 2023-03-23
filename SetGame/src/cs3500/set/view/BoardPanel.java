package cs3500.set.view;

import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import cs3500.set.controller.FeaturesInterface;
import cs3500.set.model.hw02.Card;
import cs3500.set.model.hw02.Coord;
import cs3500.set.model.hw02.SetGameModelState;

/**
 * Represents the visual view of the grid for a game of Set. Cards are layed out
 * as a grid of unselected cards. Each card has its text representation printed
 * on the card back.
 */
public class BoardPanel extends JPanel implements IBoardPanel {
  private final SetGameModelState<Card> modelState;
  private Image unselectedCard;
  private Image selectedCard;
  private final int cellDimension;
  private int originX;
  private int originY;

  /**
   * Constructs a new panel for the given game state. Loads in 2 images
   * representing the unselected and selected cards.
   *
   * @param state the current state of the game
   * @throws IllegalStateException if res/unselected.png and res/selected.png do not exist
   */
  public BoardPanel(SetGameModelState<Card> state) throws IllegalStateException {
    super();
    this.modelState = state;
    this.setBackground(Color.WHITE);
    this.cellDimension = 50;
    try {
      unselectedCard = ImageIO.read(new FileInputStream("res/unselected.png"));
      unselectedCard = unselectedCard.getScaledInstance(cellDimension, cellDimension,
              Image.SCALE_DEFAULT);

      selectedCard = ImageIO.read(new FileInputStream("res/selected.png"));
      selectedCard = selectedCard.getScaledInstance(cellDimension, cellDimension,
              Image.SCALE_DEFAULT);

      this.setPreferredSize(
              new Dimension((this.modelState.getWidth() + 4) * cellDimension,
                      (this.modelState.getHeight() + 4) * cellDimension));
    } catch (IOException e) {
      throw new IllegalStateException("Icons not found!");
    }

  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    int xOffset = this.modelState.getWidth() * cellDimension / 2;
    int yOffset = this.modelState.getHeight() * cellDimension / 2;
    originX = (int) (this.getPreferredSize().getWidth() / 2 - xOffset);
    originY = (int) (this.getPreferredSize().getHeight() / 2 - yOffset);

    for (int i = 0; i < this.modelState.getHeight(); i++) {
      for (int j = 0; j < this.modelState.getWidth(); j++) {
        if (this.modelState.getCardAtCoord(i, j) != null) {
          if (this.modelState.getClaimsList().contains(new Coord(i, j))) {
            g.drawImage(selectedCard, originX + j * cellDimension,
                    originY + i * cellDimension, null);
          }
          else {
            g.drawImage(unselectedCard, originX + j * cellDimension,
                    originY + i * cellDimension, null);
          }
          g.drawChars(this.modelState.getCardAtCoord(i, j).toString().toCharArray(), 0,
                  this.modelState.getCardAtCoord(i, j).toString().length(),
                  originX + j * cellDimension + 10, originY + i * cellDimension + 30);
        }
      }
    }
  }


  @Override
  public void addFeatures(FeaturesInterface features) {

    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        int row = (y - originY) / cellDimension;
        int col = (x - originX) / cellDimension;
        System.out.println("row: " + row + " col: " + col);
        if (row >= 0 && row < modelState.getHeight() && col >= 0 && col < modelState.getWidth()) {
          features.input(row, col);
        }
      }
    });
  }
}
