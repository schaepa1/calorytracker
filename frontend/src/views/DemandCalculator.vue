<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Bedarfsrechner</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-grid>
        <ion-row justify-content-center>
          <ion-col align-self-center>
            <ion-header collapse="condense">
              <ion-toolbar>
                <ion-title size="large">Bedarfsrechner</ion-title>
              </ion-toolbar>
            </ion-header>
            <div :style="{ display: 'flex', flexDirection: 'column', justifyContent: 'center' }">
              <ion-item>
                <ion-label position="stacked">
                  Grösse (cm)
                </ion-label>
                <ion-input type="number" v-model="calculationData.height" required></ion-input>
              </ion-item>
              <ion-item>
                <ion-label position="stacked">
                  Gewicht (kg)
                </ion-label>
                <ion-input type="number" v-model="calculationData.weight" required></ion-input>
              </ion-item>
              <ion-item>
                <ion-label position="stacked">
                  Alter (Jahre)
                </ion-label>
                <ion-input type="number" v-model="calculationData.age" required></ion-input>
              </ion-item>
              <div padding>
                <ion-button size="large" @click="addNewProduct" expand="block">Berechnen</ion-button>
              </div>
            </div>
          </ion-col>
        </ion-row>
      </ion-grid>
    </ion-content>
  </ion-page>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
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
      calculationData: {
        height: null,
        weight: null,
        age: null,
        sex: '',
        activity: null,
      },
    };
  },
  methods: {
    addNewProduct() {
      console.log("BEDARF BERECHNET");
      this.calculationData = {
        height: null,
        weight: null,
        age: null,
        sex: '',
        activity: null,
      };
    }
  }
});
</script>