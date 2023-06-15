package java.com.niit;

public class Route
{
    String Destination;
    String Source;
    String airFare;
    int distance;
    String  time;


    public Route(String Source, String Destination, int distance, String airFare, String time) {
        this.Source=Source;
        this.Destination=Destination;
        this.airFare=airFare;
        this.distance=distance;
        this.time=time;
    }

    public String getDestination() {
        return Destination;
    }

    public String getSource() {
        return Source;
    }

    @Override
    public String toString() {
        return "Route"+"-->>" +"Source -->" + Source.toUpperCase() + "     Destination -->" + Destination.toUpperCase()  + "     airFare -->" + airFare + "     distance -->" + distance + "     Time -->"+time ;
    }
}
