import java.io.*;
import java.lang.*;
import java.util.*;


class Ticket {
	protected int fee;
	protected String dest, type;

	public void setDetail(int f, String d, String t) {
		this.fee = f;
		this.dest = d;
		this.type = t;
	}

	public void message() {
		System.out.println(this.dest + "行きの" + this.type + "の切符です。");
	}

	public int calFee() {
		return this.fee;
	}
}

class Reserved extends Ticket {
	protected int reserveFee;

	public void setDetail(int f, String d, String t, int r) {
		this.fee = f;
		this.dest = d;
		this.type = t;
		this.reserveFee = r;
	}

	public int calFee() {
		return this.fee + this.reserveFee;
	}
}

class questionTwo {
	public static void main(String[] args) {
		Ticket[] ticketArr = new Ticket[5];

		ticketArr[0] = new Ticket();
		ticketArr[0].setDetail(10000, "群馬", "自由席");

		Reserved r1 = new Reserved();
		r1.setDetail(6000, "千葉", "指定席", 2000);
		ticketArr[1] = r1;
		

		ticketArr[2] = new Ticket();
		ticketArr[2].setDetail(4000, "埼玉", "自由席");

		Reserved r2 = new Reserved();
		r2.setDetail(5000, "横浜", "指定席", 3000);
		ticketArr[3] = r2;

		ticketArr[4] = new Ticket();
		ticketArr[4].setDetail(8000, "静岡", "自由席");

		for (Ticket ticket : ticketArr) {
			ticket.message();
			System.out.println("切符代: " + ticket.calFee() + "円");
		}

	}
}
