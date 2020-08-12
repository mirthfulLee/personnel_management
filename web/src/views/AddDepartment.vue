<template>
    <div id="addDepartment">
        <el-main style="display:flex;margin-left:40%">
            <el-form
                label-position="top"
                label-width="100px"
                ref="department"
                :rules="rules"
                :model="department"
                class="demo-ruleForm"
            >
                <el-form-item label="名称" prop="name">
                    <el-input v-model="department.name"></el-input>
                </el-form-item>
                <el-form-item label="部长" prop="chief" placeholder="请输入部长手机号码">
                    <el-input v-model="department.chief"></el-input>
                </el-form-item>
                <el-form-item label="工作时薪" prop="salaryPerHour">
                    <el-input v-model="department.salaryPerHour"></el-input>
                </el-form-item>
                <el-form-item label="加班时薪" prop="overtimePayPerHour">
                    <el-input v-model="department.overtimePayPerHour"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm('department')">立即创建</el-button>
                    <el-button @click="resetForm('department')">重置</el-button>
                </el-form-item>
            </el-form>
        </el-main>
    </div>
</template>

<script>
export default {
    data() {
        return {
            department: {
                name: "",
                chief: undefined,
                manager: "",
                salaryPerHour: 40.0,
                overtimePayPerHour: 50.0,
            },
            rules: {
                name: [
                    {
                        required: true,
                        message: "请输入部门名称",
                        trigger: "blur",
                    },
                    {
                        min: 2,
                        max: 7,
                        message: "长度在2-7个字符",
                        trigger: "blur",
                    },
                ],
                chief: [
                    {
                        min: 11,
                        max: 11,
                        message: "请输入正确的手机号码",
                        trigger: "blur",
                    },
                ],
                salaryPerHour: [
                    {
                        required: true,
                        message: "请输入工作时薪",
                        trigger: "blur",
                    },
                ],
                overtimePayPerHour: [
                    {
                        required: true,
                        message: "请输入加班时薪",
                        trigger: "blur",
                    },
                ],
            },
        };
    },
    methods: {
        submitForm(formName) {
            var that = this;
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    alert("submit!");
                    axios
                        .post("http://localhost:8181/department/add", {
                            name: that.department.name,
                            chief: that.department.chief,
                            manager: that.department.manager,
                            salaryPerHour: that.department.salaryPerHour,
                            overtimePayPerHour: that.department.overtimePayPerHour,
                        })
                        .then(function (response) {
                            console.log(response);
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
                } else {
                    console.log("error submit!!");
                    return false;
                }
            });
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        },
    },
    created: function () {
        this.department.manager = this.$route.params.manager.phone;
    },
};
</script>

<style>
</style>