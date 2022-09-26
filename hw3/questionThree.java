import java.io.*;
import java.lang.*;
import java.util.*;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.lang3.*;


abstract class GymMember {
	protected String id, name;
	protected int fee;

	public void setDetail(String i, String n) {
		this.id = i;
		this.name = n;
		this.fee = 15000;
	}

	public abstract void printData();
}

class Bronze extends GymMember {
	public void printData() {
		System.out.println("会員ID: " + this.id + "; 氏名: " + this.name + "; 会員の種別: ブロンズ; 会費: " + this.fee + "円");
	}
}

class Silver extends GymMember {
	public void setDetail(String i, String n) {
		this.id = i;
		this.name = n;
		this.fee = 12000;
	}

	public void printData() {
		System.out.println("会員ID: " + this.id + "; 氏名: " + this.name + "; 会員の種別: シルバー; 会費: " + this.fee + "円");
	}
}

class Gold extends GymMember {
	public void setDetail(String i, String n) {
		this.id = i;
		this.name = n;
		this.fee = 10000;
	}

	public void printData() {
		System.out.println("会員ID: " + this.id + "; 氏名: " + this.name + "; 会員の種別: ゴールド; 会費: " + this.fee + "円");
	}
}

interface MemberFuncInf {
	public double calPeriodOfYears(int year, int month, int day, int targetYear, int targetMonth);

	public void createAndPrint(double periodOfYears, String id, String name);
}

class MemberFunc implements MemberFuncInf {
	public double calPeriodOfYears(int year, int month, int day, int targetYear, int targetMonth) {
		int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31 ,31, 30, 31, 30, 31};

		int targetDays = (targetYear - year) * 365;
		for (int i=0; i<=targetMonth-1; i++) {
			targetDays = targetDays + daysOfMonth[i];
		}

		int days = day;
		for (int i=0; i<=month-1; i++) {
			days = days + daysOfMonth[i];
		}

		double periodOfYears = (targetDays - days) / 365;

		return periodOfYears;
	}

	public void createAndPrint(double periodOfYears, String id, String name) {
		if (periodOfYears >= 4) {
			GymMember gm = new Gold();
			gm.setDetail(id, name);
			gm.printData();
		} else if (periodOfYears >= 2) {
			GymMember gm = new Silver();
			gm.setDetail(id, name);
			gm.printData();
		} else if (periodOfYears >= 0){
			GymMember gm = new Bronze();
			gm.setDetail(id, name);
			gm.printData();
		}
	}
}

class questionThree {
	public static void main(String[] args) {
		String str;

		try {
				BufferedReader br1 =
					new BufferedReader(new InputStreamReader(System.in));

				System.out.println("会費を請求する年と月を入力してください。");
				System.out.println("年: ");
				String str1 = br1.readLine();
				System.out.println("月: ");
				String str2 = br1.readLine();

				try {
					int targetYear = Integer.parseInt(str1);
					int targetMonth = Integer.parseInt(str2);

					if (targetYear < 0 || targetMonth < 1 || targetMonth > 12) {
						System.out.println("正しい年と月を入力してください。");
					} else {
						try {
							//File Reader
							FileReader fr = new FileReader("GymMember-utf8.csv");
							CSVReader reader = new CSVReader(fr);

							MemberFuncInf m = new MemberFunc();

							List<String[]> dataList = reader.readAll();
							for (String[] data: dataList) {
								double periodOfYears = m.calPeriodOfYears(Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]), targetYear, targetMonth);
								m.createAndPrint(periodOfYears, data[0], data[1]);
							}

							fr.close();
						}

						catch (CsvException e) {
							System.out.println("入力された名前のファイルは存在しません。");
						}
					}

				}	

				catch (NumberFormatException e) {
					System.out.println("数字を入力してください。");
				}	
			}

			catch (IOException e) {
				System.out.println("標準入力において例外が発生しました。");
			}
	}
}
