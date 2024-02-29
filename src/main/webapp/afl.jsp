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
    <title>请假申请</title>
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
        <el-menu-item index="1">请假申请</el-menu-item>
        <el-menu-item index="2" @click="checkAfl">查看申请</el-menu-item>

        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="姓名" prop="name" class="name">
                <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>

            <template>
                <div class="block">
                    <el-date-picker
                            v-model="ruleForm.date"
                            type="daterange"
                            start-placeholder="开始日期"
                            end-placeholder="结束日期"
                            :default-time="['00:00:00', '23:59:59']">
                    </el-date-picker>
                </div>
            </template>


            <el-form-item label="请假原因" prop="reason" class="reason">
                <el-input v-model="ruleForm.reason"></el-input>
            </el-form-item>

            <el-form-item label="请假类型" prop="type" class="type">
                <el-input v-model="ruleForm.type"></el-input>
            </el-form-item>


            <el-form-item>
                <el-button type="primary" class="button" @click="afl">申请</el-button>
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
                        {required: true, message: '请输入请假原因', trigger: 'blur'},
                        {min: 1, max: 100, message: '字数为100字内', trigger: 'blur'}
                    ],
                    type: [
                        {required: true, message: '请输入请假类型', trigger: 'blur'},
                        {min: 1, max: 100, message: '字数为100字内', trigger: 'blur'}
                    ],

                },
                ruleForm: {
                    username: '${username}',
                    name: '',
                    reason: '',
                    date: '',
                    type: '',
                    status: '0'
                },
            }
        },
        methods: {
            afl() {
                axios({
                    method: "post",
                    url: "http://localhost:8080/system/aflServlet",
                    data: this.ruleForm
                }).then(function (resp) {
                    alert("提交成功!!")
                    location.href = "http://localhost:8080/system/eHomepageServlet?username=${username}"
                })
            },
            checkAfl() {
                location.href = "http://localhost:8080/system/checkAflServlet?username=${username}"
            }
        }
    })
</script>
</html>
