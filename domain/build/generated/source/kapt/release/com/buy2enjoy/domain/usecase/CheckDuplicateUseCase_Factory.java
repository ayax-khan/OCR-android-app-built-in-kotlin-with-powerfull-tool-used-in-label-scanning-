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
public final class CheckDuplicateUseCase_Factory implements Factory<CheckDuplicateUseCase> {
  private final Provider<ReturnRepository> repositoryProvider;

  public CheckDuplicateUseCase_Factory(Provider<ReturnRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public CheckDuplicateUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static CheckDuplicateUseCase_Factory create(
      Provider<ReturnRepository> repositoryProvider) {
    return new CheckDuplicateUseCase_Factory(repositoryProvider);
  }

  public static CheckDuplicateUseCase newInstance(ReturnRepository repository) {
    return new CheckDuplicateUseCase(repository);
  }
}
