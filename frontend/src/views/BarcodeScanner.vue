<template>
  <h2>Bitte Barcode in die Kamera halten</h2>
  <StreamBarcodeReader @decode="onDecode" @loaded="onLoaded"></StreamBarcodeReader>
</template>

<script>
import { defineComponent, ref } from 'vue';

import { StreamBarcodeReader } from "vue-barcode-reader";

export default defineComponent({
  name: 'BarcodeTest',
  components: {
    StreamBarcodeReader
  },
  setup(props, context) {

    const decodedText = ref("");

    const onLoaded = () => {
      console.log("loaded");
    };

    const onDecode = (text) => {
      decodedText.value = text;
    };

    context.expose({ decodedText })
    return {
      decodedText,
      onLoaded,
      onDecode
    }
  }
});
</script>

<style scoped>
a {
  color: #42b983;
}

.information {
  margin-top: 100px;
}
</style>
