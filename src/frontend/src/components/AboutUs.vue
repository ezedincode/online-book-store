<template>
  <div class="min-h-screen bg-slate-50 pt-32 pb-20 px-4">
    <div class="max-w-4xl mx-auto">
      <div class="bg-white rounded-3xl shadow-xl overflow-hidden">
        <div class="h-64 bg-[#173f5f] flex items-center justify-center relative overflow-hidden">
          <div class="absolute inset-0 opacity-20">
            <svg class="w-full h-full" viewBox="0 0 100 100" preserveAspectRatio="none">
              <path d="M0 100 C 20 0 50 0 100 100 Z" fill="white"></path>
            </svg>
          </div>
          <h1 class="text-5xl font-serif font-bold text-white relative z-10">Our Story</h1>
        </div>
        
        <div class="p-8 md:p-16 space-y-8">
          <section class="space-y-4">
            <h2 class="text-3xl font-bold text-slate-800">Mission & Vision</h2>
            <p class="text-lg text-slate-600 leading-relaxed">
              Founded with a passion for literature and a commitment to spreading knowledge, "The Bookshelf" began as a small neighborhood project. Today, we are a digital haven for book lovers, offering a curated collection of timeless stories and cutting-edge discoveries.
            </p>
          </section>

          <div class="grid md:grid-cols-2 gap-12 py-8">
            <div class="bg-indigo-50 p-8 rounded-2xl border border-indigo-100">
              <h3 class="text-xl font-bold text-indigo-900 mb-3">Community First</h3>
              <p class="text-slate-600 italic">"Where the timeless joy of turning a page awaited by thousands."</p>
            </div>
            <div class="bg-emerald-50 p-8 rounded-2xl border border-emerald-100">
              <h3 class="text-xl font-bold text-emerald-900 mb-3">Expert Curation</h3>
              <p class="text-slate-600">Every volume in our collection is handpicked by enthusiasts who believe in the power of a good read.</p>
            </div>
          </div>

          <section class="space-y-4 border-t pt-8">
            <h2 class="text-2xl font-bold text-slate-800 text-center">Visit Us</h2>
            <p class="text-slate-600 text-center max-w-2xl mx-auto leading-relaxed">
              Whether you're looking for academic excellence, a gripping fiction, or the latest in technology, our digital doors are always open. We believe that a world that reads is a world that grows.
            </p>
          </section>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
// Static content page
</script>
