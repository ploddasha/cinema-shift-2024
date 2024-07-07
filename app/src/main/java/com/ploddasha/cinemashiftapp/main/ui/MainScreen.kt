package com.ploddasha.cinemashiftapp.main.ui

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.ploddasha.cinemashiftapp.R
import com.ploddasha.cinemashiftapp.film.FilmRoute
import com.ploddasha.cinemashiftapp.film.ui.FilmScreen
import com.ploddasha.cinemashiftapp.main.presentation.MainViewModel
import com.ploddasha.cinemashiftapp.main.presentation.NavigationOption
import com.ploddasha.cinemashiftapp.navigation.NavControllerHolder
import com.ploddasha.cinemashiftapp.poster.FilmPosterRoute
import com.ploddasha.cinemashiftapp.poster.ui.FilmPosterScreen
import com.ploddasha.cinemashiftapp.schedule.ScheduleRoute
import com.ploddasha.cinemashiftapp.schedule.ui.ScheduleScreen
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val globalRouterImpl = koinInject<NavControllerHolder>()
    val mainViewModel = koinViewModel<MainViewModel>()

    val state by mainViewModel.state.collectAsStateWithLifecycle()

    DisposableEffect(key1 = Unit) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val openedOption = state.navigationOptions.firstOrNull {
                destination.hasRoute(route = it.route)
            }
            mainViewModel.handleOpenedScreen(openedOption)
        }

        globalRouterImpl.setNavController(navController)
        onDispose {
            globalRouterImpl.clearNavController()
        }
    }

    Surface {
        Column {
            NavHost(
                modifier = Modifier.weight(1f),
                navController = navController,
                startDestination = FilmPosterRoute
            ) {
                animatedComposable<FilmPosterRoute> {
                    FilmPosterScreen(
                        filmPosterViewModel = koinViewModel(),
                    )
                }
                animatedComposable<FilmRoute> {
                    val destination = it.toRoute<FilmRoute>()
                    FilmScreen(
                        filmViewModel = koinViewModel { parametersOf(destination.filmId) },
                    )
                }
                animatedComposable<ScheduleRoute> {
                    val destination = it.toRoute<ScheduleRoute>()
                    ScheduleScreen(
                        scheduleViewModel = koinViewModel { parametersOf(destination.filmId) },
                    )
                }
            }
            BottomNavigation(
                navigationOptions = state.navigationOptions,
                selectedNavigationOption = state.selectedNavOption,
                onItemClicked = mainViewModel::openOption,
            )
        }

    }
}

inline fun <reified T: Any> NavGraphBuilder.animatedComposable(noinline block: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit) {
    composable<T>(
        enterTransition = ENTER_TRANSITION,
        exitTransition = EXIT_TRANSITION,
        popEnterTransition = POP_ENTER_TRANSITION,
        popExitTransition = POP_EXIT_TRANSITION,
        content = block
    )
}

@Composable
private fun BottomNavigation(
    navigationOptions: List<NavigationOption>,
    selectedNavigationOption: NavigationOption?,
    onItemClicked: (NavigationOption) -> Unit,
) {
    NavigationBar {
        for (option in navigationOptions) {
            NavigationBarItem(
                selected = selectedNavigationOption == option,
                onClick = { onItemClicked(option) },
                icon = { Icon(navOptionIcon(option), "") },
                label = { Text(text = navOptionLabel(option)) }
            )
        }
    }
}

private fun navOptionIcon(option: NavigationOption): ImageVector =
    when (option) {
        NavigationOption.POSTER    -> Icons.Default.Home
        NavigationOption.TICKETS    -> Icons.Default.ShoppingCart
        NavigationOption.PROFILE    -> Icons.Default.AccountCircle

    }

@Composable
private fun navOptionLabel(option: NavigationOption): String = stringResource(
    when (option) {
        NavigationOption.POSTER    -> R.string.bottom_bar_poster
        NavigationOption.TICKETS -> R.string.bottom_bar_tickets
        NavigationOption.PROFILE -> R.string.bottom_bar_profile
    }
)