public class SRotatedarray {
    public static void main(String[] args) {
        int nums[] = { 4, 5, 6, 7, 2, 1, 0 };
        int target = 4;
        System.out.println(Search(nums, target));
    }

    static int peakElement(int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] < arr[mid + 1]) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return s;
    }

    static int Search(int[] arr, int target) {
        int peakE = peakElement(arr);
        int f = binSearch(arr, target, 0, peakE);
        if (f != -1) {
            return f;
        }
        return binSearch(arr, target, peakE + 1, arr.length - 1);
    }

    static int binSearch(int[] mountainArr, int target, int s, int e) {
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (mountainArr[mid] == target) {
                return mid;
            }
            if (s > e) {
                if (mountainArr[mid] > target) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else {
                if (mountainArr[mid] > target) {
                    e = mid;
                } else {
                    s = mid + 1;
                }
            }
        }
        return -1;
    }
}
