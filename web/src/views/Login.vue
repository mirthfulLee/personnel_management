<template>
    <div id="login">
        <el-container>
            <el-main>
                <h1>人事管理系统</h1>
                <label>账号：</label>
                <el-input
                    type="text"
                    v-model="phone"
                    class="in"
                    ref="input1"
                    placeholder="手机号码"
                    maxlength="11"
                    clearable
                    show-word-limit
                    @blur="check_legal('phone')"
                />
                <br />

                <label>密码：</label>
                <el-input type="password" v-model="password" class="in" placeholder="请输入密码" />
                <br />
                <el-button type="primary" class="button" @click="submit">登录</el-button>
                <el-button class="button">注册</el-button>
            </el-main>
            <el-footer></el-footer>
        </el-container>
    </div>
</template>

<script>
export default {
    name: "login",
    
    components: {},
    data() {
        return {
            phone: "",
            password: "",
            manager: null
        };
    },
    methods: {
        submit () {
            
            console.log(this.phone);
            var that = this;
            axios
                .post("http://localhost:8181/manager/getByPhone", {
                    phone: this.phone,
                })
                .then(function(response){
                    that.manager = response.data;

                    if(that.manager.phone.length<11){
                        that.open("错误","该账号不存在");
                    }
                    if (that.equal(that.phone,that.manager.phone)
                    &&that.equal(that.password,that.manager.password)){
                        //登录成功
                        that.$router.push({
                            name: 'Departments',
                            params: {
                                manager: that.manager,
                            }
                        })
                    }else{
                        that.open("错误","账号密码不匹配");
                    }
                })
                .catch(function (error) {
                    console.log(error);
                    that.open("错误","该账号不存在");
                });
            
        },
        equal(input, sample) {
            if (input.length != sample.length) {
                return false;
            }
            for (var i = 0; i < input.length; i++) {
                if (input[i] != sample[i]) {
                    return false;
                }
            }
            return true;
        },
        legal_phone: function() {
            if (this.phone.length < 11) {
                return false;
            } else {
                for (var i = 0; i < 11; i++) {
                    return !isNaN(this.phone);
                }
            }
            return true;
        },
        //弹窗
        open(title, content) {
            this.$alert(content, title, {
                confirmButtonText: "确定",
                callback: (action) => {
                    this.$refs.input1.focus();
                },
            });
        },
        //检验账号合法性
        check_legal() {
            if (! this.legal_phone()) {
                this.open("错误","请输入合法的账号(手机号码)");
            }
        },
    },
};
</script>

<style scoped>
#login {
    font-family: "Microsoft YaHei";
    text-align: center;
    margin: 100px;
    padding: 150px;
    padding-top: 200px;
    background-color: rgb(144, 215, 218);
    max-width: 900px;
    min-width: 550px;
}
.in {
    width: 300px;
    margin: 20px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
.button {
    margin: 40px;
}
</style>