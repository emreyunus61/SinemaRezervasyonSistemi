import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int option = 0;

        ArrayList<Show > shows = new ArrayList<Show>();

        ArrayList<Cinema> cinemas = new ArrayList<Cinema>();

        ArrayList<Booking> bookings = new ArrayList<Booking>();

        ArrayList<Customer> customers = new ArrayList<Customer>();

        Scanner select = new Scanner(System.in);

        Scanner choice = new Scanner(System.in);

//Test Objects

        Cinema testCinema = new Cinema(1, "Sinemalar");

        testCinema.createRows(1, 10, 7);

        cinemas.add(testCinema);

        shows.add(new Show("Sadece Sen- Film","Tarih: 05/04/2018 Tür: Romantik", cinemas.get(0)));

        shows.add(new Show("7. Koğuştaki Mucize - Film", "Tarih: 05/04/2018 Tür: Dram", cinemas.get(0)));

        shows.add(new Show("Kelebeğin Rüyası- Film", "Tarih: 05/04/2018 Tür: Romantik", cinemas.get(0)));

        shows.add(new Show("Ayla- Film", "Tarih: 05/04/2018 Tür: Dram", cinemas.get(0)));

        shows.add(new Show("Oflu Hoca'nın Şifresi - Film", "Tarih: 05/04/2018 Tür: Dram/Komedi", cinemas.get(0)));

        do

        {

            System.out.println("------------------------------------");

            System.out.println("Sinema Rezervasyon Sistemi ");

            System.out.println("------------------------------------\n");

            System.out.println("Sinema Filmi Eklemek için Lütfen 1 basınız");

            System.out.println("Eklediğiniz Filmleri görmek için Lütfen 2'e basınız");

            System.out.println("Fimleri Görüntülemek için Lütfen 3'e basınız");

            System.out.println("Rezervasyon Yapmak İçin Lütfen 4'e basınız");

            System.out.println("Rezervasyonunuzu İptal Etmek İçin Lütfen 5'e basınız");

            System.out.println("Çıkmak İçin Lütfen 6'ya basınız");

            System.out.print("Seçeneği Giriniz: ");

            option = select.nextInt();

            if(option==1)

            {

                System.out.println("Sinema Ekle");

                System.out.println("-------------------------\n");

                System.out.print("\n" + "Sinema için bir isim girin: \n");

                String theatreName = choice.nextLine();

                System.out.print("\n" + "Sinema için bir numara girin: \n");

                int theatreNumber = choice.nextInt();

                System.out.println("\n" + "Satır sayısını girin:");

                int rowCount = choice.nextInt();

                Cinema cinema = new Cinema(theatreNumber, theatreName);

                cinema.createRows(1, 10, rowCount);

                cinema.createRows(1, 5, 5);

                cinemas.add(cinema);

            }

            if(option==2)

            {

                System.out.println("Eklediğiniz Sinema Filmleri ");

                System.out.println("-------------------------\n");

                System.out.println("\n" + "Sinema tarihini girin: [DD/MM/YYYY]:");

                String showDate = choice.nextLine();

                System.out.print("Sinemanın adını girin: \n");

                String showName = choice.nextLine();

                System.out.println("\n" + "Numarayı yazarak bir sinema seçin:");

                for (int i = 0; i < cinemas.size(); i++)

                {

                    System.out.println(i+1 + " " + cinemas.get(i).getDescription());

                }

                int theatreNumber = choice.nextInt();

                shows.add(new Show(showName, showDate, cinemas.get(theatreNumber-1)));

            }

            if(option==3)

            {

                System.out.println("Fimleri Görüntüleme ");

                System.out.println("-------------------------\n");

                for (int i = 0; i < shows.size(); i++)

                {

                    int showNumber = i+1;

                    System.out.println("Film Numarası: " + showNumber);;

                    System.out.println("Film Adı: " + shows.get(i).getShowName());

                    System.out.println("Film Tarih/Tür : " + shows.get(i).getShowDate());

//System.out.println("Seat Status:" + shows.get(i).getFreeSeatsCount());

                    System.out.println("\n");

                }

                System.out.println("Film Listesinin Sonu\n");

            }

            if(option==4)

            {

                System.out.println("Rezervasyon Yapma ");

                System.out.println("-------------------------\n");

                Random rnd = new Random();

                int costumerId = rnd.nextInt(999);

                Customer customer = new Customer(costumerId);

                customers.add(customer);

                for (int i = 0; i< shows.size(); i++)

                {

                    int showNumber = i+1;

                    System.out.println("Film Numarası: " + showNumber);;

                    System.out.println("Film Adı: " + shows.get(i).getShowName());

                    System.out.println("Film Tarih/Tür: " + shows.get(i).getShowDate());

                    System.out.print("\n");

                }

                System.out.println("-------------------------");

                System.out.print("\n" + " Rezerve ediceğiniz filmin numarasını girin: ");

                int showNumber = choice.nextInt();

                int repeat = 0;

                System.out.println();

                do {

                    shows.get(showNumber-1).getTheatre().printSeatPlan();

                    System.out.print("Oturacağınız bloğu seçin: ");

                    int selectedRow = choice.nextInt();

                    System.out.print("Oturacağınız koltuğu seçin: ");

                    int selectedSeat = choice.nextInt();

                    System.out.println();

                    Booking booking = new Booking(customer, shows.get(showNumber-1));

                    if (booking.reserveSeat(selectedRow-1, selectedSeat-1)) {

                        bookings.add(booking);

                        System.out.println("\n" + "Koltuk artık size ayrıldı.");

                    }

                    else {

                        System.out.println("\n" + "Üzgünüm koltuk zaten ayrılmış.");

                    }

                    System.out.println();

                    System.out.print("Başka bir koltuk rezerve etmek için 1 veya kontrol etmek için 2 girin\n: ");

                    repeat = choice.nextInt();

                } while (repeat == 1);

                System.out.println();

                System.out.println("Faturanız");

                System.out.println("-------------------------");

                int totalCost = 0;

                for (Booking booking : bookings)

                {

                    if (booking.getCostumer().getId() == customer.getId())

                    {

                        totalCost += booking.getCost();

                    }

                }

                System.out.println("Müşteri ID: " + customer.getId());

                System.out.println("\n" + "Toplam ücret: " + totalCost + " TL");

                System.out.println();

            }

            if(option==5)

            {

                System.out.println("Rezervasyonunuzu İptali");

                System.out.println("-------------------------\n");

                System.out.print("Müşteri ID girin: ");

                int customerId = choice.nextInt();

                for (Customer customer : customers) {

                    if (customer.getId() == customerId)

                    {

                        for(Booking booking : bookings)

                        {

                            if (booking.getCostumer().getId() == customer.getId())

                            {

                                if (booking.unreserveSeat())

                                {

                                }

                            }

                        }

                        System.out.println("\n" + "Rezervasyonunuz iptal edildi!");

                    }

                }

                System.out.println();

            }

            if(option==6)

            {

                System.exit(0);

            }

        }while(true);

    }
}
