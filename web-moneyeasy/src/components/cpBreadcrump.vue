<template>
  <div gutter="md" class="flex items-center breadCrumpCard">
    <q-breadcrumbs>
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
  padding: 12px;
  border-radius: 50px;
  font-size: 1em;
}

.breadCrumpCard {
  padding: 5px;
  background-color: $davys-grey-soft;
  border-radius: 10px;
  margin: 25px 10px;
}
</style>
