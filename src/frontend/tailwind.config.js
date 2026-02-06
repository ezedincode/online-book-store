/** @type {import('tailwindcss').Config} */
export default {
  content: [ "./index.html", "./src/**/*.{vue,js,ts,jsx,tsx}" ],
  theme: {
    extend: {
      fontFamily: {
        // Add your custom font to Tailwind
        'archer': ['archer', 'serif'], // Fallback to serif
        'sans': ['Inter', 'system-ui', 'sans-serif'], // For body text
      }
    },
  },
  plugins: [],
}

