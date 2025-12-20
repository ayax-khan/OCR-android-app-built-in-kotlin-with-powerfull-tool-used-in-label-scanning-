package com.buy2enjoy.feature_detail;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0018J\u001a\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0012R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/buy2enjoy/feature_detail/DetailViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/buy2enjoy/domain/repository/ReturnRepository;", "updateItem", "Lcom/buy2enjoy/domain/usecase/UpdateItemUseCase;", "markStatus", "Lcom/buy2enjoy/domain/usecase/MarkStatusUseCase;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Lcom/buy2enjoy/domain/repository/ReturnRepository;Lcom/buy2enjoy/domain/usecase/UpdateItemUseCase;Lcom/buy2enjoy/domain/usecase/MarkStatusUseCase;Landroidx/lifecycle/SavedStateHandle;)V", "_isSaving", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_item", "Lcom/buy2enjoy/domain/model/ReturnItem;", "isSaving", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "item", "getItem", "itemId", "", "changeStatus", "", "status", "Lcom/buy2enjoy/domain/model/ReturnStatus;", "save", "updateFields", "orderNumber", "", "createdDateDisplay", "feature-detail_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class DetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.buy2enjoy.domain.repository.ReturnRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.buy2enjoy.domain.usecase.UpdateItemUseCase updateItem = null;
    @org.jetbrains.annotations.NotNull()
    private final com.buy2enjoy.domain.usecase.MarkStatusUseCase markStatus = null;
    private final long itemId = 0L;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.buy2enjoy.domain.model.ReturnItem> _item = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.buy2enjoy.domain.model.ReturnItem> item = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isSaving = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isSaving = null;
    
    @javax.inject.Inject()
    public DetailViewModel(@org.jetbrains.annotations.NotNull()
    com.buy2enjoy.domain.repository.ReturnRepository repository, @org.jetbrains.annotations.NotNull()
    com.buy2enjoy.domain.usecase.UpdateItemUseCase updateItem, @org.jetbrains.annotations.NotNull()
    com.buy2enjoy.domain.usecase.MarkStatusUseCase markStatus, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.SavedStateHandle savedStateHandle) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.buy2enjoy.domain.model.ReturnItem> getItem() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isSaving() {
        return null;
    }
    
    public final void updateFields(@org.jetbrains.annotations.Nullable()
    java.lang.String orderNumber, @org.jetbrains.annotations.Nullable()
    java.lang.String createdDateDisplay) {
    }
    
    public final void changeStatus(@org.jetbrains.annotations.NotNull()
    com.buy2enjoy.domain.model.ReturnStatus status) {
    }
    
    public final void save() {
    }
}