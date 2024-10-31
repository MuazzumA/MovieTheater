package theater.project.MovieTheater.DataPersistent.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import theater.project.MovieTheater.API.DTO.Payment.BestPaymentDayDTO;
import theater.project.MovieTheater.DataPersistent.Entity.Payment;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    //Get all payment
    @Query("SELECT p FROM Payment p")
    List<Payment> getAllPayments();

    @Query("SELECT p FROM Payment p JOIN p.tickets t WHERE t.movie.id = :movieId")
    List<Payment> getPaymentsByMovieId(@Param("movieId") Long movieId);

    @Query("SELECT p.paymentDate " +
            "FROM Payment p " +
            "WHERE p.paymentDate BETWEEN :startDate AND :endDate " +
            "GROUP BY p.paymentDate " +
            "ORDER BY SUM(p.totalBalance) DESC" )
    LocalDate findBestDayBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT AVG(p.totalBalance) " +
            "FROM Payment p " +
            "WHERE p.paymentDate BETWEEN :startDate AND :endDate " +
            "GROUP BY p.paymentDate " +
            "ORDER BY AVG(p.totalBalance) DESC")
    Double findBestDayAverageBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
