import { onMounted, onUpdated, ref } from 'vue';
import { useRouter } from 'vue-router';
import { getUserDemands, saveNewDemands } from '@/api/demand';

export function useDemands() {

  let height = ref<any>();
  let weight = ref<any>();
  let age = ref<any>();
  let sex = ref<any>();
  let activity = ref<any>();

  let weightKeep = ref<any>();
  let weightLose = ref<any>();
  let weightGain = ref<any>();

  const router = useRouter();

  const getDemands = async () => {
    try {
      let response = await getUserDemands();
      weightKeep.value = response.userWeightKeepCalories;
      weightLose.value = response.userWeightLoseCalories;
      weightGain.value = response.userWeightGainCalories;
    } catch (error) {
      console.log(error);
    }
  }

  const calculateDemand = () => {
    let grundumsatz = 66.5 + (13.75 * weight.value) + (5 * height.value) - (6.76 * age.value);
    sex.value == "f" ? grundumsatz *= 0.9 : grundumsatz *= 1;
    const leistungsumsatz = grundumsatz * activity.value;
    const gesamtbedarf = grundumsatz + leistungsumsatz;
    const weightKeepCalories = gesamtbedarf;
    const weightLoseCalories = gesamtbedarf - 400;
    const weightGainCalories = gesamtbedarf + 500;
    saveCaloryDemands(weightKeepCalories, weightLoseCalories, weightGainCalories);
    height.value = 0;
    weight.value = 0;
    age.value = 0;
    sex.value = 'm';
    activity.value = 0;
  }

  const saveCaloryDemands = async (weightKeep: number, weightLose: number, weightGain: number) => {
    try {
      const demands = {
        userWeightKeepCalories: weightKeep,
        userWeightLoseCalories: weightLose,
        userWeightGainCalories: weightGain,
      }

      await saveNewDemands(demands).then(async () => {
        router.push('/tabs/demandResults').then(async () => {
          await getDemands();
        })
      });
    } catch (error) {
      return error;
    }
  }

  onUpdated(() => getDemands());

  return {
    height,
    weight,
    age,
    sex,
    activity,
    weightKeep,
    weightLose,
    weightGain,
    getDemands,
    calculateDemand,
    saveCaloryDemands,
  }
}