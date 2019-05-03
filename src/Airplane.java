//YOUR NAME HERE

//TODO add number of passengers, speed

import java.util.HashMap;
import java.util.Map;
import java.lang.*;

public class Airplane {
    private String m_name;
    private int m_numberPassengers = 0;
    private int m_maxPassengers;
    private double m_speed;
    private int m_id = 0;
    private double m_timer = 0;
    private int m_maxFuel;
    private int m_fuel;
    private Airline m_airline;
    private int m_revenue;
    private int m_cost;
    private double m_fuelprice;

    public Airplane(String name, Airline airline, int maxPassengers, int maxFuel, double speed, double fuelcost, int id) {
        m_name = name;
        m_airline = airline;
        m_maxPassengers = maxPassengers;
        m_maxFuel = maxFuel;
        m_speed = speed;
        m_fuelprice = fuelcost;
        m_id = id;
    }

    public String getName() {
        return m_name;
    }

    public int getNumPassengers(){ return m_numberPassengers; }

    public void setNumPassengers(int Num) { m_numberPassengers = Num;}

    public int getMaxPassengers(){ return m_maxPassengers; }

    public double getSpeed(){ return m_speed; }

    public int getID(){ return m_id; }

    public void setTimer(double time){
        m_timer = time;
    }

    public double getTimer(){ return m_timer;}

    public Airline getAirline() {return m_airline;}

    public int getMaxFuel() {return m_maxFuel;}

    public int getFuel() {return m_fuel;}

    public void setFuel(int fuel) {m_fuel = fuel;}

    public int getRevenue () {return m_revenue;}

    public int getCost () {return m_cost;}

    public double getFuelprice() {return m_fuelprice;}
}
