<template>
	<div id="app">
		<!-- <Frame /> -->
		<router-view></router-view>
	</div>
</template>

<script>
	import Frame from './views/Frame.vue' 
	import Login from './views/Login'
	export default {
		data() {
			return{
				
			}
		},
		components:{
			Frame,
			Login
		}
	};
</script>

<style>
	
</style>
