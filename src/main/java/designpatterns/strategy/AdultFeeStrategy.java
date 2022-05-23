package designpatterns.strategy;

public class AdultFeeStrategy implements FeeStrategy {

    private final double ADULT_PRICE_BASE = 100;

    @Override
    public double calculate(TicketType ticketType) {
        if (TicketType.HALF_DAY == ticketType) {
            return ADULT_PRICE_BASE * 0.6;
        } else if (TicketType.FULL_DAY == ticketType) {
            return ADULT_PRICE_BASE * 1.2;
        }
        throw new IllegalArgumentException("Ticket type not supported");
    }

    @Override
    public boolean accepts(Visitor visitor) {
        return visitor.getAge() > 14;
    }
}
