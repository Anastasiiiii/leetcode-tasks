public class TernarySearchAl {
    public static void main(String[] args) {
        int l, r, p, key;
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 20};

        l = 0;
        r = 9;

        key = 5;

        p = ternarySearch(l, r, key, arr);
        System.out.println("Index of " + key + " is " + p);

        //Time complexity: O(2*log3n)
        //Auxiliary Space: O(log3n)

    }

    static int ternarySearch(int l, int r, int key, int arr[]) {
        if (r >= 1) {
            int mid1 = l + (r - 1) / 3;
            int mid2 = r - (r - 1) / 3;

            if ( arr[mid1] == key){
                return mid1;
            }
            if (arr[mid2] == key) {
                return mid2;
            }

            if(key < arr[mid1]) {
                return ternarySearch(l, mid1 - 1, key, arr);
            } else if (key > arr[mid2]) {
                return ternarySearch(mid2 + 1, r, key, arr);
            } else {
                return ternarySearch(mid1 + 1, mid2 - 1, key, arr);
            }
        }
        return -1;
    }
}
