<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Produkt einscannen</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Produkt einscannen</ion-title>
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
                <barcode-test ref="barcoder"></barcode-test>
                <ion-label position="stacked"><h1>Barcode Nummer</h1></ion-label>
                <ion-input type="number" v-model="barcode" required>
                  <p v-if="this.$refs.barcoder">
                    {{ setBarcode(this.$refs.barcoder.decodedText) }}
                  </p>
                </ion-input>
              </ion-item>
            </ion-item>
            <div padding>
              <ion-button size="large" @click="getProductInfo" expand="block"
                >Produktinformationen sammeln</ion-button
              >
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
import BarcodeTest from "./BarcodeScanner.vue";
import { useProducts } from "@/composables/useProducts";

export default {
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
    BarcodeTest,
    IonLabel,
  },
  setup() {
    const { newProduct, addProduct, barcode, getProductInfo, setBarcode } =
      useProducts();
    return { newProduct, addProduct, barcode, getProductInfo, setBarcode };
  },
};
</script>