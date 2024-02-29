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
            mode="horizontal"
            @select="handleSelect">
        <el-menu-item index="2" @click="afl">请假申请</el-menu-item>
        <el-menu-item index="1">查看申请</el-menu-item>

        <template id="currentSalary" >
            <el-table
                    :data="tableData"
                    style="width: 100%"
                    sort-by=["year","month"]>
                <el-table-column
                        prop="name"
                        label="员工姓名"
                        width="180">
                </el-table-column>
                <el-table-column
                        prop="startTime"
                        label="开始时间">
                </el-table-column>
                <el-table-column
                        prop="endTime"
                        label="结束时间">
                </el-table-column>
                <el-table-column
                        prop="status"
                        label="状态">
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
                tableData: ${afls}
            }
        },
        methods:{
            afl(){
                location.href="http://localhost:8080/system/aflLoadingServlet?username=${user.username}"
            }
        }

    })
</script>
</html>