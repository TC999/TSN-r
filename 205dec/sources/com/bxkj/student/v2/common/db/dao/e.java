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
/* compiled from: SportsDao.kt */
@Dao
@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007Js\u0010\u0015\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ3\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010 J#\u0010!\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\u001bJ%\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\"2\u0006\u0010\u0011\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010\u0018J%\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\"2\u0006\u0010$\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010\u0018J%\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\"2\u0006\u0010$\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010\u0018J5\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\"2\u0006\u0010$\u001a\u00020\b2\u0006\u0010(\u001a\u00020'2\u0006\u0010\u001e\u001a\u00020'H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b)\u0010*J\u001b\u0010+\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b+\u0010\u0018J3\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\"2\u0006\u0010$\u001a\u00020\b2\u0006\u0010(\u001a\u00020'2\u0006\u0010\u001e\u001a\u00020'H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b-\u0010*J%\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\"2\u0006\u0010$\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010\u0018J#\u0010/\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b/\u0010\u001bJ\u001b\u00101\u001a\u00020\u00052\u0006\u00100\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2 = {"Lcom/bxkj/student/v2/common/db/dao/e;", "", "", "Lc0/c;", "project", "Lkotlin/f1;", "a", "([Lc0/c;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "countTime", "distance", "gpsDistance", "latLngList", "stepList", "passLatLngList", "isFaceOut", "faceDetectCount", "identify", "faceCheckingDistance", "pauseLatLng", "isOpenDevelop", "d", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "deleteByIdentify", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "uploadType", "j", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "isException", "isValid", "endTime", "k", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "b", "", "getLocalRecordById", "userNumber", "getExceptionSports", "h", "", "startTime", "e", "(Ljava/lang/String;JJLkotlin/coroutines/c;)Ljava/lang/Object;", "l", "Lb0/b;", "i", "g", "f", "identity", "c", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface e {
    @Insert(onConflict = 1)
    @Nullable
    Object a(@NotNull c0.c[] cVarArr, @NotNull kotlin.coroutines.c<? super f1> cVar);

    @Query("UPDATE sports SET isValid=:isValid WHERE identify=:identify")
    @Nullable
    Object b(@NotNull String str, @NotNull String str2, @NotNull kotlin.coroutines.c<? super f1> cVar);

    @Query("UPDATE sports SET confirmCount=confirmCount+1 WHERE identify=:identity")
    @Nullable
    Object c(@NotNull String str, @NotNull kotlin.coroutines.c<? super f1> cVar);

    @Query("UPDATE sports SET countTime=:countTime,distance=:distance ,gpsDistance=:gpsDistance,latLngList=:latLngList ,stepList=:stepList,passLatLngList=:passLatLngList,isFaceOut=:isFaceOut ,faceDetectCount=:faceDetectCount ,faceCheckingDistance=:faceCheckingDistance,pauseLatLng=:pauseLatLng ,isOpenDevelop=:isOpenDevelop WHERE identify=:identify")
    @Nullable
    Object d(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull kotlin.coroutines.c<? super f1> cVar);

    @Query("DELETE FROM sports WHERE identify=:identify")
    @Nullable
    Object deleteByIdentify(@NotNull String str, @NotNull kotlin.coroutines.c<? super f1> cVar);

    @Query("SELECT * FROM sports WHERE userNumber = :userNumber AND endTime !='' AND confirmCount==0 AND startTime BETWEEN :startTime And :endTime")
    @Nullable
    Object e(@NotNull String str, long j4, long j5, @NotNull kotlin.coroutines.c<? super List<c0.c>> cVar);

    @Query("UPDATE sports SET endTime=:endTime WHERE identify=:identify")
    @Nullable
    Object f(@NotNull String str, @NotNull String str2, @NotNull kotlin.coroutines.c<? super f1> cVar);

    @Query("SELECT * FROM sports WHERE userNumber = :userNumber AND  confirmCount > 0")
    @Nullable
    Object g(@NotNull String str, @NotNull kotlin.coroutines.c<? super List<c0.c>> cVar);

    @Query("SELECT * FROM sports WHERE userNumber = :userNumber AND endTime ==''")
    @Nullable
    Object getExceptionSports(@NotNull String str, @NotNull kotlin.coroutines.c<? super List<c0.c>> cVar);

    @Query("SELECT * FROM sports WHERE identify = :identify")
    @Nullable
    Object getLocalRecordById(@NotNull String str, @NotNull kotlin.coroutines.c<? super List<c0.c>> cVar);

    @Query("SELECT * FROM sports WHERE userNumber = :userNumber AND endTime !='' AND confirmCount==0")
    @Nullable
    Object h(@NotNull String str, @NotNull kotlin.coroutines.c<? super List<c0.c>> cVar);

    @Query("SELECT COUNT(identify) as count, sum(distance) AS distance,sum(countTime) AS time FROM sports WHERE userNumber = :userNumber AND endTime !='' AND confirmCount==0 AND startTime BETWEEN :startTime And :endTime")
    @Nullable
    Object i(@NotNull String str, long j4, long j5, @NotNull kotlin.coroutines.c<? super List<b0.b>> cVar);

    @Query("UPDATE sports SET uploadType=:uploadType WHERE identify=:identify")
    @Nullable
    Object j(@NotNull String str, @NotNull String str2, @NotNull kotlin.coroutines.c<? super f1> cVar);

    @Query("UPDATE sports SET isException=:isException,isValid=:isValid, endTime=:endTime WHERE identify=:identify")
    @Nullable
    Object k(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull kotlin.coroutines.c<? super f1> cVar);

    @Query("UPDATE sports SET confirmCount=1 WHERE identify=:identify")
    @Nullable
    Object l(@NotNull String str, @NotNull kotlin.coroutines.c<? super f1> cVar);
}
