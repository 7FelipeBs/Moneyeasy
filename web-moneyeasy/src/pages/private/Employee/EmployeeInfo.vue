<template>
  <div>
    <q-card>
      <cp-breadcrump :arrayBreadCrump="pageInformation.crumbsPath" />

      <div class="q-pa-sm">
        <q-card>
          <q-card-section>
            <div class="flex justify-between items-center row">
              <div class="col-12 titleSearch">
                <div class="text-title">{{ pageInformation.title }}</div>
              </div>
            </div>

            <div class="row">
              <div class="col-md-6 col-xs-12">
                <cp-input
                  id="name"
                  name="name"
                  ref="refName"
                  labelInput="Name"
                  :disable="pageInformation.disablePage"
                  v-model="employee.name"
                />
              </div>

              <div class="col-md-6 col-xs-12">
                <cp-input
                  id="lastName"
                  name="lastName"
                  ref="refLastName"
                  labelInput="Last Name"
                  :disable="pageInformation.disablePage"
                  v-model="employee.lastName"
                />
              </div>

              <div class="col-md-3 col-xs-12">
                <cp-date-input
                  id="birthDate"
                  name="birthDate"
                  ref="refBirthDate"
                  labelInput="Birth Date"
                  :disable="pageInformation.disablePage"
                  v-model="employee.birthDate"
                />
              </div>

              <div class="col-md-3 col-xs-12">
                <cp-money
                  id="salary"
                  name="salary"
                  ref="refSalary"
                  labelMoney="Salary"
                  :disable="pageInformation.disablePage"
                  v-model="employee.salary"
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
                :disable="pageInformation.disablePage"
                @click="clearFiedls"
              />
              <q-btn
                round
                color="limerGreen"
                icon="done"
                size="1.5em"
                class="mgn-5"
                :disable="pageInformation.disablePage"
              />
            </div>
          </q-card-section>
        </q-card>
      </div>
    </q-card>
  </div>
</template>

<script>
import CpBreadcrump from "../../../components/cpBreadcrump.vue";
import CpMoney from "../../../components/cpMoney.vue";
import CpInput from "../../../components/cpInput.vue";
import CpDateInput from "../../../components/cpDateInput.vue";

export default {
  name: "EmployeeInfo",

  setup() {
    return {};
  },

  data() {
    return {
      pageInformation: {
        crumbsPath: [],
        title: "",
        disablePage: "",
      },

      employee: {
        birthDate: null,
        name: "",
        lastName: "",
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
        this.employee = this.pageInformation.entity;
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
};
</script>
<style lang="scss">
.btnOperation {
  margin: 40px 25px;
}
</style>
