/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas.gui;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.text.BadLocationException;

public class MainClass {

  public static void main(final String args[]) {
    JFrame frame = new JFrame("Popup Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    final JTextField textField = new JTextField();
    frame.add(textField, BorderLayout.NORTH);

    ActionListener actionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {

          int dotPosition = textField.getCaretPosition();
          Rectangle popupLocation = null;
          try {
            popupLocation = textField.modelToView(dotPosition);
          } catch (BadLocationException e) {
            e.printStackTrace();
          }
          System.out.println(popupLocation);
      }
    };


    KeyStroke keystroke =
      KeyStroke.getKeyStroke(KeyEvent.VK_PERIOD, 0, false);
    textField.registerKeyboardAction(actionListener, keystroke,
      JComponent.WHEN_FOCUSED);

    frame.setSize(250, 150);
    frame.setVisible(true);
  }

}