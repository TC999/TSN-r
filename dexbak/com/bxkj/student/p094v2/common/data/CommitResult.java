package com.bxkj.student.p094v2.common.data;

import androidx.exifinterface.media.ExifInterface;
import com.bxkj.base.p085v2.http.exception.ApiException;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CommitResult.kt */
@Metadata(m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B+\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\r\u0010\u0011\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00018\u0000HÂ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003JB\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001e"}, m12616d2 = {"Lcom/bxkj/student/v2/common/data/CommitResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "code", "", "msg", "", "data", "exerciseRecordId", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Ljava/lang/Object;", "getExerciseRecordId", "()Ljava/lang/String;", "getMsg", "apiData", "()Ljava/lang/Object;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Lcom/bxkj/student/v2/common/data/CommitResult;", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1}, m12612xi = 48)
/* renamed from: com.bxkj.student.v2.common.data.CommitResult */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class CommitResult<T> {
    @Nullable
    private final Integer code;
    @Nullable
    private final T data;
    @NotNull
    private final String exerciseRecordId;
    @Nullable
    private final String msg;

    public CommitResult(@Nullable Integer num, @Nullable String str, @Nullable T t, @NotNull String exerciseRecordId) {
        C14342f0.m8184p(exerciseRecordId, "exerciseRecordId");
        this.code = num;
        this.msg = str;
        this.data = t;
        this.exerciseRecordId = exerciseRecordId;
    }

    private final T component3() {
        return this.data;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommitResult copy$default(CommitResult commitResult, Integer num, String str, Object obj, String str2, int i, Object obj2) {
        if ((i & 1) != 0) {
            num = commitResult.code;
        }
        if ((i & 2) != 0) {
            str = commitResult.msg;
        }
        if ((i & 4) != 0) {
            obj = commitResult.data;
        }
        if ((i & 8) != 0) {
            str2 = commitResult.exerciseRecordId;
        }
        return commitResult.copy(num, str, obj, str2);
    }

    @Nullable
    public final T apiData() {
        Integer num = this.code;
        if (num != null && num.intValue() == 0) {
            return this.data;
        }
        throw new ApiException(this.code, this.msg);
    }

    @Nullable
    public final Integer component1() {
        return this.code;
    }

    @Nullable
    public final String component2() {
        return this.msg;
    }

    @NotNull
    public final String component4() {
        return this.exerciseRecordId;
    }

    @NotNull
    public final CommitResult<T> copy(@Nullable Integer num, @Nullable String str, @Nullable T t, @NotNull String exerciseRecordId) {
        C14342f0.m8184p(exerciseRecordId, "exerciseRecordId");
        return new CommitResult<>(num, str, t, exerciseRecordId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CommitResult) {
            CommitResult commitResult = (CommitResult) obj;
            return C14342f0.m8193g(this.code, commitResult.code) && C14342f0.m8193g(this.msg, commitResult.msg) && C14342f0.m8193g(this.data, commitResult.data) && C14342f0.m8193g(this.exerciseRecordId, commitResult.exerciseRecordId);
        }
        return false;
    }

    @Nullable
    public final Integer getCode() {
        return this.code;
    }

    @NotNull
    public final String getExerciseRecordId() {
        return this.exerciseRecordId;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        Integer num = this.code;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.msg;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        T t = this.data;
        return ((hashCode2 + (t != null ? t.hashCode() : 0)) * 31) + this.exerciseRecordId.hashCode();
    }

    @NotNull
    public String toString() {
        return "CommitResult(code=" + this.code + ", msg=" + ((Object) this.msg) + ", data=" + this.data + ", exerciseRecordId=" + this.exerciseRecordId + ')';
    }
}
