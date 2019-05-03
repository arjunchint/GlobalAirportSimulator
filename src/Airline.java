/**
 * Created by xinyao on 4/12/17.
 */
import java.lang.*;

public class Airline {
    private String m_name;
    private int m_revenue;
    private int m_cost;
    private int m_numPassengers = 0;

    public Airline (String name, int revenue, int cost) {
        m_name = name;
        m_revenue = revenue;
        m_cost = cost;
    }

    public String getAirlinename () {
        return m_name;
    }

    public int getRevenue () {
        return m_revenue;
    }

    public int getCost () {
        return m_cost;
    }

    public int getNumPassengers () {return m_numPassengers;}

    public void setRevenue (int revenue) {
        m_revenue = revenue;
    }

    public void setCost (int cost) {
        m_cost = cost;
    }

    public void setNumPassengers (int numPassengers) {m_numPassengers = numPassengers;}
}
