/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author T2Ti
 */
public class DesktopPaneImagem extends JDesktopPane{

    private final String caminhoImagem;

    public DesktopPaneImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ImageIcon img = new ImageIcon(caminhoImagem);
        g.drawImage(img.getImage(), 0, 0, this);
    }
}
