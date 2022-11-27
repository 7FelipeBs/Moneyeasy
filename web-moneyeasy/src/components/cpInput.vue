<template>
  <div class="mgn-cp">
    <q-input
      :id="id"
      :name="name"
      ref="refQinput"
      :label="labelInput"
      v-model="value"
      :disable="disable"
      :readonly="disable"
      @input="$emit('update:modelValue', $event.target.value)"
    >
    </q-input>
  </div>
</template>

<script>
export default {
  name: "CpInput",

  props: {
    modelValue: {
      typeof: [String, Number],
      default: "",
    },

    id: {
      typeof: [String, Number],
      default: null,
      required: true,
    },

    name: {
      typeof: [String, Number],
      default: null,
      required: true,
    },

    labelInput: {
      typeof: String,
      default: "",
    },

    disable: {
      typeof: Boolean,
      default: false,
    },
  },

  emits: ["update:modelValue"],

  data() {
    return {};
  },

  methods: {
    clear() {
      this.value = "";
    },
    load(value) {
      /* Carrega a informação no v-model */
      this.value = value;
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
};
</script>
