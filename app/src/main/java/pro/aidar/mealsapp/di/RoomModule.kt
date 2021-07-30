package pro.aidar.mealsapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import pro.aidar.mealsapp.db.FavoritesDao
import pro.aidar.mealsapp.db.MealDataBase

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Provides
    @Singleton
    fun provideCharacterDatabase(
        @ApplicationContext context: Context
    ): MealDataBase {
        return Room.databaseBuilder(
            context,
            MealDataBase::class.java,
            "database"
        ).build()
    }

    @Provides
    fun provideNoteDao(db: MealDataBase): FavoritesDao {
        return db.mealDao()
    }
}