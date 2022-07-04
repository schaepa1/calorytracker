<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Calory Tracker</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Timerecord</ion-title>
        </ion-toolbar>
      </ion-header>

      


      <ion-card :key="calory" v-for="calory in allProducts">
        <ion-card-header>
          <ion-card-subtitle>{{ calory.productConsumeTime }}</ion-card-subtitle>
          <ion-card-title>{{ calory.productName }}</ion-card-title>
        </ion-card-header>
        <ion-card-content>
          <ion-grid>
            <ion-row>
              <ion-col>
                <ion-text>
                  <div>
                    {{ calory.productDescription }}
                  </div>
                </ion-text>
              </ion-col>
              <ion-col>
                <h1 class="ion-float-right">
                  <b> {{ calory.productCalories }} kcal</b>
                </h1>
              </ion-col>
            </ion-row>
          </ion-grid>
        </ion-card-content>
      </ion-card>
 <ion-card>
        <ion-card-header>
          <ion-card-title>Kalorien Total</ion-card-title>
        </ion-card-header>
        <ion-card-content>
          <ion-grid>
            <ion-row>
              <ion-col>
                <ion-text>
                  <div>
                    Kalorien Total am {{ this.allProducts[0].productConsumeTime}}
                  </div>
                </ion-text>
              </ion-col>
              <ion-col>
                <h1 class="ion-float-right">
                  <b> 300 kcal</b>
                </h1>
              </ion-col>
            </ion-row>
          </ion-grid>
        </ion-card-content>
      </ion-card>
    </ion-content>
  </ion-page>
</template>

<script lang="ts">
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonCardContent, IonCardHeader, IonCardSubtitle, IonCardTitle, IonIcon, IonItem, IonLabel, IonCol, IonGrid, IonRow, IonCard, IonText, IonTextarea } from '@ionic/vue';
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'Calorytracker',
  components: {
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonPage,
    IonCard,
    IonCardContent,
    IonCardHeader,
    IonCardSubtitle,
    IonCardTitle,
    IonCol,
    IonGrid,
    IonRow,
    IonText,
    IonTextarea,
    IonLabel
  },
  data() {
    return {
      allProducts: [
        {
          productName: 'Essen 1',
          productDescription: 'Beschreibung 1',
          productCalories: 500,
          productConsumeTime: new Date(),
          productEan: '4 003994 155486',
        },
        {
          productName: 'Essen 2',
          productDescription: 'Beschreibung 2',
          productCalories: 150,
          productConsumeTime: new Date(),
          productEan: '4 003994 133675',
        },
        {
          productName: 'Essen 3',
          productDescription: 'Beschreibung 3',
          productCalories: 300,
          productConsumeTime: new Date(),
          productEan: '4 003994 199862',
        },
        {
          productName: 'Essen 4',
          productDescription: 'Beschreibung 4',
          productCalories: 200,
          productConsumeTime: new Date(),
          productEan: '4 003994 477166',
        },
      ],
    }
  },
});
</script>