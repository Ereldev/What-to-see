package com.ereldev.whattosee.android.show

import com.ereldev.whattosee.shared.show.GetShowsUseCase
import com.ereldev.whattosee.shared.show.ShowRepository
import com.ereldev.whattosee.shared.show.ShowService
import com.ereldev.whattosee.shared.show.mapper.MovieToToShowMapper
import com.ereldev.whattosee.shared.show.mapper.ShowToShowUIMapper
import com.ereldev.whattosee.shared.show.mapper.TVShowToToShowMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val showModule = module {

    viewModel { ShowsViewModel(get()) }

    single { GetShowsUseCase(get(), get()) }

    single { ShowRepository(get(), get(), get()) }

    single { ShowService() }

    single { ShowToShowUIMapper() }
    single { MovieToToShowMapper() }
    single { TVShowToToShowMapper() }

}