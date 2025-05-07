🎬 TMDB Movies App (Kotlin + Retrofit + MVVM)
This is an Android application built in Kotlin using the TMDB (The Movie Database) API. The app displays 4 categories of movies—Now Playing, Popular, Top Rated, and Upcoming—using a Bottom Navigation Bar, each hosted in a separate Fragment. All categories use a shared RecyclerView Adapter and a common Movie data class, following the MVVM architecture.

✨ Features
🔄 Fetches real-time data from TMDB API using Retrofit

📦 Displays 4 movie categories:

Now Playing

Popular

Top Rated

Upcoming

📱 Clean and responsive UI using RecyclerViews

🧠 MVVM architecture for scalability and separation of concerns

🔍 Logs API errors for easy debugging

🧰 Tech Stack
Kotlin

Retrofit

MVVM Architecture

LiveData + ViewModel

BottomNavigationView

RecyclerView

🔑 API Key
This project uses the TMDB API. You’ll need to sign up at https://www.themoviedb.org and get your own API key to run the app. And use the api key in var apikey in MovieViewModel.kt 

