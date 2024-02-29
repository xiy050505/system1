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
    <title>离职申请</title>
    <link href="css/afl.css" rel="stylesheet">
</head>
<body>
<div id="app">
    <el-menu
            :default-active="activeIndex"
            class="el-menu-demo"
            empty-text="暂无数据"
            mode="horizontal"
            @select="handleSelect">
        <el-menu-item index="1">离职申请</el-menu-item>
        <el-menu-item index="2" @click="checkDimission">查看申请</el-menu-item>

    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="姓名" prop="name" class="name">
            <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>


        <el-form-item label="离职原因" prop="reason" class="reason">
            <el-input v-model="ruleForm.reason"></el-input>
        </el-form-item>



        <el-form-item>
            <el-button type="primary" class="button" @click="dimission">申请</el-button>
        </el-form-item>
    </el-form>

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
                rules: {
                    name: [
                        {required: true, message: '请输入姓名', trigger: 'blur'},
                        {min: 2, max: 5, message: '长度在 2 到 5 个字符', trigger: 'blur'}
                    ],
                    reason: [
                        {required: true, message: '请输入离职原因原因', trigger: 'blur'},
                        {min: 1, max: 100, message: '字数为100字内', trigger: 'blur'}
                    ],
                },
                ruleForm: {
                    username:'${username}',
                    name: '',
                    reason: '',
                    status:'0'
                },
            }
        },
        methods: {
            dimission(){
                axios({
                    method:"post",
                    url:"http://localhost:8080/system/dimissionServlet",
                    data:this.ruleForm
                }).then(function (resp){
                    alert("提交成功!!")
                    location.href="http://localhost:8080/system/eHomepageServlet?username=${username}"
                })
            },
            checkDimission(){
                location.href="http://localhost:8080/system/checkDimissionServlet?username=${username}"
            }
        }
    })
</script>
</html>
