<template>
  <div class="mgn-cp">
    <q-input filled v-model="inputValue" mask="date" :label="labelInput">
      <template v-slot:append>
        <q-icon name="event" class="cursor-pointer">
          <q-popup-proxy cover transition-show="scale" transition-hide="scale">
            <q-date v-model="inputValue">
              <div class="row items-center justify-end">
                <q-btn v-close-popup label="Close" color="primary" flat />
              </div>
            </q-date>
          </q-popup-proxy>
        </q-icon>
      </template>
    </q-input>
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
