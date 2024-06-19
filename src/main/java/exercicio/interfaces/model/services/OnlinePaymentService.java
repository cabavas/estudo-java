package exercicio.interfaces.model.services;

public interface OnlinePaymentService {
    double paymentFee(double amount);
    double interest(double amount, int months);
}
