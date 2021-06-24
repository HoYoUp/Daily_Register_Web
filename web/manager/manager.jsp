<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ page import="usersManager.user" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Welcome Checker</title>
    <link rel="stylesheet" href="res/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="res/css/basic.css">
    <script src="res/js/manager.js"></script>
    <%
        user u = (user) session.getAttribute("info");
        int[] m = {0, 0, 0, 0};
        int c = u.getMonth().length - 1, c1 = 3;
        while (u.getMonth()[c] != ',') c--;
        int h = 1;
        for (c--; c >= 0; c--) {
            if (u.getMonth()[c] == ',') {
                c1--;
                h = 1;
                continue;
            }
            System.out.print(u.getMonth()[c] + " ");
            m[c1] = m[c1] + h * (u.getMonth()[c] - '0');
            h *= 10;
        }
    %>
</head>
<body>
<div class="container">
    <div class="row lEM">
        <div class="info col-md-3">
            Basic info
        </div>
        <div class="info col-md-9">
            <label> 应签到人数：<%out.print(m[0]);%></label>
            <label> 签到一次人数：<%out.print(m[1]);%></label>
            <label> 签到两次人数：<%out.print(m[2]);%></label>
            <label> 未签到人数：<%out.print(m[3]);%></label>
        </div>
    </div>
    <br>
    <div class="row lEM function">
        <div class="col-sm-3 orders">
            <button class="fb" onclick="call('0')"> 考勤情况</button>
            <br>
            <button class="fb" onclick="call('1')"> 反馈</button>
            <br>
            <button class="fb" onclick="call('2')"> 公告</button>
            <br>
            <button class="fb" onclick="call('3')"> 策略</button>
            <br>
            <button class="fb" onclick="call('4')"> 请假</button>
            <br>
        </div>
    </div>

</div>
</body>
</html>