<template>
  <ion-page>
    <ion-tabs>
      <ion-router-outlet></ion-router-outlet>

      <ion-tab-bar slot="bottom">
        <ion-tab-button tab="dailyConsumption" href="/tabs/dailyConsumption">
          <ion-icon :icon="fastFood" />
          <ion-label>Tageskonsum</ion-label>
        </ion-tab-button>
        <ion-tab-button tab="newProduct" href="/tabs/newProduct">
          <ion-icon :icon="add" />
          <ion-label>Produkt erfassen</ion-label>
        </ion-tab-button>
        <ion-tab-button tab="scan" href="/tabs/scan">
          <ion-icon :icon="barcodeSharp" />
          <ion-label>Produktscan</ion-label>
        </ion-tab-button>
        <ion-tab-button tab="demandCalculator" href="/tabs/demandCalculator">
          <ion-icon :icon="calculator" />
          <ion-label>Bedarfsrechner</ion-label>
        </ion-tab-button>
        <ion-tab-button tab="demandResults" href="/tabs/demandResults">
          <ion-icon :icon="person" />
          <ion-label>Mein Bedarf</ion-label>
        </ion-tab-button>
      </ion-tab-bar>
    </ion-tabs>
  </ion-page>
</template>

<script lang="ts">
import { IonTabBar, IonTabButton, IonTabs, IonLabel, IonIcon, IonPage, IonRouterOutlet } from '@ionic/vue';
import { add, flash, apps, send, fastFood, calculator, person, barcodeSharp } from 'ionicons/icons';

export default {
  name: 'Tabs',
  components: { IonLabel, IonTabs, IonTabBar, IonTabButton, IonIcon, IonPage, IonRouterOutlet },
  setup() {
    return {
      add,
      flash,
      apps,
      send,
      fastFood,
      calculator,
      person,
      barcodeSharp
    }
  }
}
</script>