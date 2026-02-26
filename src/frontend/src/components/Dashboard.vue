<script setup>
import { onMounted, ref, computed } from 'vue';
import { useAuthStore } from '@/stores/auth';
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  PointElement,
  LineElement,
  Title,
  Tooltip,
  Legend
} from 'chart.js';
import { Line } from 'vue-chartjs';

ChartJS.register(
  CategoryScale,
  LinearScale,
  PointElement,
  LineElement,
  Title,
  Tooltip,
  Legend
);

const authStore = useAuthStore();
const loading = ref(true);

const chartData = computed(() => {
  return {
    labels: authStore.dailyDownloads.map(d => d.date),
    datasets: [
      {
        label: 'Daily Downloads',
        backgroundColor: '#173f5f',
        borderColor: '#173f5f',
        data: authStore.dailyDownloads.map(d => d.count),
        tension: 0.4,
        fill: false
      }
    ]
  };
});

const chartOptions = {
  responsive: true,
  maintainAspectRatio: false,
  plugins: {
    legend: {
      position: 'top',
    },
    title: {
      display: true,
      text: 'Download Activity (Last 30 Days)'
    }
  },
  scales: {
    y: {
      beginAtZero: true,
      ticks: {
        stepSize: 1
      }
    }
  }
};

onMounted(async () => {
  try {
    await Promise.all([
      authStore.fetchGlobalStatistics(),
      authStore.fetchDailyDownloads()
    ]);
  } catch (err) {
    console.error('Dashboard Error:', err);
  } finally {
    loading.value = false;
  }
});
</script>

<template>
  <div v-if="loading" class="flex justify-center items-center p-10">
    <div class="animate-spin rounded-full h-8 w-8 border-b-2 border-[#173f5f]"></div>
    <span class="ml-3 text-gray-500">Loading statistics...</span>
  </div>

  <div v-else class="p-8 space-y-8">
    <div class="grid grid-cols-1 md:grid-cols-3 gap-6">
        
        <div class="bg-white p-6 rounded-xl border border-gray-100 shadow-sm hover:shadow-md transition-shadow flex items-center gap-5">
            <div class="p-4 bg-blue-50 rounded-lg text-blue-600">
                <svg xmlns="http://www.w3.org/2000/svg" class="h-8 w-8" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 6.253v13m0-13C10.832 5.477 9.246 5 7.5 5S4.168 5.477 3 6.253v13C4.168 18.477 5.754 18 7.5 18s3.332.477 4.5 1.253m0-13C13.168 5.477 14.754 5 16.5 5s3.332.477 4.5 1.253v13C19.832 18.477 18.246 18 16.5 18c-1.746 0-3.332.477-4.5 1.253" />
                </svg>
            </div>
            <div>
                <p class="text-sm font-medium text-gray-500 uppercase tracking-wider">Total Books</p>
                <p class="text-3xl font-bold text-gray-900">{{ authStore.globalStatistics.totalBooks }}</p>
            </div>
        </div>

        <!-- Total Downloads Card -->
        <div class="bg-white p-6 rounded-xl border border-gray-100 shadow-sm hover:shadow-md transition-shadow flex items-center gap-5">
            <div class="p-4 bg-green-50 rounded-lg text-green-600">
                <svg xmlns="http://www.w3.org/2000/svg" class="h-8 w-8" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 16v1a3 3 0 003 3h10a3 3 0 003-3v-1m-4-4l-4 4m0 0l-4-4m4 4V4" />
                </svg>
            </div>
            <div>
                <p class="text-sm font-medium text-gray-500 uppercase tracking-wider">Total Downloads</p>
                <p class="text-3xl font-bold text-gray-900">{{ authStore.globalStatistics.totalDownloads }}</p>
            </div>
        </div>

        <!-- Total Views Card -->
        <div class="bg-white p-6 rounded-xl border border-gray-100 shadow-sm hover:shadow-md transition-shadow flex items-center gap-5">
            <div class="p-4 bg-purple-50 rounded-lg text-purple-600">
                <svg xmlns="http://www.w3.org/2000/svg" class="h-8 w-8" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 12a3 3 0 11-6 0 3 3 0 016 0z" />
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M2.458 12C3.732 7.943 7.523 5 12 5c4.478 0 8.268 2.943 9.542 7-1.274 4.057-5.064 7-9.542 7-4.477 0-8.268-2.943-9.542-7z" />
                </svg>
            </div>
            <div>
                <p class="text-sm font-medium text-gray-500 uppercase tracking-wider">Total Views</p>
                <p class="text-3xl font-bold text-gray-900">{{ authStore.globalStatistics.totalViews }}</p>
            </div>
        </div>
    </div>

    <!-- Charts Section -->
    <div class="grid grid-cols-1 gap-6">
        <div class="bg-white p-8 rounded-2xl border border-gray-100 shadow-sm">
            <div class="h-[400px]">
                <Line :data="chartData" :options="chartOptions" />
            </div>
        </div>
    </div>
  </div>
</template>
