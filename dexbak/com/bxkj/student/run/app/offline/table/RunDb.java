package com.bxkj.student.run.app.offline.table;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.umeng.analytics.AnalyticsConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RunDb.kt */
@Entity(tableName = "runDb")
@Parcelize
@Metadata(m12618bv = {}, m12617d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\b\u0087\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0002¢\u0006\u0004\bO\u0010PJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\t\u0010\t\u001a\u00020\u0002HÆ\u0003J\t\u0010\n\u001a\u00020\u0002HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0002HÆ\u0003J\t\u0010\f\u001a\u00020\u0002HÆ\u0003J\t\u0010\r\u001a\u00020\u0002HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0002HÆ\u0003J\u009f\u0001\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u0002HÆ\u0001J\t\u0010\"\u001a\u00020\u0002HÖ\u0001J\t\u0010$\u001a\u00020#HÖ\u0001J\u0013\u0010(\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010)\u001a\u00020#HÖ\u0001J\u0019\u0010.\u001a\u00020-2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020#HÖ\u0001R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010/\u001a\u0004\b4\u00101\"\u0004\b5\u00103R\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010/\u001a\u0004\b6\u00101\"\u0004\b7\u00103R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010/\u001a\u0004\b8\u00101\"\u0004\b9\u00103R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010/\u001a\u0004\b:\u00101\"\u0004\b;\u00103R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010/\u001a\u0004\b<\u00101\"\u0004\b=\u00103R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010/\u001a\u0004\b>\u00101\"\u0004\b?\u00103R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010/\u001a\u0004\b@\u00101\"\u0004\bA\u00103R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010/\u001a\u0004\bB\u00101\"\u0004\bC\u00103R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010/\u001a\u0004\bD\u00101\"\u0004\bE\u00103R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010/\u001a\u0004\bF\u00101\"\u0004\bG\u00103R\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010/\u001a\u0004\bH\u00101\"\u0004\bI\u00103R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010/\u001a\u0004\b\u001e\u00101\"\u0004\bJ\u00103R\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010/\u001a\u0004\bK\u00101\"\u0004\bL\u00103R\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010/\u001a\u0004\bM\u00101\"\u0004\bN\u00103¨\u0006Q"}, m12616d2 = {"Lcom/bxkj/student/run/app/offline/table/RunDb;", "Landroid/os/Parcelable;", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "identify", "userNumber", "sportsType", "sportsSet", AnalyticsConfig.RTD_START_TIME, "endTime", "countTime", "distance", "latLngList", "stepList", "passLatLngList", "userPassPointList", "isFaceOut", "faceDetectCount", "uploadType", "copy", "toString", "", TTDownloadField.TT_HASHCODE, "", AdnName.OTHER, "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/f1;", "writeToParcel", "Ljava/lang/String;", "getIdentify", "()Ljava/lang/String;", "setIdentify", "(Ljava/lang/String;)V", "getUserNumber", "setUserNumber", "getSportsType", "setSportsType", "getSportsSet", "setSportsSet", "getStartTime", "setStartTime", "getEndTime", "setEndTime", "getCountTime", "setCountTime", "getDistance", "setDistance", "getLatLngList", "setLatLngList", "getStepList", "setStepList", "getPassLatLngList", "setPassLatLngList", "getUserPassPointList", "setUserPassPointList", "setFaceOut", "getFaceDetectCount", "setFaceDetectCount", "getUploadType", "setUploadType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class RunDb implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<RunDb> CREATOR = new Creator();
    @ColumnInfo(name = "countTime", typeAffinity = 2)
    @NotNull
    private String countTime;
    @ColumnInfo(name = "distance", typeAffinity = 2)
    @NotNull
    private String distance;
    @ColumnInfo(name = "endTime", typeAffinity = 2)
    @NotNull
    private String endTime;
    @ColumnInfo(name = "faceDetectCount", typeAffinity = 2)
    @NotNull
    private String faceDetectCount;
    @PrimaryKey
    @ColumnInfo(name = "identify", typeAffinity = 2)
    @NotNull
    private String identify;
    @ColumnInfo(name = "isFaceOut", typeAffinity = 2)
    @NotNull
    private String isFaceOut;
    @ColumnInfo(name = "latLngList", typeAffinity = 2)
    @NotNull
    private String latLngList;
    @ColumnInfo(name = "passLatLngList", typeAffinity = 2)
    @NotNull
    private String passLatLngList;
    @ColumnInfo(name = "sportsSet", typeAffinity = 2)
    @NotNull
    private String sportsSet;
    @ColumnInfo(name = "sportsType", typeAffinity = 2)
    @NotNull
    private String sportsType;
    @ColumnInfo(name = AnalyticsConfig.RTD_START_TIME, typeAffinity = 2)
    @NotNull
    private String startTime;
    @ColumnInfo(name = "stepList", typeAffinity = 2)
    @NotNull
    private String stepList;
    @ColumnInfo(name = "uploadType", typeAffinity = 2)
    @NotNull
    private String uploadType;
    @ColumnInfo(name = "userNumber", typeAffinity = 2)
    @NotNull
    private String userNumber;
    @ColumnInfo(name = "points", typeAffinity = 2)
    @NotNull
    private String userPassPointList;

    /* compiled from: RunDb.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class Creator implements Parcelable.Creator<RunDb> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RunDb createFromParcel(@NotNull Parcel parcel) {
            C14342f0.m8184p(parcel, "parcel");
            return new RunDb(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RunDb[] newArray(int i) {
            return new RunDb[i];
        }
    }

    public RunDb(@NotNull String identify, @NotNull String userNumber, @NotNull String sportsType, @NotNull String sportsSet, @NotNull String startTime, @NotNull String endTime, @NotNull String countTime, @NotNull String distance, @NotNull String latLngList, @NotNull String stepList, @NotNull String passLatLngList, @NotNull String userPassPointList, @NotNull String isFaceOut, @NotNull String faceDetectCount, @NotNull String uploadType) {
        C14342f0.m8184p(identify, "identify");
        C14342f0.m8184p(userNumber, "userNumber");
        C14342f0.m8184p(sportsType, "sportsType");
        C14342f0.m8184p(sportsSet, "sportsSet");
        C14342f0.m8184p(startTime, "startTime");
        C14342f0.m8184p(endTime, "endTime");
        C14342f0.m8184p(countTime, "countTime");
        C14342f0.m8184p(distance, "distance");
        C14342f0.m8184p(latLngList, "latLngList");
        C14342f0.m8184p(stepList, "stepList");
        C14342f0.m8184p(passLatLngList, "passLatLngList");
        C14342f0.m8184p(userPassPointList, "userPassPointList");
        C14342f0.m8184p(isFaceOut, "isFaceOut");
        C14342f0.m8184p(faceDetectCount, "faceDetectCount");
        C14342f0.m8184p(uploadType, "uploadType");
        this.identify = identify;
        this.userNumber = userNumber;
        this.sportsType = sportsType;
        this.sportsSet = sportsSet;
        this.startTime = startTime;
        this.endTime = endTime;
        this.countTime = countTime;
        this.distance = distance;
        this.latLngList = latLngList;
        this.stepList = stepList;
        this.passLatLngList = passLatLngList;
        this.userPassPointList = userPassPointList;
        this.isFaceOut = isFaceOut;
        this.faceDetectCount = faceDetectCount;
        this.uploadType = uploadType;
    }

    @NotNull
    public final String component1() {
        return this.identify;
    }

    @NotNull
    public final String component10() {
        return this.stepList;
    }

    @NotNull
    public final String component11() {
        return this.passLatLngList;
    }

    @NotNull
    public final String component12() {
        return this.userPassPointList;
    }

    @NotNull
    public final String component13() {
        return this.isFaceOut;
    }

    @NotNull
    public final String component14() {
        return this.faceDetectCount;
    }

    @NotNull
    public final String component15() {
        return this.uploadType;
    }

    @NotNull
    public final String component2() {
        return this.userNumber;
    }

    @NotNull
    public final String component3() {
        return this.sportsType;
    }

    @NotNull
    public final String component4() {
        return this.sportsSet;
    }

    @NotNull
    public final String component5() {
        return this.startTime;
    }

    @NotNull
    public final String component6() {
        return this.endTime;
    }

    @NotNull
    public final String component7() {
        return this.countTime;
    }

    @NotNull
    public final String component8() {
        return this.distance;
    }

    @NotNull
    public final String component9() {
        return this.latLngList;
    }

    @NotNull
    public final RunDb copy(@NotNull String identify, @NotNull String userNumber, @NotNull String sportsType, @NotNull String sportsSet, @NotNull String startTime, @NotNull String endTime, @NotNull String countTime, @NotNull String distance, @NotNull String latLngList, @NotNull String stepList, @NotNull String passLatLngList, @NotNull String userPassPointList, @NotNull String isFaceOut, @NotNull String faceDetectCount, @NotNull String uploadType) {
        C14342f0.m8184p(identify, "identify");
        C14342f0.m8184p(userNumber, "userNumber");
        C14342f0.m8184p(sportsType, "sportsType");
        C14342f0.m8184p(sportsSet, "sportsSet");
        C14342f0.m8184p(startTime, "startTime");
        C14342f0.m8184p(endTime, "endTime");
        C14342f0.m8184p(countTime, "countTime");
        C14342f0.m8184p(distance, "distance");
        C14342f0.m8184p(latLngList, "latLngList");
        C14342f0.m8184p(stepList, "stepList");
        C14342f0.m8184p(passLatLngList, "passLatLngList");
        C14342f0.m8184p(userPassPointList, "userPassPointList");
        C14342f0.m8184p(isFaceOut, "isFaceOut");
        C14342f0.m8184p(faceDetectCount, "faceDetectCount");
        C14342f0.m8184p(uploadType, "uploadType");
        return new RunDb(identify, userNumber, sportsType, sportsSet, startTime, endTime, countTime, distance, latLngList, stepList, passLatLngList, userPassPointList, isFaceOut, faceDetectCount, uploadType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RunDb) {
            RunDb runDb = (RunDb) obj;
            return C14342f0.m8193g(this.identify, runDb.identify) && C14342f0.m8193g(this.userNumber, runDb.userNumber) && C14342f0.m8193g(this.sportsType, runDb.sportsType) && C14342f0.m8193g(this.sportsSet, runDb.sportsSet) && C14342f0.m8193g(this.startTime, runDb.startTime) && C14342f0.m8193g(this.endTime, runDb.endTime) && C14342f0.m8193g(this.countTime, runDb.countTime) && C14342f0.m8193g(this.distance, runDb.distance) && C14342f0.m8193g(this.latLngList, runDb.latLngList) && C14342f0.m8193g(this.stepList, runDb.stepList) && C14342f0.m8193g(this.passLatLngList, runDb.passLatLngList) && C14342f0.m8193g(this.userPassPointList, runDb.userPassPointList) && C14342f0.m8193g(this.isFaceOut, runDb.isFaceOut) && C14342f0.m8193g(this.faceDetectCount, runDb.faceDetectCount) && C14342f0.m8193g(this.uploadType, runDb.uploadType);
        }
        return false;
    }

    @NotNull
    public final String getCountTime() {
        return this.countTime;
    }

    @NotNull
    public final String getDistance() {
        return this.distance;
    }

    @NotNull
    public final String getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final String getFaceDetectCount() {
        return this.faceDetectCount;
    }

    @NotNull
    public final String getIdentify() {
        return this.identify;
    }

    @NotNull
    public final String getLatLngList() {
        return this.latLngList;
    }

    @NotNull
    public final String getPassLatLngList() {
        return this.passLatLngList;
    }

    @NotNull
    public final String getSportsSet() {
        return this.sportsSet;
    }

    @NotNull
    public final String getSportsType() {
        return this.sportsType;
    }

    @NotNull
    public final String getStartTime() {
        return this.startTime;
    }

    @NotNull
    public final String getStepList() {
        return this.stepList;
    }

    @NotNull
    public final String getUploadType() {
        return this.uploadType;
    }

    @NotNull
    public final String getUserNumber() {
        return this.userNumber;
    }

    @NotNull
    public final String getUserPassPointList() {
        return this.userPassPointList;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((this.identify.hashCode() * 31) + this.userNumber.hashCode()) * 31) + this.sportsType.hashCode()) * 31) + this.sportsSet.hashCode()) * 31) + this.startTime.hashCode()) * 31) + this.endTime.hashCode()) * 31) + this.countTime.hashCode()) * 31) + this.distance.hashCode()) * 31) + this.latLngList.hashCode()) * 31) + this.stepList.hashCode()) * 31) + this.passLatLngList.hashCode()) * 31) + this.userPassPointList.hashCode()) * 31) + this.isFaceOut.hashCode()) * 31) + this.faceDetectCount.hashCode()) * 31) + this.uploadType.hashCode();
    }

    @NotNull
    public final String isFaceOut() {
        return this.isFaceOut;
    }

    public final void setCountTime(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.countTime = str;
    }

    public final void setDistance(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.distance = str;
    }

    public final void setEndTime(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.endTime = str;
    }

    public final void setFaceDetectCount(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.faceDetectCount = str;
    }

    public final void setFaceOut(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.isFaceOut = str;
    }

    public final void setIdentify(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.identify = str;
    }

    public final void setLatLngList(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.latLngList = str;
    }

    public final void setPassLatLngList(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.passLatLngList = str;
    }

    public final void setSportsSet(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.sportsSet = str;
    }

    public final void setSportsType(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.sportsType = str;
    }

    public final void setStartTime(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.startTime = str;
    }

    public final void setStepList(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.stepList = str;
    }

    public final void setUploadType(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.uploadType = str;
    }

    public final void setUserNumber(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.userNumber = str;
    }

    public final void setUserPassPointList(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.userPassPointList = str;
    }

    @NotNull
    public String toString() {
        return "RunDb(identify=" + this.identify + ", userNumber=" + this.userNumber + ", sportsType=" + this.sportsType + ", sportsSet=" + this.sportsSet + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", countTime=" + this.countTime + ", distance=" + this.distance + ", latLngList=" + this.latLngList + ", stepList=" + this.stepList + ", passLatLngList=" + this.passLatLngList + ", userPassPointList=" + this.userPassPointList + ", isFaceOut=" + this.isFaceOut + ", faceDetectCount=" + this.faceDetectCount + ", uploadType=" + this.uploadType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i) {
        C14342f0.m8184p(out, "out");
        out.writeString(this.identify);
        out.writeString(this.userNumber);
        out.writeString(this.sportsType);
        out.writeString(this.sportsSet);
        out.writeString(this.startTime);
        out.writeString(this.endTime);
        out.writeString(this.countTime);
        out.writeString(this.distance);
        out.writeString(this.latLngList);
        out.writeString(this.stepList);
        out.writeString(this.passLatLngList);
        out.writeString(this.userPassPointList);
        out.writeString(this.isFaceOut);
        out.writeString(this.faceDetectCount);
        out.writeString(this.uploadType);
    }

    public /* synthetic */ RunDb(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, (i & 64) != 0 ? "0" : str7, (i & 128) != 0 ? "0" : str8, str9, str10, str11, str12, str13, str14, str15);
    }
}
