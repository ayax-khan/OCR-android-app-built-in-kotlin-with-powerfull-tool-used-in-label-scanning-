package com.buy2enjoy.core.database.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u00152\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ2\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\f0\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\'J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/buy2enjoy/core/database/dao/ReturnItemDao;", "", "countAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "countByMonth", "month", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "countPending", "countVerified", "getById", "Lcom/buy2enjoy/core/database/entity/ReturnItemEntity;", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getByTracking", "tracking", "insertIgnore", "item", "(Lcom/buy2enjoy/core/database/entity/ReturnItemEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "itemsByMonth", "", "paging", "Landroidx/paging/PagingSource;", "", "query", "status", "update", "", "core-database_debug"})
@androidx.room.Dao()
public abstract interface ReturnItemDao {
    
    @androidx.room.Insert(onConflict = 5)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertIgnore(@org.jetbrains.annotations.NotNull()
    com.buy2enjoy.core.database.entity.ReturnItemEntity item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull()
    com.buy2enjoy.core.database.entity.ReturnItemEntity item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM return_items WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.buy2enjoy.core.database.entity.ReturnItemEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM return_items WHERE trackingNumber = :tracking LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getByTracking(@org.jetbrains.annotations.NotNull()
    java.lang.String tracking, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.buy2enjoy.core.database.entity.ReturnItemEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM return_items WHERE (:query IS NULL OR trackingNumber LIKE :query OR orderNumber LIKE :query) AND (:month IS NULL OR monthYear = :month) AND (:status IS NULL OR status = :status) ORDER BY scanDate DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.paging.PagingSource<java.lang.Integer, com.buy2enjoy.core.database.entity.ReturnItemEntity> paging(@org.jetbrains.annotations.Nullable()
    java.lang.String query, @org.jetbrains.annotations.Nullable()
    java.lang.String month, @org.jetbrains.annotations.Nullable()
    java.lang.String status);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM return_items")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object countAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM return_items WHERE status = \'VERIFIED\'")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object countVerified(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM return_items WHERE status = \'PENDING_VERIFICATION\' OR status = \'SCANNED\'")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object countPending(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM return_items WHERE monthYear = :month")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object countByMonth(@org.jetbrains.annotations.NotNull()
    java.lang.String month, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM return_items WHERE monthYear = :month ORDER BY scanDate DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object itemsByMonth(@org.jetbrains.annotations.NotNull()
    java.lang.String month, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.buy2enjoy.core.database.entity.ReturnItemEntity>> $completion);
}