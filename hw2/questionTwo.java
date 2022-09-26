import java.io.*;
import java.lang.*;
import java.util.*;


class questionTwo {
	public static void main(String[] args) {
		try {
			BufferedReader br =
				new BufferedReader(new InputStreamReader(System.in));

			String str1 = br.readLine();
			String str2 = br.readLine();

			try {
				int num1 = Integer.parseInt(str1);
				int num2 = Integer.parseInt(str2);

				int[] numList1 = new int[Math.max(str1.length(), str2.length())];
				int[] numList2 = new int[numList1.length];
				int[] res = new int[numList1.length];

				// transform to numlist and add 0
				for (int i=numList1.length-1; i>=0; i--) {
					if (num1 == 0) {
						numList1[i] = 0;
					} else {
						numList1[i] = num1 % 10;
						num1 = (int)(Math.floor(num1 / 10));
					}

					if (num2 == 0) {
						numList2[i] = 0;
					} else {
						numList2[i] = num2 % 10;
						num2 = (int)(Math.floor(num2 / 10));	
					}
				}
				System.out.println("筆算: ");
				System.out.print("  ");

				for (int n1 : numList1) {
					System.out.print(n1);
				}
				System.out.println("");
				System.out.print("+ ");
				for (int n2 : numList2) {
					System.out.print(n2);
				}
				System.out.println("");

				// cal
				boolean addOne = false;		
				for (int j=numList1.length-1; j>=0; j--) {
					if (addOne) {
						res[j] = 1;
					} else {
						res[j] = 0;
					}

					if (j == 0 | (res[j] + numList1[j] + numList2[j]) < 10){
						res[j] = res[j] + numList1[j] + numList2[j];
						addOne = false;
					} else {
						res[j] = res[j] + numList1[j] + numList2[j] - 10;
						addOne = true;
					}
				}

				System.out.print("--");
				for (int k=0; k<res.length; k++) {
					System.out.print("-");
				}
				System.out.println("");
				System.out.print("  ");

				// print result
				for (int k=0; k<res.length; k++){
					System.out.print(res[k]);
				}
				System.out.println("");
			}

			catch (NumberFormatException e) {
			}

		}

		catch (IOException e) {
			System.out.println("標準入力において例外が発生しました。");
		}
	}
}
