import java.io.*;
import java.lang.*;
import java.util.*;
import org.apache.commons.io.FileUtils;
import java.nio.charset.Charset;
import com.google.common.base.Splitter;


class questionFour {
	public static void main(String[] args) {
		try {
			List<String> contentList = FileUtils.readLines(new File("Shopping-utf8.txt"), Charset.forName("Shift_JIS"));
			List<String> strList = new ArrayList<>();
			HashMap<String, Integer> dailyHMap = new HashMap<>();
			HashMap<String, Integer> itemHMap = new HashMap<>();
			int defaultInt;

			for (String items : contentList) {
				strList = Splitter.on(" ").splitToList(items);
				if (dailyHMap.get(strList.get(0)) == null) {
					defaultInt = 0;
				} else {
					defaultInt = dailyHMap.get(strList.get(0));
				}
				dailyHMap.put(
					strList.get(0)
					, defaultInt + 
					Integer.parseInt(strList.get(2).replace("円", ""))
					);

				if (itemHMap.get(strList.get(1)) == null) {
					defaultInt = 0;
				} else {
					defaultInt = itemHMap.get(strList.get(1));
				}

				itemHMap.put(
					strList.get(1)
					, defaultInt + 
					Integer.parseInt(strList.get(2).replace("円", ""))
					);
			}

			List<String> writeList = new ArrayList<>();

			for (String dailyHMapKey : dailyHMap.keySet()) {
				writeList.add(dailyHMapKey + " " + String.valueOf(dailyHMap.get(dailyHMapKey)) + "円");
			}

			for (String itemHMapKey : itemHMap.keySet()) {
				writeList.add(itemHMapKey + " " + String.valueOf(itemHMap.get(itemHMapKey)) + "円");
			}

			FileUtils.writeLines(new File("OutPut.txt"), writeList);

		}

		catch (IOException e) {
		}
	}
}
