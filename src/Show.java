import java.util.*;

public class Show {

    private String showName;

    private String showDate;

    private Cinema cinema;

    private ArrayList<Seat> seats;

    private int freeSeats;

    public Show(String showName, String showDate, Cinema cinema)

    {

        this.showName = showName;

        this.showDate = showDate;

        this.cinema = cinema;

    }

    public void loadSeats()

    {

        for (Row row : cinema.getRows())

        {

            for (Seat seat : row.getSeats())

            {

                seats.add(seat);

            }

        }

    }

    public int getFreeSeatsCount()

    {

        for (Seat seat : seats)

        {

            if (!seat.getReservationStatus())

            {

                freeSeats++;

            }

        }

        return freeSeats;

    }

    public void setShowName(String showName)

    {

        this.showName = showName;

    }

    public void setShowDate(String showDate)

    {

        this.showDate = showDate;

    }

    public void setTheatre(Cinema cinema)

    {

        this.cinema = cinema;

    }

    public String getShowName()

    {

        return showName;

    }

    public String getShowDate()

    {

        return showDate;

    }

    public Cinema getTheatre()

    {

        return cinema;

    }

    public ArrayList<Seat> getSeats()

    {

        return seats;

    }

}