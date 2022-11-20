<template>
  <div class="align">
    <div class="row">
      <div class="col-12 fieldAcess">
        <q-input
          standout="bg-davysGreys-soft"
          filled
          v-model="username"
          type="username"
          label-color="davysGreys"
          placeholder="Username"
        />
      </div>

      <div class="col-12 fieldAcess">
        <q-input
          standout="bg-davysGreys-soft"
          filled
          v-model="password"
          type="password"
          label-color="davysGreys"
          placeholder="password"
        />
      </div>
    </div>
  </div>
</template>
<script>
import { defineComponent, ref } from "vue";

export default defineComponent({
  name: "SigninLogin",

  setup() {
    const username = ref("");
    const password = ref("");
    return {
      username,
      password,
    };
  },
});
</script>
<style lang="scss">
.align {
  display: flex;
  justify-content: center;
}

.fieldAcess {
  margin: 15px auto;
  padding: 0;
}

.mg-5 {
  margin: 5px;
}
</style>
