package designpatterns.strategy;

public class ChildFeeStrategy implements FeeStrategy {
    private final double CHILD_PRICE_BASE = 100;

    @Override
    public double calculate(TicketType ticketType) {
        if (TicketType.HALF_DAY == ticketType) {
            return CHILD_PRICE_BASE * 0.2;
        } else if (TicketType.FULL_DAY == ticketType) {
            return CHILD_PRICE_BASE * 0.5;
        }

        throw new IllegalArgumentException("Ticket type not supported");
    }

    @Override
    public boolean accepts(Visitor visitor) {
        return visitor.getAge() <= 14;
    }
}
