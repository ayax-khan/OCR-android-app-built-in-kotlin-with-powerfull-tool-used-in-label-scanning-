package com.buy2enjoy.domain.usecase;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\n\u000bB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086B\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/buy2enjoy/domain/usecase/ScanAndInsertItemUseCase;", "", "repository", "Lcom/buy2enjoy/domain/repository/ReturnRepository;", "(Lcom/buy2enjoy/domain/repository/ReturnRepository;)V", "invoke", "Lcom/buy2enjoy/domain/usecase/ScanAndInsertItemUseCase$Result;", "params", "Lcom/buy2enjoy/domain/usecase/ScanAndInsertItemUseCase$Params;", "(Lcom/buy2enjoy/domain/usecase/ScanAndInsertItemUseCase$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Params", "Result", "domain_release"})
public final class ScanAndInsertItemUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.buy2enjoy.domain.repository.ReturnRepository repository = null;
    
    @javax.inject.Inject()
    public ScanAndInsertItemUseCase(@org.jetbrains.annotations.NotNull()
    com.buy2enjoy.domain.repository.ReturnRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    com.buy2enjoy.domain.usecase.ScanAndInsertItemUseCase.Params params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.buy2enjoy.domain.usecase.ScanAndInsertItemUseCase.Result> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J+\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/buy2enjoy/domain/usecase/ScanAndInsertItemUseCase$Params;", "", "trackingNumber", "", "orderNumber", "createdDateDisplay", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCreatedDateDisplay", "()Ljava/lang/String;", "getOrderNumber", "getTrackingNumber", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "domain_release"})
    public static final class Params {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String trackingNumber = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String orderNumber = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String createdDateDisplay = null;
        
        public Params(@org.jetbrains.annotations.NotNull()
        java.lang.String trackingNumber, @org.jetbrains.annotations.Nullable()
        java.lang.String orderNumber, @org.jetbrains.annotations.Nullable()
        java.lang.String createdDateDisplay) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTrackingNumber() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getOrderNumber() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getCreatedDateDisplay() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.buy2enjoy.domain.usecase.ScanAndInsertItemUseCase.Params copy(@org.jetbrains.annotations.NotNull()
        java.lang.String trackingNumber, @org.jetbrains.annotations.Nullable()
        java.lang.String orderNumber, @org.jetbrains.annotations.Nullable()
        java.lang.String createdDateDisplay) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/buy2enjoy/domain/usecase/ScanAndInsertItemUseCase$Result;", "", "()V", "Duplicate", "Inserted", "Invalid", "Lcom/buy2enjoy/domain/usecase/ScanAndInsertItemUseCase$Result$Duplicate;", "Lcom/buy2enjoy/domain/usecase/ScanAndInsertItemUseCase$Result$Inserted;", "Lcom/buy2enjoy/domain/usecase/ScanAndInsertItemUseCase$Result$Invalid;", "domain_release"})
    public static abstract class Result {
        
        private Result() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/buy2enjoy/domain/usecase/ScanAndInsertItemUseCase$Result$Duplicate;", "Lcom/buy2enjoy/domain/usecase/ScanAndInsertItemUseCase$Result;", "existing", "Lcom/buy2enjoy/domain/model/ReturnItem;", "(Lcom/buy2enjoy/domain/model/ReturnItem;)V", "getExisting", "()Lcom/buy2enjoy/domain/model/ReturnItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "domain_release"})
        public static final class Duplicate extends com.buy2enjoy.domain.usecase.ScanAndInsertItemUseCase.Result {
            @org.jetbrains.annotations.NotNull()
            private final com.buy2enjoy.domain.model.ReturnItem existing = null;
            
            public Duplicate(@org.jetbrains.annotations.NotNull()
            com.buy2enjoy.domain.model.ReturnItem existing) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.buy2enjoy.domain.model.ReturnItem getExisting() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.buy2enjoy.domain.model.ReturnItem component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.buy2enjoy.domain.usecase.ScanAndInsertItemUseCase.Result.Duplicate copy(@org.jetbrains.annotations.NotNull()
            com.buy2enjoy.domain.model.ReturnItem existing) {
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
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/buy2enjoy/domain/usecase/ScanAndInsertItemUseCase$Result$Inserted;", "Lcom/buy2enjoy/domain/usecase/ScanAndInsertItemUseCase$Result;", "item", "Lcom/buy2enjoy/domain/model/ReturnItem;", "(Lcom/buy2enjoy/domain/model/ReturnItem;)V", "getItem", "()Lcom/buy2enjoy/domain/model/ReturnItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "domain_release"})
        public static final class Inserted extends com.buy2enjoy.domain.usecase.ScanAndInsertItemUseCase.Result {
            @org.jetbrains.annotations.NotNull()
            private final com.buy2enjoy.domain.model.ReturnItem item = null;
            
            public Inserted(@org.jetbrains.annotations.NotNull()
            com.buy2enjoy.domain.model.ReturnItem item) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.buy2enjoy.domain.model.ReturnItem getItem() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.buy2enjoy.domain.model.ReturnItem component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.buy2enjoy.domain.usecase.ScanAndInsertItemUseCase.Result.Inserted copy(@org.jetbrains.annotations.NotNull()
            com.buy2enjoy.domain.model.ReturnItem item) {
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
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/buy2enjoy/domain/usecase/ScanAndInsertItemUseCase$Result$Invalid;", "Lcom/buy2enjoy/domain/usecase/ScanAndInsertItemUseCase$Result;", "reason", "", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "domain_release"})
        public static final class Invalid extends com.buy2enjoy.domain.usecase.ScanAndInsertItemUseCase.Result {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String reason = null;
            
            public Invalid(@org.jetbrains.annotations.NotNull()
            java.lang.String reason) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getReason() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.buy2enjoy.domain.usecase.ScanAndInsertItemUseCase.Result.Invalid copy(@org.jetbrains.annotations.NotNull()
            java.lang.String reason) {
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
}