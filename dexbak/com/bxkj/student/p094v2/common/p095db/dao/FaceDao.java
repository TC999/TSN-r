package com.bxkj.student.p094v2.common.p095db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p027c0.FaceDb;

@Dao
@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ#\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\nJ\u0013\u0010\r\u001a\u00020\u0004H§@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, m12616d2 = {"Lcom/bxkj/student/v2/common/db/dao/a;", "", "Lc0/a;", "faceDb", "Lkotlin/f1;", "insert", "(Lc0/a;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "identify", "deleteByIdentify", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "b", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.common.db.dao.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface FaceDao {
    @Query("DELETE FROM face")
    @Nullable
    /* renamed from: a */
    Object mo39212a(@NotNull InterfaceC14268c<? super Unit> interfaceC14268c);

    @Query("SELECT * FROM face WHERE identify=:identify")
    @Nullable
    /* renamed from: b */
    Object mo39211b(@NotNull String str, @NotNull InterfaceC14268c<? super List<FaceDb>> interfaceC14268c);

    @Query("DELETE FROM face WHERE identify=:identify")
    @Nullable
    Object deleteByIdentify(@NotNull String str, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c);

    @Insert(onConflict = 1)
    @Nullable
    Object insert(@NotNull FaceDb faceDb, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c);
}
