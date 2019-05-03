//YOUR NAME HERE

import javax.swing.*;
import java.util.Random;
import java.util.TreeSet;


public class AirportSim {
    /*private static int stopTime;*/
    public static void run(int numOfAirplanes, int numOfAirports, double fuelCost, int stopDay) {
        int stopTime = stopDay * 24 * 60;
        double[][] distanceMatrix = new double[numOfAirports][numOfAirports];

        Airline[] airlines = new Airline[3];
        airlines[0] = new Airline("Delta", 0, 0 );
        airlines[1] = new Airline("SouthWest", 0, 0 );
        airlines[2] = new Airline("Sprite", 0, 0 );

        Airplane[] airplane = new Airplane[numOfAirplanes];
        for (int i = 0; i < numOfAirplanes; i++) {
            Random ran = new Random();
            int x = ran.nextInt(3);
            switch (x) {
                case 0:
                    airplane[i] = new Airplane("Airbus A380", airlines[0], 525, 84600,560, fuelCost, i);
                    break;
                case 1:
                    airplane[i] = new Airplane("Boeing 777-200ER", airlines[1],313 ,47890, 554, fuelCost,i);
                    break;
                case 2:
                    airplane[i] = new Airplane("Airbus A320", airlines[2],236,61900, 515, fuelCost, i);
                    break;
            }
        }

        Airport[] airport = new Airport[numOfAirports];

        for(int i = 0; i < numOfAirports ; i++) {
            Random ran = new Random();
            int runWayTime = ran.nextInt(5) + 5;
            airport[i] = new Airport("Airport " + i, runWayTime, runWayTime, 20, i);
        }

        for(int i = 0; i < numOfAirports; i++){
            for(int j = 0; j <= i; j++){
                Random ran = new Random();
                int d = ran.nextInt(10000) + 500;
                if(i == j)
                    distanceMatrix[i][j] = 0;
                else{
                    distanceMatrix[i][j] = d;
                    distanceMatrix[j][i] = d;
                }
            }
        }

        for(int i = 0; i < numOfAirports; i++) {
            airport[i].getAirport(airport);
            airport[i].getDistance(distanceMatrix);
        }

        for (int i = 0; i < numOfAirplanes; i++) {
            Random ran = new Random();
            int x = ran.nextInt(5);
            int t = ran.nextInt(100);
            AirportEvent landingEvent = new AirportEvent(t, airport[x], AirportEvent.PLANE_ARRIVES, airplane[i]);
            Simulator.schedule(landingEvent);
        }


        Simulator.stopAt(stopTime);
        Simulator.run();

        for(int i = 0; i < numOfAirports; i++) {
            System.out.format(airport[i].getName() + " has total of " + airport[i].getTotalPassengersArrive() + " passengers arrived and " +
                    airport[i].getTotalPassengersDepart() + " passengers departed with " + airport[i].getTotalPlaneArrive() + " planes arrived, total circle time is %.1f minutes, average circle time is %.3f minutes.%n", airport[i].getTotalCircleTime(),
                    airport[i].getTotalCircleTime()/airport[i].getTotalPlaneArrive() );
        }
        System.out.println(airport[0].getName() + " profit: " + airport[0].getAirportProfit());

        System.out.println(airlines[0].getAirlinename() + " revenue: " + airlines[0].getRevenue());

        System.out.println("Total simulation time: " + stopTime + " minutes.");
        System.out.println("Total number of planes: " + numOfAirplanes + ".");

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new outputGUI(airlines/*,numOfAirports,numOfAirplanes*/).setVisible(true);
            }
        });



    }
}
