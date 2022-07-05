<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Tageskonsum vom {{allProducts[0].productConsumeDate}}</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Tageskonsum vom {{allProducts[0].productConsumeDate}}</ion-title>
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
 <ion-card style="border: 5px outset #13FF00;">
        <ion-card-header>
          <ion-card-title><b>Kalorien Total</b></ion-card-title>
        </ion-card-header>
        <ion-card-content>
          <ion-grid>
            <ion-row>
              <ion-col>
                <ion-text>
                  <div>
                    Kalorien Total am {{ this.allProducts[0].productConsumeDate }}
                  </div>
                </ion-text>
              </ion-col>
              <ion-col>
                <h1 class="ion-float-right" style="font-size:40px">
                  <b> {{calculateDailyTotalCalory()}} kcal</b>
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
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonCardContent, IonCardHeader, IonCardSubtitle, IonCardTitle, IonCol, IonGrid, IonRow, IonCard, IonText } from '@ionic/vue';
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'DailyConsumption',
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
  },
  data() {
    return {
      allProducts: [
        {
          productName: 'Essen 1',
          productDescription: 'Beschreibung 1',
          productCalories: 500,
          productConsumeDate: new Date().toISOString().split('T')[0],
          productConsumeTime: new Date().toLocaleTimeString().slice(0,5),
          productEan: '4 003994 155486',
        },
        {
          productName: 'Essen 2',
          productDescription: 'Beschreibung 2',
          productCalories: 150,
          productConsumeDate: new Date().toISOString().split('T')[0],
          productConsumeTime: new Date().toLocaleTimeString().slice(0,5),
          productEan: '4 003994 133675',
        },
        {
          productName: 'Essen 3',
          productDescription: 'Beschreibung 3',
          productCalories: 300,
          productConsumeDate: new Date().toISOString().split('T')[0],
          productConsumeTime: new Date().toLocaleTimeString().slice(0,5),
          productEan: '4 003994 199862',
        },
        {
          productName: 'Essen 4',
          productDescription: 'Beschreibung 4',
          productCalories: 200,
          productConsumeDate: new Date().toISOString().split('T')[0],
          productConsumeTime: new Date().toLocaleTimeString().slice(0,5),
          productEan: '4 003994 477166',
        },
      ],
    }
  },
  methods: {
    calculateDailyTotalCalory() {
     
      let total = 0;
      this.allProducts.forEach(product => {
        total += product.productCalories
      })
       console.log("Total Daily Calory Intake Test: "+total);
       return total;
    }
  }
});
</script>