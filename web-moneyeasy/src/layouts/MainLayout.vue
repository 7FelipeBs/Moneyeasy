<template>
  <q-layout view="hHh Lpr lff" style="height: 300px">
    <q-header elevated class="menu">
      <q-toolbar>
        <q-btn flat @click="drawer = !drawer" round dense icon="menu" />
        <q-toolbar-title style="font-family: 'Roboto Mono'">
          Menu
        </q-toolbar-title>
      </q-toolbar>

      <q-drawer
        v-model="drawer"
        class="secondary btnMenuOptions"
        show-if-above
        side="left"
        bordered
      >
        <q-list>
          <template v-for="(menuItem, index) in menuList" :key="index">
            <q-item
              clickable
              @click="goRouteItem(menuItem)"
              :class="[
                selectedItem.label === menuItem.label ? 'bg-blue-grey-1' : '',
              ]"
              v-ripple
            >
              <q-item-section avatar>
                <q-icon :name="menuItem.icon" />
              </q-item-section>
              <q-item-section>
                {{ menuItem.label }}
              </q-item-section>
            </q-item>
            <q-separator v-if="index === 0" />
          </template>
        </q-list>
      </q-drawer>
    </q-header>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script>
import { defineComponent, ref } from "vue";

import menu from "src/scripts/menu";

export default defineComponent({
  name: "MainLayout",

  setup() {
    return {
      menuList: menu,

      drawer: ref(true),
      selectedItem: ref(""),
      dialogOpen: ref(false),
    };
  },

  methods: {
    goRouteItem(item) {
      this.selectedItem = item;
      this.$router.push(item.path);
    },
  },
});
</script>
