<%--
  Created by IntelliJ IDEA.
  User: 26018
  Date: 2024/2/25
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>个人信息</title>
</head>
<body>
<div id="app">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="用户名" prop="username">
            <el-input v-model="ruleForm.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
            <el-input v-model="ruleForm.password"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="rpassword">
            <el-input v-model="ruleForm.rpassword"></el-input>
        </el-form-item>

        <el-form-item label="验证码" prop="checkCode">
            <el-input v-model="ruleForm.checkCode"></el-input>
        </el-form-item>
        
        <el-form-item>
            <el-button type="primary" @click="register">注册</el-button>
        </el-form-item>
    </el-form>
</div>
<img src="/System/checkCodeServlet" id="checkCode">
<a href="#" id="changeImg">看不清?</a>


</body>

<script src="js/axios-0.18.0.js"></script>
<script src="js/vue.js"></script>
<script src="element-ui/lib/index.js"></script>
<link rel="stylesheet" href="element-ui/lib/theme-chalk/index.css">

<script>
    new Vue({
        el:"#app",
        data() {
            return {
                ruleForm: {
                    username:'',
                    password:'',
                    rpassword:'',
                    checkCode:''

                },
                rules: {
                    username: [
                        {required: true, message: '请输入用户名', trigger: 'blur'},
                        {min: 4, max: 8, message: '长度在 4 到 8 个字符', trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: '请输入密码', trigger: 'blur'},
                        {min: 8, max: 12, message: '长度在 8到 12 个字符', trigger: 'blur'}
                    ],
                    rpassword: [
                        {required: true, message: '请再次输入密码', trigger: 'blur'},
                        {min: 8, max: 12, message: '长度在 8到 12 个字符', trigger: 'blur'}
                    ]
                }
            }
        },
        methods:{
            register(){
                axios({
                    method:"post",
                    url:"http://localhost:8080/system/registerServlet",
                    data:this.ruleForm
                }).then(function (resp){
                    if (resp.data==="success"){
                        alert("注册成功!");
                    } else if (resp.data==="checkCodeFailure"){
                        alert("验证码错误!")
                    } else if(resp.data==="passwordFailure"){
                        alert("两次输入的密码不匹配!")
                    } else {
                        alert("用户名已存在!")
                    }
                })
            }
        }
    })

    document.getElementById("changeImg").onclick = function (){
        document.getElementById("checkCode").src="/System/checkCodeServlet?"+new Date().getMilliseconds();
    }
</script>
</html>
