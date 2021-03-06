/*
 * Copyright (c) 2010, Oracle. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * * Neither the name of Oracle nor the names of its contributors
 *   may be used to endorse or promote products derived from this software without
 *   specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

//package examples;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class outputGUI extends JFrame {
    Airline[] m_airlines = new Airline[3];
    /*private int m_numOfAirports;
    private int m_numOfAirplanes;*/
    /** Creates new form outputGUI */
    public outputGUI(Airline[] airlines/*, int numOfAirports, int numOfAirplanes*/) {
        initComponents();
        m_airlines = airlines;
        /*m_numOfAirports = numOfAirports;
        m_numOfAirplanes = numOfAirplanes;*/

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new JPanel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jButton1 = new JButton();
        jPanel1 = new JPanel();
        jButton2 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jLabel1 = new JLabel();
        jButton4 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulation Output");

        jPanel2.setBorder(BorderFactory.createTitledBorder(" Output Selection: "));

       /* jLabel3.setText("Airplane Selection:" + Integer.toString(m_numOfAirplanes));*/

        jLabel4.setText("Output Statistics Selection:");

        jButton1.setText("Profit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new BorderLayout());

        jButton2.setText("Revenue");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setText("Cost");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Passengers");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        /*jLabel1.setText("Airports Chosen: " + m_numOfAirports);
        jLabel1.setToolTipText("");*/

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(jPanel2Layout.createSequentialGroup()
                                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(jPanel2Layout.createSequentialGroup()
                                                                .add(jLabel3)
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .add(jPanel2Layout.createSequentialGroup()
                                                                .add(jLabel4)
                                                                .add(53, 53, 53)
                                                                .add(jButton1)
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 24, Short.MAX_VALUE)
                                                                .add(jButton2)
                                                                .add(18, 18, 18)))
                                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(jPanel2Layout.createSequentialGroup()
                                                                .add(jButton5)
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                                .add(jButton6))
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                                                                .add(jLabel1)
                                                                .add(33, 33, 33)))))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jLabel3)
                                        .add(jLabel1))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jButton1)
                                        .add(jButton2)
                                        .add(jButton5)
                                        .add(jButton6)
                                        .add(jLabel4))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 10, Short.MAX_VALUE)
                                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 268, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jButton4.setText("OK");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(layout.createSequentialGroup()
                                                .add(0, 0, Short.MAX_VALUE)
                                                .add(jButton4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(0, 0, Short.MAX_VALUE)
                                .add(jButton4)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        final String AP = "Airline";
        final String DELTA = "Delta";
        final String SW = "Southwest";
        final String Spirit = "Spirit";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue( m_airlines[0].getRevenue()-m_airlines[0].getCost() , AP, DELTA );
        dataset.setValue( m_airlines[1].getRevenue()-m_airlines[1].getCost() , AP, SW );
        dataset.setValue( m_airlines[2].getRevenue()-m_airlines[2].getCost() , AP, Spirit );

        JFreeChart barChart = ChartFactory.createBarChart(
                "Profit Statistics",
                "Airport Simulation",
                "Profit ($)",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.ORANGE);
        ChartPanel chartPanel = new ChartPanel( barChart);
        jPanel1.removeAll();
        jPanel1.add(chartPanel, BorderLayout.CENTER);
        jPanel1.validate();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        final String AP = "Airline";
        final String DELTA = "Delta";
        final String SW = "Southwest";
        final String Spirit = "Spirit";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue( m_airlines[0].getRevenue() , AP, DELTA );
        dataset.setValue( m_airlines[1].getRevenue() , AP, SW );
        dataset.setValue( m_airlines[2].getRevenue() , AP, Spirit );

        JFreeChart barChart = ChartFactory.createBarChart(
                "Revenue Statistics",
                "Airport Simulation",
                "Revenue ($)",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.ORANGE);
        ChartPanel chartPanel = new ChartPanel( barChart);
        jPanel1.removeAll();
        jPanel1.add(chartPanel, BorderLayout.CENTER);
        jPanel1.validate();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        final String AP = "Airline";
        final String DELTA = "Delta";
        final String SW = "Southwest";
        final String Spirit = "Spirit";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue( m_airlines[0].getCost() , AP, DELTA );
        dataset.setValue( m_airlines[1].getCost() , AP, SW );
        dataset.setValue( m_airlines[2].getCost() , AP, Spirit );

        JFreeChart barChart = ChartFactory.createBarChart(
                "Cost Statistics",
                "Airport Simulation",
                "Cost ($)",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.ORANGE);
        ChartPanel chartPanel = new ChartPanel( barChart);
        jPanel1.removeAll();
        jPanel1.add(chartPanel, BorderLayout.CENTER);
        jPanel1.validate();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        final String AP = "Airline";
        final String DELTA = "Delta";
        final String SW = "Southwest";
        final String Spirit = "Spirit";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue( m_airlines[0].getNumPassengers() , AP, DELTA );
        dataset.setValue( m_airlines[1].getNumPassengers(), AP, SW );
        dataset.setValue( m_airlines[2].getNumPassengers() , AP, Spirit );

        JFreeChart barChart = ChartFactory.createBarChart(
                "Passengers Statistics",
                "Airport Simulation",
                "Passengers (Persons)",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.ORANGE);
        ChartPanel chartPanel = new ChartPanel( barChart);
        jPanel1.removeAll();
        jPanel1.add(chartPanel, BorderLayout.CENTER);
        jPanel1.validate();

    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        *//* Set the Nimbus look and feel *//*
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        *//* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         *//*
        try {
            UIManager.LookAndFeelInfo[] installedLookAndFeels= UIManager.getInstalledLookAndFeels();
            for (int idx=0; idx<installedLookAndFeels.length; idx++)
                if ("Nimbus".equals(installedLookAndFeels[idx].getName())) {
                    UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                    break;
                }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(outputGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(outputGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(outputGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(outputGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        *//* Create and display the form *//*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new outputGUI().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

}

