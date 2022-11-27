<template>
  <div>
    <q-card>
      <div>
        <cp-breadcrump :arrayBreadCrump="pageInformation.crumbsPath" />
      </div>

      <div>
        <cp-search
          :columns="columns"
          :rows="rows"
          :registerScreen="registerScreen"
          :title="pageInformation.title"
        />
      </div>
    </q-card>
  </div>
</template>

<script>
import { defineComponent } from "vue";

import CpSearch from "components/cpSearch.vue";
import CpBreadcrump from "components/cpBreadcrump.vue";

export default defineComponent({
  name: "EmployeeSearch",
  setup() {
    return {};
  },
  data() {
    return {
      columns: [
        {
          name: "name",
          required: true,
          label: "Name",
          align: "left",
          field: (row) => row.name,
        },
        {
          name: "lastName",
          align: "left",
          label: "Last Name",
          field: (row) => row.lastName,
        },
        {
          name: "birthDate",
          label: "Birth Date",
          align: "center",
          field: (row) => row.birthDate,
        },
        {
          name: "salary",
          label: "Salary",
          field: "salary",
          align: "center",
        },
        {
          name: "operations",
          label: "Operations",
          field: "operations",
          align: "center",
        },
      ],

      rows: [
        {
          name: "Felipe",
          lastName: "Silva",
          birthDate: "2000-02-09",
          salary: 1808.45,
          operations: [],
        },
        {
          name: "Marcia",
          lastName: "Oliveira",
          birthDate: "1991-11-30",
          salary: 4968.54,
          operations: [],
        },
        {
          name: "Antonia",
          lastName: "Souza",
          birthDate: "2000-02-09",
          salary: 1808.45,
          operations: [],
        },
        {
          name: "Renato",
          lastName: "Henrique",
          birthDate: "1991-11-30",
          salary: 4968.54,
          operations: [],
        },
        {
          name: "Brayan",
          lastName: "Oliveira",
          birthDate: "2000-02-09",
          salary: 1808.45,
          operations: [],
        },
        {
          name: "Lucas",
          lastName: "Santana",
          birthDate: "1991-11-30",
          salary: 4968.54,
          operations: [],
        },
        {
          name: "Monique",
          lastName: "Cardoso",
          birthDate: "2000-02-09",
          salary: 1808.45,
          operations: [],
        },
        {
          name: "Olivia",
          lastName: "Silva",
          birthDate: "1991-11-30",
          salary: 4968.54,
          operations: [],
        },
        {
          name: "Herinque",
          lastName: "Machado",
          birthDate: "2000-02-09",
          salary: 1808.45,
          operations: [],
        },
        {
          name: "Ryan",
          lastName: "Barbosa",
          birthDate: "1991-11-30",
          salary: 4968.54,
          operations: [],
        },
      ],

      operations: [
        {
          label: "Visualizer",
          icon: "visibility",
          color: "primary",
          click: this.visualize,
        },
        {
          label: "Edit",
          icon: "edit",
          color: "secondary",
          click: this.edit,
        },
        {
          label: "Delete",
          icon: "delete",
          color: "negative",
          click: this.delete,
        },
      ],

      pageInformation: {
        title: "Employees",
        crumbsPath: [
          {
            label: "Employees",
            icon: "badge",
            path: "/employeeSearch",
          },
        ],
      },
    };
  },

  methods: {
    visualize(item) {
      this.goScreen({
        operation: "visualize",
        icon: "visibility",
        label: "Visualize Employee",
        entity: item,
        disable: true,
      });
    },
    edit(item) {
      this.goScreen({
        operation: "edit",
        icon: "edit",
        label: "Edit Employee",
        entity: item,
        disable: false,
      });
    },
    delete() {
      console.log("delete...");
    },
    registerScreen() {
      this.goScreen({
        operation: "new",
        icon: "add",
        label: "New Employee",
        entity: null,
        disable: false,
      });
    },

    goScreen(item) {
      this.$router.push({
        name: "employeeInfo",
        params: {
          item: JSON.stringify({
            ...this.pageInformation,
            disablePage: item.disable,
            operation: item.operation,
            entity: item.entity,
            icon: item.icon,
            label: item.label,
            path: "/employeeSearch",
          }),
        },
      });
    },
  },

  mounted() {
    this.operations.forEach((operation) => {
      this.rows.forEach((item) => {
        item.operations.push(operation);
      });
    });
  },

  components: { CpSearch, CpBreadcrump },
});
</script>
<style lang="scss"></style>
