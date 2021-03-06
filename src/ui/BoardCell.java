package ui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;

@SuppressWarnings("serial")
public class BoardCell extends JLabel implements MouseListener{
    private int i;
    private int j;

    private GameEngine ge;
    private JPanel parent;

    private int highlight = 0;
    private String text = "";

    public BoardCell(GameEngine ge ,JPanel parent,int i,int j){
        this.ge = ge;
        this.parent = parent;
        this.i = i;
        this.j = j;
        this.addMouseListener(this);
    }
    
    public void setHighlight(int highlight) {
		this.highlight = highlight;
	}

    @Override
    public void paint(Graphics g) {

        int margin_left = this.getWidth() / 10;
        int margin_top = this.getHeight() / 10;

        //draw highlight
        if (highlight == 1) {
            g.setColor(new Color(138, 177, 62));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(parent.getBackground());
            g.fillRect(4,4,this.getWidth()-8, this.getHeight()-8);
        } else if (highlight == 2) {
            g.setColor(new Color(177, 158, 70));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(parent.getBackground());
            g.fillRect(4,4,this.getWidth()-8, this.getHeight()-8);
        } else if (highlight == 10) {
            g.setColor(new Color(177, 43, 71));
            g.fillRect(0 , 0, this.getWidth(), this.getHeight());
        }

        //draw border
        g.setColor(Color.BLACK);
        g.drawRect(0,0,this.getWidth(),this.getHeight());

        //draw piece
        int value = ge.getBoardValue(i, j);
        if (value == 1) {
        	g.setColor(new Color(240, 240, 240));
        	g.fillOval(margin_left,margin_top,this.getWidth() - 2 * margin_left,this.getHeight() - 2 * margin_top);
            g.setColor(Color.BLACK);
            g.fillOval(margin_left,margin_top,this.getWidth() - 2 * margin_left - 3, this.getHeight() - 2 * margin_top - 3);
        } else if (value == 2) {
        	g.setColor(Color.BLACK);
        	g.fillOval(margin_left,margin_top,this.getWidth() - 2 * margin_left, this.getHeight() - 2 * margin_top);
        	g.setColor(new Color(240, 240, 240));
            g.fillOval(margin_left,margin_top,this.getWidth() - 2 * margin_left - 5, this.getHeight() - 2 * margin_top - 5);
        }

        // draw text
        if (!text.isEmpty()) {
            g.setColor(new Color(255, 255, 0));
            Font font = g.getFont();
            Font nfont = new Font(font.getName(), Font.PLAIN, 30);
            g.setFont(nfont);
        }
        super.paint(g);
    }


    //Extension function to ease drawing text
    public void drawStringInCenterOfRectangle(Graphics g, int x, int y, int w, int h, String text) {
        Graphics2D g2 = (Graphics2D) g;
        Font bfont = g2.getFont();
        FontRenderContext context = g2.getFontRenderContext();
        g2.setFont(bfont);
        int textWidth = (int) bfont.getStringBounds(text, context).getWidth();
        LineMetrics ln = bfont.getLineMetrics(text, context);
        int textHeight = (int) (ln.getAscent() + ln.getDescent());
        int tx = x+(w - textWidth)/2;
        int ty = (int)((y + h + textHeight)/2 - ln.getDescent());
        g2.drawString(text, (int)tx, (int)ty);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        ge.handleClick(i, j);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
