<template>
  <div>
    <q-card>
      <q-card-section>
        <cp-breadcrump :arrayBreadCrump="pageInformation.crumbsPath" />
      </q-card-section>
    </q-card>
  </div>
</template>

<script>
import { defineComponent } from "vue";
import CpBreadcrump from "../../../components/cpBreadcrump.vue";

export default defineComponent({
  name: "EmployeeInfo",

  setup() {
    return {};
  },

  data() {
    return {
      pageInformation: {
        crumbsPath: [],
      },
    };
  },

  methods: {
    loadPageInformation(query) {
      this.pageInformation = {
        ...this.pageInformation,
        ...query,
      };
      this.pageInformation.crumbsPath.push({
        label: this.pageInformation.label,
        icon: this.pageInformation.icon,
        path: this.pageInformation.path,
      });
      debugger;
      this.pageInformation.crumbsPath.push({
        label: "New Register",
        icon: this.getIcon(this.pageInformation.operation),
        path: "/employeeInfo",
      });
      console.log(this.pageInformation);
    },

    getIcon(operation) {
      if (operation === "new") return "add";
    },
  },

  mounted() {
    if (this.$route.query) {
      this.loadPageInformation(this.$route.query);
    }
  },

  components: { CpBreadcrump },
});
</script>
<style lang="scss"></style>
