<template>

  <h3 v-if="isAuthenticated()">Welcome {{ getUsername() }}</h3>

</template>

<script>
import {GET_USERNAME, IS_USER_AUTHENTICATED} from "../store/storeconstants";

export default {
  name: 'WelcomeVIew',
  data() {
    return {}
  },
  methods: {
    isAuthenticated() {
      return this.$store.getters[`auth/${IS_USER_AUTHENTICATED}`];
    },
    getUsername() {
      return this.$store.getters[`auth/${GET_USERNAME}`];
    },
  }
}
</script>