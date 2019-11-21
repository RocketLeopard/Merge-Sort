class MergeSort {
    private int[] arr;
    private int[] temp;

    public MergeSort(int[] arr) {
        this.arr = arr;
        this.temp = new int[arr.length];
    }

    public void sort() {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int p1 = left;
        int p2 = mid + 1;
        int index = left;

        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while (p1 <= mid && p2 <= right) {
            temp[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while (p1 <= mid) {
            temp[index++] = arr[p1++];
        }
        while (p2 <= right) {
            temp[index++] = arr[p2++];
        }

        for (int i = 0; i <= right; i++) {
            arr[i] = temp[i];
        }
    }
}
