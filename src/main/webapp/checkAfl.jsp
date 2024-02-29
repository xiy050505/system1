<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>请假,离职申请</title>
</head>
<body>
<div id="app">
    <el-menu
            :default-active="activeIndex"
            class="el-menu-demo"
            mode="horizontal"
            @select="handleSelect">
        <el-menu-item index="1">请假申请</el-menu-item>
        <el-menu-item index="2" @click="dimission">离职申请</el-menu-item>
        <template id="eInformation">
            <el-table
                    :data="tableData"
                    style="width: 100%"
                    highlight-current-row
                    @current-change="handleCurrentChange">
                <el-table-column
                        type="index"
                        width="50">
                </el-table-column>

                <el-table-column
                        prop="username"
                        label="用户名"
                        width="100">
                </el-table-column>
                <el-table-column
                        prop="name"
                        label="员工姓名"
                        width="100">
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
                        prop="reason"
                        label="原因">
                </el-table-column>

                <el-table-column
                        prop="type"
                        label="请假类型"
                        width="180">
                </el-table-column>

                <el-table-column
                        prop="status"
                        label="状态">
                </el-table-column>

                <el-table-column
                        align="center"
                        label="操作">

                    <el-row>
                        <el-button type="primary" @click="success">批准</el-button>
                        <el-button type="danger" @click="failure">拒绝</el-button>
                    </el-row>

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
        el: "#app",
        mounted() {
            this.selectAll();
        },

        methods: {
            selectAll() {
                var _this = this;
                axios({
                    method: "post",
                    url: "http://localhost:8080/system/aflSelectServlet"
                }).then(function (resp) {
                    _this.tableData = resp.data;
                })
            },
            dimission(){
                location.href="http://localhost:8080/system/checkDimission.jsp"
            },
            success() {
                this.$confirm('是否通过该请假申请?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    axios({
                        method: "post",
                        url: "http://localhost:8080/system/aflUpdateServlet?result=yes",
                        data: this.afl
                    }).then(function (resp) {
                        location.href = "http://localhost:8080/system/checkAfl.jsp"
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消'
                    });
                });
            },
            failure() {
                this.$confirm('是否删除该员工信息?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    axios({
                        method: "post",
                        url: "http://localhost:8080/system/aflUpdateServlet?result=no",
                        data: this.afl
                    }).then(function (resp) {
                        location.href = "http://localhost:8080/system/checkAfl.jsp"
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消'
                    });
                });
            },
            handleCurrentChange(val) {
                this.afl.currentRow = val;
            },
        },
        data() {
            return {
                activeIndex: '1',
                tableData: [],
                afl: {
                    currentRow: ''
                },
            }
        }

    })
</script>
</html>