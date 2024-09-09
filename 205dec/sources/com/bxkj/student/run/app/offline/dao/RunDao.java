package com.bxkj.student.run.app.offline.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.bxkj.student.run.app.offline.table.RunDb;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: RunDao.kt */
@Dao
@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ+\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\rJ%\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\rJ%\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\rJ-\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/bxkj/student/run/app/offline/dao/RunDao;", "", "", "Lcom/bxkj/student/run/app/offline/table/RunDb;", "runDb", "Lkotlin/f1;", "insertRun", "([Lcom/bxkj/student/run/app/offline/table/RunDb;Lkotlin/coroutines/c;)Ljava/lang/Object;", "deleteSports", "(Lcom/bxkj/student/run/app/offline/table/RunDb;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "identify", "deleteByIdentify", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "endTime", "uploadType", "updateSports", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "getLocalRecordById", "userNumber", "getExceptionSports", "getUploadFailSports", "", "sportsType", "getUploadFailSportsByType", "(Ljava/lang/String;ILkotlin/coroutines/c;)Ljava/lang/Object;", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface RunDao {
    @Query("DELETE FROM runDb WHERE identify=:identify")
    @Nullable
    Object deleteByIdentify(@NotNull String str, @NotNull c<? super f1> cVar);

    @Delete
    @Nullable
    Object deleteSports(@NotNull RunDb runDb, @NotNull c<? super f1> cVar);

    @Query("SELECT * FROM runDb WHERE userNumber = :userNumber AND uploadType =='-1'")
    @Nullable
    Object getExceptionSports(@NotNull String str, @NotNull c<? super List<RunDb>> cVar);

    @Query("SELECT * FROM runDb WHERE identify = :identify")
    @Nullable
    Object getLocalRecordById(@NotNull String str, @NotNull c<? super List<RunDb>> cVar);

    @Query("SELECT * FROM runDb WHERE userNumber = :userNumber AND uploadType !='-1'")
    @Nullable
    Object getUploadFailSports(@NotNull String str, @NotNull c<? super List<RunDb>> cVar);

    @Query("SELECT * FROM runDb WHERE userNumber = :userNumber AND uploadType !='-1' AND sportsType=:sportsType")
    @Nullable
    Object getUploadFailSportsByType(@NotNull String str, int i4, @NotNull c<? super List<RunDb>> cVar);

    @Insert(onConflict = 1)
    @Nullable
    Object insertRun(@NotNull RunDb[] runDbArr, @NotNull c<? super f1> cVar);

    @Query("UPDATE runDb SET endTime=:endTime,uploadType=:uploadType WHERE identify=:identify")
    @Nullable
    Object updateSports(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull c<? super f1> cVar);
}
