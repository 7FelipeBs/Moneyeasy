<template>
  <q-page class="fit row">
    <div class="bg-davysGreys-trans col-6">
      <div class="fit row flex flex-center">
        <q-icon class="iconMoney" name="monetization_on" />
        <span class="title">Money Easy</span>
      </div>
    </div>

    <div class="bg-pinklavender col-6">
      <signin />
    </div>
  </q-page>
</template>

<script>
import Signin from "./SigninAcess.vue";

export default {
  setup() {
    return {};
  },

  components: { Signin },
};
</script>
