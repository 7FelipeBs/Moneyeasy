<template>
  <div>
    <q-card>
      <q-card-section>
        <cp-breadcrump :arrayBreadCrump="pageInformation.crumbsPath" />
      </q-card-section>

      <div>
        <cp-search
          :columns="columns"
          :data="rows"
          :registerScreen="registerScreen"
          title="Employees"
        />
      </div>
    </q-card>
  </div>
</template>

<script>
import { defineComponent } from "vue";
import CpSearch from "../../../components/cpSearch.vue";
import CpBreadcrump from "../../../components/cpBreadcrump.vue";

export default defineComponent({
  name: "EmployeeSearch",

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
          label: "Birth Date)",
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
          birthDate: "02-09-2000",
          salary: 1808.45,
          operations: [],
        },
        {
          name: "Marcia",
          lastName: "Oliveira",
          birthDate: "30-11-1991",
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
      console.log("visualizou...");
      this.goScreen(item, true, "visualize");
    },
    edit(item) {
      console.log("editou...");
      this.goScreen(item, false, "edit");
    },
    delete() {
      console.log("deletou...");
    },
    registerScreen() {
      this.goScreen(null, false, "new");
    },

    goScreen(item, disable, operation) {
      this.$router.push({
        name: "employeeInfo",

        query: {
          disablePage: disable,
          operation: operation,
          item: item,
          label: "Employees",
          icon: "badge",
          path: "/employeeSearch",
          array: [...this.pageInformation.crumbsPath],
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
