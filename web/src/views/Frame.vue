<template>
    <div id="frame">
        <el-container style="height: 800px; border: 1px solid #eee">
            <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
                <el-menu :default-openeds="['1']">
                    <el-submenu index="1">
                        <template slot="title">
                            <i class="el-icon-user"></i>人事管理
                        </template>
                        <el-menu-item-group>
                            <template slot="title">部门管理</template>
                            <el-menu-item
                                index="departments"
                                :class="$route.path=='/departments'?'is-active':''"
                                @click="changePage('Departments')"
                            >查看部门</el-menu-item>
                            <el-menu-item
                                index="addDepartment"
                                :class="$route.path=='/addDepartment'?'is-active':''"
                                @click="changePage('AddDepartment')"
                            >新增部门</el-menu-item>
                        </el-menu-item-group>
                        <el-menu-item-group title="员工管理">
                            <el-menu-item
                                index="employees"
                                :class="$route.path=='/employees'?'is-active':''"
                            >查看员工</el-menu-item>
                            <el-menu-item
                                index="addEmployee"
                                :class="$route.path=='/addEmployee'?'is-active':''"
                            >新增员工</el-menu-item>
                        </el-menu-item-group>
                    </el-submenu>
                    <el-submenu index="2">
                        <template slot="title">
                            <i class="el-icon-menu"></i>工资发放
                        </template>
                        <el-menu-item-group>
                            <template slot="title">分组一</template>
                            <el-menu-item index="2-1">选项1</el-menu-item>
                            <el-menu-item index="2-2">选项2</el-menu-item>
                        </el-menu-item-group>
                        <el-menu-item-group title="分组2">
                            <el-menu-item index="2-3">选项3</el-menu-item>
                        </el-menu-item-group>
                    </el-submenu>
                </el-menu>
            </el-aside>

            <el-container style="border: 1px solid #eee;width: 500px">
                <el-header style="text-align: right; font-size: 18px">
                    <span>{{manager.name}}</span>
                    <el-dropdown>
                        <i class="el-icon-setting" style="margin: 15px; size:auto"></i>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item>查看</el-dropdown-item>
                            <el-dropdown-item>修改密码</el-dropdown-item>
                            <el-dropdown-item>退出登录</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                </el-header>

                <router-view></router-view>
            </el-container>
        </el-container>
    </div>
</template>

<script>
export default {
    name: "frame",
    data() {
        return {
            manager: this.$route.params.manager,
        };
    },
    methods: {
        changePage: function (destination) {
            if (this.$route.name !== destination) {
                this.$router.push({
                    name: destination,
                    params: {
                        manager: this.manager,
                    },
                });
            }
        },
    },
};
</script>

<style>
#Frame {
    font-family: "Avenir", Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
}
.el-header {
    background-color: #b3c0d1;
    color: #333;
    line-height: 60px;
}

.el-aside {
    color: #333;
}
</style>
