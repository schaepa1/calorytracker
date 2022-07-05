<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Produkt erfassen</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-grid>
        <ion-row justify-content-center>
          <ion-col align-self-center>
            <ion-header collapse="condense">
              <ion-toolbar>
                <ion-title size="large">Produkt erfassen</ion-title>
              </ion-toolbar>
            </ion-header>
            <div :style="{ display: 'flex', flexDirection: 'column', justifyContent: 'center' }">
              <ion-item>
                <ion-label position="stacked">
                  Produktname
                </ion-label>
                <ion-input type="text" v-model="newProduct.productName" required></ion-input>
              </ion-item>
              <ion-item>
                <ion-label position="stacked">Produktbeschreibung</ion-label>
                <ion-textarea v-model="newProduct.productDescription"></ion-textarea>
              </ion-item>
              <ion-item>
                <ion-label position="stacked">
                  Kalorien
                </ion-label>
                <ion-input type="number" v-model="newProduct.productCalories" required></ion-input>
              </ion-item>
              <ion-item>
                <ion-label position="stacked">
                  Konsumdatum
                </ion-label>
                <ion-input type="date" v-model="newProduct.productConsumeDate" required></ion-input>
              </ion-item>
              <ion-item>
                <ion-label position="stacked">
                  Konsumzeitpunkt
                </ion-label>
                <ion-input type="time" v-model="newProduct.productConsumeTime" required></ion-input>
              </ion-item>
              <div padding>
                <ion-button size="large" @click="addNewProduct" expand="block">Hinzufügen</ion-button>
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
  IonTextarea,
} from "@ionic/vue";
import { useProducts } from '@/composables/useProducts';

export default defineComponent({
  name: "NewProduct",
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
    IonTextarea,
  },
  setup() {
    const { newProduct, addNewProduct } = useProducts();
    return { newProduct, addNewProduct };
  }
});
</script>