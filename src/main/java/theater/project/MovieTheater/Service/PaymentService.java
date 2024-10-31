package theater.project.MovieTheater.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import theater.project.MovieTheater.API.DTO.Movie.CreateMovieRequestDTO;
import theater.project.MovieTheater.API.DTO.Movie.ShowMovieResponseDTO;
import theater.project.MovieTheater.API.DTO.Payment.BestPaymentDayDTO;
import theater.project.MovieTheater.DataPersistent.Entity.Movie;
import theater.project.MovieTheater.DataPersistent.Entity.Payment;
import theater.project.MovieTheater.Exception.MovieNotFoundException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public interface PaymentService {
    List<Payment> getAllPayments();
    BestPaymentDayDTO getBestDayBetweenDatesWithAvg(LocalDate startDate, LocalDate endDate);
}
