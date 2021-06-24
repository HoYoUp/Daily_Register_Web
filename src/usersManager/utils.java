package usersManager;

import java.util.Date;

import sqlBaisc.sqlBasic;


public class utils {
    public static user getUser(String name,String pwd) {
    	Date t = new Date();
    	String query = "select id,name,m"+t.getMonth()+1+" from user where name='"+name+"' and pwd='"+pwd+"'";
    	sqlBasic b = new sqlBasic();
    	user u = b.sqlSetUser(query);
    	if(u.getId()==1) {
    		query = "select m"+t.getMonth()+1+" from user where id>1";
    		query+=t.getDate(); 
    		u.setMonth(b.totalInfo(query));
    	}
    	b.close();
    	//System.out.print(u.getMonth());
    	return u;
	}

    public static boolean roll(char[] m,int id) {
    	Date t = new Date();
    	int d =t.getDate()-1,h=t.getHours();
    	System.out.println("p "+id+" "+m[d]);
    	if(m[d]=='0'&&h<=8)
    		m[d]='1';
    	else if(m[d]=='1'&&h<20&&h>=18)
    		m[d]='2';
    	else if(m[d]=='0'&&h>=18)
    		m[d]='1';
    	else
    		return false;
    	String query = "update user set m"+t.getMonth()+1+"='";
    	for(int c=0;c<m.length;c++) 
    		query+=m[c];
    	query+="' where id=";
    	query+=id;
    	sqlBasic b = new sqlBasic();
    	if(b.change(query)>0)
    	    return true;
    	return false;
    }
}
