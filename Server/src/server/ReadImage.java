/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class ReadImage {

    public void main(String path) {
        String s = path;
        Image newImage = null;
        try {
            File sourceimage = new File(s);
            newImage = ImageIO.read(sourceimage);
            newImage = newImage.getScaledInstance(683, 384, Image.SCALE_DEFAULT);
        } catch (IOException e) {
        }

        JDialog frame = new JDialog();
        frame.setSize(750, 450);
        JLabel label = new JLabel(new ImageIcon(newImage));
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        frame.setTitle("Picture");
        frame.add(label);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
