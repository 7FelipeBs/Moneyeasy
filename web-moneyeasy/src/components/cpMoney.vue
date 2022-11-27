<template>
  <div>
    <q-field
      filled
      v-model="value"
      :label="labelMoney"
      class="mgn-cp"
      :disable="disable"
      :readonly="disable"
    >
      <template v-slot:control="{ id, floatingLabel, modelValue, emitValue }">
        <input
          v-show="floatingLabel"
          :id="id"
          :name="name"
          class="q-field__input text-right"
          :value="modelValue"
          :disable="disable"
          :readonly="disable"
          @change="(e) => emitValue(e.target.value)"
          v-money="moneyFormatForDirective"
        />
      </template>
    </q-field>
  </div>
</template>

<script>
import { ref } from "vue";
import { VMoney } from "v-money";

export default {
  props: {
    modelValue: {
      typeof: [String, Number],
      default: "",
    },

    id: {
      type: String,
      required: true,
    },

    name: {
      type: String,
      required: true,
    },

    labelMoney: {
      typeof: String,
      default: "",
    },

    disable: {
      typeof: Boolean,
      default: false,
    },
  },

  emits: ["update:modelValue"],

  setup() {
    const moneyFormatForDirective = ref({
      decimal: ".",
      thousands: ",",
      prefix: "$ ",
      suffix: "",
      precision: 2,
      masked: false /* doesn't work with directive */,
    });

    return {
      moneyFormatForDirective,
    };
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

  directives: { money: VMoney },
};
</script>
