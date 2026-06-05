package queue;

import java.util.LinkedList;
import java.util.Queue;

public class DesignASharedMobilitySystem {
}


class RideSharingSystem {
    Queue<Integer> guests;
    Queue<Integer> drivers;
    public RideSharingSystem() {
        guests = new LinkedList<Integer>();
        drivers = new LinkedList<Integer>();
    }

    public void addRider(int riderId) {
        guests.add(riderId);
    }

    public void addDriver(int driverId) {
        drivers.add(driverId);
    }

    public int[] matchDriverWithRider() {
        if (!guests.isEmpty() && !drivers.isEmpty()) {
            Integer riderId = guests.poll();
            Integer driverId = drivers.poll();
            return new int[] {riderId, driverId};
        }
        return new int[]{-1,-1};
    }

    public void cancelRider(int riderId) {
        guests.remove(riderId);
    }
}