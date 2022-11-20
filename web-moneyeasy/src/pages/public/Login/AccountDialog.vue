<template>
  <div>
    <q-dialog v-model="dialogAcess">
      <q-card>
        <q-card-section>
          <div class="text-h6 alignment titleAccount">User</div>
        </q-card-section>

        <q-card-section class="q-pt-none">
          <div class="row alignment">
            <div class="col-12" v-if="!openSignup">
              <Signin />
            </div>

            <div class="col-12" v-if="openSignup">
              <Signup />
            </div>

            <div class="col-12 btnAlign" v-if="!openSignup">
              <q-btn
                class="mg-5 btnSignin"
                icon="login"
                label="Signin"
                @click="signinAccount"
              />
              <q-btn
                class="mg-5 btnSignup"
                icon="person_add"
                label="Signup"
                @click="openSignup = true"
              />
            </div>

            <div class="col-12 btnAlign" v-if="openSignup">
              <q-btn
                class="mg-5 btnSignup"
                icon="person_add"
                label="Signup"
                @click="signupAccount"
              />
              <q-btn
                class="mg-5 btnSignin"
                icon="keyboard_return"
                label="Back"
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
<style lang="scss">
.alignment {
  display: flex;
  justify-content: center;
}
.btnAlign {
  display: flex;
  justify-content: center;
}

.btnSignup {
  color: $white;
  background-color: $lime-green;
}

.btnSignin {
  color: $white;
  background-color: $cerulean-crayola;
}

.titleAccount {
  font-family: $robotoMono;
  font-size: 2em;
  color: $davys-grey;
}
</style>
