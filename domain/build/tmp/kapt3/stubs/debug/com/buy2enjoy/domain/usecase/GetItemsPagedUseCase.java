package com.buy2enjoy.domain.usecase;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/buy2enjoy/domain/usecase/GetItemsPagedUseCase;", "", "repository", "Lcom/buy2enjoy/domain/repository/ReturnRepository;", "(Lcom/buy2enjoy/domain/repository/ReturnRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/buy2enjoy/domain/model/ReturnItem;", "params", "Lcom/buy2enjoy/domain/usecase/GetItemsPagedUseCase$Params;", "Params", "domain_debug"})
public final class GetItemsPagedUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.buy2enjoy.domain.repository.ReturnRepository repository = null;
    
    @javax.inject.Inject()
    public GetItemsPagedUseCase(@org.jetbrains.annotations.NotNull()
    com.buy2enjoy.domain.repository.ReturnRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.buy2enjoy.domain.model.ReturnItem>> invoke(@org.jetbrains.annotations.NotNull()
    com.buy2enjoy.domain.usecase.GetItemsPagedUseCase.Params params) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\bH\u00c6\u0003J7\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\bH\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001b"}, d2 = {"Lcom/buy2enjoy/domain/usecase/GetItemsPagedUseCase$Params;", "", "query", "", "monthYear", "status", "Lcom/buy2enjoy/domain/model/ReturnStatus;", "pageSize", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/buy2enjoy/domain/model/ReturnStatus;I)V", "getMonthYear", "()Ljava/lang/String;", "getPageSize", "()I", "getQuery", "getStatus", "()Lcom/buy2enjoy/domain/model/ReturnStatus;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "domain_debug"})
    public static final class Params {
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String query = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String monthYear = null;
        @org.jetbrains.annotations.Nullable()
        private final com.buy2enjoy.domain.model.ReturnStatus status = null;
        private final int pageSize = 0;
        
        public Params(@org.jetbrains.annotations.Nullable()
        java.lang.String query, @org.jetbrains.annotations.Nullable()
        java.lang.String monthYear, @org.jetbrains.annotations.Nullable()
        com.buy2enjoy.domain.model.ReturnStatus status, int pageSize) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getQuery() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getMonthYear() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.buy2enjoy.domain.model.ReturnStatus getStatus() {
            return null;
        }
        
        public final int getPageSize() {
            return 0;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.buy2enjoy.domain.model.ReturnStatus component3() {
            return null;
        }
        
        public final int component4() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.buy2enjoy.domain.usecase.GetItemsPagedUseCase.Params copy(@org.jetbrains.annotations.Nullable()
        java.lang.String query, @org.jetbrains.annotations.Nullable()
        java.lang.String monthYear, @org.jetbrains.annotations.Nullable()
        com.buy2enjoy.domain.model.ReturnStatus status, int pageSize) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}