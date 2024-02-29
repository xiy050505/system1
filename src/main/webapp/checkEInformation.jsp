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
    <title>员工信息</title>
</head>
<body>
<div id="app">

    <el-input v-model="inputData.username" placeholder="用户名"></el-input>
    <el-input v-model="inputData.name" placeholder="员工姓名"></el-input>
    <el-input v-model="inputData.cellphoneNumber" placeholder="手机号"></el-input>
    <el-input v-model="inputData.email" placeholder="邮箱"></el-input>
    <el-input v-model="inputData.address" placeholder="住址"></el-input>
    <el-input v-model="inputData.description" placeholder="个人描述"></el-input>

    <el-row>
        <el-button type="primary" @click="select" plain>查询</el-button>
    </el-row>
    <el-row>
        <el-button type="primary" @click="add" plain>新增</el-button>
    </el-row>
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
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="员工姓名"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="cellphoneNumber"
                    label="手机号">
            </el-table-column>
            <el-table-column
                    prop="email"
                    label="邮箱">
            </el-table-column>
            <el-table-column
                    prop="address"
                    label="住址">
            </el-table-column>

            <el-table-column
                    prop="description"
                    label="个人描述">
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
                    url: "http://localhost:8080/system/checkEInformationServlet"
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
                        url: "http://localhost:8080/system/eInformationSelect1Servlet",
                        data: this.eInformation
                    }).then(function (resp) {
                        location.href = "http://localhost:8080/system/eInformation.jsp"
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
                this.eInformation.currentRow = val;
            },
            select() {
                var _this = this;
                axios({
                    method: "post",
                    url: "http://localhost:8080/system/conditionSelectServlet",
                    data: this.inputData
                }).then(function (resp) {
                    _this.tableData = resp.data;
                    alert("查询成功!")
                })
            },
            add() {
                location.href="addEInformation.jsp"
            }

        },
        data() {
            return {
                activeIndex: '1',
                tableData: [],
                eInformation: {
                    username: '',
                    currentRow: ''
                },
                inputData: {
                    username: '',
                    name: '',
                    cellphoneNumber: '',
                    email: '',
                    address: '',
                    description: ''
                }
            }
        }

    })
</script>
</html>