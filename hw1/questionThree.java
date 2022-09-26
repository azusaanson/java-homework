import java.io.*;
import java.lang.*;
import java.util.*;
import com.google.common.collect.HashBasedTable;


class questionThree {
	public static void main(String[] args) {
		String str;

		try {
			FileReader fr = new FileReader("StudentData-utf8.txt");
			BufferedReader br = new BufferedReader(fr);

			HashBasedTable<String, String, String> studentTable = HashBasedTable.create();

			while(br.ready()){
				str = br.readLine();
				String[] parts = str.split(",");
				studentTable.put(parts[0], "氏名", parts[1]);
				studentTable.put(parts[0], "住所", parts[2]);
			}

			br.close();
			fr.close();
		

			try {
				BufferedReader br1 =
					new BufferedReader(new InputStreamReader(System.in));

				String str1 = br1.readLine();

				Map<String, String> studentColumn = studentTable.column("氏名");

				if (str1.equals("1")) {
					System.out.println(studentColumn);

				} else if (str1.equals("2")) {
					for (String hMapkey : studentColumn.keySet()) {
						System.out.println(studentTable.row(hMapkey));
					}

				} else if (str1.equals("3")) {
					String str2 = br1.readLine();
					System.out.println(studentTable.row(str2));
					
				} else {
					System.out.println("無効な入力。");
				}
			}

			catch (IOException e) {
				System.out.println("標準入力において例外が発生しました。");
			}

		}

		catch (IOException e) {
			System.out.println("入力された名前のファイルは存在しません");
		}
	}
}
