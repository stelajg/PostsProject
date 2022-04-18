<template>
  <div id="grid">
    <v-row>
      <v-col
        cols="12"
        sm="6"
        md="4"
      >
        <v-menu
          v-model="menu1"
          :close-on-content-click="false"
          :nudge-right="40"
          transition="scale-transition"
          offset-y
          min-width="auto"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-text-field
              v-model="startDate"
              label="Start Date"
              prepend-icon="mdi-calendar"
              readonly
              v-bind="attrs"
              v-on="on"
            ></v-text-field>
          </template>
          <v-date-picker
            v-model="startDate"
            @input="menu1 = false"
            @change="initialize()"
          ></v-date-picker>
        </v-menu>
      </v-col>
      <v-col
        cols="12"
        sm="6"
        md="4"
        align-self="end"
      >
        <v-menu
          v-model="menu2"
          :close-on-content-click="false"
          :nudge-right="40"
          transition="scale-transition"
          offset-y
          min-width="auto"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-text-field
              v-model="endDate"
              label="End Date"
              prepend-icon="mdi-calendar"
              readonly
              v-bind="attrs"
              v-on="on"
            ></v-text-field>
          </template>
          <v-date-picker
            v-model="endDate"
            @input="menu2 = false; "
            @change="initialize()"
            
          ></v-date-picker>
        </v-menu>
      </v-col>
      <v-col
          cols="12"
          sm="6"
        >
          <v-text-field
            :value="'Number of posts: ' + items.length"
            label="Solo"
            solo
            readonly
          ></v-text-field>
        </v-col>
    </v-row>
    <v-row dense align-content="center">
      <v-col cols="3" md="6" v-for="item in items" :key="item.id">
      <v-card
        :loading="loading"
        class="mx-auto my-12"
        max-width="374"
      >
        <template slot="progress">
          <v-progress-linear
            color="deep-purple"
            height="10"
            indeterminate
          ></v-progress-linear>
        </template>

        <v-card-title>{{formatPlatformName(item.permalink)}}</v-card-title>

        <v-img
          height="250"
          :src="item.picture"
        ></v-img>

        

        <v-card-text>
          <v-row align="center" class="mx-0"> </v-row>

          <div class="my-4 subtitle-1">
           Caption: {{item.caption}}
          </div>

          <div></div>
          <v-row align="center" class="mx-0"> </v-row>

          <div class="my-4 subtitle-1">
            Engagement: {{item.engagement}}
          </div>

          <div></div>
          <v-row align="center" class="mx-0"> </v-row>

          <div class="my-4 subtitle-1">
            Link: {{item.permalink}}
          </div>

          <div></div>
        </v-card-text>

        <v-divider class="mx-4"></v-divider>
      </v-card>

      </v-col>
      <v-col cols="12"
        sm="3"
        md="4"
        align-self="end">
      <vue-json-to-csv
        :json-data="items"
        :csv-title="'posts'"
      >
      <v-btn color="success" class="mr-6">
        Export <i class="mdi mdi-export-variant" aria-hidden="true"></i>
      </v-btn>
      </vue-json-to-csv>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import api from "../components/backend_api";
export default {
  name: "DisplayView",
  data: () => ({
    loading: false,
    selection: 1,
    items: [],
    menu1: false,
    startDate: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
    menu2: false,
    endDate: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10)
  }),
  created() {
    this.initialize();
  },
  methods: {
    initialize() {
      api
        .getPosts(this.startDate, this.endDate)
        .then(response => {
          console.log(response.data);
          this.items = response.data;
        })
        .catch(error => {
          this.errors.push(error);
        });
    },
    formatPlatformName(string){
      return string.split(".")[1].charAt(0).toUpperCase() + string.split(".")[1].slice(1);
    }
  }
};
</script>

<style scoped>
#grid{
  width: 60%;
  margin: auto;
  align-self: center;
}
</style>