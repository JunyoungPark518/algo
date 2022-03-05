package self.java.util;

import java.util.List;

public class SummationWithStream {

    private Double a;
    private Double b;

    private List<Double> sum;

    private SummationWithStream(List<Double> sum) {
        this.sum = sum;
    }

    public Double summary1() {
        final Double reduce = sum.stream().reduce((double) 0, (a, b) -> a + b);
        return reduce;
    }

    public Double summary2() {
        return sum.stream().mapToDouble(Double::valueOf).sum();
    }
}
