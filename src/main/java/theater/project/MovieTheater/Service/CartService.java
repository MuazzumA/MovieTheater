package theater.project.MovieTheater.Service;

import theater.project.MovieTheater.API.DTO.Payment.CardRequestDTO;
import theater.project.MovieTheater.DataPersistent.Entity.Payment;

public interface CartService  {
    Payment processCardDetails(CardRequestDTO requestDTO);
}
