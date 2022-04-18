import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import JsonExcel from "../node_modules/vue-json-excel";
import VueJsonToCsv from '../node_modules/vue-json-to-csv'
Vue.component("downloadExcel", JsonExcel);
Vue.component("vue-json-to-csv", VueJsonToCsv);
new Vue({
  vuetify,
  render: h => h(App)
}).$mount('#app')
