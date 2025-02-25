package haromszogek;

import haromszogek.Haromszogek.DHaromszog;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Haromszogek extends javax.swing.JFrame {

    /**
     * Creates new form Haromszogek
     */
    public Haromszogek() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Adatok betöltése");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fileolvasas();
        for (int i = 0; i < vektor.size(); i++) {
  jTextArea2.append((i+1)+".sor: a="+vektor.get(i).aOldal+" b="+vektor.get(i).bOldal+" c="+vektor.get(i).cOldal+'\n');
            
        }
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public static class DHaromszog {

        private double aOldal;
        private double bOldal;
        private double cOldal;
        private int sorszam;

        public DHaromszog(String sor, int sorSzáma) {
            var oldalak = sor.replace(',', '.').split(" ");

            var beAoldal = Double.parseDouble(oldalak[0]);
            var beBoldal = Double.parseDouble(oldalak[1]);
            var beColdal = Double.parseDouble(oldalak[2]);

            setaOldal(beAoldal);
            setbOldal(beBoldal);
            setcOldal(beColdal);

            if (!EllNovekvoSorrend()) {
                System.out.println("A háromszög adatai nem sorrendben vannak");
            }

            if (!EllDerekszogu()) {
                System.out.println("A háromszög nem derékszögű");
            }

            if (!EllMegszerkesztheto()) {
                System.out.println("A háromszög nem megszerkeszthető");

            }

        }

        private boolean EllNovekvoSorrend() {
            return aOldal <= bOldal && bOldal <= cOldal;

        }

        private boolean EllMegszerkesztheto() {
            return (aOldal + bOldal) > cOldal;
        }

        private boolean EllDerekszogu() {
            return (cOldal * cOldal) == ((aOldal * aOldal) + (bOldal * bOldal));
        }

        public double kerulet() {
            return aOldal + bOldal + cOldal;
        }

        public double terulet() {
            return aOldal * bOldal / cOldal;
        }

        public double getaOldal() {
            return aOldal;
        }

        public double getbOldal() {
            return bOldal;
        }

        public double getcOldal() {
            return cOldal;
        }

        public int getSorszam() {
            return sorszam;
        }

        public void setSorszam(int sorszam) {
            this.sorszam = sorszam;
        }

        public void setaOldal(double aOldal) {
            if (aOldal > 0D) {
                this.aOldal = aOldal;
            } else {
                System.out.println("Az \"a\" oldal nem lehet nulla vagy negatív!");
            }
        }

        public void setbOldal(double bOldal) {
            if (aOldal > 0D) {
                this.bOldal = bOldal;
            } else {
                System.out.println("A \"b\" oldal nem lehet nulla vagy negatív!");
            }
        }

        public void setcOldal(double cOldal) {
            if (aOldal > 0D) {
                this.cOldal = cOldal;
            } else {
                System.out.println("A \"c\" oldal nem lehet nulla vagy negatív!");
            }

        }
    }
    public static Vector<DHaromszog>vektor=new Vector<DHaromszog>();
    
    public static void fileolvasas(){
        try {
            int szamlalo=0;
            Scanner fileinput=new Scanner(new File("haromszogek.txt"));
            while(fileinput.hasNextLine()){
            String data=fileinput.nextLine();
            szamlalo++;
             vektor.add(new DHaromszog(data, szamlalo));
            }
           fileinput.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    
    }
    
    public static void main(String args[]) { 
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Haromszogek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Haromszogek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Haromszogek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Haromszogek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Haromszogek().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    // End of variables declaration//GEN-END:variables
}
