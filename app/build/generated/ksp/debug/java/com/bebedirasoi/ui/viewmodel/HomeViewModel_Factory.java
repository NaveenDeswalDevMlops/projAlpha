package com.bebedirasoi.ui.viewmodel;

import com.bebedirasoi.domain.repository.MealRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<MealRepository> mealRepositoryProvider;

  public HomeViewModel_Factory(Provider<MealRepository> mealRepositoryProvider) {
    this.mealRepositoryProvider = mealRepositoryProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(mealRepositoryProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<MealRepository> mealRepositoryProvider) {
    return new HomeViewModel_Factory(mealRepositoryProvider);
  }

  public static HomeViewModel newInstance(MealRepository mealRepository) {
    return new HomeViewModel(mealRepository);
  }
}
