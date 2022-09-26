import java.io.*;
import java.lang.*;
import java.util.*;
import com.google.common.base.Strings;


class questionOne {
	public static void main(String[] args) {
		LinkedHashMap<String, String> lHMap = new LinkedHashMap<>();
		HashMap<String, String> hMap = new HashMap<>();

		try {
			BufferedReader br =
				new BufferedReader(new InputStreamReader(System.in));

			String str1 = br.readLine();
			String str2 = br.readLine();
			String str3 = br.readLine();
			String str4 = br.readLine();
			String str5 = br.readLine();

			String key1, key2, key3, key4, key5;

			key1 = "WJ" + Strings.padStart(String.valueOf((int)(Math.ceil(Math.random()*100))), 3, '0');
			key2 = key1;
			while (key1.equals(key2)){
				key2 = "WJ" + Strings.padStart(String.valueOf((int)(Math.ceil(Math.random()*100))), 3, '0');
			}
			key3 = key2;
			while (key2.equals(key3)){
				key3 = "WJ" + Strings.padStart(String.valueOf((int)(Math.ceil(Math.random()*100))), 3, '0');
				
			}
			key4 = key3;
			while (key3.equals(key4)){
				key4 = "WJ" + Strings.padStart(String.valueOf((int)(Math.ceil(Math.random()*100))), 3, '0');
			}
			key5 = key4;
			while (key4.equals(key5)){
				key5 = "WJ" + Strings.padStart(String.valueOf((int)(Math.ceil(Math.random()*100))), 3, '0');
			}

			lHMap.put(key1, str1);
			lHMap.put(key2, str2);
			lHMap.put(key3, str3);
			lHMap.put(key4, str4);
			lHMap.put(key5, str5);

			hMap.put(key1, str1);
			hMap.put(key2, str2);
			hMap.put(key3, str3);
			hMap.put(key4, str4);
			hMap.put(key5, str5);

			int i = 0;
			int j = 0;

			System.out.println("LinkedHashMap:");
			for (String lHMapkey : lHMap.keySet()) {
				if ( i==4 ){
					System.out.print(lHMapkey + ":" + lHMap.get(lHMapkey));
				} else {
					System.out.print(lHMapkey + ":" + lHMap.get(lHMapkey) + "&");
				}
				i++;
			}

			System.out.println("");
			System.out.println("HashMap:");
			for (String hMapkey : hMap.keySet()) {
				if ( j==4 ){
					System.out.print(hMapkey + ":" + hMap.get(hMapkey));
				} else {
					System.out.print(hMapkey + ":" + hMap.get(hMapkey) + "&");
				}
				j++;
			}
		}

		catch (IOException e) {
			System.out.println("標準入力において例外が発生しました。");
		}
	}
}
//HashMapは要素の順番を保障しないのに対し、LinkedHashMapは格納された順番を保持している
