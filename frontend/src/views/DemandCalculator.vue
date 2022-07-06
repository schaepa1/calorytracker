<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Bedarfsrechner</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-grid :style="{ paddingTop: '50px' }">
        <ion-row :style="{ display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center' }">
          <ion-col align-self-center size-md="6" size-lg="5" size-xs="12">
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
                <ion-input type="number" v-model="height" required></ion-input>
              </ion-item>
              <ion-item>
                <ion-label position="stacked">
                  Gewicht (kg)
                </ion-label>
                <ion-input type="number" v-model="weight" required></ion-input>
              </ion-item>
              <ion-item>
                <ion-label position="stacked">
                  Alter (Jahre)
                </ion-label>
                <ion-input type="number" v-model="age" required></ion-input>
              </ion-item>
              <ion-list>
                <ion-radio-group v-model="sex" value="sex">
                  <ion-item>
                    <ion-label>Geschlecht</ion-label>
                  </ion-item>

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
                  <ion-label position="stacked">
                    Deine körperliche Aktivität <br /> (1 = kaum aktiv, 4 = sehr aktiv)
                  </ion-label>
                  <ion-select v-model="activity" placeholder="Wie aktiv bist du körperlich?">
                    <ion-select-option value=0.4>1</ion-select-option>
                    <ion-select-option value=0.7>2</ion-select-option>
                    <ion-select-option value=0.8>3</ion-select-option>
                    <ion-select-option value=1.2>4</ion-select-option>
                  </ion-select>
                </ion-item>
              </ion-list>
              <div padding>
                <ion-button size="large" @click="calculateDemand" expand="block">
                  Berechnen
                </ion-button>
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
import { useDemands } from '@/composables/useDemands';
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
  IonSelect,
  IonSelectOption,
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
    IonSelect,
    IonSelectOption,
  },
  setup() {
    const { height, weight, age, sex, activity, calculateDemand } = useDemands();
    return { height, weight, age, sex, activity, calculateDemand };
  },
});
</script>