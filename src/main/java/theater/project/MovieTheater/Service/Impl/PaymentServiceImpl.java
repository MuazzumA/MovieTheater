package theater.project.MovieTheater.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import theater.project.MovieTheater.API.DTO.Payment.BestPaymentDayDTO;
import theater.project.MovieTheater.DataPersistent.Entity.Movie;
import theater.project.MovieTheater.DataPersistent.Entity.Payment;
import theater.project.MovieTheater.DataPersistent.Repo.MovieRepository;
import theater.project.MovieTheater.DataPersistent.Repo.PaymentRepository;
import theater.project.MovieTheater.Service.PaymentService;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public BestPaymentDayDTO getBestDayBetweenDatesWithAvg(LocalDate startDate, LocalDate endDate) {
        LocalDate bestDay = paymentRepository.findBestDayBetweenDates(startDate, endDate);

        double bestDayAvg = paymentRepository.findBestDayAverageBetweenDates(startDate, endDate);

        return new BestPaymentDayDTO(bestDay, bestDayAvg);
    }


}
