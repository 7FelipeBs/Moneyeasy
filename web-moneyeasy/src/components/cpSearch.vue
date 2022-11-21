<template>
  <div class="q-pa-sm">
    <q-card>
      <q-card-section>
        <div class="flex justify-between items-center row">
          <div class="col-12 title">
            <div class="text-title">{{ title }}</div>
          </div>

          <div class="col-6">
            <cp-input
              ref="refLastName"
              v-model="keywordsToSearch"
              labelInput="Search for keywords"
            />
          </div>
          <div>
            <q-btn
              class="btnNew"
              icon="add"
              ripple
              push
              round
              @click="registerScreen"
            />
          </div>
        </div>
      </q-card-section>
      <q-card-section>
        <q-table :rows="data" :columns="columns" row-key="name">
          <template v-slot:header="props">
            <q-tr :props="props">
              <q-th
                v-for="col in props.cols"
                :key="col.name"
                :props="props"
                class="text-title-table"
              >
                {{ col.label }}
              </q-th>
            </q-tr>
          </template>

          <template v-slot:body-cell-operations="props">
            <q-td :props="props">
              <div v-if="props.row" class="flex justify-center items-center">
                <div
                  v-for="(operation, index) in props.row.operations"
                  :key="index"
                >
                  <q-btn
                    ripple
                    dense
                    round
                    push
                    class="mgn-5"
                    :color="operation.color"
                    :icon="operation.icon"
                    @click="operation.click"
                  >
                    <q-tooltip
                      class="bg-davysGreys-soft text-white"
                      anchor="top middle"
                      self="bottom middle"
                      :offset="[10, 10]"
                      transition-show="flip-right"
                      transition-hide="flip-left"
                      >{{ operation.label }}</q-tooltip
                    ></q-btn
                  >
                </div>
              </div>
            </q-td>
          </template>
        </q-table>
      </q-card-section>
    </q-card>
  </div>
</template>

<script>
import { defineComponent, ref } from "vue";
import CpInput from "../components/cpInput.vue";

export default defineComponent({
  props: {
    title: {
      typeof: String,
      default: "",
      required: true,
    },

    columns: {
      typeof: Array,
      default: [],
      required: true,
    },

    data: {
      typeof: Array,
      default: [],
      required: true,
    },

    registerScreen: {
      typeof: Function,
      default: () => {},
      required: true,
    },
  },

  setup() {
    return {
      keywordsToSearch: ref(""),
    };
  },

  components: { CpInput },
});
</script>
<style lang="scss">
.titleSearch {
  color: $davys-grey;
}

.text-title-table {
  color: $dark-page;
}

.btnNew {
  color: $white;
  margin-right: 10px;
  background-color: $lime-green;
}
</style>
