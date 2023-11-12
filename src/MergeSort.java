import java.util.Arrays;

/* Tugas 2 Struktur Data */
/* Soal nomor 1 */
class MergeSort {
    /* Function merge untuk menggabungkan 2 sub array */
    void merge(int[] arr, int left, int mid, int right) {
        /* Mencari ukuran dari sub array untuk digabung */
        int n1 = mid - left + 1;
        int n2 = right - mid;

        /* Inisiasi variable untuk penyimpanan sementara atau temporary */
        int[] tempLeft = new int[n1];
        int[] tempRight = new int[n2];

        /* Mengcopy data array kedalam variable temp */
        for (int i = 0; i < n1; i++){
            tempLeft[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++){
            tempRight[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;

        /* Menginisiasi index dari sub array yang telah digabung */
        int k = left;
        while(i < n1 && j < n2){
            if(tempLeft[i] < tempRight[j]) {
                arr[k] = tempLeft[i];
                i++;
            }else {
                arr[k] = tempRight[j];
                j++;
            }
            k++;
        }

        /* Mengcopy sisa elemen dari variable tempLeft jika masih ada */
        while(i < n1) {
            arr[k] = tempLeft[i];
            i++;
            k++;
        }

        /* Mengcopy sisa elemen dari variable tempRight jika masih ada */
        while(j < n2) {
            arr[k] = tempRight[j];
            j++;
            k++;
        }
    }

    /*
    * Function sort untuk mengurutkan elemen array
    * Function ini merupakan recursive function
    */
    void sort(int[] arr, int left, int right) {
        if (left < right) {
            /* Mencari titik tengah */
            int mid = left + (right - left) / 2;

            /* Mengurutkan setengah elemen pertama dan setengah elemen kedua dalam array */
            sort(arr, left, mid);
            sort(arr, mid + 1, right);

            /*
            * Menggabungkan elemen yang telah diurutkan tadi dengan menggunakan function merge
            * yang telah dibuat
            */
            merge(arr, left, mid, right);
        }
    }

    /* Main function */
    public static void main(String[] args) {
        int[] data = {12, 11, 13, 6, 5, 7};

        System.out.println("Data sebelum diurutkan menggunakan Merge-sort:");
        System.out.println(Arrays.toString(data));

        MergeSort ob = new MergeSort();
        ob.sort(data, 0, data.length - 1);

        System.out.println("\nData setelah diurutkan menggunakan Merge-sort:");
        System.out.println(Arrays.toString(data));
    }
}