package com.shreyasmp.blankproject.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Requirement of this app was the complete left over code to make this game
 * toggle blue to yellow on clicking the cells.
 * when one cell turns yellow, and tapping on another cell, the previously tapped cell
 * should turn blue and the tapped cell should turn Yellow.
 *
 * This was infact solved later using ChatGPT 3.5.
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContentView()
        }
    }
}

// You can update with your own data structure if needed.
// This is just an example of simplest data structure for recomposition.

// Changed from:
// val cells: SnapshotStateList<Any> = listOf<Any>().toMutableStateList()
val cells: SnapshotStateList<Boolean> = List(12) { false }.toMutableStateList()


/**
 * A simple [Composable] function that displays a grid of buttons.
 * The grid is 3 columns wide and has 4 rows.
 *
 * Important:
 *  Manually import LazyVerticalGrid and GridCells.
 *  This can happen because different versions of Compose have placed these classes in different packages.
 *
 */
@Composable
private fun ContentView() {

    remember { cells } //Recomposition is triggered after you change this object

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp),
    ) {
        items(12) { index ->
            // Passed index which was initially not passed
            CardButton(index)
        }
    }
}

@Composable
private fun CardButton(index: Int) {

    Button(
        modifier = Modifier.aspectRatio(1.0f),
        colors = ButtonDefaults.buttonColors(
            // Added if condition to get value state to flip colours
            containerColor = if (cells[index]) Color.Yellow else Color.Blue,
            contentColor = if (cells[index]) Color.Black else Color.White,
        ),
        shape = RoundedCornerShape(CornerSize(10.dp)),
        onClick = {
            // This was TO-DO part, along with some other changes required at top
            cells.fill(false)
            cells[index] = true
        }
    ) {
        Text(text = "0")
    }
}



