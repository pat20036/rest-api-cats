package com.pat.rest



import com.pat.rest.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    single <CatInterface>{ CatInterfaceImpl() }
    viewModel{ MainViewModel(get()) }
}