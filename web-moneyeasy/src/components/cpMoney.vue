<template>
  <div>
    <q-field filled v-model="inputValue" :label="labelMoney" class="mgn-cp">
      <template v-slot:control="{ id, floatingLabel, modelValue, emitValue }">
        <input
          :id="id"
          class="q-field__input text-right"
          :value="modelValue"
          @change="(e) => emitValue(e.target.value)"
          v-money="moneyFormatForDirective"
          v-show="floatingLabel"
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
    labelMoney: {
      typeof: String,
      default: "",
    },
  },

  setup() {
    return {
      inputValue: ref(null),
      moneyFormatForDirective: {
        decimal: ".",
        thousands: ",",
        prefix: "$ ",
        suffix: "",
        precision: 2,
        masked: false /* doesn't work with directive */,
      },
    };
  },

  methods: {
    clear() {
      this.inputValue = "";
    },
  },

  directives: { money: VMoney },
};
</script>
