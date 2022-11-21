<template>
  <div class="mgn-cp">
    <q-input filled v-model="inputValue" :label="labelInput" />
  </div>
</template>

<script>
import { defineComponent } from "vue";

export default defineComponent({
  name: "CpInput",

  props: {
    labelInput: {
      typeOf: String,
      default: "",
    },
  },

  data() {
    return {
      inputValue: "",
    };
  },

  methods: {
    clear() {
      this.inputValue = "";
    },
  },
});
</script>
