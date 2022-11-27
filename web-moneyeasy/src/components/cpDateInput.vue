<template>
  <div class="mgn-cp">
    <q-input
      filled
      mask="date"
      :label="labelInput"
      :disable="disable"
      :readonly="disable"
      v-model="value"
    >
    </q-input>
  </div>
</template>

<script>
import { defineComponent } from "vue";

export default defineComponent({
  name: "CpInput",

  props: {
    modelValue: {
      type: [Date, String],
      default: null,
    },

    id: {
      type: String,
      required: true,
    },

    name: {
      type: String,
      required: true,
    },

    labelInput: {
      typeOf: String,
      default: "",
    },

    disable: {
      typeof: Boolean,
      default: false,
    },
  },

  methods: {
    clear() {
      this.value = "";
    },
  },

  computed: {
    value: {
      get() {
        return this.modelValue;
      },

      set(value) {
        this.$emit("update:modelValue", value);
      },
    },
  },
});
</script>
