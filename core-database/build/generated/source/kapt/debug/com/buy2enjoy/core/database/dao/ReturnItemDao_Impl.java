package com.buy2enjoy.core.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.PagingSource;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.paging.LimitOffsetPagingSource;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.buy2enjoy.core.database.entity.ReturnItemEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ReturnItemDao_Impl implements ReturnItemDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ReturnItemEntity> __insertionAdapterOfReturnItemEntity;

  private final EntityDeletionOrUpdateAdapter<ReturnItemEntity> __updateAdapterOfReturnItemEntity;

  public ReturnItemDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfReturnItemEntity = new EntityInsertionAdapter<ReturnItemEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR IGNORE INTO `return_items` (`id`,`trackingNumber`,`orderNumber`,`createdDateDisplay`,`scanDate`,`status`,`monthYear`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ReturnItemEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTrackingNumber() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTrackingNumber());
        }
        if (entity.getOrderNumber() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getOrderNumber());
        }
        if (entity.getCreatedDateDisplay() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCreatedDateDisplay());
        }
        statement.bindLong(5, entity.getScanDate());
        if (entity.getStatus() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getStatus());
        }
        if (entity.getMonthYear() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getMonthYear());
        }
      }
    };
    this.__updateAdapterOfReturnItemEntity = new EntityDeletionOrUpdateAdapter<ReturnItemEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `return_items` SET `id` = ?,`trackingNumber` = ?,`orderNumber` = ?,`createdDateDisplay` = ?,`scanDate` = ?,`status` = ?,`monthYear` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ReturnItemEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTrackingNumber() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTrackingNumber());
        }
        if (entity.getOrderNumber() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getOrderNumber());
        }
        if (entity.getCreatedDateDisplay() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCreatedDateDisplay());
        }
        statement.bindLong(5, entity.getScanDate());
        if (entity.getStatus() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getStatus());
        }
        if (entity.getMonthYear() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getMonthYear());
        }
        statement.bindLong(8, entity.getId());
      }
    };
  }

  @Override
  public Object insertIgnore(final ReturnItemEntity item,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfReturnItemEntity.insertAndReturnId(item);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final ReturnItemEntity item, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfReturnItemEntity.handle(item);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getById(final long id, final Continuation<? super ReturnItemEntity> $completion) {
    final String _sql = "SELECT * FROM return_items WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<ReturnItemEntity>() {
      @Override
      @Nullable
      public ReturnItemEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTrackingNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "trackingNumber");
          final int _cursorIndexOfOrderNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "orderNumber");
          final int _cursorIndexOfCreatedDateDisplay = CursorUtil.getColumnIndexOrThrow(_cursor, "createdDateDisplay");
          final int _cursorIndexOfScanDate = CursorUtil.getColumnIndexOrThrow(_cursor, "scanDate");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfMonthYear = CursorUtil.getColumnIndexOrThrow(_cursor, "monthYear");
          final ReturnItemEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTrackingNumber;
            if (_cursor.isNull(_cursorIndexOfTrackingNumber)) {
              _tmpTrackingNumber = null;
            } else {
              _tmpTrackingNumber = _cursor.getString(_cursorIndexOfTrackingNumber);
            }
            final String _tmpOrderNumber;
            if (_cursor.isNull(_cursorIndexOfOrderNumber)) {
              _tmpOrderNumber = null;
            } else {
              _tmpOrderNumber = _cursor.getString(_cursorIndexOfOrderNumber);
            }
            final String _tmpCreatedDateDisplay;
            if (_cursor.isNull(_cursorIndexOfCreatedDateDisplay)) {
              _tmpCreatedDateDisplay = null;
            } else {
              _tmpCreatedDateDisplay = _cursor.getString(_cursorIndexOfCreatedDateDisplay);
            }
            final long _tmpScanDate;
            _tmpScanDate = _cursor.getLong(_cursorIndexOfScanDate);
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpMonthYear;
            if (_cursor.isNull(_cursorIndexOfMonthYear)) {
              _tmpMonthYear = null;
            } else {
              _tmpMonthYear = _cursor.getString(_cursorIndexOfMonthYear);
            }
            _result = new ReturnItemEntity(_tmpId,_tmpTrackingNumber,_tmpOrderNumber,_tmpCreatedDateDisplay,_tmpScanDate,_tmpStatus,_tmpMonthYear);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getByTracking(final String tracking,
      final Continuation<? super ReturnItemEntity> $completion) {
    final String _sql = "SELECT * FROM return_items WHERE trackingNumber = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (tracking == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tracking);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<ReturnItemEntity>() {
      @Override
      @Nullable
      public ReturnItemEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTrackingNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "trackingNumber");
          final int _cursorIndexOfOrderNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "orderNumber");
          final int _cursorIndexOfCreatedDateDisplay = CursorUtil.getColumnIndexOrThrow(_cursor, "createdDateDisplay");
          final int _cursorIndexOfScanDate = CursorUtil.getColumnIndexOrThrow(_cursor, "scanDate");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfMonthYear = CursorUtil.getColumnIndexOrThrow(_cursor, "monthYear");
          final ReturnItemEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTrackingNumber;
            if (_cursor.isNull(_cursorIndexOfTrackingNumber)) {
              _tmpTrackingNumber = null;
            } else {
              _tmpTrackingNumber = _cursor.getString(_cursorIndexOfTrackingNumber);
            }
            final String _tmpOrderNumber;
            if (_cursor.isNull(_cursorIndexOfOrderNumber)) {
              _tmpOrderNumber = null;
            } else {
              _tmpOrderNumber = _cursor.getString(_cursorIndexOfOrderNumber);
            }
            final String _tmpCreatedDateDisplay;
            if (_cursor.isNull(_cursorIndexOfCreatedDateDisplay)) {
              _tmpCreatedDateDisplay = null;
            } else {
              _tmpCreatedDateDisplay = _cursor.getString(_cursorIndexOfCreatedDateDisplay);
            }
            final long _tmpScanDate;
            _tmpScanDate = _cursor.getLong(_cursorIndexOfScanDate);
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpMonthYear;
            if (_cursor.isNull(_cursorIndexOfMonthYear)) {
              _tmpMonthYear = null;
            } else {
              _tmpMonthYear = _cursor.getString(_cursorIndexOfMonthYear);
            }
            _result = new ReturnItemEntity(_tmpId,_tmpTrackingNumber,_tmpOrderNumber,_tmpCreatedDateDisplay,_tmpScanDate,_tmpStatus,_tmpMonthYear);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public PagingSource<Integer, ReturnItemEntity> paging(final String query, final String month,
      final String status) {
    final String _sql = "SELECT * FROM return_items WHERE (? IS NULL OR trackingNumber LIKE ? OR orderNumber LIKE ?) AND (? IS NULL OR monthYear = ?) AND (? IS NULL OR status = ?) ORDER BY scanDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 7);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 3;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 4;
    if (month == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, month);
    }
    _argIndex = 5;
    if (month == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, month);
    }
    _argIndex = 6;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, status);
    }
    _argIndex = 7;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, status);
    }
    return new LimitOffsetPagingSource<ReturnItemEntity>(_statement, __db, "return_items") {
      @Override
      @NonNull
      protected List<ReturnItemEntity> convertRows(@NonNull final Cursor cursor) {
        final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
        final int _cursorIndexOfTrackingNumber = CursorUtil.getColumnIndexOrThrow(cursor, "trackingNumber");
        final int _cursorIndexOfOrderNumber = CursorUtil.getColumnIndexOrThrow(cursor, "orderNumber");
        final int _cursorIndexOfCreatedDateDisplay = CursorUtil.getColumnIndexOrThrow(cursor, "createdDateDisplay");
        final int _cursorIndexOfScanDate = CursorUtil.getColumnIndexOrThrow(cursor, "scanDate");
        final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(cursor, "status");
        final int _cursorIndexOfMonthYear = CursorUtil.getColumnIndexOrThrow(cursor, "monthYear");
        final List<ReturnItemEntity> _result = new ArrayList<ReturnItemEntity>(cursor.getCount());
        while (cursor.moveToNext()) {
          final ReturnItemEntity _item;
          final long _tmpId;
          _tmpId = cursor.getLong(_cursorIndexOfId);
          final String _tmpTrackingNumber;
          if (cursor.isNull(_cursorIndexOfTrackingNumber)) {
            _tmpTrackingNumber = null;
          } else {
            _tmpTrackingNumber = cursor.getString(_cursorIndexOfTrackingNumber);
          }
          final String _tmpOrderNumber;
          if (cursor.isNull(_cursorIndexOfOrderNumber)) {
            _tmpOrderNumber = null;
          } else {
            _tmpOrderNumber = cursor.getString(_cursorIndexOfOrderNumber);
          }
          final String _tmpCreatedDateDisplay;
          if (cursor.isNull(_cursorIndexOfCreatedDateDisplay)) {
            _tmpCreatedDateDisplay = null;
          } else {
            _tmpCreatedDateDisplay = cursor.getString(_cursorIndexOfCreatedDateDisplay);
          }
          final long _tmpScanDate;
          _tmpScanDate = cursor.getLong(_cursorIndexOfScanDate);
          final String _tmpStatus;
          if (cursor.isNull(_cursorIndexOfStatus)) {
            _tmpStatus = null;
          } else {
            _tmpStatus = cursor.getString(_cursorIndexOfStatus);
          }
          final String _tmpMonthYear;
          if (cursor.isNull(_cursorIndexOfMonthYear)) {
            _tmpMonthYear = null;
          } else {
            _tmpMonthYear = cursor.getString(_cursorIndexOfMonthYear);
          }
          _item = new ReturnItemEntity(_tmpId,_tmpTrackingNumber,_tmpOrderNumber,_tmpCreatedDateDisplay,_tmpScanDate,_tmpStatus,_tmpMonthYear);
          _result.add(_item);
        }
        return _result;
      }
    };
  }

  @Override
  public Object countAll(final Continuation<? super Long> $completion) {
    final String _sql = "SELECT COUNT(*) FROM return_items";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Long _result;
          if (_cursor.moveToFirst()) {
            final Long _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object countVerified(final Continuation<? super Long> $completion) {
    final String _sql = "SELECT COUNT(*) FROM return_items WHERE status = 'VERIFIED'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Long _result;
          if (_cursor.moveToFirst()) {
            final Long _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object countPending(final Continuation<? super Long> $completion) {
    final String _sql = "SELECT COUNT(*) FROM return_items WHERE status = 'PENDING_VERIFICATION' OR status = 'SCANNED'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Long _result;
          if (_cursor.moveToFirst()) {
            final Long _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object countByMonth(final String month, final Continuation<? super Long> $completion) {
    final String _sql = "SELECT COUNT(*) FROM return_items WHERE monthYear = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (month == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, month);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Long _result;
          if (_cursor.moveToFirst()) {
            final Long _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object itemsByMonth(final String month,
      final Continuation<? super List<ReturnItemEntity>> $completion) {
    final String _sql = "SELECT * FROM return_items WHERE monthYear = ? ORDER BY scanDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (month == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, month);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<ReturnItemEntity>>() {
      @Override
      @NonNull
      public List<ReturnItemEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTrackingNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "trackingNumber");
          final int _cursorIndexOfOrderNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "orderNumber");
          final int _cursorIndexOfCreatedDateDisplay = CursorUtil.getColumnIndexOrThrow(_cursor, "createdDateDisplay");
          final int _cursorIndexOfScanDate = CursorUtil.getColumnIndexOrThrow(_cursor, "scanDate");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfMonthYear = CursorUtil.getColumnIndexOrThrow(_cursor, "monthYear");
          final List<ReturnItemEntity> _result = new ArrayList<ReturnItemEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ReturnItemEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTrackingNumber;
            if (_cursor.isNull(_cursorIndexOfTrackingNumber)) {
              _tmpTrackingNumber = null;
            } else {
              _tmpTrackingNumber = _cursor.getString(_cursorIndexOfTrackingNumber);
            }
            final String _tmpOrderNumber;
            if (_cursor.isNull(_cursorIndexOfOrderNumber)) {
              _tmpOrderNumber = null;
            } else {
              _tmpOrderNumber = _cursor.getString(_cursorIndexOfOrderNumber);
            }
            final String _tmpCreatedDateDisplay;
            if (_cursor.isNull(_cursorIndexOfCreatedDateDisplay)) {
              _tmpCreatedDateDisplay = null;
            } else {
              _tmpCreatedDateDisplay = _cursor.getString(_cursorIndexOfCreatedDateDisplay);
            }
            final long _tmpScanDate;
            _tmpScanDate = _cursor.getLong(_cursorIndexOfScanDate);
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpMonthYear;
            if (_cursor.isNull(_cursorIndexOfMonthYear)) {
              _tmpMonthYear = null;
            } else {
              _tmpMonthYear = _cursor.getString(_cursorIndexOfMonthYear);
            }
            _item = new ReturnItemEntity(_tmpId,_tmpTrackingNumber,_tmpOrderNumber,_tmpCreatedDateDisplay,_tmpScanDate,_tmpStatus,_tmpMonthYear);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
