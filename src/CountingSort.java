import java.util.Arrays;

/* Tugas 2 Struktur Data */
/* Soal nomor 2 */
class CountingSort{
    /* Fungsi untuk sort count */
    void countSort(int[] arr, int size){
        int[] output = new int[size + 1];

        /* Mencari nilai terbesar dalam array */
        int max = arr[0];

        for (int i = 1; i < size; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        /*
        * Mengubah semua nilai dalam array menjadi 0 terlebih dahulu
        * ke dalam variable count
        */
        int[] count = new int[max + 1];

        for (int j = 0; j < max; ++j) {
            count[j] = 0;
        }

        /*
        * Memasukkan nilai array ke dalam variable count
        */
        for (int i = 0; i < size; i++) {
            count[arr[i]]++;
        }

        /*
        * Menambahkan nilai kumulatif dari variable count untuk setiap array
        */
        for (int i = 1; i <= max; i++){
            count[i] += count[i - 1];
        }

        /*
        * Mencari index dari setiap elemen dari array awal,
        * lalu dimasukkan kedalam variable output
        */
        for (int i = size - 1; i >= 0; i--){
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        /*
        * Mengcopy elemen yang telah diurutkan kedalam array awal menggunakan System.arraycopy.
        */
        if (size >= 0) {
            for (int i = 0; i < size; i++) {
                arr[i] = output[i];
            }
        }
    }

    /* Main function */
    public static void main(String[]args){
        int[] data = {4, 2, 3, 1, 5, 6};
        int size = data.length;

        System.out.println("Data sebelum diurutkan menggunakan Counting-sort:");
        System.out.println(Arrays.toString(data));

        CountingSort cs = new CountingSort();
        cs.countSort(data, size);

        System.out.println("\nData setelah diurutkan menggunakan Counting-sort:");
        System.out.println(Arrays.toString(data));
    }
}