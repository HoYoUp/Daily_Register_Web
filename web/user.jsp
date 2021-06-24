<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="usersManager.user"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Welcome Body</title>
<link rel="stylesheet" type="text/css" href="res/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="res/css/basic.css">
<script type="text/javascript" src="res/js/user.js"></script>
<script>
	
<%response.setCharacterEncoding("utf-8");
			user u = (user) session.getAttribute("info");%>
	
</script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="lEU col-md-10">
				<div class="anounce row">通知：</div>
				<div class="info row">
					<div class="basic col-md-6">
						姓名：<%
						out.print(u.getName());
					%><br> 工号：<%
						out.print(u.getId());
					%>
					</div>
					<div class="sign col-md-4">
						<%
							Date m = new Date();
							String cs = " ", rs = "签到";
							char ch = u.getMonth()[m.getDate() - 1];
							if (ch == '1') {
								rs = "18-19点再签到";
							} else if (ch == '2') {
								rs = "本日签到已完成";
								cs = " disabled";
							}
							out.print("<button onclick=\"talk('0')\"" + cs + ">" + rs + "</button>");
						%>
					</div>
				</div>

				<div class="selections row">
					<button onclick="talk('1')">本月考勤</button>
					<button onclick="talk('2')">请假</button>
					<button onclick="talk('3')">反馈</button>
					<button onclick="talk('4')">排名</button>
					<button onclick="talk('5')">绩效规则</button>
				</div>
				<div class="more row">
					<div class="col-md-8">
						<%
							//输出本月考勤情况
							int s = m.getDay();
							if (s == 0)
								s = 7;
							int c = s - (m.getDate() % 7);//月初是星期几
							if (c < 0)
								c = 8 + c;
							String [] css = new String[]{"一"," 二","三"," 四"," 五"," 六","日"};
							for(s=0;s<7;s++)
								out.print("<label class=\"lab\">星期"+ css[s]+"</label>");
							out.print("<br>");
							for (s = 1; s < c; s++)
								out.print("<label class=\"lab\" style=\"visibility:hidden;\">null</label>");
							s = c;
							char[] scc = u.getMonth();
							for (c = 1; c <= m.getDate(); c++) {
								if (s == 8) {
									out.print("<br>");
									s = 1;
								}
								String sc = "";
								switch (scc[c - 1]) {
								case '1':
									sc = "yellow";
									break;
								case '2':
									sc = "green";
									break;
								case '3':
									sc = "orange";
									break;
								case '0':
									sc = "red";
									break;
								}
								out.print("<label class=\"lab\" style=\"background:" + sc + ";\">" + c + "</label>");
								s++;
							}
							for (; c < scc.length; c++) {
								if (s == 8) {
									out.print("<br>");
									s = 1;
								}
								out.print("<label class=\"lab\">" + c + "</label>");
								s++;
							}
						%>
					</div>
					<div class="col-md-2 sympbol">
						<label style="background: yellow;">少签一次</label><br> <label
							style="background: green;">已签完</label><br> <label
							style="background: orange;">请假</label><br> <label
							style="background: red;">旷工</label><br>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>