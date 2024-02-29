<%--
  Created by IntelliJ IDEA.
  User: 26018
  Date: 2024/2/28
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>新增信息</title>
</head>
<body>
<div id="app">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="用户名" prop="username">
            <el-input v-model="ruleForm.username"></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>
        <el-form-item label="手机号" prop="cellphoneNumber">
            <el-input v-model="ruleForm.cellphoneNumber"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
            <el-input v-model="ruleForm.email"></el-input>
        </el-form-item>
        <el-form-item label="个人地址">
            <el-input v-model="ruleForm.address"></el-input>
        </el-form-item>
        <el-form-item label="个人描述" prop="description">
            <el-input v-model="ruleForm.description"></el-input>
        </el-form-item>

        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">添加</el-button>
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
        data() {
            return {
                ruleForm: {
                    username: '',
                    name: '',
                    cellphoneNumber: '',
                    email: '',
                    address: '',
                    description: '',
                },
                rules: {
                    username: [
                        {required: true, message: '请输入用户名', trigger: 'blur'},
                        {min: 2, max: 5, message: '长度在 2 到 5 个字符', trigger: 'blur'}
                    ],
                    name: [
                        {required: true, message: '请输入姓名', trigger: 'blur'},
                        {min: 2, max: 5, message: '长度在 2 到 5 个字符', trigger: 'blur'}
                    ],
                    cellphoneNumber: [
                        {required: true, message: '请输入手机号', trigger: 'blur'},
                        {min: 11, max: 11, message: '长度为11位', trigger: 'blur'}
                    ],

                }
            }
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios({
                            method:"post",
                            url:"http://localhost:8080/system/addEInformationServlet",
                            data:this.ruleForm
                        }).then(function (resp){
                            if (resp.data==="failure"){
                                alert("用户名已存在");
                            } else {
                                alert("添加成功!");
                                location.href="checkEInformation.jsp"
                            }
                        })
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            }
        }
    })
</script>
</html>