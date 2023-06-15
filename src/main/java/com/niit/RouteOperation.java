package com.niit;

import  java.io.*;
public class RouteOperation {
    public int count() throws IOException {
        int recordCount = 0;
        File f = new File("src/main/resources/routes.csv");
        String str;
        BufferedReader br = new BufferedReader(new FileReader(f));
        while ((br.readLine()) != null) {
            recordCount++;
        }
        return recordCount;
    }
    public Route[] readRoutedata(int recordCount) throws IOException {
        Route[] routeInfo = new Route[recordCount];
        FileReader fr = new FileReader("");
        BufferedReader br = new BufferedReader(fr);
        String str;
        int i = 0;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
            String route[] = str.split(",");
            String source = route[0];
            String destination = route[1];
            int distance = Integer.parseInt(route[2].trim());
            String airFare = route[3];
            String time = route[4];
            Route rot = new Route(source, destination, distance, airFare, time);
            routeInfo[i] = rot;
            i++;
        }
        return routeInfo;
    }
    public void displayFlights(Route[] routeInfo){
        for(Route route: routeInfo)
            System.out.println(route);
    }
    public Route[] showDirectFlights(Route[] routeInfo, String fromCity)
    {
        int count=0;
        for(int i=0;i<routeInfo.length; i++)
        {
            if(routeInfo[i].getSource().equalsIgnoreCase(fromCity))
                count++;
        }
        Route[] flightCity=new Route[count];
        int j=0;
        for(int i=0; i<routeInfo.length;i++)
        {
            if(routeInfo[i].getSource().equalsIgnoreCase(fromCity))
            {
                flightCity[j]=routeInfo[i];
                j++;
            }
        }
        return flightCity;
    }
    Route[] sortDirectFlights (Route[]flightCity) {
        for (int i = 1; i < flightCity.length-1; i++) {
            for (int j = 0; j < flightCity.length - i; j++) {
                if (flightCity[j].getDestination().compareToIgnoreCase(flightCity[j + 1].getDestination()) > 0) {
                    Route temp = flightCity[j];
                    flightCity[j] = flightCity[j + 1];
                    flightCity[j + 1] = temp;
                }
            }
        }
        return flightCity;
    }
    static void showAllConnections(Route[] routeInfo, String fromCity, String toCity)
    {
        for(Route r:routeInfo)
        {
            if(r.getSource().equalsIgnoreCase(fromCity)&&r.getDestination().equalsIgnoreCase(toCity))
            {
                System.out.println(r);
                break;
            }
        }
        for (Route r:routeInfo)
        {
            if(r.getSource().equalsIgnoreCase(fromCity)){
                String temp=r.getDestination();
                System.out.println(r);
                System.out.println("-----Via This Route -----"+"------"+"Destination City--->"+"------"+toCity);
                System.out.println("");
                for(Route r1:routeInfo)
                {
                    if(r.getSource().equalsIgnoreCase(temp)&& r1.getDestination().equalsIgnoreCase(toCity))
                    {
                        System.out.println(r1);
                        showAllConnections(routeInfo,fromCity,temp);
                        showAllConnections(routeInfo,temp,toCity);
                    }
                }
            }
        }
    }
    }
