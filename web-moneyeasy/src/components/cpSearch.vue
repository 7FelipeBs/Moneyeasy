<template>
  <div class="q-pa-sm">
    <q-card>
      <q-card-section>
        <div class="flex justify-between items-center row">
          <div class="col-12 titleSearch">
            <div class="text-title">{{ title }}</div>
          </div>

          <div class="col-6">
            <cp-input
              id="keywordsToSearch"
              name="keywordsToSearch"
              ref="refKeywordsToSearch"
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
        <q-table
          :rows="rows"
          :columns="columns"
          row-key="name"
          v-model:pagination="pagination"
          hide-pagination
        >
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
                    @click="operation.click(getFormatRow(props.row))"
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

        <div class="row justify-center q-mt-md">
          <q-pagination
            v-model="pagination.page"
            color="grey-8"
            direction-links
            boundary-links
            :max-pages="5"
            :boundary-numbers="false"
            icon-first="first_page"
            icon-last="last_page"
            icon-prev="chevron_left"
            icon-next="chevron_right"
            :max="pagesNumber"
            size="md"
          />
        </div>
      </q-card-section>
    </q-card>
  </div>
</template>

<script>
import { defineComponent, ref, computed } from "vue";
import util from "src/scripts/util";

import CpInput from "./cpInput.vue";

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

    rows: {
      typeof: Array,
      default: [],
      required: true,
    },

    registerScreen: {
      typeof: Function,
      default: () => {},
      required: true,
    },

    rowsPerPage: {
      typeof: Number,
      default: 5,
    },
  },

  setup(props) {
    const pagination = ref({
      sortBy: "desc",
      descending: false,
      page: 0,
      rowsPerPage: props.rowsPerPage,
      // rowsNumber: xx if getting data from a server
    });

    return {
      keywordsToSearch: ref(""),
      pagination,
      pagesNumber: computed(() =>
        Math.ceil(props.rows.length / pagination.value.rowsPerPage)
      ),
    };
  },

  methods: {
    getFormatRow(row) {
      if (util.validyProperty(row.operations)) delete row["operations"];
      return row;
    },
  },

  components: { CpInput },
});
</script>
<style lang="scss">
.text-title-table {
  color: $dark-page;
}

.btnNew {
  color: $white;
  margin-right: 10px;
  background-color: $lime-green;
}
</style>
