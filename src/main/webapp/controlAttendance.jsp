<%--
  Created by IntelliJ IDEA.
  User: 26018
  Date: 2024/2/28
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>员工信息</title>
</head>
<body>
<div id="app">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="用户名" prop="username">
            <el-input v-model="ruleForm.username"></el-input>
        </el-form-item>
        <el-form-item label="员工姓名" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>
        <el-form-item label="类型" prop="type">
            <el-select v-model="ruleForm.type" placeholder="请选择类型">
                <el-option label="迟到" value="late"></el-option>
                <el-option label="早退" value="early"></el-option>
                <el-option label="缺勤" value="absence"></el-option>
                <el-option label="请假" value="afl"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="日期" required>
            <el-col :span="11">
                <el-form-item >
                    <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.date" format="yyyy 年 MM 月 dd 日"
                                    value-format="yyyy-MM-dd"
                                    style="width: 100%;">
                    </el-date-picker>
                </el-form-item>
            </el-col>
        </el-form-item>


        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">记录</el-button>
        </el-form-item>
    </el-form>


</div>

</body>
<script src="js/axios-0.18.0.js"></script>
<script src="js/vue.js"></script>
<script src="element-ui/lib/index.js"></script>
<link rel="stylesheet" href="element-ui/lib/theme-chalk/index.css">

<script>
    new Vue({
        el: "#app",

        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios({
                            method: "post",
                            url: "http://localhost:8080/system/controlAttendanceServlet",
                            data: this.ruleForm
                        }).then(function (resp){
                            if (resp.data==="failure"){
                                alert("用户名不存在!")
                            } else {
                                alert("记录成功!")
                            }
                        })
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
        },
        data() {
            return {
                rules: {
                    username: [
                        {required: true, message: '请输入用户名', trigger: 'blur'},
                        {min: 1, max: 100, message: '用户名不能为空', trigger: 'blur'}
                    ],
                    name: [
                        {required: true, message: '请输入员工姓名', trigger: 'blur'},
                        {min: 1, max: 100, message: '员工姓名不能为空', trigger: 'blur'}
                    ],
                    type: [
                        {required: true, message: '请选择活动区域', trigger: 'change'}
                    ],
                },
                ruleForm: {
                    username: '',
                    name: '',
                    date: '',
                    type: []
                }
            }
        }

    })
</script>

</html>
