package com.example.infoapp.ui_components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.infoapp.MainViewModel
import com.example.infoapp.ui.theme.GrayBlue
import kotlinx.coroutines.launch

@Composable
fun MainTopBar(
    title: String,
    scaffoldState: ScaffoldState,
    onFavCLick:() -> Unit
) {
    val coroutine = rememberCoroutineScope()

    TopAppBar(
        title = {
            Text(text = title)
        },
        backgroundColor = GrayBlue,
        navigationIcon = {
            IconButton(
                onClick = {
                    coroutine.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu"
                    )
            }
        },
        actions = {
            IconButton(
                onClick = {
                    onFavCLick()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite"
                )
            }
        }
    )
}