<template>
  <header class="p-3 bg-dark text-white">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
          <router-link to="/">
            <img src="@/assets/logo-96.png" width="40" height="32" role="img" class="bi me-2"/>
          </router-link>
        </a>
        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li>
            <router-link class="nav-link px-2 text-white" to="/login">Login</router-link>
          </li>
          <li>
            <router-link class="nav-link px-2 text-white" to="/register">Register</router-link>
          </li>
        </ul>
      </div>
    </div>
  </header>
  <div class="container overflow-auto">
    <RouterView/>
  </div>
</template>

<script>

export default {
  name: 'App',
  components: {}
}
</script>

<style>
#app {

}
</style>
