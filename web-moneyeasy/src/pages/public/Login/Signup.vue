<template>
  <div class="align">
    <div class="row" style="max-width: 100%">
      <div class="col-12 fieldAcess">
        <q-input standout="bg-blue-2" v-model="username" label="Email" />
      </div>
      <div class="col-12 fieldAcess">
        <q-input standout="bg-blue-2" v-model="name" label="Name" />
      </div>

      <div class="col-12 fieldAcess">
        <q-input
          standout="bg-blue-2"
          v-model="password"
          type="password"
          label="Password"
        />
      </div>
      <div class="col-12 fieldAcess">
        <q-input
          standout="bg-blue-2"
          v-model="passwordVerify"
          type="password"
          label="Confirm Password"
        />
      </div>
    </div>
  </div>
</template>
<script>
import { defineComponent, ref } from "vue";

export default defineComponent({
  name: "SignupLogin",

  setup() {
    const username = ref("");
    const password = ref("");
    const passwordVerify = ref("");
    return {
      username,
      password,
      passwordVerify,
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
