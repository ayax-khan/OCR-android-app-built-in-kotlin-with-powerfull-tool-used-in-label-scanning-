package com.buy2enjoy.feature_detail;

import androidx.lifecycle.SavedStateHandle;
import com.buy2enjoy.domain.repository.ReturnRepository;
import com.buy2enjoy.domain.usecase.MarkStatusUseCase;
import com.buy2enjoy.domain.usecase.UpdateItemUseCase;
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
public final class DetailViewModel_Factory implements Factory<DetailViewModel> {
  private final Provider<ReturnRepository> repositoryProvider;

  private final Provider<UpdateItemUseCase> updateItemProvider;

  private final Provider<MarkStatusUseCase> markStatusProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public DetailViewModel_Factory(Provider<ReturnRepository> repositoryProvider,
      Provider<UpdateItemUseCase> updateItemProvider,
      Provider<MarkStatusUseCase> markStatusProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.repositoryProvider = repositoryProvider;
    this.updateItemProvider = updateItemProvider;
    this.markStatusProvider = markStatusProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public DetailViewModel get() {
    return newInstance(repositoryProvider.get(), updateItemProvider.get(), markStatusProvider.get(), savedStateHandleProvider.get());
  }

  public static DetailViewModel_Factory create(Provider<ReturnRepository> repositoryProvider,
      Provider<UpdateItemUseCase> updateItemProvider,
      Provider<MarkStatusUseCase> markStatusProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new DetailViewModel_Factory(repositoryProvider, updateItemProvider, markStatusProvider, savedStateHandleProvider);
  }

  public static DetailViewModel newInstance(ReturnRepository repository,
      UpdateItemUseCase updateItem, MarkStatusUseCase markStatus,
      SavedStateHandle savedStateHandle) {
    return new DetailViewModel(repository, updateItem, markStatus, savedStateHandle);
  }
}
