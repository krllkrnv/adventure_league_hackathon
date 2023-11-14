<template>
  <v-app>
    <navigation-bar>
      <router-view></router-view>
    </navigation-bar>
    <footer-component></footer-component>
  </v-app>
</template>

<script>
import registrationComponent from "./pages/authPage.vue";
import navigationBar from "./components/UI/navigationBar.vue";
import footerComponent from "./components/UI/footerComponent.vue";
export default {
  name: 'App',
  components: {
    registrationComponent, navigationBar, footerComponent
  },
}

</script>



<style lang="scss">
@import './styles.scss';
.v-application__wrap{
  background-color: #F3F1F1;
}
</style>
