package edu.ucne.aplicada2.frailyn_garcia_ap2_p2.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import edu.ucne.aplicada2.frailyn_garcia_ap2_p2.presentation.Home.HomeScreen
import edu.ucne.aplicada2.frailyn_garcia_ap2_p2.presentation.contributors.ContributorsListScreen
import edu.ucne.aplicada2.frailyn_garcia_ap2_p2.presentation.repositories.RepositoryListScreen

@Composable
fun HomeNavHost(
    navHostController: NavHostController
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    NavHost(
        navController = navHostController,
        startDestination = Screen.Home
    ) {
        // Inicio
        composable<Screen.Home> {
            HomeScreen(navController = navHostController)
        }

        // Lista de repositorios
        composable<Screen.RepositoryList> {
            RepositoryListScreen(
                goToRepository = { id ->
                    navHostController.navigate(Screen.ContributorsList(id))
                },
                createRepository = {
                    // TODO: Implementar navegación a la pantalla de creación de repositorios
                    navHostController.navigate(Screen.Repository(null))
                },
                deleteRepository = null, // Pasamos null explícitamente
                drawerState = drawerState,
                scope = scope
            )
        }

        // Lista de contribuidores
        composable<Screen.ContributorsList> { backStackEntry ->
            val contributorsListScreen = backStackEntry.toRoute<Screen.ContributorsList>()
            ContributorsListScreen(
                repositoryName = contributorsListScreen.repositoryName,
                drawerState = drawerState,
                scope = scope,
                onBackClick = { navHostController.popBackStack() }
            )
        }

        // Placeholder para Repository (para createRepository)
        composable<Screen.Repository> { backStackEntry ->
            val repositoryScreen = backStackEntry.toRoute<Screen.Repository>()
            // TODO: Implementar pantalla para Repository
            Text(
                text = "Pantalla de Repositorio (registroId: ${repositoryScreen.registroId})",
                modifier = Modifier.fillMaxSize(),
                textAlign = TextAlign.Center
            )
        }
    }
}
