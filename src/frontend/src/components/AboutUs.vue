<template>
  <div class="flex flex-col w-full overflow-x-hidden">
    <!-- Top bar -->
    <div class="flex justify-between items-center px-4 sm:px-6 md:px-10 py-4 bg-white border-b border-slate-100">
      <router-link to="/" class="flex items-center gap-2 sm:gap-3 group cursor-pointer">
        <div class="w-9 h-9 sm:w-10 sm:h-10 rounded-xl bg-[#173f5f] flex items-center justify-center group-hover:bg-indigo-600 transition-all duration-300 shadow-lg shadow-indigo-100 rotate-3 group-hover:rotate-0">
          <svg class="w-5 h-5 sm:w-6 sm:h-6 text-white" fill="none" stroke="currentColor" viewBox="0 0 24 24">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 6.253v13m0-13C10.832 5.477 9.246 5 7.5 5S4.168 5.477 3 6.253v13C4.168 18.477 5.754 18 7.5 18s3.332.477 4.5 1.253m0-13C13.168 5.477 14.754 5 16.5 5c1.747 0 3.332.477 4.5 1.253v13C19.832 18 18.247 18 16.5 18c-1.746 0-3.332.477-4.5 1.253"></path>
          </svg>
        </div>
        <div class="flex flex-col">
          <span class="text-[#173f5f] font-serif font-black text-base sm:text-xl tracking-tighter leading-none">THE BOOKSHELF</span>
          <span class="text-indigo-600 font-bold text-[9px] sm:text-[10px] tracking-widest uppercase opacity-80">Premium Collection</span>
        </div>
      </router-link>

      <div class="hidden md:flex items-center gap-4">
        <a href="#" class="p-2 rounded-xl hover:bg-slate-50 text-slate-400 hover:text-indigo-600 transition-all">
          <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 24 24"><path d="M24 12.073c0-6.627-5.373-12-12-12s-12 5.373-12 12c0 5.99 4.388 10.954 10.125 11.854v-8.385H7.078v-3.469h3.047V9.43c0-3.007 1.791-4.669 4.533-4.669 1.312 0 2.686.235 2.686.235v2.953H15.83c-1.491 0-1.956.925-1.956 1.874v2.25h3.328l-.532 3.47h-2.796v8.385C19.612 23.027 24 18.062 24 12.073z"/></svg>
        </a>
        <a href="#" class="p-2 rounded-xl hover:bg-slate-50 text-slate-400 hover:text-pink-600 transition-all">
          <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 24 24"><path d="M12 2.163c3.204 0 3.584.012 4.85.07 1.17.054 1.805.249 2.227.412.558.217.957.477 1.377.896.419.42.679.819.896 1.377.163.422.358 1.057.412 2.227.058 1.266.07 1.646.07 4.85s-.012 3.584-.07 4.85c-.054 1.17-.249 1.805-.412 2.227-.217.558-.477.957-.896 1.377-.42.419-.819.679-1.377.896-.422.163-1.057.358-2.227.412-1.266.058-1.646.07-4.85.07s-3.584-.012-4.85-.07c-1.17-.054-1.805-.249-2.227-.412-.558-.217-.957-.477-1.377-.896-.419-.42-.679-.819-.896-1.377-.163-.422-.358-1.057-.412-2.227C2.175 15.668 2.163 15.288 2.163 12.08s.012-3.584.07-4.85c.054-1.17.249-1.805.412-2.227.217-.558.477-.957.896-1.377.42-.419.819-.679 1.377-.896.422-.163 1.057-.358 2.227-.412 1.266-.058 1.646-.07 4.85-.07zm0-2.163c-3.259 0-3.667.014-4.947.072-1.277.057-2.148.258-2.911.554-.789.306-1.459.717-2.126 1.384-.666.667-1.077 1.337-1.384 2.126-.296.763-.497 1.634-.554 2.911-.058 1.28-.072 1.688-.072 4.947s.014 3.667.072 4.947c.057 1.277.258 2.148.554 2.911.306.789.717 1.459 1.384 2.126.667.666 1.337 1.077 2.126 1.384.763.296 1.634.497 2.911.554 1.28.058 1.688.072 4.947.072s3.667-.014 4.947-.072c1.277-.057 2.148-.258 2.911-.554.789-.306 1.459-.717 2.126-1.384.666-.667-1.077-1.337 1.384-2.126.296-.763.497-1.634.554-2.911.058-1.28.072-1.688.072-4.947s-.014-3.667-.072-4.947c-.057-1.277-.258-2.148-.554-2.911-.306-.789-.717-1.459-1.384-2.126C21.319 1.347 20.65.935 19.86.629c-.763-.296-1.634-.497-2.911-.554-1.28-.058-1.688-.072-4.947-.072zM12 5.838c-3.403 0-6.162 2.759-6.162 6.162s2.759 6.163 6.162 6.163 6.162-2.759 6.162-6.163c0-3.403-2.759-6.162-6.162-6.162zm0 10.162c-2.209 0-4-1.79-4-4 0-2.209 1.791-4 4-4s4 1.791 4 4c0 2.21-1.791 4-4 4zm6.406-11.845a1.44 1.44 0 100 2.881 1.44 1.44 0 000-2.881z"/></svg>
        </a>
        <a href="#" class="p-2 rounded-xl hover:bg-slate-50 text-slate-400 hover:text-blue-700 transition-all">
          <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 24 24"><path d="M22.232 0H1.771C.792 0 0 .774 0 1.729v20.542C0 23.227.792 24 1.771 24h20.451C23.2 24 24 23.227 24 22.271V1.729C24 .774 23.2 0 22.222 0h.01zM7.12 20.452H3.558V8.995H7.12v11.457zM5.339 7.433c-1.146 0-2.071-.926-2.071-2.065 0-1.146.925-2.065 2.071-2.065 1.141 0 2.065.919 2.065 2.065 0 1.139-.925 2.065-2.065 2.065zm15.113 13.019h-3.56V14.89c0-1.327-.027-3.037-1.851-3.037-1.852 0-2.135 1.445-2.135 2.939v5.66h-3.559V8.995h3.414v1.565h.049c.475-.9 1.636-1.848 3.365-1.848 3.601 0 4.267 2.37 4.267 5.455v6.285z"/></svg>
        </a>
        <a href="#" class="p-2 rounded-xl hover:bg-slate-50 text-slate-400 hover:text-black transition-all">
          <svg class="w-4 h-4" fill="currentColor" viewBox="0 0 24 24"><path d="M18.901 1.153h3.68l-8.04 9.19L24 22.846h-7.406l-5.8-7.584-6.638 7.584H.474l8.6-9.83L0 1.154h7.594l5.243 6.932 6.064-6.932zm-1.292 19.497h2.039L6.486 3.24H4.298l13.311 17.41z"/></svg>
        </a>
      </div>
    </div>

    <!-- Navigation bar -->
    <div class="bg-[#173f5f] flex flex-wrap justify-center gap-3 sm:gap-6 md:gap-10 text-white items-center px-4 py-3 md:h-12">
      <router-link to="/" class="font-bold text-xs sm:text-sm md:text-base hover:text-indigo-200 transition-colors">HOME</router-link>
      <router-link to="/about" class="text-xs sm:text-sm md:text-base hover:text-indigo-200 transition-colors uppercase">About Us</router-link>
      <router-link to="/books" class="text-xs sm:text-sm md:text-base hover:text-indigo-200 transition-colors uppercase">Books</router-link>
      <router-link to="/new-release" class="text-xs sm:text-sm md:text-base hover:text-indigo-200 transition-colors uppercase">New Release</router-link>
      <router-link to="/contact" class="text-xs sm:text-sm md:text-base hover:text-indigo-200 transition-colors uppercase">Contact Us</router-link>
      <router-link to="/blog" class="text-xs sm:text-sm md:text-base hover:text-indigo-200 transition-colors uppercase">Blog</router-link>
    </div>

    <!-- Page content -->
    <div class="min-h-screen bg-slate-50 pt-12 pb-20 px-4">
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
  </div>
</template>

<script setup>
// Static content page
</script>
