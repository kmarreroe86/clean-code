package designpatterns.strategy;

public interface FeeStrategy {

    double calculate(TicketType ticketType);

    boolean accepts(Visitor visitor);
}
