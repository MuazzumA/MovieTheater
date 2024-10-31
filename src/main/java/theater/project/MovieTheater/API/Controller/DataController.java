package theater.project.MovieTheater.API.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import theater.project.MovieTheater.API.DTO.Payment.BestPaymentDayDTO;
import theater.project.MovieTheater.DataPersistent.Entity.Movie;
import theater.project.MovieTheater.DataPersistent.Repo.PaymentRepository;
import theater.project.MovieTheater.Service.Impl.HomeService;
import theater.project.MovieTheater.Service.PaymentService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class DataController {

    private final PaymentService paymentService;
    private final PaymentRepository paymentRepository;

    @GetMapping("/best_day")
    public ResponseEntity<BestPaymentDayDTO> getBestPaymentDay(
            @RequestParam("startDate") LocalDate startDate,
            @RequestParam("endDate") LocalDate endDate) {

        LocalDate bestDay = paymentRepository.findBestDayBetweenDates(startDate, endDate);

        double bestDayAvg = paymentRepository.findBestDayAverageBetweenDates(startDate, endDate);

        if (bestDay != null) {
            BestPaymentDayDTO bestPaymentDayDTO = new BestPaymentDayDTO(bestDay, bestDayAvg);
            return ResponseEntity.ok(bestPaymentDayDTO);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
