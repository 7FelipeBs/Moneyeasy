<template>
  <div class="align">
    <div class="row" style="max-width: 100%">
      <div class="col-12 fieldAcess">
        <q-input
          standout="bg-blue-2"
          v-model="username"
          type="username"
          label="Username"
        />
      </div>

      <div class="col-12 fieldAcess">
        <q-input
          standout="bg-blue-2"
          v-model="password"
          type="password"
          label="password"
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
<style>
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
