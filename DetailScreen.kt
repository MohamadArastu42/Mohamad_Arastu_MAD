package com.example.lectureexamples.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.lectureexamples.models.getMovies

@Composable
fun DetailScreen(navController: NavController, movieId: String?) {
    movieId?.let {
        Text(text = "$movieId")
    }
}