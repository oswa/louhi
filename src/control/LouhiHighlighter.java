/*
 * This file is part of Louhi.

    Louhi is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License.

    Louhi is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with Louhi.  If not, see <http://www.gnu.org/licenses/>.
 */
package control;

import java.awt.Color;
import java.util.Random;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;

/**
 *
 * @author alos
 */
public class LouhiHighlighter {

    static Random random = new Random();
    private JTextPane comp;
    private Highlighter.HighlightPainter painter;

    public LouhiHighlighter(JTextPane comp) {
        Color randomColor = Color.getHSBColor(random.nextFloat(), 1.0F, 1.0F);
        this.comp = comp;
        painter = new DefaultHighlighter.DefaultHighlightPainter(randomColor);//para el hightlighter de referencias

    }

    // Search for a word and return the offset of the
    // first occurrence. Highlights are added for all
    // occurrences found.
    public int search(String word) {
        int firstOffset = -1;
        Highlighter highlighter = comp.getHighlighter();

        // Remove any existing highlights for last word
    /*Highlighter.Highlight[] highlights = highlighter.getHighlights();
        for (int i = 0; i < highlights.length; i++) {
        Highlighter.Highlight h = highlights[i];
        if (h.getPainter() instanceof DefaultHighlighter.DefaultHighlightPainter) {
        highlighter.removeHighlight(h);
        }
        }*/

        if (word == null || word.equals("")) {
            return -1;
        }

        // Look for the word we are given - insensitive search
        String content = null;
        try {
            Document d = comp.getDocument();
            content = d.getText(0, d.getLength()).toLowerCase();
        } catch (BadLocationException e) {
            // Cannot happen
            return -1;
        }

        word = word.toLowerCase();
        int lastIndex = 0;
        int wordSize = word.length();

        while ((lastIndex = content.indexOf(word, lastIndex)) != -1) {
            int endIndex = lastIndex + wordSize;
            try {
                highlighter.addHighlight(lastIndex, endIndex, painter);
            } catch (BadLocationException e) {
                // Nothing to do
            }
            if (firstOffset == -1) {
                firstOffset = lastIndex;
            }
            lastIndex = endIndex;
        }

        return firstOffset;
    }

    public void clearHightlight() {
        Highlighter highlighter = comp.getHighlighter();
        Highlighter.Highlight[] highlights = highlighter.getHighlights();
        for (int i = 0; i < highlights.length; i++) {
            Highlighter.Highlight h = highlights[i];
            if (h.getPainter() instanceof DefaultHighlighter.DefaultHighlightPainter) {
                highlighter.removeHighlight(h);
            }
        }
    }
}
