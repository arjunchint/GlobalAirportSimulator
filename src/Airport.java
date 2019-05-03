//YOUR NAME HERE

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.lang.*;

public class Airport implements EventHandler {

    //TODO add landing and takeoff queues, random variables

    private int m_totalPassengersArrive = 0;
    private int m_totalPassengersDepart = 0;
    private int m_totalPlaneArrive = 0;

    private double m_totalCircleTime = 0;

    private boolean m_landingFree;
    private boolean m_departingFree;

    private double m_flightTime;
    private double m_runwayTimeToLand;
    private double m_runwayTimeToDepart;
    private double m_requiredTimeOnGround;

    private String m_airportName;
    private int m_airportID;

    private static final int airport_fee = 10000;

    private int profit_airport = 0;

    Airport[] airport;

    private Comparator comparator = new AirplaneComparator();
    private PriorityQueue<Airplane> landingQueue = new PriorityQueue<>(comparator);
    private Queue<Airplane> departingQueue = new LinkedList<Airplane>();

    private static class AirplaneComparator implements Comparator<Airplane> {

        @Override
        public int compare(Airplane x, Airplane y) {

            if (x.getFuel() < y.getFuel()) {
                return -1;
            } else if (x.getFuel() > y.getFuel()) {
                return 1;
            }
            return 0;
        }
    }

    private double[][] m_distanceInMile;

    private static final Map<String, Double> revenue_permilepassenger = new HashMap<>();
    {
        revenue_permilepassenger.put("Delta", 3.3);
        revenue_permilepassenger.put("SouthWest", 2.6);
        revenue_permilepassenger.put("Sprite", 2.8);
    }


    public int getTotalPassengersArrive(){ return m_totalPassengersArrive; }

    public int getTotalPassengersDepart(){ return m_totalPassengersDepart; }

    public double getTotalCircleTime(){ return  m_totalCircleTime; }

    public int getTotalPlaneArrive(){ return  m_totalPlaneArrive; }

    public Airport(String name, double runwayTimeToLand, double runwayTimeToDepart, double requiredTimeOnGround, int id) {
        m_airportName = name;
        m_landingFree = true;
        m_departingFree = true;
        m_runwayTimeToLand = runwayTimeToLand;
        m_runwayTimeToDepart = runwayTimeToDepart;
        m_requiredTimeOnGround = requiredTimeOnGround;
        m_airportID = id;
    }

    public void getAirport(Airport[] airport){
        this.airport = airport;
    }

    public void getDistance(double[][] distance) { this.m_distanceInMile = distance;}

    public String getName() {
        return m_airportName;
    }

    public int getAirportProfit() {
        return profit_airport;
    }


    public void handle(Event event) {
        AirportEvent airEvent = (AirportEvent)event;

        switch(airEvent.getType()) {
            case AirportEvent.PLANE_ARRIVES:
                System.out.format("%.1f: " + airEvent.airplane.getName() + ",ID:" + airEvent.airplane.getID() + " arrived at airport " + m_airportName + "%n", Simulator.getCurrentTime());
                if(m_landingFree) {
                    m_landingFree = false;
                    AirportEvent landedEvent = new AirportEvent(m_runwayTimeToLand, this, AirportEvent.PLANE_LANDED, airEvent.airplane);
                    Simulator.schedule(landedEvent);
                }
                else {
                    landingQueue.add(airEvent.airplane);
                    airEvent.airplane.setTimer(Simulator.getCurrentTime());
                    //airEvent.airplane.m_landing = true;
                }


                break;

            case AirportEvent.PLANE_LANDED:
                int numPassagersArrive = airEvent.airplane.getNumPassengers();
                m_totalPassengersArrive = m_totalPassengersArrive + numPassagersArrive;
                m_totalPlaneArrive++;
                profit_airport += airport_fee;
                airEvent.airplane.getAirline().setNumPassengers(airEvent.airplane.getAirline().getNumPassengers() + airEvent.airplane.getNumPassengers());
        ////////// modify the required time on ground according to the number of passengers and total fuel/////////
                int fuel_tofill = airEvent.airplane.getMaxFuel() - airEvent.airplane.getFuel();
                double m_requiredTimeOnGround_modify = m_requiredTimeOnGround + 0.001 * airEvent.airplane.getNumPassengers() + 0.0001 * fuel_tofill;

                System.out.format("%.1f: " + airEvent.airplane.getName() + ",ID:" + airEvent.airplane.getID() + " landed at airport " + m_airportName + " with " + numPassagersArrive + " passengers%n", Simulator.getCurrentTime());
                AirportEvent departureEvent = new AirportEvent(m_requiredTimeOnGround_modify, this, AirportEvent.PLANE_DEPARTS, airEvent.airplane);

                ////// set the airplane's fuel to full
                airEvent.airplane.setFuel(airEvent.airplane.getMaxFuel());

                Simulator.schedule(departureEvent);
                if(!landingQueue.isEmpty())
                {
                    Airplane airplane = landingQueue.poll();
                    m_totalCircleTime = m_totalCircleTime + Simulator.getCurrentTime() - airplane.getTimer();
                    AirportEvent takeoffEvent = new AirportEvent(m_runwayTimeToLand, this, AirportEvent.PLANE_LANDED, airplane);
                    Simulator.schedule(takeoffEvent);
                    //airplane.m_takeOFF = false;
                }
                else
                {
                    m_landingFree = true;
                }
                break;

            case AirportEvent.PLANE_DEPARTS:
                Random ran = new Random();
                int i = ran.nextInt(airEvent.airplane.getMaxPassengers()) * 2 / 3 + airEvent.airplane.getMaxPassengers() / 3;
                m_totalPassengersDepart = m_totalPassengersDepart + i;
                airEvent.airplane.setNumPassengers(i);
                if(m_departingFree) {
                    m_departingFree = false;
                    System.out.format("%.1f: " + airEvent.airplane.getName() + ",ID:" + airEvent.airplane.getID() + " departs from airport " + m_airportName + " with " + i +" passengers%n", Simulator.getCurrentTime());
                    AirportEvent takeoffEvent = new AirportEvent(m_runwayTimeToDepart, this, AirportEvent.PLANE_DEPARTED, airEvent.airplane);
                    Simulator.schedule(takeoffEvent);
                }
                else{
                    departingQueue.add(airEvent.airplane);
                    //airEvent.airplane.m_takeOFF = true;
                }
                break;

            case AirportEvent.PLANE_DEPARTED:
                while(true) {
                    Random r = new Random();
                    int x = r.nextInt(50);
                    if(x != this.m_airportID){
                        m_flightTime = m_distanceInMile[this.m_airportID][x] * 60 / airEvent.airplane.getSpeed();
                        System.out.format("%.1f: " + airEvent.airplane.getName() + ",ID:" + airEvent.airplane.getID() + " departed from airport " + m_airportName + ", heading for " + airport[x].getName() + "%n", Simulator.getCurrentTime());
                        AirportEvent arriveEvent = new AirportEvent(m_flightTime, airport[x], AirportEvent.PLANE_ARRIVES, airEvent.airplane);
                        Simulator.schedule(arriveEvent);
                        //calculate the revenue and cost for this trip

                        double fuelcost_permile = 5;
                        double fuelprice_permile = airEvent.airplane.getFuelprice();

                        int cost = (int)(m_distanceInMile[this.m_airportID][x] * fuelprice_permile);
                        int revenue = (int)(m_distanceInMile[this.m_airportID][x] * revenue_permilepassenger.get(airEvent.airplane.getAirline().getAirlinename()));
                        int fuel_remain = (int) (airEvent.airplane.getFuel() - m_distanceInMile[this.m_airportID][x] * fuelcost_permile);
                        //airEvent.airplane.setCost(cost);
                        //airEvent.airplane.setRevenue(revenue);
                        airEvent.airplane.setFuel(fuel_remain);

                        airEvent.airplane.getAirline().setRevenue(airEvent.airplane.getRevenue() + revenue);

                        airEvent.airplane.getAirline().setCost(airEvent.airplane.getCost() + cost);

                        break;
                    }
                }
                if(!departingQueue.isEmpty())
                {
                    Airplane airplane = departingQueue.poll();

                    AirportEvent takeoffEvent = new AirportEvent(m_runwayTimeToDepart, this, AirportEvent.PLANE_DEPARTED, airplane);
                    Simulator.schedule(takeoffEvent);
                    //airplane.m_takeOFF = false;
                }
                else
                {
                    m_departingFree = true;
                }

                break;


        }
    }
}
