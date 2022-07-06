<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Todos</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Todos</ion-title>
        </ion-toolbar>
      </ion-header>

     
      <ion-grid>
        <ion-row
          :style="{
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            justifyContent: 'center',
          }"
        >
          <ion-col align-self-center size-md="6" size-lg="5" size-xs="12">
            <ion-item>
              <ion-item>
                 <barcode-scanner></barcode-scanner>
                <ion-label position="stacked"> Barcode Nummer </ion-label>
                <ion-input type="number" v-model="barcode.number" required>{{ this.$refs.decodedText }}</ion-input>
              </ion-item>
            </ion-item>
            <div padding>
                <ion-button size="large" @click="navigateProduct" expand="block">Produktinformationen sammeln</ion-button>
              </div>
          </ion-col>
        </ion-row>
      </ion-grid>
    </ion-content>
  </ion-page>
</template>

<script>
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
  IonList,
  IonButton,
  IonInput,
  IonLabel,
} from "@ionic/vue";
import { useTodos } from "@/composables/useTodos";
import BarcodeScanner from "./BarcodeScanner.vue";
import { defineComponent } from 'vue';

export default ({
  name: "Todo",
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
    IonList,
    IonButton,
    IonInput,
    BarcodeScanner,
    IonLabel
  },
  data() {
    return {
      barcode: {
        number: "" 
        //product info
      },
    };
  },
  methods: {
    getProductInfo(bacodenumber) {

    //   this.demands = {
    //     weightKeep: 3000,
    //     weightLose: 2600,
    //     weightGain: 3500,
    //   }
    //   const config = {
    //     withCredentials: true
    //   }
    //   axios.get(API_ROOT + '/api/users', config)
    //     .then(response => {
    //       this.demands.weightKeep = response.data.userWeightKeepCalories;
    //       this.demands.weightLose = response.data.userWeightLoseCalories;
    //       this.demands.weightGain = response.data.userWeightGainCalories;
    //     })
    },
  },
  mounted() {
    this.getProductInfo();
  },
});
</script>