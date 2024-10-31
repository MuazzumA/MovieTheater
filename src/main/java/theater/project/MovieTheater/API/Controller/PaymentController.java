package theater.project.MovieTheater.API.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import theater.project.MovieTheater.API.DTO.Payment.BestPaymentDayDTO;
import theater.project.MovieTheater.DataPersistent.Entity.Movie;
import theater.project.MovieTheater.DataPersistent.Entity.Payment;
import theater.project.MovieTheater.Service.Impl.HomeService;
import theater.project.MovieTheater.Service.PaymentService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping
    public List<Payment> getAllPayment(){
        return paymentService.getAllPayments();
    }

}
