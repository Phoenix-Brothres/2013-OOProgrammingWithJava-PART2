
import java.util.Scanner;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author WONSEOB
 */
public class AirPortManager {

    private Scanner reader;
    private ArrayList<Airplane> planes;
    private ArrayList<Flight> flights;

    public AirPortManager(Scanner reader) {
        this.reader = reader;
        this.planes = new ArrayList<Airplane>();
        this.flights = new ArrayList<Flight>();
    }

    public void start() {
        airportPanel();
        flightService();
    }

    private void airportPanel() {
        String opt = "";
        System.out.println("Airport panel\n"
                + "--------------------\n\n");

        while (true) {
            System.out.println("Choose operation:\n"
                    + "[1] Add airplane\n"
                    + "[2] Add flight\n"
                    + "[x] Exit\n"
                    + "> ");
            opt = reader.nextLine();
            if (opt.equals("x")) {
                break;
            }
            if (opt.equals("1")) {
                addAirplane();
            } else if (opt.equals("2")) {
                addFlight();
            }
        }
    }

    private void addAirplane() {
        String id = "";
        int capa;
        System.out.println("Give plane ID: ");
        id = reader.nextLine();
        System.out.println("Give plane capacity: ");
        capa = Integer.parseInt(reader.nextLine());
        this.planes.add(new Airplane(id, capa));
    }

    private void addFlight() {
        String id = "";
        String dep = "";
        String desti = "";
        System.out.println("Give plane ID: ");
        id = reader.nextLine();
        System.out.println("Give departure airport code: ");
        dep = reader.nextLine();
        System.out.println("Give destination airport code: ");
        desti = reader.nextLine();
        this.flights.add(new Flight(getById(id, planes), dep, desti));
    }

    private Airplane getById(String id, ArrayList<Airplane> planes) {
        for (Airplane p : planes) {
            if (id.equals(p.getId())) {
                return p;
            }
        }
        return null;
    }

    private void flightService() {
        String opt = "";
        System.out.println("Flight service\n"
                + "------------\n\n");
        while (true) {
            System.out.println("Choose operation:\n"
                    + "[1] Print planes\n"
                    + "[2] Print flights\n"
                    + "[3] Print plane info\n"
                    + "[x] Quit\n"
                    + "> ");
            opt = reader.nextLine();
            if (opt.equals("x")) {
                break;
            }
            if (opt.equals("1")) {
                printPlanes();
            } else if (opt.equals("2")) {
                printFlights();
            } else if (opt.equals("3")) {
                printPlaneInfo();
            }
        }
    }

    private void printPlanes() {
        for (Airplane p : planes) {
            System.out.println(p);
        }
    }

    private void printFlights() {
        for (Flight f : flights) {
            System.out.println(f);
        }
    }

    private void printPlaneInfo() {
        String id;
        System.out.println("Give plane ID: ");
        id = reader.nextLine();
        System.out.println(getById(id, planes));
    }
}
