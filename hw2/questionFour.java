import java.io.*;
import java.lang.*;
import java.util.*;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.lang3.*;

class SortByBread implements Comparator<String[]> {  
	public int compare(String[] a, String[] b) {  
		return a[2].compareTo(b[2]);
	}  
}

class questionFour {
	public static void main(String[] args) {
		try {
			//ファイルを開く
			FileReader fr = new FileReader("BreadSale-utf8.csv");
			CSVReader reader = new CSVReader(fr);

			//(A)の条件:読み込んでいない行が存在
			List<String[]> dataList = new ArrayList<>();
			String[] i;
			while ((i = reader.readNext()) != null) {
				dataList.add(i);
			}
			dataList.remove(0);

			//計算結果を表す変数を初期化する
			int price, num;
			int tempRes = 0;
			String key = "";

			System.out.println("月ごとの売上金額:");
			for (String[] data : dataList) { //(C)の条件:ファイルから行が読み込み不可能 & 1行ずつ読み込む
				price = Integer.parseInt(data[3]);
				num = Integer.parseInt(data[4]);

				if (key.equals(data[0])) { //(B)の条件:1つ前に読み込んだ行のキーと、今読み込んだ行のキーが同じ
					tempRes = tempRes + (price * num); //結果を計算
				} else { //計算結果に対する処理をする
					if (!key.equals("")) {
						System.out.println(key + "の売上金額は" + tempRes + "円です。");
					}
					key = data[0];
					tempRes = price * num;
				}
			}
			System.out.println(key + "の売上金額は" + tempRes + "円です。");

			//計算結果を表す変数を初期化する
			key = "";
			tempRes = 0;
			String month = "";

			System.out.println("日ごとの売上金額:");
			for (String[] data : dataList) { //(C)の条件:ファイルから行が読み込み不可能 & 1行ずつ読み込む
				price = Integer.parseInt(data[3]);
				num = Integer.parseInt(data[4]);

				if (key.equals(data[1])) { //(B)の条件:1つ前に読み込んだ行のキーと、今読み込んだ行のキーが同じ
					tempRes = tempRes + (price * num); //結果を計算
				} else { //計算結果に対する処理をする
					if (!key.equals("")) {
						System.out.println(month + key + "の売上金額は" + tempRes + "円です。");
					}
					key = data[1];
					tempRes = price * num;
				}
				month = data[0];
			}
			System.out.println(month + key + "の売上金額は" + tempRes + "円です。");

			//計算結果を表す変数を初期化する
			key = "";
			tempRes = 0;

			//sort by bread
			Collections.sort(dataList, new SortByBread());

			System.out.println("パンの名前ごとの売上金額:");
			for (String[] data : dataList) { //(C)の条件:ファイルから行が読み込み不可能 & 1行ずつ読み込む
				price = Integer.parseInt(data[3]);
				num = Integer.parseInt(data[4]);

				if (key.equals(data[2])) { //(B)の条件:1つ前に読み込んだ行のキーと、今読み込んだ行のキーが同じ
					tempRes = tempRes + (price * num); //結果を計算
				} else { //計算結果に対する処理をする
					if (!key.equals("")) {
						System.out.println(key + "の売上金額は" + tempRes + "円です。");
					}
					key = data[2];
					tempRes = price * num;
				}
			}
			System.out.println(key + "の売上金額は" + tempRes + "円です。");

			fr.close();
		}

		catch (IOException e) {
			System.out.println("入力された名前のファイルは存在しません");
		}
		catch(CsvException ce) {
		}
	}
}
