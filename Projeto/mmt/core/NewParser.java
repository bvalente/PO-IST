package mmt.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.time.LocalTime;
import java.time.LocalDate;

import mmt.core.exceptions.ImportFileException;

import mmt.core.exceptions.NoSuchStationNameException;

public class NewParser {

  private TrainCompany _trainCompany;

  public TrainCompany parseFile(String fileName) throws ImportFileException {

    _trainCompany = new TrainCompany();

    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
      String line;

      while ((line = reader.readLine()) != null) {
        parseLine(line);
      }
    } catch (IOException ioe) {
      throw new ImportFileException(ioe);
    }

    return _trainCompany;
  }

  private void parseLine(String line) throws ImportFileException {
    String[] components = line.split("\\|");

    switch (components[0]) {
      case "PASSENGER":
        parsePassenger(components);
        break;

      case "SERVICE":
        parseService(components);
        break;

      case "ITINERARY":
        parseItinerary(components);
        break;

     default:
       throw new ImportFileException("invalid type of line: " + components[0]);
    }
  }

  private void parsePassenger(String[] components) throws ImportFileException {
    if (components.length != 2)
      throw new ImportFileException("invalid number of arguments in passenger line: " + components.length);

    String passengerName = components[1];

    _trainCompany.registerPassenger(passengerName);
  }

  private void parseService(String[] components) {
      // ImportFileException (?)
    double cost = Double.parseDouble(components[2]);
    int serviceId = Integer.parseInt(components[1]);
    TrainStop trainstop;
    Station station;

    // criar o serviço com o id e custo e associar ao TrainCompany
    Service service = _trainCompany.registerService(serviceId, cost);

    for (int i = 3; i < components.length; i += 2) {
      String time = components[i];
      String stationName = components[i + 1];
      LocalTime ltime = LocalTime.parse(time);

      // adicionar TrainStop com ltime e Station com o nome stationName

      //primeiro ver se ja existe uma Station com stationName
      //se nao existir, criamos a Station
      try{
          station = _trainCompany.searchStationName(stationName);
      } catch (NoSuchStationNameException e){
          //temos de mandar o traincompany criar a station e retornar o ponteiro
          station = _trainCompany.registerStation(stationName);
      }

      //registers the TrainStop in the Station and adds it to the service
      station.registerTrainStop(ltime, service);
    }
  }

  private void parseItinerary(String[] components) throws ImportFileException{
    if (components.length < 4)
      throw new ImportFileException("Invalid number of elements in itinerary line: " + components.length);

    int passengerId = Integer.parseInt(components[1]);
    LocalDate date = LocalDate.parse(components[2]);

    // criar um itinerário com data indicada

    for (int i = 3; i < components.length; i++) {
      String segmentDescription[] = components[i].split("/");

      int serviceId = Integer.parseInt(segmentDescription[0]);
      String departureTrainStop = segmentDescription[1];
      String arrivalTrainStop = segmentDescription[2];

      // criar segmento com paragem em departureTrainStop e arrivalTrainStop
      // adicionar segmento ao itinerario
    }

    // adicionar o itinerário ao passageiro
  }
}
