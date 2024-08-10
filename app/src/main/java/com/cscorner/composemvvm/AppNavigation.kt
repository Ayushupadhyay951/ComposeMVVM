package com.cscorner.composemvvm

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cscorner.composemvvm.ui.screens.AppViewModel
import com.cscorner.composemvvm.ui.screens.ArticleScreen
import com.cscorner.composemvvm.ui.screens.BlogScreen
import com.cscorner.composemvvm.ui.screens.LoginScreen

enum class Screen(val route: String) {
    Login("login"),
    Blog("blog"),
    Article("article")
}

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val vm: AppViewModel = viewModel()
    val navController = rememberNavController()
    val blogState=vm.blogState.collectAsState().value
    val loginState=vm.loginState.collectAsState().value
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            LoginScreen(
                modifier = Modifier,
                state = loginState,
                onEvent = vm::onLoginEvent,
            )
            if (loginState.isLoginCompleted) {
                navController.navigate(Screen.Blog.route)
            }

        }
        composable(Screen.Blog.route) {
            BlogScreen(
                modifier = Modifier,
                blogState = blogState,
                loginState = loginState,
                onEvent = vm::onBlogEvent,
            )
            if(blogState.selectedArticle!=null){
                navController.navigate(Screen.Article.route)
            }
        }
        composable(Screen.Article.route) {
            if(blogState.selectedArticle== null){
                navController.popBackStack()
            }
            ArticleScreen(
                modifier = Modifier,
                blogState = blogState,
                loginState = loginState,
                onEvent = vm::onBlogEvent,
            )
        }

    }
}