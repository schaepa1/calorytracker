<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title
          >Tageskonsum vom {{ products[0]?.productConsumeDate }}</ion-title
        >
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large"
            >Tageskonsum vom {{ products[0]?.productConsumeDate }}</ion-title
          >
        </ion-toolbar>
      </ion-header>

      <ion-card :key="product.id" v-for="product in products">
        <ion-grid>
          <ion-row>
            <ion-col class="ion-no-padding">
              <ion-card-header>
                <ion-card-subtitle>
                  {{ product.productConsumeTime }}
                </ion-card-subtitle>
                <ion-card-title>
                  {{ product.productName }}
                </ion-card-title>
              </ion-card-header>
            </ion-col>
            <ion-col class="ion-no-padding">
              <ion-button color="danger" class="ion-float-right">
                <ion-icon :icon="trash" />
              </ion-button>
            </ion-col>
          </ion-row>
          <ion-row>
            <ion-col class="ion-no-padding"
              ><ion-card-content>
                <ion-text>
                  <div>
                    {{ product.productDescription }}
                  </div>
                </ion-text>
              </ion-card-content>
            </ion-col>
            <ion-col class="ion-no-padding" style="padding-right: 16px">
              <h1 class="ion-float-right">
                <b> {{ product.productCalories }} kcal</b>
              </h1>
            </ion-col>
          </ion-row>
        </ion-grid>
      </ion-card>
      <ion-card style="border: 5px outset #13ff00">
        <ion-card-header>
          <ion-card-title><b>Kalorien Total</b></ion-card-title>
        </ion-card-header>
        <ion-card-content>
          <ion-grid>
            <ion-row>
              <ion-col>
                <ion-text>
                  <div>
                    Kalorien Total am {{ products[0]?.productConsumeDate }}
                  </div>
                </ion-text>
              </ion-col>
              <ion-col>
                <h1 class="ion-float-right" style="font-size: 40px">
                  <b> {{ calculateDailyTotalCalories() }} kcal</b>
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
import {
  IonPage,
  IonHeader,
  IonToolbar,
  IonTitle,
  IonContent,
  IonCardContent,
  IonCardHeader,
  IonCardSubtitle,
  IonCardTitle,
  IonCol,
  IonGrid,
  IonRow,
  IonCard,
  IonText,
} from "@ionic/vue";
import { defineComponent } from "vue";
import { useProducts } from "@/composables/useProducts";
import { trash } from "ionicons/icons";

export default defineComponent({
  name: "DailyConsumption",
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
  setup() {
    const { products, getProducts, calculateDailyTotalCalories } =
      useProducts();
    return {
      products,
      getProducts,
      calculateDailyTotalCalories,
      trash,
    };
  },
});
</script>