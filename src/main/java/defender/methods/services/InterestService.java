package defender.methods.services;

import java.security.InvalidParameterException;

public interface InterestService {

    double interestRate();

    default double payment(double amount, int months) {
        if(months < 1) {
            throw new InvalidParameterException("Months must be greater than 0");
        }
        return amount * Math.pow(1 + interestRate() / 100, months);
    }
}
