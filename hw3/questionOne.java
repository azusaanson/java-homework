import java.io.*;
import java.lang.*;
import java.util.*;


class Music implements MusicVideoFuncs {
	private int playTime;
	private String id, musicName;

	public void setId(String i) {
		this.id = i;
	}

	public String getId() {
		return this.id;
	}

	public void setName(String n) {
		this.musicName = n;
	}

	public void setPlayTime(int t) {
		this.playTime = t;
	}

	public void play() {
		System.out.println("Music Start!");
	}

	public void showDetail() {
		System.out.println("曲名: " + this.musicName);
		System.out.println("再生時間: " + this.playTime + "秒");
	}
}

class Video implements MusicVideoFuncs {
	private int playTime;
	private String id, videoName;

	public void setId(String i) {
		this.id = i;
	}

	public String getId() {
		return this.id;
	}

	public void setName(String n) {
		this.videoName = n;
	}

	public void setPlayTime(int t) {
		this.playTime = t;
	}

	public void play() {
		System.out.println("映像再生開始");
	}

	public void showDetail() {
		System.out.println("作品名: " + this.videoName);
		System.out.println("再生時間: " + this.playTime + "秒");
	}
}

class Image implements FileFuncs {
	private int widthPx, heightPx;
	private String id, imageName;

	public void setId(String i) {
		this.id = i;
	}

	public String getId() {
		return this.id;
	}

	public void setName(String n) {
		this.imageName = n;
	}

	public void setPx(int wp, int hp) {
		this.widthPx = wp;
		this.heightPx = hp;
	}

	public void showDetail() {
		System.out.println("ファイル名: " + this.imageName);
		System.out.println("横 × 縦のピクセル数: " + this.widthPx + "Px × " + this.heightPx + "Px");
	}
}

interface FileFuncs {
	public void showDetail();
}

interface MusicVideoFuncs extends FileFuncs {
	public void play();
}

class questionOne {
	public static void main(String[] args) {
		HashMap<String, Music> mHMap = new HashMap<>();
		HashMap<String, Video> vHMap = new HashMap<>();
		HashMap<String, Image> iHMap = new HashMap<>();

		for (int i=1; i<=5; i++) {
			Music m = new Music();
			Video v = new Video();
			Image im = new Image();

			m.setId("MU00" + Integer.toString(i));
			m.setName("Music Name " + Integer.toString(i));
			m.setPlayTime((int)(Math.ceil(Math.random()*10000)));

			v.setId("MO00" + Integer.toString(i));
			v.setName("Video Name " + Integer.toString(i));
			v.setPlayTime((int)(Math.ceil(Math.random()*10000)));

			im.setId("IM00" + Integer.toString(i));
			im.setName("Image Name " + Integer.toString(i));
			im.setPx(((int)(Math.ceil(Math.random()*1000))), ((int)(Math.ceil(Math.random()*1000))));

			mHMap.put(m.getId(), m);
			vHMap.put(v.getId(), v);
			iHMap.put(im.getId(), im);
		}

		try {
			BufferedReader br =
				new BufferedReader(new InputStreamReader(System.in));

			String str1 = br.readLine();

			if (iHMap.get(str1) != null) {
				iHMap.get(str1).showDetail();
			} else if (mHMap.get(str1) != null) {
				System.out.println("再生であれば1、情報表示であれば2を入力してください: ");
				String str2 = br.readLine();

				if (str2.equals("1")) {
					mHMap.get(str1).play();
				} else if (str2.equals("2")) {
					mHMap.get(str1).showDetail();
				} else {
					System.out.println("入力を間違った。");
				}
			} else if (vHMap.get(str1) != null) {
				System.out.println("再生であれば1、情報表示であれば2を入力してください: ");
				String str2 = br.readLine();
				
				if (str2.equals("1")) {
					vHMap.get(str1).play();
				} else if (str2.equals("2")) {
					vHMap.get(str1).showDetail();
				} else {
					System.out.println("入力を間違った。");
				}
			} else {
				System.out.println("入力したファイル名は存在しない。");
			}

		}

		catch (IOException e) {
			System.out.println("標準入力において例外が発生しました。");
		}
	}
}
