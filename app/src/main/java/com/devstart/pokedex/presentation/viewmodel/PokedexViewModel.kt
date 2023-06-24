package com.devstart.pokedex.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devstart.pokedex.domain.usecase.GetPokemonUseCase
import com.devstart.pokedex.domain.usecase.GetPokemonsUseCase
import com.devstart.pokedex.presentation.dataui.PokemonDataUi
import com.devstart.pokedex.presentation.mapper.PokemonDataUiMapper
import com.devstart.pokedex.presentation.state.PokemonDetailState
import com.devstart.pokedex.presentation.state.PokemonListState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PokedexViewModel(
    private val getPokemonsUseCase: GetPokemonsUseCase,
    private val getPokemonUseCase: GetPokemonUseCase,
    private val pokemonDataUiMapper: PokemonDataUiMapper
) : ViewModel() {

    var pokemonListState by mutableStateOf(PokemonListState())
    private var defaultPokemonList: List<PokemonDataUi> = emptyList()

    var pokemonDetailState by mutableStateOf(PokemonDetailState())

    init {
        getPokemons()
    }

    private fun getPokemons() {
        updatePokemonListState(loading = true)
        viewModelScope.launch(Dispatchers.IO) {
            runCatching { getPokemonsUseCase() }
                .onSuccess { pokemons ->
                    val pokemonsDataUi = pokemonDataUiMapper.toItemList(pokemons)
                    updatePokemonListState(pokemons = pokemonsDataUi)
                    defaultPokemonList = pokemonsDataUi
                }
                .onFailure { throwable ->
                    updatePokemonListState(error = throwable)
                }
        }
    }

    private fun updatePokemonListState(
        pokemons: List<PokemonDataUi>? = null,
        loading: Boolean = false,
        error: Throwable? = null,
    ) {
        pokemonListState = pokemonListState.copy(
            pokemons = pokemons,
            loading = loading,
            error = error
        )
    }

    fun onSearchValueChanged(query: String) {
        if (query.isEmpty()) {
            updatePokemonListState(pokemons = defaultPokemonList)
        } else {
            val newPokemonList = defaultPokemonList.filter { it.doesMatchSearchQuery(query) }
            updatePokemonListState(pokemons = newPokemonList)
        }
    }

    fun getPokemonDetail(name: String) {
        updatePokemonDetailState(loading = true)
        viewModelScope.launch(Dispatchers.IO) {
            runCatching { getPokemonUseCase(name) }
                .onSuccess { pokemon ->
                    updatePokemonDetailState(pokemonDataUiMapper.toItem(pokemon), loading = false)
                }
                .onFailure { throwable ->
                    updatePokemonDetailState(error = throwable, loading = false)
                }
        }
    }

    private fun updatePokemonDetailState(
        pokemon: PokemonDataUi? = null,
        loading: Boolean = false,
        error: Throwable? = null
    ) {
        pokemonDetailState = pokemonDetailState.copy(
            pokemon = pokemon,
            loading = loading,
            error = error
        )
    }
}