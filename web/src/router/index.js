import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Login",
    component: () => import("@/views/Login"),
  },
  {
    path: "/Frame",
    name: "Frame",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ "../views/Frame"),
    children: [
      {
        path: '/departments',
        name: 'Departments',
        component: () =>import("../views/Departments")
      },
      {
        path: '/addDepartment',
        name: 'AddDepartment',
        component:()=>import("../views/AddDepartment")
      }
    ]
  }
  
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
