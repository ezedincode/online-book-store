<template>
  <div class="min-h-screen bg-slate-50 pt-32 pb-20 px-4">
    <div class="max-w-6xl mx-auto">
      <div class="text-center mb-16">
        <h1 class="text-5xl font-serif font-bold text-slate-800 mb-4">The Bookworm Blog</h1>
        <p class="text-xl text-slate-500">Insights, reviews, and stories from our bibliophile community</p>
      </div>

      <div class="grid md:grid-cols-2 lg:grid-cols-3 gap-8">
        <article v-for="i in 6" :key="i" class="bg-white rounded-3xl overflow-hidden shadow-sm hover:shadow-xl transition-all duration-300 group">
          <div class="h-48 bg-slate-200 relative overflow-hidden">
            <div class="absolute inset-0 bg-gradient-to-t from-black/20 to-transparent"></div>
            <div class="absolute top-4 left-4">
              <span class="px-3 py-1 bg-white/90 backdrop-blur rounded-full text-xs font-bold text-indigo-600">Category</span>
            </div>
          </div>
          <div class="p-8">
            <div class="text-sm text-slate-400 mb-3">February 17, 2026 • 5 min read</div>
            <h2 class="text-2xl font-bold text-slate-800 mb-4 group-hover:text-indigo-600 transition-colors">
              The Evolution of Digital Reading in 2026
            </h2>
            <p class="text-slate-500 line-clamp-3 mb-6 leading-relaxed">
              Explore how modern technology is reshaping the way we consume literature and the enduring charm of physical bookshelves...
            </p>
            <button class="flex items-center gap-2 text-indigo-600 font-bold hover:gap-3 transition-all">
              Read Article
              <svg class="w-4 h-4" fill="none" stroke="currentColor" viewBox="0 0 24 24"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M17 8l4 4m0 0l-4 4m4-4H3"/></svg>
            </button>
          </div>
        </article>
      </div>
    </div>
  </div>
</template>

<script setup>
// Blog listing page mockup
</script>
