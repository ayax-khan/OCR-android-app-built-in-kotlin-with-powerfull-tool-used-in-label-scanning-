package com.buy2enjoy.core.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.buy2enjoy.core.database.dao.ReturnItemDao;
import com.buy2enjoy.core.database.dao.ReturnItemDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile ReturnItemDao _returnItemDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `return_items` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `trackingNumber` TEXT NOT NULL, `orderNumber` TEXT, `createdDateDisplay` TEXT, `scanDate` INTEGER NOT NULL, `status` TEXT NOT NULL, `monthYear` TEXT NOT NULL)");
        db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_return_items_trackingNumber` ON `return_items` (`trackingNumber`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_return_items_monthYear` ON `return_items` (`monthYear`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_return_items_scanDate` ON `return_items` (`scanDate`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_return_items_status` ON `return_items` (`status`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'eb5dff7063636d12f0dab4135b8804e1')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `return_items`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsReturnItems = new HashMap<String, TableInfo.Column>(7);
        _columnsReturnItems.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReturnItems.put("trackingNumber", new TableInfo.Column("trackingNumber", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReturnItems.put("orderNumber", new TableInfo.Column("orderNumber", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReturnItems.put("createdDateDisplay", new TableInfo.Column("createdDateDisplay", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReturnItems.put("scanDate", new TableInfo.Column("scanDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReturnItems.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReturnItems.put("monthYear", new TableInfo.Column("monthYear", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysReturnItems = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesReturnItems = new HashSet<TableInfo.Index>(4);
        _indicesReturnItems.add(new TableInfo.Index("index_return_items_trackingNumber", true, Arrays.asList("trackingNumber"), Arrays.asList("ASC")));
        _indicesReturnItems.add(new TableInfo.Index("index_return_items_monthYear", false, Arrays.asList("monthYear"), Arrays.asList("ASC")));
        _indicesReturnItems.add(new TableInfo.Index("index_return_items_scanDate", false, Arrays.asList("scanDate"), Arrays.asList("ASC")));
        _indicesReturnItems.add(new TableInfo.Index("index_return_items_status", false, Arrays.asList("status"), Arrays.asList("ASC")));
        final TableInfo _infoReturnItems = new TableInfo("return_items", _columnsReturnItems, _foreignKeysReturnItems, _indicesReturnItems);
        final TableInfo _existingReturnItems = TableInfo.read(db, "return_items");
        if (!_infoReturnItems.equals(_existingReturnItems)) {
          return new RoomOpenHelper.ValidationResult(false, "return_items(com.buy2enjoy.core.database.entity.ReturnItemEntity).\n"
                  + " Expected:\n" + _infoReturnItems + "\n"
                  + " Found:\n" + _existingReturnItems);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "eb5dff7063636d12f0dab4135b8804e1", "26b4aad2e20018e6c6ca38922c18951b");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "return_items");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `return_items`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ReturnItemDao.class, ReturnItemDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public ReturnItemDao returnItemDao() {
    if (_returnItemDao != null) {
      return _returnItemDao;
    } else {
      synchronized(this) {
        if(_returnItemDao == null) {
          _returnItemDao = new ReturnItemDao_Impl(this);
        }
        return _returnItemDao;
      }
    }
  }
}
