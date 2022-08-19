package amqp;

//import com.example.apigateway.Model.Product.Product;
//import com.example.apigateway.Model.Product.ProductCreationDto;
import com.example.demo.model.CurrencyExchangeDto;
import com.example.demo.service.CurrencyService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @RabbitListener(queues = "#{queue.name}")
    public String receive(CurrencyExchangeDto currencyExchangeDto) {
        String oldCurrency = currencyExchangeDto.getOldCurrency();
        String newCurrency = currencyExchangeDto.getNewCurrency();
        System.out.println("received ");
        CurrencyService currencyService = new CurrencyService();
        String exchangeRate = currencyService.getExchangeRateSpecified(oldCurrency, newCurrency);
        return exchangeRate;
    }
}
