<%--
  Created by IntelliJ IDEA.
  User: 26018
  Date: 2024/2/26
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>考勤信息</title>
</head>
<body>
<div id="app">
    <el-form :inline="true" :model="formInline" class="demo-form-inline">
    <el-form-item label="年份">
        <el-select v-model="formInline.year" placeholder="年份">
            <el-option label="${year1}" value="${year1}"></el-option>
            <el-option label="${lastYear}" value="${lastYear}"></el-option>
        </el-select>
    </el-form-item>

        <el-form-item label="月份">
            <el-select v-model="formInline.month" placeholder="月份">
                <el-option label="1月" value="01"></el-option>
                <el-option label="2月" value="02"></el-option>
                <el-option label="3月" value="03"></el-option>
                <el-option label="4月" value="04"></el-option>
                <el-option label="5月" value="05"></el-option>
                <el-option label="6月" value="06"></el-option>
                <el-option label="7月" value="07"></el-option>
                <el-option label="8月" value="08"></el-option>
                <el-option label="9月" value="09"></el-option>
                <el-option label="10月" value="10"></el-option>
                <el-option label="11月" value="11"></el-option>
                <el-option label="12月" value="12"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="select">查询</el-button>
        </el-form-item>
    </el-form>

    <template id="currentSalary" >
        <el-table
                :data="tableData"
                style="width: 100%">
            <el-table-column
                    prop="year"
                    label="年份"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="month"
                    label="月份"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="late"
                    label="迟到/天">
            </el-table-column>
            <el-table-column
                    prop="early"
                    label="早退/天">
            </el-table-column>
            <el-table-column
                    prop="absence"
                    label="缺勤/天">
            </el-table-column>
            <el-table-column
                    prop="afl"
                    label="请假/天">
            </el-table-column>
        </el-table>
    </template>


</div>
</body>

<script src="js/axios-0.18.0.js"></script>
<script src="js/vue.js"></script>
<script src="element-ui/lib/index.js"></script>
<link rel="stylesheet" href="element-ui/lib/theme-chalk/index.css">

<script>

    new Vue({
        el:"#app",
        data(){
            return{
                formInline: {
                    year: '',
                    month: '',
                    lastYear:'${lastYear}',
                },
                tableData: [${attendance}]
            }
        },
        methods:{
            select() {
                axios({
                    method:"post",
                    url:"http://localhost:8080/system/attendanceServlet",
                    data:this.formInline
                }).then(function (resp){
                    location.href="http://localhost:8080/system/attendance1Servlet?username=${user.username}"
                })
            }
        }
    })
</script>
</html>
