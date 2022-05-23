package functional.workingWithStream;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {

        Comparator<Employee> comparator = Comparator.comparing((Employee e) -> e.name);
        Employee[] arr = {
          new Employee("John", 42),
          new Employee("Jane", 24)
        };
        List<Employee> employeeArrayList = Arrays.asList(arr);
        employeeArrayList.sort((e1, e2) -> e1.name.compareTo(e2.name));

    }


}

class Employee {
    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class DateBucket {
    final Instant from;
    final Instant to;

    DateBucket(Instant from, Instant to) {
        this.from = from;
        this.to = to;
    }

    /*public static List<DateBucket> bucketize(ZonedDateTime fromDate,
                                             ZonedDateTime toDate,
                                             int bucketSize,
                                             ChronoUnit bucketSizeUnit) {
        List<DateBucket> buckets = new ArrayList<>();
        boolean reachedDate = false;
        for (int i = 0; !reachedDate; i++) {
            ZonedDateTime minDate = fromDate.plus(i * bucketSize, bucketSizeUnit);
            ZonedDateTime maxDate = fromDate.plus((i + 1) * bucketSize, bucketSizeUnit);
            reachedDate = toDate.isBefore(maxDate);
            buckets.add(new DateBucket(minDate.toInstant(), maxDate.toInstant()));
        }

        return buckets;
    }*/

    public static List<DateBucket> bucketize(ZonedDateTime fromDate,
                                             ZonedDateTime toDate,
                                             int bucketSize,
                                             ChronoUnit bucketSizeUnit) {

        Stream<Integer> infiniteStream = Stream.iterate(0, i -> i + 1);
        List<DateBucket> buckets = infiniteStream
                .filter(i -> toDate.isBefore(fromDate.plus((i + 1) * bucketSize, bucketSizeUnit)))
                .map(i -> new DateBucket(fromDate.plus(i * bucketSize, bucketSizeUnit).toInstant(),
                                         fromDate.plus((i + 1) * bucketSize, bucketSizeUnit).toInstant())
                )
                .collect(Collectors.toList());

        return buckets;
    }
}

