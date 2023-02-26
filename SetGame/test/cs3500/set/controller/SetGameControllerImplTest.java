package cs3500.set.controller;

import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import cs3500.set.model.hw02.Card;
import cs3500.set.model.hw02.ConfirmHeightAndWidthModel;
import cs3500.set.model.hw02.ConfirmInputsForSetClaimModel;
import cs3500.set.model.hw02.SetGameModel;
import cs3500.set.model.hw02.SetThreeGameModel;
import cs3500.set.view.SetGameTextView;
import cs3500.set.view.SetGameView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class to test the SetGameController.
 */
public class SetGameControllerImplTest {
  SetGameModel<Card> model = new SetThreeGameModel();
  StringBuilder out = new StringBuilder();
  SetGameView view = new SetGameTextView(model, out);

  /**
   * Tests that the inputs correctly make coordinates when inputs make valid set.
   */
  @Test
  public void testCoordInputForValidClaim() {
    Reader in = new StringReader("3 3 1 1 2 2 3 3 q");
    StringBuilder doNotCare = new StringBuilder();
    StringBuilder mockOutput = new StringBuilder();
    SetGameModel<Card> mockModel = new ConfirmInputsForSetClaimModel(mockOutput);
    SetGameView mockView = new SetGameTextView(mockModel, doNotCare);
    SetGameController mockController = new SetGameControllerImpl(mockModel, mockView, in);
    mockController.playGame();
    assertEquals("coord1row = 0\n" +
            "coord1col = 0\n" +
            "coord2row = 1\n" +
            "coord2col = 1\n" +
            "coord3row = 2\n" +
            "coord3col = 2", mockOutput.toString());
  }

  /**
   * Tests that the inputs correctly make coordinates when inputs make invalid set.
   */
  @Test
  public void testCoordInputForInvalidClaim() {
    Reader in = new StringReader("3 3 1 3 2 1 3 1 q");
    StringBuilder doNotCare = new StringBuilder();
    StringBuilder mockOutput = new StringBuilder();
    SetGameModel<Card> mockModel = new ConfirmInputsForSetClaimModel(mockOutput);
    SetGameView mockView = new SetGameTextView(mockModel, doNotCare);
    SetGameController mockController = new SetGameControllerImpl(mockModel, mockView, in);
    mockController.playGame();
    assertEquals(mockOutput.toString(), "coord1row = 0\n" +
            "coord1col = 2\n" +
            "coord2row = 1\n" +
            "coord2col = 0\n" +
            "coord3row = 2\n" +
            "coord3col = 0");
  }

  /**
   * Tests that the inputs correctly make coordinates when an invalid input is given.
   */
  @Test
  public void testInvalidCoordInput() {
    Reader in = new StringReader("3 3 1 3 a 2 1 3 -1 1 q");
    StringBuilder doNotCare = new StringBuilder();
    StringBuilder mockOutput = new StringBuilder();
    SetGameModel<Card> mockModel = new ConfirmInputsForSetClaimModel(mockOutput);
    SetGameView mockView = new SetGameTextView(mockModel, doNotCare);
    SetGameController mockController = new SetGameControllerImpl(mockModel, mockView, in);
    mockController.playGame();
    assertEquals(mockOutput.toString(), "coord1row = 0\n" +
            "coord1col = 2\n" +
            "coord2row = 1\n" +
            "coord2col = 0\n" +
            "coord3row = 2\n" +
            "coord3col = 0");
  }

  /**
   * Tests that the inputs for the given height and width are correctly parsed when height and
   * width are valid for the model.
   */
  @Test
  public void testValidHeightAndWidthInput() {
    Reader in = new StringReader("3 3 q");
    StringBuilder doNotCare = new StringBuilder();
    StringBuilder mockOutput = new StringBuilder();
    SetGameModel<Card> mockModel = new ConfirmHeightAndWidthModel(mockOutput);
    SetGameView mockView = new SetGameTextView(mockModel, doNotCare);
    SetGameController mockController = new SetGameControllerImpl(mockModel, mockView, in);
    mockController.playGame();
    assertEquals(mockOutput.toString(), "height = 3\n" +
            "width = 3");
  }

  /**
   * Tests that the inputs for the given height and width are correctly parsed when height and
   * width are invalid for the model.
   */
  @Test
  public void testInvalidHeightAndWidthInput() {
    Reader in = new StringReader("3 2 q");
    StringBuilder doNotCare = new StringBuilder();
    StringBuilder mockOutput = new StringBuilder();
    SetGameModel<Card> mockModel = new ConfirmHeightAndWidthModel(mockOutput);
    SetGameView mockView = new SetGameTextView(mockModel, doNotCare);
    SetGameController mockController = new SetGameControllerImpl(mockModel, mockView, in);
    mockController.playGame();
    assertEquals(mockOutput.toString(), "height = 3\n" +
            "width = 2");
  }

  /**
   * Tests that the inputs for the given height and width are correctly parsed when height and
   * width are not valid for the game.
   */
  @Test
  public void testBadHeightAndWidthInput() {
    Reader in = new StringReader("a 2 3 q");
    StringBuilder doNotCare = new StringBuilder();
    StringBuilder mockOutput = new StringBuilder();
    SetGameModel<Card> mockModel = new ConfirmHeightAndWidthModel(mockOutput);
    SetGameView mockView = new SetGameTextView(mockModel, doNotCare);
    SetGameController mockController = new SetGameControllerImpl(mockModel, mockView, in);
    mockController.playGame();
    assertEquals(mockOutput.toString(), "height = 2\n" +
            "width = 3");
  }

  /**
   * Tests the constructor throws an IllegalArgumentException when one of its parameters are null.
   * Model is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNullModel() {
    SetGameController controllerWithNullModel = new SetGameControllerImpl(null, view,
            new StringReader(""));
    controllerWithNullModel.playGame();
  }

  /**
   * Tests the constructor throws an IllegalArgumentException when one of its parameters are null.
   * View is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNullView() {
    SetGameController controllerWithNullView = new SetGameControllerImpl(model, null,
            new StringReader(""));
    controllerWithNullView.playGame();
  }

  /**
   * Tests the constructor throws an IllegalArgumentException when one of its parameters are null.
   * Readable is null
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNullReadable() {
    SetGameController controllerWithNullReadable = new SetGameControllerImpl(model, view,
            null);
    controllerWithNullReadable.playGame();
  }

  /**
   * Tests the constructor throws an IllegalArgumentException when all of its parameters are null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNullEverything() {
    SetGameController controllerWithNullValues = new SetGameControllerImpl(null, null,
            null);
    controllerWithNullValues.playGame();
  }

  /**
   * Tests quitting immediately.
   *
   * @throws IOException when there is an issue reading the input or output
   */
  @Test
  public void testQuitImmediately() throws IOException {
    Reader in = new StringReader("q");
    SetGameController controller = new SetGameControllerImpl(model, view, in);
    controller.playGame();
    String output = this.out.toString();
    String[] lines = output.split("\n");
    String expectedOutput = lines[1] + "\n" + lines[2];
    String actualOutput = "Game quit!\n" +
            "Score: 0";
    assertEquals(expectedOutput.replace("\r\n", "\n").trim(),
            actualOutput.replace("\r\n", "\n").trim());
  }

  /**
   * Tests quitting immediately.
   *
   * @throws IOException when there is an issue reading the input or output
   */
  @Test
  public void testQuitAfterValidHeightInput() throws IOException {
    Reader in = new StringReader("3 q");
    SetGameController controller = new SetGameControllerImpl(model, view, in);
    controller.playGame();
    String output = this.out.toString();
    String[] lines = output.split("\n");
    String expectedOutput = lines[1] + "\n" + lines[2];
    String actualOutput = "Game quit!\n" +
            "Score: 0";
    assertEquals(expectedOutput.replace("\r\n", "\n").trim(),
            actualOutput.replace("\r\n", "\n").trim());
  }

  /**
   * Tests the starting grid is rendered correctly.
   *
   * @throws IOException when there is an issue reading the input or output
   */
  @Test
  public void testStartingGrid() throws IOException {
    Reader in = new StringReader("3\n 3 q");
    SetGameController controller = new SetGameControllerImpl(model, view, in);
    controller.playGame();
    String output = this.out.toString();
    String[] lines = output.split("\n");
    String startingGrid = lines[1] + "\n" + lines[2] + "\n" + lines[3];
    String expectedStartingGrid = "1EO 1EQ 1ED\n" +
            "1SO 1SQ 1SD\n" +
            "1FO 1FQ 1FD\n";
    assertEquals(startingGrid.trim(), expectedStartingGrid.trim());
  }

  /**
   * Tests that the grid is valid after 1 successful claim.
   *
   * @throws IOException when there is an issue reading the input or output
   */
  @Test
  public void testGridAfter1ValidClaim() throws IOException {
    Reader in = new StringReader("3 3 1 1 2 2 3 3 q");
    SetGameController controller = new SetGameControllerImpl(model, view, in);
    controller.playGame();
    String output = out.toString();
    String[] lines = output.split("\n");
    String expectedOutput = lines[12] + "\n" + lines[13] + "\n" + lines[14] + "\n" +
            lines[15] + "\n" + lines[16] + "\n" + lines[17];
    assertEquals(expectedOutput.replace("\r\n", "\n"), "Game quit!\n" +
            "State of game when quit:\n" +
            "2EO 1EQ 1ED\n" +
            "1SO 2EQ 1SD\n" +
            "1FO 1FQ 2ED\n" +
            "Score: 1");
  }

  /**
   * Tests invalid claim message is correctly given when a valid claim is made.
   *
   * @throws IOException when there is an issue reading the input or output
   */
  @Test
  public void testInvalidClaim() throws IOException {
    Reader in = new StringReader("3 3 1 2 2 2 3 3 q");
    SetGameController controller = new SetGameControllerImpl(model, view, in);
    controller.playGame();
    String output = out.toString();
    assertTrue(output.contains("Invalid claim. Try again."));
  }

  /**
   * Tests that the score stays the same with 1 unsuccessful but valid inputted claim.
   *
   * @throws IOException when there is an issue reading the input or output
   */
  @Test
  public void testScoreStaysTheSameAfter1ValidButUnsuccessfulClaim() throws IOException {
    Reader in = new StringReader("3 3 1 2 2 2 3 3 q");
    SetGameController controller = new SetGameControllerImpl(model, view, in);
    controller.playGame();
    String output = out.toString();
    String[] lines = output.split("\n");
    String expectedOutput = lines[17];
    assertEquals(expectedOutput.replace("\r\n", "\n"), "Score: 0");
  }

  /**
   * Tests that the score stays the same with 1 successful claim and 1 unsuccessful but
   * valid inputted claim.
   *
   * @throws IOException when there is an issue reading the input or output
   */
  @Test
  public void testScoreStaysTheSameAfter1ValidClaimAnd1ValidButUnsuccessfulClaim()
          throws IOException {
    Reader in = new StringReader("3 3 1 1 2 2 3 3 1 2 2 2 3 3 q");
    SetGameController controller = new SetGameControllerImpl(model, view, in);
    controller.playGame();
    String output = out.toString();
    String[] lines = output.split("\n");
    String expectedOutput = lines[23];
    assertEquals(expectedOutput.replace("\r\n", "\n"), "Score: 1");
  }

  /**
   * Tests invalid height given and that try again message appears.
   *
   * @throws IOException when there is an issue reading the input or output
   */
  @Test
  public void testInvalidHeight() throws IOException {
    Reader in = new StringReader("2 3 q");
    SetGameController controller = new SetGameControllerImpl(model, view, in);
    controller.playGame();
    assertTrue(out.toString().contains("Invalid height/width. Try again."));
  }

  /**
   * Tests invalid width is given and that try again message appears.
   *
   * @throws IOException when there is an issue reading the input or output
   */
  @Test
  public void testInvalidWidth() throws IOException {
    Reader in = new StringReader("3 2 q");
    SetGameController controller = new SetGameControllerImpl(model, view, in);
    controller.playGame();
    assertTrue(out.toString().contains("Invalid height/width. Try again."));
  }

  /**
   * Tests invalid height is given and is a non-integer that correct message appears.
   *
   * @throws IOException when there is an issue reading the input or output
   */
  @Test
  public void testHeightIsNonInteger() throws IOException {
    Reader in = new StringReader("a q");
    SetGameController controller = new SetGameControllerImpl(model, view, in);
    controller.playGame();
    assertTrue(out.toString().contains("Enter value again"));

    Reader in2 = new StringReader("} 3 3 q");
    SetGameController controller2 = new SetGameControllerImpl(model, view, in2);
    controller2.playGame();
    assertTrue(out.toString().contains("Enter value again"));
  }

  /**
   * Tests that the game over message appears after 7 straight valid claims are made.
   */
  @Test
  public void testFullGameWithNoInvalidClaims() {
    Reader in = new StringReader("3 3 " +
            "1 1 2 2 3 3 " +
            "1 1 2 2 3 3 " +
            "1 1 2 2 3 3 " +
            "1 1 2 2 3 3 " +
            "1 1 2 2 3 3 " +
            "1 1 2 2 3 3 " +
            "1 1 2 2 3 3 q");
    SetGameController controller = new SetGameControllerImpl(model, view, in);
    controller.playGame();
    String output = out.toString();
    String[] lines = output.split("\n");
    String expectedOutput = lines[43] + "\n" + lines[44];
    assertEquals(expectedOutput.replace("\r\n", "\n").trim(),
            "Game over!\nScore: 7".trim());
  }

  /**
   * Tests that the game over message appears after 7 valid claims are made but with invalid claims.
   */
  @Test
  public void testFullGameWithInvalidClaimsInBetween() {
    Reader in = new StringReader("3 3 " +
            "1 1 2 2 3 3 " +
            "1 2 1 1 1 2 " +
            "1 1 2 2 3 3 " +
            "1 1 2 2 3 3 " +
            "a 1 1 2 3 3 4 " +
            "1 1 2 2 3 3 " +
            "1 1 2 2 3 3 " +
            "1 1 2 2 3 3 " +
            "1 1 2 2 3 3 q");
    SetGameController controller = new SetGameControllerImpl(model, view, in);
    controller.playGame();
    String output = out.toString();
    String[] lines = output.split("\n");
    String expectedOutput = lines[56] + "\n" + lines[57];
    assertEquals(expectedOutput.replace("\r\n", "\n").trim(),
            "Game over!\nScore: 7".trim());
  }
}