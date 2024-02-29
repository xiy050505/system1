<%--
  Created by IntelliJ IDEA.
  User: 26018
  Date: 2024/2/27
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>查看申请</title>
</head>
<body>
<div id="app">
    <el-menu
            :default-active="activeIndex"
            class="el-menu-demo"
            mode="horizontal"
            @select="handleSelect">
        <el-menu-item index="2" @click="dimission">离职申请</el-menu-item>
        <el-menu-item index="1">查看申请</el-menu-item>

        <template >
            <el-table
                    :data="tableData"
                    style="width: 100%">
                <el-table-column
                        prop="name"
                        label="姓名"
                        width="100">
                </el-table-column>
                <el-table-column
                        prop="reason"
                        label="原因">
                </el-table-column>
                <el-table-column
                        prop="status"
                        label="状态"
                        width="100">
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
                tableData:${dimissions},
                activeIndex: '1'
            }
        },
        methods:{
            dimission(){
                window.location.href="http://localhost:8080/system/dimissionLoadingServlet?username=${user.username}"
            }

        }

    })
</script>
</html>
