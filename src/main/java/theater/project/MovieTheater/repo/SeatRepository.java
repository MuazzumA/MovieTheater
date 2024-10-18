package theater.project.MovieTheater.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import theater.project.MovieTheater.Entity.Seat;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    List<Seat> getAllSeats();

    @Query("SELECT s FROM Seat s WHERE s.id = :seatId")
    Seat getSeatById(@Param("seatId") Long id); // Corrected method signature

    // Assuming seatNumber is unique, else change the method name to indicate it returns a list
    @Query("SELECT s FROM Seat s WHERE s.seatNumber = :seatNumber")
    Seat getSeatBySeatNumber(@Param("seatNumber") String seatNumber);

    //@Query("SELECT s FROM Seat s WHERE s.isOccupied = false AND s.id IN :seatIds")
    //List<Seat> getAvailableSeats(@Param("seatIds") List<Long> seatIds); // Changed method name for clarity

}