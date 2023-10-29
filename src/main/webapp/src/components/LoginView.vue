<template>
  <main class="form-signin">
    <form>
      <div class="form-floating">
        <input class="form-control" type="text" id="username" v-model="input.username"/>
        <label class="form-label" for="username">Username</label>
      </div>
      <div class="form-floating">
        <input class="form-control" type="password" id="password" v-model="input.password"/>
        <label class="form-label" for="password">Password</label>
      </div>
      <div class="row mb-4">
        <div class="col d-flex justify-content-center">
          <!-- Checkbox -->
          <div class="form-check">
            <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked/>
            <label class="form-check-label" for="form2Example31"> Remember me </label>
          </div>
        </div>

        <div class="col">
          <!-- Simple link -->
          <a href="#!">Forgot password?</a>
        </div>
      </div>

      <button class="btn btn-primary btn-block mb-4" type="submit" v-on:click.prevent="login()">
        Login
      </button>

      <!-- Register buttons -->
      <div class="text-center">
        <p>Not a member? <a href="#!">Register</a></p>
      </div>
    </form>
  </main>
</template>

<script>
import {SET_AUTHENTICATION, SET_USERNAME} from "../store/storeconstants";

console.log("start?")
export default {
  name: 'LoginView',
  data() {
    return {
      input: {
        username: "",
        password: ""
      }
    }
  },
  methods: {
    login() {
      //make sure username OR password are not empty
      if (this.input.username !== "" || this.input.password !== "") {
        this.output = "Authentication complete"
        //stores true to the set_authentication and username to the set_username
        this.$store.commit(`auth/${SET_AUTHENTICATION}`, true);
        this.$store.commit(`auth/${SET_USERNAME}`, this.input.username);
        this.output = "Authentication complete."
        this.$router.push('/home')
      } else {
        this.$store.commit(`auth/${SET_AUTHENTICATION}`, false);
        this.output = "Username and password can not be empty"
      }
    }
  },
}
</script>

<style>
.form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;
}
.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="text"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>