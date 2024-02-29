<%--
  Created by IntelliJ IDEA.
  User: 26018
  Date: 2024/2/24
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理员主页</title>
    <link href="css/ehomepage.css" rel="stylesheet">
</head>
<body>
<div id="app">
    <el-menu
            :default-active="activeIndex"
            class="el-menu-demo"
            mode="horizontal"
            @select="handleSelect">
        <el-menu-item index="1">主页</el-menu-item>
        <el-submenu index="2">
            <template slot="title">工作台</template>
            <el-menu-item index="2-1" @click="eInformation">员工信息</el-menu-item>
            <el-menu-item index="2-2" @click="employee">管理员工</el-menu-item>
            <el-menu-item index="2-3" @click="alfDimission">请假,离职申请</el-menu-item>
        </el-submenu>
        <el-menu-item index="3" @click="activity">培训活动</el-menu-item>
        <el-menu-item index="4" @click="register">账号注册</el-menu-item>

        <template>
            <el-row class="avatar">
                <el-col :span="12">
                    <div class="avatar">
                        <div class="block">
                            <el-avatar shape="square" :size="50" :src="squareUrl"></el-avatar>
                        </div>
                    </div>
                </el-col>
            </el-row>
        </template>

        <div id="username">${manager.username}</div>
        <el-row>
            <el-button type="danger" class="button" @click="elogout" round>登出</el-button>
        </el-row>

    </el-menu>

</div>

</body>

<script src="js/axios-0.18.0.js"></script>
<script src="js/vue.js"></script>
<script src="element-ui/lib/index.js"></script>
<link rel="stylesheet" href="element-ui/lib/theme-chalk/index.css">

<script>
    new Vue({
        el: "#app",
        data() {
            return {
                activeIndex: '1',
                squareUrl: "https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png",
                username: ""
            }
        },
        methods: {
            elogout() {
                location.href = "index.html"
            },
            eInformation() {
                location.href = "http://localhost:8080/system/checkEInformation.jsp"
            },
            employee() {
                location.href = "controlAttendance.jsp"
            },
            alfDimission() {
                location.href = "checkAfl.jsp"
            },
            activity() {
                location.href="http://localhost:8080/system/checkActivity.jsp"
            },
            register() {
                location.href = "http://localhost:8080/system/register.jsp"
            }
        },

    })

    document.getElementsByClassName("avatar").onclick = function () {
        location.href = "updateAvatar.html"
    }
</script>
</html>

</html>
