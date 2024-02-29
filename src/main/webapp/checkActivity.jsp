<%--
  Created by IntelliJ IDEA.
  User: 26018
  Date: 2024/2/28
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>活动管理</title>
</head>
<body>
<div id="app">

    <el-form ref="form" :model="inputData" label-width="80px">
        <el-form-item label="活动名称">
            <el-input v-model="inputData.name"></el-input>
        </el-form-item>
        <el-form-item label="开始时间">
            <el-input v-model="inputData.startTime" placeholder="格式(例:2024-01-01)"></el-input>
        </el-form-item>
        <el-form-item label="结束时间">
            <el-input v-model="inputData.endTime" placeholder="格式(例:2024-01-01)"></el-input>
        </el-form-item>
        <el-form-item label="活动内容">
            <el-input v-model="inputData.content"></el-input>
        </el-form-item>

    </el-form>


    <el-row>
        <el-button type="primary" @click="select" plain>查询</el-button>
    </el-row>
    <el-row>
        <el-button type="primary" @click="add" plain>新增</el-button>
    </el-row>
    <template id="Activity">
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
                    prop="name"
                    label="活动名称"
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
                    prop="content"
                    label="活动内容">
            </el-table-column>

            <el-table-column
                    prop="count"
                    label="参与人数"
                    width="100">
            </el-table-column>

            <el-table-column
                    align="center"
                    label="操作">

                <el-row>
                    <el-button type="primary" @click="update">修改</el-button>
                    <el-button type="danger" @click="delete1">删除</el-button>
                </el-row>

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
        el: "#app",
        mounted() {
            this.selectAll();
        },

        methods: {
            selectAll() {
                var _this = this;
                axios({
                    method: "post",
                    url: "http://localhost:8080/system/activityServlet"
                }).then(function (resp) {
                    _this.tableData = resp.data;
                })
            },
            update() {
                this.$confirm('是否修改该信息?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    axios({
                        method: "post",
                        url: "http://localhost:8080/system/activityUpdateServlet",
                        data: this.activity
                    }).then(function (resp) {
                        location.href = "http://localhost:8080/system/activityUpdate.jsp"
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消'
                    });
                });
            },
            delete1() {
                this.$confirm('是否删除该员工信息?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    axios({
                        method: "post",
                        url: "http://localhost:8080/system/eInformationDeleteServlet",
                        data: this.eInformation
                    }).then(function (resp) {
                        alert("删除成功!");
                        location.href = "http://localhost:8080/system/checkEInformation.jsp"
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消'
                    });
                });
            },
            handleCurrentChange(val) {
                this.activity.currentRow = val;
            },
            select() {
                var _this = this;
                axios({
                    method: "post",
                    url: "http://localhost:8080/system/activitySelectServlet",
                    data: this.inputData
                }).then(function (resp) {
                    _this.tableData = resp.data;
                    alert("查询成功!")
                })
            },
            add() {
                location.href = "addActivity.jsp"
            }

        },
        data() {
            return {
                activeIndex: '1',
                tableData: [],
                activity: {
                    currentRow: ''
                },
                inputData: {
                    name: '',
                    startTime: '',
                    endTime: '',
                    content: ''
                }
            }
        }

    })
</script>
</html>