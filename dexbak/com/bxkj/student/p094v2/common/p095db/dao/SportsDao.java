package com.bxkj.student.p094v2.common.p095db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.umeng.analytics.AnalyticsConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p023b0.CountDistanceTime;
import p027c0.SportsDb;

@Dao
@Metadata(m12618bv = {}, m12617d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007Js\u0010\u0015\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ3\u0010!\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J#\u0010#\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0004\b#\u0010\u001dJ%\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010$2\u0006\u0010\u0011\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0004\b%\u0010\u001aJ%\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010$2\u0006\u0010&\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0004\b'\u0010\u001aJ%\u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010$2\u0006\u0010&\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0004\b(\u0010\u001aJ%\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010$2\u0006\u0010&\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0004\b)\u0010\u001aJ5\u0010,\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010$2\u0006\u0010&\u001a\u00020\b2\u0006\u0010+\u001a\u00020*2\u0006\u0010 \u001a\u00020*H§@ø\u0001\u0000¢\u0006\u0004\b,\u0010-J3\u0010/\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010$2\u0006\u0010&\u001a\u00020\b2\u0006\u0010+\u001a\u00020*2\u0006\u0010 \u001a\u00020*H§@ø\u0001\u0000¢\u0006\u0004\b/\u0010-\u0082\u0002\u0004\n\u0002\b\u0019¨\u00060"}, m12616d2 = {"Lcom/bxkj/student/v2/common/db/dao/e;", "", "", "Lc0/c;", "project", "Lkotlin/f1;", "b", "([Lc0/c;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "countTime", "distance", "gpsDistance", "latLngList", "stepList", "passLatLngList", "isFaceOut", "faceDetectCount", "identify", "faceCheckingDistance", "pauseLatLng", "isOpenDevelop", "e", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "c", "(Lc0/c;Lkotlin/coroutines/c;)Ljava/lang/Object;", "deleteByIdentify", "(Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "uploadType", "i", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "isException", "isValid", "endTime", "j", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/c;)Ljava/lang/Object;", "d", "", "getLocalRecordById", "userNumber", "getExceptionSports", "a", "g", "", AnalyticsConfig.RTD_START_TIME, "f", "(Ljava/lang/String;JJLkotlin/coroutines/c;)Ljava/lang/Object;", "Lb0/b;", "h", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.common.db.dao.e */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface SportsDao {
    @Query("SELECT * FROM sports WHERE userNumber = :userNumber AND endTime !=''")
    @Nullable
    /* renamed from: a */
    Object mo39182a(@NotNull String str, @NotNull InterfaceC14268c<? super List<SportsDb>> interfaceC14268c);

    @Insert(onConflict = 1)
    @Nullable
    /* renamed from: b */
    Object mo39181b(@NotNull SportsDb[] sportsDbArr, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c);

    @Delete
    @Nullable
    /* renamed from: c */
    Object mo39180c(@NotNull SportsDb sportsDb, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c);

    @Query("UPDATE sports SET isValid=:isValid WHERE identify=:identify")
    @Nullable
    /* renamed from: d */
    Object mo39179d(@NotNull String str, @NotNull String str2, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c);

    @Query("DELETE FROM sports WHERE identify=:identify")
    @Nullable
    Object deleteByIdentify(@NotNull String str, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c);

    @Query("UPDATE sports SET countTime=:countTime,distance=:distance ,gpsDistance=:gpsDistance,latLngList=:latLngList ,stepList=:stepList,passLatLngList=:passLatLngList,isFaceOut=:isFaceOut ,faceDetectCount=:faceDetectCount ,faceCheckingDistance=:faceCheckingDistance,pauseLatLng=:pauseLatLng ,isOpenDevelop=:isOpenDevelop WHERE identify=:identify")
    @Nullable
    /* renamed from: e */
    Object mo39178e(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c);

    @Query("SELECT * FROM sports WHERE userNumber = :userNumber AND endTime !='' AND startTime BETWEEN :startTime And :endTime")
    @Nullable
    /* renamed from: f */
    Object mo39177f(@NotNull String str, long j, long j2, @NotNull InterfaceC14268c<? super List<SportsDb>> interfaceC14268c);

    @Query("SELECT * FROM sports WHERE userNumber = :userNumber AND endTime !=''")
    @Nullable
    /* renamed from: g */
    Object mo39176g(@NotNull String str, @NotNull InterfaceC14268c<? super List<SportsDb>> interfaceC14268c);

    @Query("SELECT * FROM sports WHERE userNumber = :userNumber AND endTime ==''")
    @Nullable
    Object getExceptionSports(@NotNull String str, @NotNull InterfaceC14268c<? super List<SportsDb>> interfaceC14268c);

    @Query("SELECT * FROM sports WHERE identify = :identify")
    @Nullable
    Object getLocalRecordById(@NotNull String str, @NotNull InterfaceC14268c<? super List<SportsDb>> interfaceC14268c);

    @Query("SELECT COUNT(identify) as count, sum(distance) AS distance,sum(countTime) AS time FROM sports WHERE userNumber = :userNumber AND endTime !='' AND startTime BETWEEN :startTime And :endTime")
    @Nullable
    /* renamed from: h */
    Object mo39175h(@NotNull String str, long j, long j2, @NotNull InterfaceC14268c<? super List<CountDistanceTime>> interfaceC14268c);

    @Query("UPDATE sports SET uploadType=:uploadType WHERE identify=:identify")
    @Nullable
    /* renamed from: i */
    Object mo39174i(@NotNull String str, @NotNull String str2, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c);

    @Query("UPDATE sports SET isException=:isException,isValid=:isValid, endTime=:endTime WHERE identify=:identify")
    @Nullable
    /* renamed from: j */
    Object mo39173j(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c);
}
