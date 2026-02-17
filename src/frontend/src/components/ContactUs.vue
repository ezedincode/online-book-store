<template>
  <div class="min-h-screen bg-slate-50 pt-32 pb-20 px-4">
    <div class="max-w-4xl mx-auto">
      <div class="bg-white rounded-3xl shadow-xl overflow-hidden grid md:grid-cols-2">
        <div class="bg-[#173f5f] p-12 text-white flex flex-col justify-between">
          <div>
            <h1 class="text-4xl font-bold mb-6">Contact Us</h1>
            <p class="text-indigo-100 mb-12">We'd love to hear from you. Reach out via any of these channels.</p>
            
            <div class="space-y-8">
              <div class="flex items-center gap-4">
                <div class="w-12 h-12 bg-white/10 rounded-xl flex items-center justify-center border border-white/20">
                  <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3 8l7.89 5.26a2 2 0 002.22 0L21 8M5 19h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v10a2 2 0 002 2z"/></svg>
                </div>
                <div>
                  <p class="text-xs text-indigo-300 uppercase tracking-wider font-bold">Email</p>
                  <a href="mailto:ezedinahmed2021@gmail.com" class="text-lg hover:text-indigo-300 transition-colors">ezedinahmed2021@gmail.com</a>
                </div>
              </div>

              <div class="flex items-center gap-4">
                <div class="w-12 h-12 bg-white/10 rounded-xl flex items-center justify-center border border-white/20">
                  <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3 5a2 2 0 012-2h3.28a1 1 0 01.948.684l1.498 4.493a1 1 0 01-.502 1.21l-2.257 1.13a11.042 11.042 0 005.516 5.516l1.13-2.257a1 1 0 011.21-.502l4.493 1.498a1 1 0 01.684.949V19a2 2 0 01-2 2h-1C9.716 21 3 14.284 3 6V5z"/></svg>
                </div>
                <div>
                  <p class="text-xs text-indigo-300 uppercase tracking-wider font-bold">Phone</p>
                  <p class="text-lg">+251964240012</p>
                </div>
              </div>

              <div class="flex items-center gap-4">
                <div class="w-12 h-12 bg-white/10 rounded-xl flex items-center justify-center border border-white/20">
                  <svg class="w-6 h-6" fill="currentColor" viewBox="0 0 24 24"><path d="M12 0c-6.626 0-12 5.373-12 12 0 5.302 3.438 9.8 8.207 11.387.599.111.793-.261.793-.577v-2.234c-3.338.726-4.033-1.416-4.033-1.416-.546-1.387-1.333-1.756-1.333-1.756-1.089-.745.083-.729.083-.729 1.205.084 1.839 1.237 1.839 1.237 1.07 1.834 2.807 1.304 3.492.997.107-.775.418-1.305.762-1.604-2.665-.305-5.467-1.334-5.467-5.931 0-1.311.469-2.381 1.236-3.221-.124-.303-.535-1.524.117-3.176 0 0 1.008-.322 3.301 1.23.957-.266 1.983-.399 3.003-.404 1.02.005 2.047.138 3.006.404 2.291-1.552 3.297-1.23 3.297-1.23.653 1.653.242 2.874.118 3.176.77.84 1.235 1.911 1.235 3.221 0 4.609-2.807 5.624-5.479 5.921.43.372.823 1.102.823 2.222v3.293c0 .319.192.694.801.576 4.765-1.589 8.199-6.086 8.199-11.386 0-6.627-5.373-12-12-12z"/></svg>
                </div>
                <div>
                  <p class="text-xs text-indigo-300 uppercase tracking-wider font-bold">GitHub</p>
                  <a href="https://github.com/ezedincode" target="_blank" class="text-lg hover:text-indigo-300 transition-colors">ezedincode</a>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="p-12">
          <form class="space-y-6">
            <div>
              <label class="block text-sm font-semibold text-slate-700 mb-2">Name</label>
              <input type="text" class="w-full px-4 py-3 rounded-xl border border-slate-200 focus:outline-none focus:ring-2 focus:ring-indigo-500 transition-all" placeholder="John Doe">
            </div>
            <div>
              <label class="block text-sm font-semibold text-slate-700 mb-2">Email</label>
              <input type="email" class="w-full px-4 py-3 rounded-xl border border-slate-200 focus:outline-none focus:ring-2 focus:ring-indigo-500 transition-all" placeholder="john@example.com">
            </div>
            <div>
              <label class="block text-sm font-semibold text-slate-700 mb-2">Message</label>
              <textarea rows="4" class="w-full px-4 py-3 rounded-xl border border-slate-200 focus:outline-none focus:ring-2 focus:ring-indigo-500 transition-all" placeholder="How can we help?"></textarea>
            </div>
            <button class="w-full py-4 bg-indigo-600 hover:bg-indigo-700 text-white font-bold rounded-xl shadow-lg shadow-indigo-100 transition-all">Send Message</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
// Contact page with user details
</script>
