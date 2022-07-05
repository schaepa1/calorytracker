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
              <ion-list>
                <ion-radio-group v-model="calculationData.sex" value="sex">
                  <ion-list-header>
                    <ion-label>Geschlecht</ion-label>
                  </ion-list-header>

                  <ion-item>
                    <ion-label>Männlich</ion-label>
                    <ion-radio slot="start" value="m"></ion-radio>
                  </ion-item>

                  <ion-item>
                    <ion-label>Weiblich</ion-label>
                    <ion-radio slot="start" value="f"></ion-radio>
                  </ion-item>
                </ion-radio-group>
              </ion-list>
              <ion-list>
                <ion-item>
                  <ion-select placeholder="Wie aktiv bist du körperlich?">
                    <ion-select-option value="1">Ich bewege mich kaum</ion-select-option>
                    <ion-select-option value="2">Ich bewege mich ab und zu</ion-select-option>
                    <ion-select-option value="3">Ich bewege mich </ion-select-option>
                  </ion-select>
                </ion-item>
              </ion-list>
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
  IonRadio,
  IonRadioGroup,
  IonList,
  IonListHeader,
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
    IonRadio,
    IonRadioGroup,
    IonList,
    IonListHeader,
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