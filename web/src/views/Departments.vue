<template>
    <div id="departments">
        <el-main>
            <el-table :data="departmentTable" style="width: 100%" row-key="id">
                <el-table-column prop="id" label="ID" ></el-table-column>
                <el-table-column prop="name" label="名称" ></el-table-column>
                <el-table-column prop="chief" label="负责人" ></el-table-column>
                <el-table-column prop="manager" label="总管" ></el-table-column>
                <el-table-column fixed="right" label="操作" >
                    <template slot-scope="scope">
                        <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
                        <el-button @click="deleteDepartment(scope.row)" type="text" size="small">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <el-pagination
                background
                layout="prev, pager, next"
                class="pagination"
                :page-size="pageSize"
                :total="total"
                @current-change="pageChange"
            ></el-pagination>
        </el-main>
    </div>
</template>

<script>
export default {
    data() {
        return {
            pageNo: 1,
            pageSize: 3,
            total: 0,
            manager: this.$route.params.manager,
            departmentTable: [],
        };
    },
    components: {},
    //方法
    methods: {
        edit: function (row) {
            console.log(row);
        },
        deleteDepartment: function (row) {
            console.log(row);
        },
        pageChange(currentPage) {
            this.pageNo = currentPage;
            var that = this;
            axios
                .post("http://localhost:8181/manager/getDepartments", {
                    pageNo: that.pageNo,
                    pageSize: that.pageSize,
                    manager: this.$route.params.manager.phone,
                })
                .then(function (response) {
                    console.log(response.data);
                    that.departmentTable = response.data.list;
                    that.total = response.data.total;
                })
                .catch(function(error){
                    console.log(error);
                });
        },
    },
    //生命周期钩子
    created: function () {
        var that = this;
        axios
            .post("http://localhost:8181/manager/getDepartments", {
                pageNo: that.pageNo,
                pageSize: that.pageSize,
                manager: this.$route.params.manager.phone,
            })
            .then(function (response) {
                that.departmentTable = response.data.list;
                that.total = response.data.total;
                // console.log(that.responseData);
            })
            .catch(function (error) {
                console.log(error);
            });
    },
};
</script>

<style>
#departments{
    font-family: "Microsoft YaHei";
    text-align: center;
    display: flex;
}
.pagination{
    margin: 40px;
}
</style>
