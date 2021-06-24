package usersManager;

import java.util.Date;

public class user {
	private String name = new String();
	private char[] month = new char[32];
	private int id = -1;

	public user(String n, String m, int i) {
		name = n;
		month = m.toCharArray();
		id = i;
	}

	public user() {

	}

	public String getName() {
		return name;
	}

	public char[] getMonth() {
		return month;
	}

	public int getId() {
		return id;
	}

	public void setName(String n) {
		name = n;
	}

	public void setMonth(String m) {
		int c = m.length();
		System.out.print("mlength"+c);
		if (c>28||c==8) {
			for (c = 0; c<m.length(); c++) 
				  month[c] = m.charAt(c);
		} else {
			Date d = new Date();
			int md = d.getMonth()+1;
			c = d.getYear()+1900;
			if(md==4||md==6||md==9||md==11)
				md=31;
			else if(md==2)
				md=28;
			else if(c%4==0&&c%100!=0&&md==2)
				md=29;
			else
				md=30;
			for (c=0; c < md; c++)
				month[c] = '0';
				month[c] = 'a';
		}

	}

	public void setId(int i) {
		id = i;
	}
}
