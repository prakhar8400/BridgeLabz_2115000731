import java.util.Queue;
import java.util.LinkedList;

class PetrolPump {
    int petrol;
    int distance;

    public PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTour {

    public static int findStartingIndex(PetrolPump[] arr) {
        int n = arr.length;
        int start = 0;
        int end = 1;
        int currPetrol = arr[start].petrol - arr[start].distance;

        // Simulate the tour
        while (start != end || currPetrol < 0) {
            while (currPetrol < 0 && start != end) {
                currPetrol -= arr[start].petrol - arr[start].distance;
                start = (start + 1) % n;
                if (start == 0) {
                    return -1; // Not possible to complete the circuit
                }
            }
            currPetrol += arr[end].petrol - arr[end].distance;
            end = (end + 1) % n;
        }

        return start;
    }

    public static void main(String[] args) {
        PetrolPump[] arr = {
                new PetrolPump(4, 6),
                new PetrolPump(6, 5),
                new PetrolPump(7, 3),
                new PetrolPump(4, 5)
        };

        int startingIndex = findStartingIndex(arr);

        if (startingIndex == -1) {
            System.out.println("Cannot complete the circuit");
        } else {
            System.out.println("Starting index: " + startingIndex);
        }
    }
}
