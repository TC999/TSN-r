package com.bxkj.student.v2.common.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import kotlin.Metadata;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: FaceDao.kt */
@Dao
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ#\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\nJ\u0013\u0010\r\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/bxkj/student/v2/common/db/dao/a;", "", "Lc0/a;", "faceDb", "Lkotlin/f1;", "insert", "(Lc0/a;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "identify", "deleteByIdentify", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "b", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface a {
    @Query("DELETE FROM face")
    @Nullable
    Object a(@NotNull kotlin.coroutines.c<? super f1> cVar);

    @Query("SELECT * FROM face WHERE identify=:identify")
    @Nullable
    Object b(@NotNull String str, @NotNull kotlin.coroutines.c<? super List<c0.a>> cVar);

    @Query("DELETE FROM face WHERE identify=:identify")
    @Nullable
    Object deleteByIdentify(@NotNull String str, @NotNull kotlin.coroutines.c<? super f1> cVar);

    @Insert(onConflict = 1)
    @Nullable
    Object insert(@NotNull c0.a aVar, @NotNull kotlin.coroutines.c<? super f1> cVar);
}
