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
    <title>修改活动</title>
</head>
<body>
<div id="app">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="活动名称">
            <el-input v-model="ruleForm.name" disabled="ture"></el-input>
        </el-form-item>

        <el-form-item label="活动时间" required>
            <el-col :span="5">
                <el-form-item prop="startTime">
                    <el-date-picker
                            v-model="ruleForm.startTime"
                            type="date"
                            placeholder="选择日期"
                            value-format="yyyy-MM-dd">
                    </el-date-picker>

                </el-form-item>
            </el-col>
            <el-col class="line" :span="1"> 至</el-col>
            <el-col :span="5">
                <el-form-item prop="endTime">
                    <el-date-picker type="date"
                                    placeholder="选择结束时间"
                                    v-model="ruleForm.endTime"
                                    value-format="yyyy-MM-dd"
                                    style="width: 100%;">

                    </el-date-picker>
                </el-form-item>
            </el-col>
        </el-form-item>

        <el-form-item label="活动内容" prop="content">
            <el-input v-model="ruleForm.content"></el-input>
        </el-form-item>

        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
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
                    name: '${activity1.name}',
                    content: '${activity1.content}',
                    startTime: '',
                    endTime: ''
                },
                rules: {
                    content: [
                        {required: true, message: '请输入活动内容', trigger: 'blur'},
                        {min: 1, max: 100, message: '活动内容为100字内', trigger: 'blur'}
                    ]
                }
            }
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios({
                            method: "post",
                            url: "http://localhost:8080/system/activityUpdate1Servlet",
                            data: this.ruleForm
                        }).then(function (resp) {
                            if (resp.data === "dateError") {
                                alert("日期选择错误!")
                            } else {
                                alert("活动信息修改成功!")
                                location.href = "http://localhost:8080/system/checkActivity.jsp"
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
