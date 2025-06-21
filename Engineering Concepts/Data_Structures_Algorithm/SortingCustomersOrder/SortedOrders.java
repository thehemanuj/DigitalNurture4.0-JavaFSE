package SortingCustomersOrder;

public class SortedOrders {
    
    public Order[] bubbleSort(Order[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j].getPrice() > a[j + 1].getPrice()) {
                    Order temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    public Order[] quickSort(Order[] a) {
    quickSortByPrice(a, 0, a.length - 1);
    return a;
    }

    private void quickSortByPrice(Order[] a, int low, int high) {
        if (low < high) {
            int pi = partition(a, low, high);
            quickSortByPrice(a, low, pi - 1);
            quickSortByPrice(a, pi + 1, high);
        }
    }

    private int partition(Order[] a, int low, int high) {
        double pivot = a[high].getPrice();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (a[j].getPrice() <= pivot) {
                i++;
                Order temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        Order temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;

        return i + 1;
    }
    
}
