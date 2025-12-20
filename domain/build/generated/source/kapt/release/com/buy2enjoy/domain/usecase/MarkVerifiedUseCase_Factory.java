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
public final class MarkVerifiedUseCase_Factory implements Factory<MarkVerifiedUseCase> {
  private final Provider<ReturnRepository> repositoryProvider;

  public MarkVerifiedUseCase_Factory(Provider<ReturnRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public MarkVerifiedUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static MarkVerifiedUseCase_Factory create(Provider<ReturnRepository> repositoryProvider) {
    return new MarkVerifiedUseCase_Factory(repositoryProvider);
  }

  public static MarkVerifiedUseCase newInstance(ReturnRepository repository) {
    return new MarkVerifiedUseCase(repository);
  }
}
