<template>
    <div id="table">
        <el-main>
            <el-table :data="tableData" style="width: 100%">
                <el-table-column prop="date" label="日期" width="140"></el-table-column>
                <el-table-column prop="name" label="姓名" width="120"></el-table-column>
                <el-table-column prop="address" label="地址"></el-table-column>
                <el-table-column fixed="right" label="操作" width="100">
                    <template slot-scope="scope">
                        <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
                        <el-button @click="deleteBook(scope.row)" type="text" size="small">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </el-main>
    </div>
</template>

<script>
export default {
    data() {
        const item = {
            date: "2016-05-02",
            name: "王小虎",
            address: "上海市普陀区金沙江路 1518 弄",
        };
        return {
            manager: this.$route.params.manager,
            tableData: Array(10).fill(item),
        };
    },
    components: {},
};
</script>

<style>
#Table {
    font-family: "Avenir", Helvetica, Arial, sans-serif;
    text-align: center;
    width: 800px;
}
</style>
