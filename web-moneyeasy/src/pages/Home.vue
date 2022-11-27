<template>
  <q-page class="flex flex-center">
    <q-icon class="iconMoneyHome" name="monetization_on" />
    <div class="titleHome">Money Easy</div>
  </q-page>
</template>

<script>
import { defineComponent } from "vue";

export default defineComponent({
  name: "HomePage",
});
</script>
<style lang="scss">
.titleHome {
  font-size: 8em;
  text-shadow: 2px 1px 3px $davys-grey;
  color: $davys-grey;
  font-family: "Roboto Mono";
}

.iconMoneyHome {
  font-size: 8em;
  color: $lime-green;
}
</style>
