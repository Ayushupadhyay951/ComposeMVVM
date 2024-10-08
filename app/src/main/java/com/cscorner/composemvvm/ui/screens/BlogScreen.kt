package com.cscorner.composemvvm.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cscorner.composemvvm.models.Article

sealed class BlogEvent {
    data class OnArticleClick(val article: Article?) : BlogEvent()
}

@Composable
fun BlogScreen(
    modifier: Modifier = Modifier,
    blogState: BlogState,
    loginState: LoginState,
    onEvent: (BlogEvent) -> Unit = {},
    onLoginEvent: (LoginEvent)->Unit={}
) {
    Column(modifier = Modifier) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .padding(8.dp)
                        .background(Color.Gray, shape = CircleShape),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(imageVector = Icons.Default.Person, contentDescription = "person")
                }
                Text(text = "Welcome,${loginState.username}", fontSize = 20.sp)
            }
        }
        LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = PaddingValues(8.dp)) {
            items(blogState.articleList) { article ->
                ArticleCard(article = article) { selectedArticle ->
                    onEvent( BlogEvent.OnArticleClick(selectedArticle))
                }
            }
        }
    }

}


@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onArticleSelected: (Article) -> Unit,
) {
    Card(
        onClick = { onArticleSelected(article) }, modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Column {
            AsyncImage(
                article.imgUrl,
                contentDescription = article.title,
                modifier = Modifier.height(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = article.title, fontSize = 16.sp, modifier = Modifier.padding(
                    vertical = 8.dp, horizontal = 8.dp
                )
            )
        }
    }
}

@Preview
@Composable
private fun BlogScreenPreview() {
    BlogScreen(blogState = BlogState(), loginState = LoginState(
        username = "Rahul"
    ), onEvent = {})
}