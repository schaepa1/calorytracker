<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Mein Kalorienbedarf</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-grid :style="{ paddingTop: '50px' }">
        <ion-row :style="{ display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center' }">
          <ion-col align-self-center size-md="6" size-lg="5" size-xs="12">
            <ion-header collapse="condense">
              <ion-toolbar>
                <ion-title size="large">Mein Kalorienbedarf</ion-title>
              </ion-toolbar>
            </ion-header>
            <div :style="{ display: 'flex', flexDirection: 'column', justifyContent: 'center' }">
              <ion-item>
                <ion-label position="stacked">
                  Kalorienbedarf zum abnehmen
                </ion-label>
                <ion-input disabled type="number" v-model="demands.weightLose" required></ion-input>
              </ion-item>
              <ion-item>
                <ion-label position="stacked">
                  Kalorienbedarf zum Gewicht halten
                </ion-label>
                <ion-input disabled type="number" v-model="demands.weightKeep" required></ion-input>
              </ion-item>
              <ion-item>
                <ion-label position="stacked">
                  Kalorienbedarf zum zunehmen
                </ion-label>
                <ion-input disabled type="number" v-model="demands.weightGain" required></ion-input>
              </ion-item>
              <div padding>
                <ion-button router-link="/tabs/demandCalculator" size="large" expand="block">Neu Berechnen</ion-button>
              </div>
            </div>
          </ion-col>
        </ion-row>
      </ion-grid>
    </ion-content>
  </ion-page>
</template>

<script>
import { defineComponent } from 'vue';
import axios from 'axios';
import { API_ROOT } from "@/config/development";
import {
  IonPage,
  IonHeader,
  IonToolbar,
  IonTitle,
  IonContent,
  IonCol,
  IonRow,
  IonGrid,
  IonItem,
  IonButton,
  IonInput,
  IonLabel,
} from "@ionic/vue";

export default defineComponent({
  name: "DemandCalculator",
  components: {
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonPage,
    IonCol,
    IonRow,
    IonGrid,
    IonItem,
    IonButton,
    IonInput,
    IonLabel,
  },
  data() {
    return {
      demands: {
        weightKeep: 0,
        weightLose: 0,
        weightGain: 0,
      },
    };
  },
  methods: {
    getDemands() {

      this.demands = {
        weightKeep: 3000,
        weightLose: 2600,
        weightGain: 3500,
      }
      const config = {
        withCredentials: true
      }
      axios.get(API_ROOT + '/api/users', config)
        .then(response => {
          this.demands.weightKeep = response.data.userWeightKeepCalories;
          this.demands.weightLose = response.data.userWeightLoseCalories;
          this.demands.weightGain = response.data.userWeightGainCalories;
        })
    },
  },

  mounted() {
    this.getDemands();
  },
});
</script>