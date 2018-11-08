/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulasi_pipaair;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author lenovo
 */
public class HalamanUtama_DenahGedung extends JFrame {

    private static final int FRAME_W = 700;
    private static final int FRAME_H = 500;
    private static final int FRAME_X = 150;
    private static final int FRAME_Y = 150;
    private JButton next, prev, ok;
    private JLabel my_pict;
//    private  Container content;
    private ListNode pointerN;
    private ListNode pointerP;
    private LinkedList list;
    private ImageIcon my_pict_code;

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.addFirst(new Picture_List("gambar 1 part1"));
        list.addFirst(new Picture_List("gambar 2 part2"));
        list.addFirst(new Picture_List("gambar 3 part3"));
        list.addFirst(new Picture_List("gambar 4 part4"));

        HalamanUtama_DenahGedung gal = new HalamanUtama_DenahGedung();
        gal.inputData(list);
        gal.setVisible(true);

    }

    //Identified LinkedList and ListNode
    public void inputData(Object data) {
        list = (LinkedList) data;
        pointerN = list.getHead().getNext();

        String a = pointerN.getData().toString();
        String code = "./" + a + ".jpg";

        my_pict_code = new ImageIcon(code);
        my_pict.setIcon(my_pict_code);
//        pointerP = list.getHead();
    }

    public HalamanUtama_DenahGedung() {
        setTitle("Halaman Utama Denah Gedung");
        setSize(FRAME_W, FRAME_H);
        setLocation(FRAME_X, FRAME_Y);

        Container content;
        content = getContentPane();
        content.setBackground(Color.white);
        content.setLayout(new BorderLayout());

        JPanel Panel = new JPanel(new GridLayout(1, 4));
        JPanel Panel2 = new JPanel();

        my_pict = new JLabel();
//        my_pict.setBounds(365, 70, 650, 550);
        Panel2.add(my_pict);

        next = new JButton(">>>");
        ok = new JButton("Ok");
        prev = new JButton("<<<");

        HalamanUtama_Action_Perfomed();
        Panel.add(prev);
        Panel.add(ok);
        Panel.add(next);

        content.add(Panel, BorderLayout.SOUTH);
        content.add(Panel2, BorderLayout.CENTER);
        

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void HalamanUtama_Action_Perfomed() {
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton clicked = (JButton) e.getSource();
                try {
                    if (pointerN == list.getHead()) {

                        String a = pointerN.getNext().getData().toString();
                        String code = "./" + a + ".jpg";

                        my_pict_code = new ImageIcon(code);

                        my_pict.setIcon(my_pict_code);
                        pointerN = pointerN.getNext();

                    } else if (pointerN != list.getHead()) {
                        if (pointerN == list.getHead().getPrev()) {
                            pointerN = pointerN.getNext();
                        }

                        String a = pointerN.getNext().getData().toString();

                        String code = "./" + a + ".jpg";

                        my_pict_code = new ImageIcon(code);

                        my_pict.setIcon(my_pict_code);
                        pointerN = pointerN.getNext();
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(rootPane, "Gambar Habis");
                }
            }
        });
        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (pointerN == list.getHead()) {
                        String a = pointerN.getPrev().getData().toString();
                        String code = "./" + a + ".jpg";

                        my_pict_code = new ImageIcon(code);
                        my_pict.setIcon(my_pict_code);
                        pointerN = pointerN.getPrev();

                    } else if (pointerN != list.getHead()) {
                        if (pointerN == list.getHead().getNext()) {
                            pointerN = pointerN.getPrev();
                        }
                        String a = pointerN.getPrev().getData().toString();
                        String code = "./" + a + ".jpg";

                        my_pict_code = new ImageIcon(code);
                        my_pict.setIcon(my_pict_code);
                        pointerN = pointerN.getPrev();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(rootPane, "Gambar Habis");
                }
            }
        });
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == ok) {
                   HalamanTampilan tamp = new HalamanTampilan();
                   tamp.setVisible(true);
                }

            }
        });

    }

    @Override
    public String toString() {
        String isi = "";
        ListNode pointer = list.getHead();
        while (pointer != list.getHead()) {
            isi += (pointer.getData() + " ");
            pointer = pointer.getNext();
        }
        return isi;
    }
}
