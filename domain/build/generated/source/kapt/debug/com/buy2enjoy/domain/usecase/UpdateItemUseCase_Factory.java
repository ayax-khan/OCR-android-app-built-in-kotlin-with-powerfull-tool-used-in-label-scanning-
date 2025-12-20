package com.buy2enjoy.domain.usecase;

import com.buy2enjoy.domain.repository.ReturnRepository;
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
public final class UpdateItemUseCase_Factory implements Factory<UpdateItemUseCase> {
  private final Provider<ReturnRepository> repositoryProvider;

  public UpdateItemUseCase_Factory(Provider<ReturnRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public UpdateItemUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static UpdateItemUseCase_Factory create(Provider<ReturnRepository> repositoryProvider) {
    return new UpdateItemUseCase_Factory(repositoryProvider);
  }

  public static UpdateItemUseCase newInstance(ReturnRepository repository) {
    return new UpdateItemUseCase(repository);
  }
}
