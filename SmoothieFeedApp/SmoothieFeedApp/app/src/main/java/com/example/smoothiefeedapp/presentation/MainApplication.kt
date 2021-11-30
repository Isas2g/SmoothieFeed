package com.example.smoothiefeedapp.presentation

import android.app.Application
import androidx.room.Room
import com.example.smoothiefeedapp.BuildConfig
import com.example.smoothiefeedapp.data.*
import com.example.smoothiefeedapp.data.implementations.VKRetrofitImpl
import com.example.smoothiefeedapp.data.implementations.*
import com.example.smoothiefeedapp.domain.use_cases.*
import com.example.smoothiefeedapp.presentation.view_models.*
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import timber.log.Timber

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidContext(this@MainApplication)
            modules(
                listOf(
                    localModule,
                    daosModule,
                    remoteModule,
                    implsModule,
                    useCasesModule,
                    viewModelsModule
                )
            )
        }
    }

    private val localModule = module {
        single {
            Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                AppDatabase.DB_NAME
            ).build()
        }
        single { DatastoreRepositoryImpl(applicationContext) }
    }

    private val daosModule = module {
        factory { get<AppDatabase>().getUserDao() }
        factory { get<AppDatabase>().getDetoxDao() }
        factory { get<AppDatabase>().getPostsDetoxDao() }
        factory { get<AppDatabase>().getTimeDetoxDao() }
        factory { get<AppDatabase>().getNewsDao() }
        factory { get<AppDatabase>().getSFUserDao() }
    }

    private val remoteModule = module {
        factory { VKRetrofitImpl() }
        factory { NewsRepositoryImpl(get<VKRetrofitImpl>().VKApi, get(), get()) }
    }

    private val implsModule = module {
        factory { SFUserMockRepositoryImpl(get(), get<DatastoreRepositoryImpl>()) }
        factory {
            NetworkingUserRepositoryImpl(
                get<VKRetrofitImpl>().VKApi,
                get(),
                get<DatastoreRepositoryImpl>()
            )
        }
    }

    private val useCasesModule = module {
        factory { GetNewsListUseCase(get<NewsRepositoryImpl>()) }
        factory { LoadNewsListUseCase(get<NewsRepositoryImpl>()) }
        factory { SaveTokenUseCase(get<DatastoreRepositoryImpl>()) }
        factory { ListenTokenChangesUseCase(get<DatastoreRepositoryImpl>()) }
        factory { GetTokenUseCase(get<DatastoreRepositoryImpl>()) }
        factory { AuthSFUserUseCase(get<SFUserMockRepositoryImpl>()) }//change with smoothie server
        factory { GetSFUserUseCase(get<SFUserMockRepositoryImpl>()) }//change with smoothie server
        factory { CreateNewSFUserUseCase(get<SFUserMockRepositoryImpl>()) }//change with smoothie server
        factory { GetVKUserUseCase(get<NetworkingUserRepositoryImpl>()) }
        factory { LoadVKUserUseCase(get<NetworkingUserRepositoryImpl>()) }
    }

    private val viewModelsModule = module {
        viewModel {
            MainFragmentViewModel(
                get(),
                GetDetoxUseCase(PostsDetoxRepositoryImpl(get())),
                GetDetoxUseCase(TimeDetoxRepositoryImpl(get())),
                DeleteDetoxUseCase(PostsDetoxRepositoryImpl(get())),
                DeleteDetoxUseCase(TimeDetoxRepositoryImpl(get())),
                get()
            )
        }
        viewModel { AuthorizationFragmentViewModel(get(), get(), get(), get()) }
        viewModel { LoginFragmentViewModel(get(), get()) }
        viewModel {
            ChooseDetoxDialogueViewModel(
                SavePostsDetoxUseCase(PostsDetoxRepositoryImpl(get())),
                SaveTimeDetoxUseCase(TimeDetoxRepositoryImpl(get())),
                GetDetoxUseCase(PostsDetoxRepositoryImpl(get())),
                GetDetoxUseCase(TimeDetoxRepositoryImpl(get()))
            )
        }
        viewModel { RegistrationFragmentViewModel(get()) }
        viewModel { UserAccountsFragmentViewModel(get()) }
    }
}