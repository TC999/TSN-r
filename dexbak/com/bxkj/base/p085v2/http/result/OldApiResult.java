package com.bxkj.base.p085v2.http.result;

import androidx.exifinterface.media.ExifInterface;
import com.bxkj.base.p085v2.http.exception.ApiException;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OldApiResult.kt */
@Metadata(m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\bJ\r\u0010\u000f\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00018\u0000HÂ\u0003¢\u0006\u0002\u0010\u0010J8\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0012\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, m12616d2 = {"Lcom/bxkj/base/v2/http/result/OldApiResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "returnCode", "", "returnMsg", "", "data", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Object;)V", "Ljava/lang/Object;", "getReturnCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getReturnMsg", "()Ljava/lang/String;", "apiData", "()Ljava/lang/Object;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Object;)Lcom/bxkj/base/v2/http/result/OldApiResult;", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1}, m12612xi = 48)
/* renamed from: com.bxkj.base.v2.http.result.OldApiResult */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class OldApiResult<T> {
    @Nullable
    private final T data;
    @Nullable
    private final Integer returnCode;
    @Nullable
    private final String returnMsg;

    public OldApiResult(@Nullable Integer num, @Nullable String str, @Nullable T t) {
        this.returnCode = num;
        this.returnMsg = str;
        this.data = t;
    }

    private final T component3() {
        return this.data;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OldApiResult copy$default(OldApiResult oldApiResult, Integer num, String str, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            num = oldApiResult.returnCode;
        }
        if ((i & 2) != 0) {
            str = oldApiResult.returnMsg;
        }
        if ((i & 4) != 0) {
            obj = oldApiResult.data;
        }
        return oldApiResult.copy(num, str, obj);
    }

    @Nullable
    public final T apiData() {
        Integer num = this.returnCode;
        if (num != null && num.intValue() == 200) {
            return this.data;
        }
        throw new ApiException(this.returnCode, this.returnMsg);
    }

    @Nullable
    public final Integer component1() {
        return this.returnCode;
    }

    @Nullable
    public final String component2() {
        return this.returnMsg;
    }

    @NotNull
    public final OldApiResult<T> copy(@Nullable Integer num, @Nullable String str, @Nullable T t) {
        return new OldApiResult<>(num, str, t);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OldApiResult) {
            OldApiResult oldApiResult = (OldApiResult) obj;
            return C14342f0.m8193g(this.returnCode, oldApiResult.returnCode) && C14342f0.m8193g(this.returnMsg, oldApiResult.returnMsg) && C14342f0.m8193g(this.data, oldApiResult.data);
        }
        return false;
    }

    @Nullable
    public final Integer getReturnCode() {
        return this.returnCode;
    }

    @Nullable
    public final String getReturnMsg() {
        return this.returnMsg;
    }

    public int hashCode() {
        Integer num = this.returnCode;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.returnMsg;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        T t = this.data;
        return hashCode2 + (t != null ? t.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "OldApiResult(returnCode=" + this.returnCode + ", returnMsg=" + ((Object) this.returnMsg) + ", data=" + this.data + ')';
    }
}
