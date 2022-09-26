import java.io.*;
import java.lang.*;
import java.util.*;


class questionOne {
	public static void main(String[] args) {
		printFiles("top");
	}

	public static void printFiles(String path) {
		String newPath;

		File dir = new File(path);
		File[] files = dir.listFiles();

		if (files.length == 0) {
			System.out.println(path);
		} else {
			for (File file : files) {
				newPath = path + "/" + file.getName();
				printFiles(newPath);
			}
		}
			
	}
}
