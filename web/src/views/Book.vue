<template>
    <div class="book">
        <h1>This is Book page</h1>
        <table>
            <tr>
                <td>编号</td>
                <td>图书名称</td>
                <td>作者</td>
            </tr>
            <tr v-for="item in books" :key="item.id">
                <td>{{item.id}}</td>
                <td>{{item.name}}</td>
                <td>{{item.author}}</td>

            </tr>
        </table>

    </div>
</template>

<script>
    export default {
        name: "Book",
        data(){
            return{
                msg: 'Hello World',
                books:[
                    {
                        id: 1,
                        name:'ahhhhhhhhhhhhhhhhhhhhhhh',
                        author:'张三'
                    },
                    {
                        id:2,
                        name:'小黄书',
                        author: '李四'
                    },
                    {
                        id: 3,
                        name: '王五传',
                        author:'王五'

                    }
                ]
            }
        }
    }

</script>

<style scoped>

</style>