import java.io.*;
import java.lang.*;
import java.util.*;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.lang3.*;


class questionTwo {
	public static void main(String[] args) {
		try {
			//File Reader
			FileReader fr = new FileReader("LibraryBook-utf8.csv");
			CSVReader reader = new CSVReader(fr);

			HashMap<String, String> hMap = new HashMap<>();
			List<String[]> dataList = reader.readAll();
			for (String[] items: dataList) {
				hMap.put(items[0], items[1]);
			}

			fr.close();

			TreeSet<String> treeSet = new TreeSet<String>();
			treeSet.addAll(hMap.keySet());

			for (String sortedKey : treeSet) {
				System.out.println(sortedKey + ": " + hMap.get(sortedKey));
			}
		}

		catch (IOException e) {
			System.out.println("入力された名前のファイルは存在しません");
		}
		catch(CsvException ce) {
		}
	}
}
