<template>
  <div>
    <q-dialog v-model="dialogAcess">
      <q-card>
        <q-card-section>
          <div class="text-h6 alignment">Account</div>
        </q-card-section>

        <q-card-section class="q-pt-none">
          <div class="row alignment">
            <div class="col-12" v-if="!openSignup">
              <Signin />
            </div>

            <div class="col-12" v-if="openSignup">
              <Signup />
            </div>

            <div class="col-12 btnAcesso" v-if="!openSignup">
              <q-btn
                class="mg-5"
                icon="login"
                label="Signin"
                color="primary"
                @click="signinAccount"
              />
              <q-btn
                class="mg-5"
                icon="person_add"
                label="Signup"
                @click="openSignup = true"
                color="negative"
              />
            </div>

            <div class="col-12 btnAcesso" v-if="openSignup">
              <q-btn
                class="mg-5"
                icon="person_add"
                label="Signup"
                @click="signupAccount"
                color="positive"
              />
              <q-btn
                class="mg-5"
                icon="keyboard_return"
                label="Back"
                color="negative"
                @click="openSignup = false"
              />
            </div>
          </div>
        </q-card-section>
      </q-card>
    </q-dialog>
  </div>
</template>

<script>
import { defineComponent, ref } from "vue";
import Signin from "./Signin.vue";
import Signup from "./Signup.vue";

export default defineComponent({
  name: "AccountDialog",

  props: {
    value: {
      typeof: Boolean,
      default: false,
    },
  },
  setup() {
    const dialogAcess = ref(false);
    const openSignup = ref(false);

    return {
      dialogAcess,
      openSignup,

      abrirDialogMenu() {
        menu.value = true;
      },

      fecharDialogMenu() {
        menu.value = false;
      },

      userAcess() {
        console.log("acessado");
      },
    };
  },

  methods: {
    openAccount() {
      this.dialogAcess = true;
    },

    signupAccount() {
      console.log("cadastrando...");
    },
    signinAccount() {
      console.log("logando...");
    },
  },

  components: { Signup, Signin },
});
</script>
<style>
.alignment {
  display: flex;
  justify-content: center;
}
.btnAcesso {
  display: flex;
  justify-content: center;
}
</style>
