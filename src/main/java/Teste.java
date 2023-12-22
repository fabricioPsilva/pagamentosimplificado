import java.util.Arrays;

public class Teste {

//	public static void main(String[] args) {
		
		public void bubbleSort(int[] arr) {
	        int n = arr.length;
	        
	        for (int i = 0; i < n - 1; i++) {
	            for (int j = 0; j < n - i - 1; j++) {
	                // Compara elementos adjacentes e troca se estiverem na ordem errada
	                if (arr[j] > arr[j + 1]) {
	                    int temp = arr[j];
	                    arr[j] = arr[j + 1];
	                    arr[j + 1] = temp;
	                }
	            }
	        }
	    }

	    public static void main(String[] args) {
	        int[] arr = {64, 34, 25, 12, 22, 11, 90};
	        int n = arr.length;
	        
	        String teste = "TESTE";
	        
	        teste.equals(teste);
	        
	        Arrays.sort(arr);

	        Teste sorter = new Teste();
	        sorter.bubbleSort(arr);

	        System.out.println("Array ordenado:");
	        for (int i : arr) {
	            System.out.print(i + " ");
	        }
	    }


}
