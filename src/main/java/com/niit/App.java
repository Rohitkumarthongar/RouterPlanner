package com.niit;
import java.io.IOException;
import java.util.Scanner;
public class App
{
    public static void main( String[] args ) throws IOException {
        Scanner scan=new Scanner(System.in);
            RouteOperation rr=new RouteOperation();
        System.out.println("--------------------------------------------ALL READ DATA-------------------------------------------------------");
        Route[] routes=rr.readRoutedata(rr.count());
       // rr.displayFlights(routes);
        System.out.println("--------------------------------------------DIRECT FLIGHTS-------------------------------------------------------");
        System.out.println(" ");
        System.out.println("Enter the CityName");
        String CityName= scan.nextLine();
        Route[] DirectFlights = rr.showDirectFlights(routes,CityName);
        rr.displayFlights(DirectFlights);
        System.out.println("----------------------------------------------SORTING --------------------------------------------------------------");
        System.out.println(" ");
        Route[] sortFlights = rr.sortDirectFlights(DirectFlights);
       rr.displayFlights(sortFlights);
        System.out.println("----------------------------------------------ALL FLIGHTS--------------------------------------------------------------");
        System.out.println(" ");
        System.out.println("Enter the Cities to find Path");
        System.out.println("From -->");
        String from=scan.nextLine();
        System.out.println("To -->");
        String to=scan.nextLine();
       RouteOperation.showAllConnections(routes,from,to);
      // RouteOperation.displayFetch();
        System.out.println("********************************  THANK YOU VISIT AGAIN  ************************************************");
    }
}