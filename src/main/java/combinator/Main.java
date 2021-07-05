package combinator;

import java.time.LocalDate;
import static combinator.CustomerRegistrationValidator.*;
import static combinator.CustomerRegistrationValidator.ValidationResult.SUCCESS;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+351931374191",
                LocalDate.of(2000,1,1)
        );

        //System.out.println(new CustomerValidationService().isValid(customer));

        // If valid we can store costumer in DB

        // Using combinator pattern
        var result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);

        System.out.println(result);

        if (result != SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
