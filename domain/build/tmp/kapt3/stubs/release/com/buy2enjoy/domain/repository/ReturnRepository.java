package com.buy2enjoy.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001 J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\u0011\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010\nJ\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u00a6@\u00a2\u0006\u0002\u0010\u0016J<\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00190\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001cH&J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018H&J\u0016\u0010\u001f\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006!"}, d2 = {"Lcom/buy2enjoy/domain/repository/ReturnRepository;", "", "getById", "Lcom/buy2enjoy/domain/model/ReturnItem;", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getByTrackingNumber", "trackingNumber", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertScannedItem", "", "item", "(Lcom/buy2enjoy/domain/model/ReturnItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "itemsForExport", "", "monthYear", "markStatus", "", "status", "Lcom/buy2enjoy/domain/model/ReturnStatus;", "(JLcom/buy2enjoy/domain/model/ReturnStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pagedItems", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "query", "pageSize", "", "stats", "Lcom/buy2enjoy/domain/repository/ReturnRepository$Stats;", "updateItem", "Stats", "domain_release"})
public abstract interface ReturnRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertScannedItem(@org.jetbrains.annotations.NotNull()
    com.buy2enjoy.domain.model.ReturnItem item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateItem(@org.jetbrains.annotations.NotNull()
    com.buy2enjoy.domain.model.ReturnItem item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object markStatus(long id, @org.jetbrains.annotations.NotNull()
    com.buy2enjoy.domain.model.ReturnStatus status, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.buy2enjoy.domain.model.ReturnItem>> pagedItems(@org.jetbrains.annotations.Nullable()
    java.lang.String query, @org.jetbrains.annotations.Nullable()
    java.lang.String monthYear, @org.jetbrains.annotations.Nullable()
    com.buy2enjoy.domain.model.ReturnStatus status, int pageSize);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.buy2enjoy.domain.repository.ReturnRepository.Stats> stats();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getByTrackingNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String trackingNumber, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.buy2enjoy.domain.model.ReturnItem> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.buy2enjoy.domain.model.ReturnItem> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object itemsForExport(@org.jetbrains.annotations.NotNull()
    java.lang.String monthYear, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.buy2enjoy.domain.model.ReturnItem>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0019"}, d2 = {"Lcom/buy2enjoy/domain/repository/ReturnRepository$Stats;", "", "totalScanned", "", "verified", "pending", "scannedThisMonth", "(JJJJ)V", "getPending", "()J", "getScannedThisMonth", "getTotalScanned", "getVerified", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "domain_release"})
    public static final class Stats {
        private final long totalScanned = 0L;
        private final long verified = 0L;
        private final long pending = 0L;
        private final long scannedThisMonth = 0L;
        
        public Stats(long totalScanned, long verified, long pending, long scannedThisMonth) {
            super();
        }
        
        public final long getTotalScanned() {
            return 0L;
        }
        
        public final long getVerified() {
            return 0L;
        }
        
        public final long getPending() {
            return 0L;
        }
        
        public final long getScannedThisMonth() {
            return 0L;
        }
        
        public final long component1() {
            return 0L;
        }
        
        public final long component2() {
            return 0L;
        }
        
        public final long component3() {
            return 0L;
        }
        
        public final long component4() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.buy2enjoy.domain.repository.ReturnRepository.Stats copy(long totalScanned, long verified, long pending, long scannedThisMonth) {
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