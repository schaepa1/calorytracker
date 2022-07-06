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
                <ion-input disabled type="number" v-model="weightLose" required></ion-input>
              </ion-item>
              <ion-item>
                <ion-label position="stacked">
                  Kalorienbedarf zum Gewicht halten
                </ion-label>
                <ion-input disabled type="number" v-model="weightKeep" required></ion-input>
              </ion-item>
              <ion-item>
                <ion-label position="stacked">
                  Kalorienbedarf zum zunehmen
                </ion-label>
                <ion-input disabled type="number" v-model="weightGain" required></ion-input>
              </ion-item>
              <div padding :style="{display: 'flex', flexDirection: 'row'}">
                <ion-button :style="{flex: '1'}" router-link="/tabs/demandCalculator" size="large" expand="block">Neu Berechnen</ion-button>
                <ion-button @click="getDemands" class="ion-float-right" size="large">
                  <ion-icon :icon="refresh" />
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
  IonIcon
} from "@ionic/vue";
import { useDemands } from '@/composables/useDemands';
import { refresh } from "ionicons/icons";

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
    IonIcon,
  },
  setup() {
    const { weightKeep, weightLose, weightGain, getDemands } = useDemands();
    return { weightKeep, weightLose, weightGain, getDemands, refresh };
  },
});
</script>