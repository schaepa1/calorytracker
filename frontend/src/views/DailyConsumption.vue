<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <div :style="{display: 'flex', flexDirection: 'row', alignItems: 'center'}">
          <ion-title>Tageskonsum vom</ion-title>
          <ion-button @click="openModal" :style="{ paddingLeft: '15px' }">
            <ion-text>
              {{ selectedDate.toJSON().slice(0, 10).split("-").reverse().join(".") }}
            </ion-text>
          </ion-button>
        </div>
      </ion-toolbar>

    </ion-header>
    <ion-content :fullscreen="true">
      <ion-grid>
        <ion-row :style="{
          display: 'flex',
          flexDirection: 'column',
          alignItems: 'center',
          justifyContent: 'center',
        }">
          <ion-col align-self-center size-md="6" size-lg="5" size-xs="12">
            <ion-header collapse="condense">
              <ion-toolbar :style="{ paddingBottom: '20px' }">
                <ion-title size="large" class="ion-padding-top">
                  Tageskonsum
                </ion-title>
              </ion-toolbar>
              <ion-button @click="openModal" :style="{ paddingLeft: '15px' }">
                <ion-text>
                  {{ selectedDate.toJSON().slice(0, 10).split("-").reverse().join(".") }}
                </ion-text>
              </ion-button>
            </ion-header>

            <ion-card :key="product.productId" v-for="product in products">
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
                    <ion-button @click="showConfirmDeletionAlert(product)" color="danger"
                      class="ion-padding ion-float-right">
                      <ion-icon :icon="trash" />
                    </ion-button>
                  </ion-col>
                </ion-row>
                <ion-row>
                  <ion-col class="ion-no-padding">
                    <ion-card-content>
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
            <ion-card style="background-color: #5c5c5e; color: white">
              <ion-card-header>
                <ion-card-title><b>Total</b></ion-card-title>
              </ion-card-header>
              <ion-card-content>
                <ion-grid>
                  <ion-row>
                    <ion-col class="ion-no-padding">
                      <ion-text>{{
                          checkAnyProductsToday()
                            ? "Kalorien total am " +
                            products[0]?.productConsumeDate
                            : "An diesem Tag hast du keine Produkte erfasst"
                      }}
                      </ion-text>
                    </ion-col>
                    <ion-col>
                      <h1 class="ion-float-right" style="font-size: 30px">
                        <b> {{ calculateDailyTotalCalories() }} kcal</b>
                      </h1>
                    </ion-col>
                  </ion-row>
                </ion-grid>
              </ion-card-content>
            </ion-card>
          </ion-col>
        </ion-row>
      </ion-grid>

      <ion-modal ref="modal" :is-open="isOpenModal">
        <ion-header>
          <ion-toolbar>
            <ion-title>Datum auswählen</ion-title>
            <ion-buttons slot="end">
              <ion-button :strong="true" @click="confirmModal()">Bestätigen</ion-button>
            </ion-buttons>
          </ion-toolbar>
        </ion-header>
        <ion-content class="ion-padding">
          <ion-datetime @ion-change="(date) => selectDate(date)" v-bind:value="selectedDate.toISOString()"
            presentation="date"></ion-datetime>
        </ion-content>
      </ion-modal>
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
  IonButton,
  IonIcon,
  IonModal,
  IonDatetime,
  IonButtons,
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
    IonButton,
    IonIcon,
    IonModal,
    IonDatetime,
    IonButtons,
  },
  setup() {
    const {
      products,
      getProducts,
      calculateDailyTotalCalories,
      showConfirmDeletionAlert,
      checkAnyProductsToday,
      isOpenModal,
      closeModal,
      openModal,
      selectedDate,
      selectDate,
      confirmModal,
    } = useProducts();
    return {
      products,
      getProducts,
      calculateDailyTotalCalories,
      trash,
      showConfirmDeletionAlert,
      checkAnyProductsToday,
      isOpenModal,
      closeModal,
      openModal,
      selectedDate,
      selectDate,
      confirmModal,
    };
  },
});
</script>