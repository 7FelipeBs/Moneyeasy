<template>
  <div>
    <q-card>
      <cp-breadcrump :arrayBreadCrump="pageInformation.crumbsPath" />

      <div class="q-pa-sm">
        <q-card>
          <q-card-section>
            <div class="flex justify-between items-center row">
              <div class="col-12 title">
                <div class="text-title">{{ pageInformation.title }}</div>
              </div>
            </div>

            <div class="row">
              <div class="col-md-6 col-xs-12">
                <cp-input
                  ref="refName"
                  v-model="employee.name"
                  labelInput="Name"
                />
              </div>

              <div class="col-md-6 col-xs-12">
                <cp-input
                  ref="refLastName"
                  v-model="employee.lastName"
                  labelInput="Last Name"
                />
              </div>

              <div class="col-md-3 col-xs-12">
                <cp-date-input
                  ref="refBirthDate"
                  v-model="employee.birthDate"
                  labelInput="Birth Date"
                />
              </div>

              <div class="col-12">
                <cp-money
                  ref="refSalary"
                  v-model="employee.salary"
                  labelMoney="Salary"
                />
              </div>
            </div>

            <div class="col-12 btnOperation float-right">
              <q-btn
                round
                color="pinklavender"
                icon="clear"
                size="1.5em"
                class="mgn-5"
                @click="clearFiedls"
              />
              <q-btn
                round
                color="limerGreen"
                icon="done"
                size="1.5em"
                class="mgn-5"
              />
            </div>
          </q-card-section>
        </q-card>
      </div>
    </q-card>
  </div>
</template>

<script>
import { defineComponent, ref } from "vue";
import CpBreadcrump from "../../../components/cpBreadcrump.vue";
import CpMoney from "../../../components/cpMoney.vue";
import CpInput from "../../../components/cpInput.vue";
import CpDateInput from "../../../components/cpDateInput.vue";

export default defineComponent({
  name: "EmployeeInfo",

  setup() {
    return {};
  },

  data() {
    return {
      pageInformation: {
        crumbsPath: [],
        title: "",
      },

      employee: {
        birthDate: null,
        name: null,
        lastName: null,
        name: null,
        salary: null,
      },
    };
  },

  methods: {
    clearFiedls() {
      this.$refs.refSalary.clear();
      this.$refs.refBirthDate.clear();
      this.$refs.refLastName.clear();
      this.$refs.refName.clear();
    },

    loadInit() {
      if (this.pageInformation.operation !== "new") {
        this.employee = this.pageInformation.item;
      }
    },
  },

  mounted() {
    if (this.$route.params) {
      let pageInfo = JSON.parse(this.$route.params.item);

      this.pageInformation = {
        ...pageInfo,
      };
      this.pageInformation.crumbsPath.push({
        label: this.pageInformation.label,
        icon: this.pageInformation.icon,
        path: "/employeeInfo",
      });
    }

    this.loadInit();
  },

  components: { CpBreadcrump, CpMoney, CpInput, CpDateInput },
});
</script>
<style lang="scss">
.btnOperation {
  margin: 40px 25px;
}
</style>
