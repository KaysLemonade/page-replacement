package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;

public class Gui extends JFrame implements ActionListener{

    //declaring the radio buttons and initializing an array of labels
    JRadioButton rb1;
    JRadioButton rb2;
    JRadioButton rb3;
    JLabel[] lblgroup = new JLabel[20];

    public Gui(){
        ImageIcon dino = new ImageIcon("pictures/oscase.jpg"); //the app icon

        //setting the JFrame
        this.setTitle("Page Replacement Algorithm; FIFO");
        this.setSize(420, 420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
        this.setVisible(true);       
        this.setIconImage(dino.getImage());
        this.getContentPane().setBackground(new Color(237, 221, 116));
        this.setLayout(null);

        //declaring and setting up 3 labels
        JLabel lbl1 = new JLabel();                                     //lb1 = title label
        lbl1.setText("Page Replacement Algorithm: FIFO");
        lbl1.setVisible(true);
        lbl1.setForeground(new Color(1, 56, 9));
        lbl1.setFont(new Font("Impact", Font.PLAIN, 24));
        lbl1.setVerticalAlignment(JLabel.TOP);
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.setBounds(25,10, 350, 30);

        JLabel lbl2 = new JLabel();                                     //lbl2 = prompt to choose a the number of frames
        lbl2.setText("Choose the number of Frames");
        lbl2.setVisible(true);
        lbl2.setForeground(new Color(1, 56, 9));
        lbl2.setFont(new Font("Calibri", Font.BOLD, 16));
        lbl2.setBounds(35,40, 300, 20);

        JLabel lblRan = new JLabel();                                   //lblRan = shows the generated numbers
        lblRan.setText("Generated String: ");
        lblRan.setVisible(true);
        lblRan.setForeground(new Color(1, 56, 9));
        lblRan.setFont(new Font("Calibri", Font.BOLD, 12));
        lblRan.setBounds(35,330, 350, 20);
        this.add(lblRan);

        JLabel lblPF = new JLabel();                                    //lblPF = shows the number of page faults
        lblPF.setText("Number of Page Fault: ");
        lblPF.setVisible(true);
        lblPF.setForeground(new Color(1, 56, 9));
        lblPF.setFont(new Font("Calibri", Font.BOLD, 12));
        lblPF.setBounds(35,350, 350, 20);
        this.add(lblPF);

        //setting up the radio buttons
        rb1 = new JRadioButton("3");
        rb1.setBounds(35, 55, 45, 20);
        rb2 = new JRadioButton("4");
        rb2.setBounds(85, 55, 45, 20);
        rb3 = new JRadioButton("5");
        rb3.setBounds(135, 55, 45, 20);
        rb1.setBackground(new Color(237, 221, 116));
        rb2.setBackground(new Color(237, 221, 116));
        rb3.setBackground(new Color(237, 221, 116));

        ButtonGroup rbGroup = new ButtonGroup();
        rbGroup.add(rb1);
        rbGroup.add(rb2);
        rbGroup.add(rb3);

        rb1.addActionListener(this);
        rb2.addActionListener(this);
        rb3.addActionListener(this);

        //setting the panel that will hold the numbers
        JPanel proc = new JPanel();
        proc.setBounds(40, 80, 325,250);
        proc.setLayout(new GridLayout(10, 2));
        this.add(proc);

        //setting up the button to start the process
        JButton btnConf = new JButton();
        btnConf.setText("Start");
        btnConf.setForeground(new Color(237, 221, 116));
        btnConf.setFont(new Font("Calibri", Font.BOLD, 16));
        btnConf.setBounds(250, 40, 100, 30);
        btnConf.setBackground(new Color(1, 56, 9));

        btnConf.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    //generating the string of 20 random numbers
                    for(int x = 0; pageFault.ranString.length > x; x++){
                    pageFault.ranString[x] = (int)(Math.random() * (9 - 0 + 1) + 0);
                    }

                    //printing the randomly generated number string
                    System.out.println("The Randomly Generated String: " + Arrays.toString(pageFault.ranString));

                    //traversing through the random number string
                    for(int x = 0; pageFault.ranString.length > x ; x++){
                        //traversing through the page frame array
                        for (int y = 0; pageFault.pageframe.length > y; y++){

                            //checking if the page frame array contains a number the same of the current number in the random string
                            if (pageFault.ranString[x] == pageFault.pageframe[y]){
                                pageFault.checks = true;
                                break;
                            }
                            else{
                                pageFault.checks = false;
                            }

                        }

                        //raplacing the contents of the page frame array, if the boolean turn false, on the position according to
                        //the counter variable.
                        if (pageFault.checks == true) {
                            proc.add(lblgroup[x] = new JLabel(" "+ (x+1) + ":      " + pageFault.ranString[x] + "  "));
                            continue;}
                        else{
                            pageFault.pageframe[pageFault.counter] = pageFault.ranString[x];
                            System.out.println(Arrays.toString(pageFault.pageframe));
                            proc.add(lblgroup[x] = new JLabel(" "+ (x+1) + ":      " +pageFault.ranString[x] + "  " + Arrays.toString(pageFault.pageframe)));
                            pageFault.pageFault += 1; 
                            pageFault.counter++;
                            pageFault.counter = pageFault.check(pageFault.counter,(pageFault.num - 1));                
                        }

                    }

                    //displaying the number of page faults and generated string
                    lblRan.setText("Generated String: "+ Arrays.toString(pageFault.ranString));
                    System.out.println("page fault: " + pageFault.pageFault);
                    lblPF.setText("Number of Page Faults: " + pageFault.pageFault);
                    btnConf.setVisible(false);
                }
            }
        );

        //adding the components to the JFrame
        this.add(btnConf);
        this.revalidate();
        this.add(rb1);
        this.add(rb2);
        this.add(rb3);
        this.revalidate();
        this.add(lbl1);
        this.add(lbl2);

        this.revalidate();
    }

    //setting the number of frames
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==rb1){
            pageFault.num = 3;
            System.out.println("chosen number 3");
        }
        else if(e.getSource()==rb2){
            pageFault.num = 4;
            System.out.println("chosen number 4");
        }
        else if(e.getSource()==rb3){
            pageFault.num = 5;
            System.out.println("chosen number 5");
        }   
    }

}
      