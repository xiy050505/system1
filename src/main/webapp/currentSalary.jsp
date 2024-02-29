<%--
  Created by IntelliJ IDEA.
  User: 26018
  Date: 2024/2/25
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>工资信息</title>
</head>
<body>
<div id="app">
    <el-menu
            :default-active="activeIndex"
            class="el-menu-demo"
            empty-text="暂无数据"
            mode="horizontal"
            @select="handleSelect">
        <el-menu-item index="1">本月工资</el-menu-item>
        <el-menu-item index="2" @click="historySalary">历史工资</el-menu-item>

        <template id="currentSalary" >
            <el-table
                    :data="tableData"
                    style="width: 100%"
                    empty-text="暂无数据">
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
                        prop="basicSalary"
                        label="基本工资/元">
                </el-table-column>
                <el-table-column
                        prop="award"
                        label="全勤/元">
                </el-table-column>
                <el-table-column
                        prop="performance"
                        label="业绩/元">
                </el-table-column>
            </el-table>
        </template>


    </el-menu>
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
                activeIndex: '1',
                tableData: [{
                    year: '${salary.year}',
                    month: '${salary.month}',
                    basicSalary: '${salary.basicSalary}',
                    award: '${salary.award}',
                    performance: '${salary.performance}'
                }]
            }
        },
        methods:{
            historySalary(){
                location.href="http://localhost:8080/system/historySalaryServlet?username=${user.username}"
            }
        }

    })
</script>
</html>
