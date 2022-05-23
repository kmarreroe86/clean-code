package designpatterns.strategy;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class EntranceFeeCalculatorClient {

    private static Collection<FeeStrategy> strategies = List.of(
            new AdultFeeStrategy(),
            new ChildFeeStrategy()
    );


    public static double calculateFee(Visitor visitor, TicketType ticketType) {

        /* Reduce will throw if filter return more than one fee strategy for a visitor */
        Optional<FeeStrategy> strategy = strategies.stream()
                .filter(feeStrategy -> feeStrategy.accepts(visitor))
                .reduce((feeStrategy, feeStrategy2) -> {
                    throw new IllegalStateException("There must only be one strategy for this visitor");
                });

        return strategy.orElseThrow(IllegalStateException::new).calculate(ticketType);
    }

    public static void main(String[] args) {
        var visitor = new Visitor();
        visitor.setAge(13);
        var fee = calculateFee(visitor, TicketType.HALF_DAY);
        System.out.println("Fee: " + fee);

    }


}
