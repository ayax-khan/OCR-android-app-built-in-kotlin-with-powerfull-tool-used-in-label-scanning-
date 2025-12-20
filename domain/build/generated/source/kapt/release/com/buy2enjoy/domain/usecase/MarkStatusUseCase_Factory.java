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
public final class MarkStatusUseCase_Factory implements Factory<MarkStatusUseCase> {
  private final Provider<ReturnRepository> repositoryProvider;

  public MarkStatusUseCase_Factory(Provider<ReturnRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public MarkStatusUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static MarkStatusUseCase_Factory create(Provider<ReturnRepository> repositoryProvider) {
    return new MarkStatusUseCase_Factory(repositoryProvider);
  }

  public static MarkStatusUseCase newInstance(ReturnRepository repository) {
    return new MarkStatusUseCase(repository);
  }
}
