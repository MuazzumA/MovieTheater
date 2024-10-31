package theater.project.MovieTheater.API.DTO.Payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BestPaymentDayDTO {
    private LocalDate bestDay;
    private Double averageTotal;
}
