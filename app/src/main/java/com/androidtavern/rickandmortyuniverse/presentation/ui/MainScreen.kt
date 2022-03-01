package com.androidtavern.rickandmortyuniverse.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import com.androidtavern.rickandmortyuniverse.R
import com.androidtavern.rickandmortyuniverse.presentation.model.CharacterUI
import kotlinx.coroutines.flow.StateFlow

@Preview
@Composable
fun MainScreen(
    mainViewModel: MainViewModel = viewModel()
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Rick and Morty Universe") }
            )
        }
    ) {
        CharacterList(characters = mainViewModel.characters)
    }
}

@Composable
fun CharacterList(characters: StateFlow<PagingData<CharacterUI>>) {
    val characterItems: LazyPagingItems<CharacterUI> = characters.collectAsLazyPagingItems()
    LazyColumn {
        items(characterItems) { item ->
            item?.let { character ->
                CharacterItem(character)
            }
        }
    }
}

@Composable
fun CharacterItem(item: CharacterUI) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .background(colorResource(id = R.color.gray))
        ) {
            CharacterImage(imageUrl = item.image)

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(text = item.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .height(10.dp)
                            .width(10.dp)
                            .background(colorResource(id = item.getStatusColor())),
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(text = item.getCharacterStatus(LocalContext.current))
                }

                Text(text = stringResource(id = R.string.from), fontWeight = FontWeight.Bold)

                Text(text = item.getCharacterFrom())
            }
        }
    }
}

@Composable
fun CharacterImage(imageUrl: String) {
    Box(
        modifier = Modifier
            .height(150.dp)
            .width(150.dp),
    ) {
        Image(
            painter = rememberImagePainter(
                data = imageUrl,
                builder = {
                    size(OriginalSize)
                    placeholder(R.drawable.unknown)
                },
            ),
            contentDescription = "Character Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
    }
}