<template>
  <div>
    <div>
      <q-form @submit="onSubmit" @reset="onReset" class="loginForm">
        <div class="text-h1 flex flex-center mgn-20">Sign Up</div>
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
            <q-btn icon="person_add" label="Sign Up" type="submit" size="lg" />
          </div>

          <div class="col-12 alignment">
            <q-btn icon="keyboard_return" label="Back Login" size="md" />
          </div>
        </div>
      </q-form>
    </div>
  </div>
</template>
<script>
import { useQuasar } from "quasar";
import { ref } from "vue";

export default {
  setup() {
    const $q = useQuasar();
    const username = ref(null);
    const password = ref(null);

    return {
      username,
      password,
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
    };
  },
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
