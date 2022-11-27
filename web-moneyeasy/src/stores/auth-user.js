import { defineStore } from "pinia";
// import { router } from "/src/router";

import AuthService from "src/services/auth.services";
import tokenService from "src/services/token.service";

export const authStore = defineStore({
  state: () => ({
    // initialize state from local storage to enable user to stay logged in
    stateAuth: {
      status: {
        loggedIn: false,
      },
    user: tokenService.getUser(),
    },
  }),
  actions: {
      async login(user) {
        return AuthService.login(user).then(
          (user) => {
            this.loginSuccess(this.stateAuth, user);
            return Promise.resolve(user);
          },
          (error) => {
            this.loginFailure();
            return Promise.reject(error);
          }
        );
      },
      async register(user) {
        return AuthService.register(user).then(
          (response) => {
            this.$patch("registerSuccess");
            return Promise.resolve(response.data);
          },
          (error) => {
            this.$patch("registerFailure");
            return Promise.reject(error);
          }
        );
      },
      refreshToken(accessToken) {
        this.refreshToken(accessToken);
      },
      logout() {
        AuthService.logout();
        this.logout();
      },
      loginSuccess(user) {
        this.stateAuth.status.loggedIn = true;
        this.stateAuth.user = user;
      },
      loginFailure() {
        this.stateAuth.status.loggedIn = false;
        this.stateAuth.user = null;
      },
      logout() {
        this.stateAuth.status.loggedIn = false;
        this.stateAuth.user = null;
      },
      registerSuccess() {
        this.stateAuth.status.loggedIn = false;
        this.stateAuth.user = null;
      },
      registerFailure() {
        this.stateAuth.status.loggedIn = false;
        this.stateAuth.user = null;
      },
      refreshToken(accessToken) {
        this.stateAuth.status.loggedIn = true;
        this.stateAuth.user = { ...stateAuth.user, accessToken: accessToken };
      },
  },
});
