import java.util.Optional;

public class Main {
    @SuppressWarnings("all")
    public static void main(final String[] args) {
        final Double answer = getGensokyoBus()
            .map(bus -> bus.gottenOn(3)) // 紅魔館
            .map(bus -> bus.gottenOff(1))
            .map(bus -> bus.gottenOn(0.5)) // 白玉楼
            .map(bus -> bus.gottenOff(2)) // 八雲さん家
            .map(Bus::getPassengerCount)
            .orElse(0d);

        assert answer == 0;
    }

    private static Optional<Bus> getGensokyoBus() {
        return Optional.empty();
    }

    private static class Bus {
        private final double passengerCount;

        Bus(final double passengerCount) {
            this.passengerCount = passengerCount;
        }

        double getPassengerCount() {
            return passengerCount;
        }

        Bus gottenOn(final double passengerCount) {
            return new Bus(this.passengerCount + passengerCount);
        }

        Bus gottenOff(final double passengerCount) {
            return new Bus(this.passengerCount - passengerCount);
        }
    }
}
