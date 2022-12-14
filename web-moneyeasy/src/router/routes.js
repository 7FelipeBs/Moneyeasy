const routes = [
  {
    path: "/",
    component: () => import("layouts/MainLayout.vue"),
    children: [
      { path: "", component: () => import("src/pages/Home.vue") },
      {
        path: "/login",
        name: "Login",
        component: () => import("src/pages/public/Login/LoginAcess.vue"),
      },
      {
        path: "/employeeSearch",
        name: "employeeSearch",
        component: () =>
          import("src/pages/private/Employee/EmployeeSearch.vue"),
      },
      {
        path: "/employeeInfo:item",
        name: "employeeInfo",
        component: () => import("src/pages/private/Employee/EmployeeInfo.vue"),
      },
    ],
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: "/:catchAll(.*)*",
    component: () => import("pages/ErrorNotFound.vue"),
  },
];

export default routes;
