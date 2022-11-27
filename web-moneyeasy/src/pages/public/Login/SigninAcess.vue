<template>
  <div class="fit row flex flex-center">
    <div v-if="loginAccount">
      <q-form @submit="onSubmit" @reset="onReset" class="loginForm">
        <div class="text-h1 flex flex-center mgn-20">Hello</div>
        <div class="text-h5 flex flex-center mgn-20">Welcome to Money Easy</div>
        <div class="row flex flex-center mgn-20">
          <div class="col-9 mgn-5">
            <q-input
              filled
              outlined
              lazy-rules
              label-color="white"
              color="white"
              label="Username"
              input-class="text-white"
              v-model="username"
            >
            </q-input>
          </div>

          <div class="col-9 mgn-5">
            <q-input
              filled
              outlined
              lazy-rules
              label-color="white"
              input-class="text-white"
              color="white"
              type="password"
              label="Password"
              v-model="password"
            />
          </div>

          <div class="col-12 alignment mgn-20">
            <q-btn icon="login" label="Sign In" type="submit" size="lg" />
          </div>

          <div class="col-12 alignment">
            <q-btn
              icon="add"
              label="Create Account"
              size="md"
              @click="openSignup"
            />
          </div>
        </div>
      </q-form>
    </div>

    <div v-else>
      <signup-acess />
    </div>
  </div>
</template>
<script>
import { useQuasar } from "quasar";
import { ref } from "vue";

import SignupAcess from "./SignupAcess.vue";

export default {
  setup() {
    const $q = useQuasar();

    const username = ref(null);
    const password = ref(null);

    const loginAccount = ref(true);
    return {
      username,
      password,
      loginAccount,

      onSubmit() {
        $q.notify({
          color: "green-4",
          textColor: "white",
          icon: "cloud_done",
          message: "Submitted",
        });
      },

      onReset() {
        username.value = null;
        password.value = null;
      },

      openSignup() {
        loginAccount.value = false;
      },
    };
  },

  components: { SignupAcess },
};
</script>
<style lang="scss">
.loginForm {
  color: $white;
}
.titleForm {
  font-family: $robotoMono;
  font-size: 2em;
  margin-bottom: 25px;
  color: $davys-grey;
}

.title {
  font-size: 8em;
  color: $davys-grey;
  text-shadow: 2px 1px 3px $davys-grey;
  font-family: "Roboto Mono";
}

.iconMoney {
  font-size: 8em;
  border-radius: 100%;
  color: $lime-green;
}

.alignment {
  display: flex;
  justify-content: center;
}
</style>
