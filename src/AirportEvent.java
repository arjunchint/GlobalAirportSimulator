//YOUR NAME HERE

public class AirportEvent extends Event {
    public static final int PLANE_ARRIVES = 0;
    public static final int PLANE_LANDED = 1;
    public static final int PLANE_DEPARTS = 2;
    public static final int PLANE_DEPARTED = 3;

  //  AirportEvent(double delay, EventHandler handler, int eventType) {
   //     super(delay, handler, eventType);
   // }

    AirportEvent(double delay, EventHandler handler, int eventType, Airplane airplane){
        super(delay, handler, eventType, airplane);
    }
}
