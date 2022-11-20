<template>
  <div gutter="md">
    <q-breadcrumbs>
      <template v-slot:separator>
        <q-icon size="1.2em" name="arrow_forward" color="purple" />
      </template>
      <div v-for="(item, index) in arrayBreadCrump" :key="index">
        <q-breadcrumbs-el
          class="breadCrumbsEl"
          :label="item.label"
          :icon="item.icon"
          :to="item.path"
        />
      </div>
    </q-breadcrumbs>
  </div>
</template>

<script>
import { defineComponent } from "vue";

export default defineComponent({
  name: "cp-breadcrump",

  props: {
    arrayBreadCrump: {
      typeof: Array,
      default: [],
      required: true,
    },
  },
  data() {
    return {};
  },

  methods: {},

  mounted() {},

  components: {},
});
</script>
<style lang="scss">
.breadCrumbsEl {
  color: $white;
  background-color: $davys-grey;
  padding: 10px;
  border-radius: 50px;
}
</style>
