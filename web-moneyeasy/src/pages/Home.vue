<template>
  <q-page class="flex flex-center">
    <q-icon class="iconMoney" name="monetization_on" />
    <div class="title">Money Easy</div>
  </q-page>
</template>

<script>
import { defineComponent } from "vue";

export default defineComponent({
  name: "HomePage",
});
</script>
<style lang="scss">
.title {
  font-size: 8em;
  color: $davys-grey;
  font-family: "Roboto Mono";
}

.iconMoney {
  font-size: 8em;
  color: $lime-green;
}
</style>
