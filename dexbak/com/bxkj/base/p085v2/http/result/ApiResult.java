package com.bxkj.base.p085v2.http.result;

import androidx.exifinterface.media.ExifInterface;
import com.bxkj.base.p085v2.http.exception.ApiException;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ApiResult.kt */
@Metadata(m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\bJ\r\u0010\u000f\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00018\u0000HÂ\u0003¢\u0006\u0002\u0010\u0010J8\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, m12616d2 = {"Lcom/bxkj/base/v2/http/result/ApiResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "code", "", "msg", "", "data", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Object;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Ljava/lang/Object;", "getMsg", "()Ljava/lang/String;", "apiData", "()Ljava/lang/Object;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Object;)Lcom/bxkj/base/v2/http/result/ApiResult;", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1}, m12612xi = 48)
/* renamed from: com.bxkj.base.v2.http.result.ApiResult */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class ApiResult<T> {
    @Nullable
    private final Integer code;
    @Nullable
    private final T data;
    @Nullable
    private final String msg;

    public ApiResult(@Nullable Integer num, @Nullable String str, @Nullable T t) {
        this.code = num;
        this.msg = str;
        this.data = t;
    }

    private final T component3() {
        return this.data;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApiResult copy$default(ApiResult apiResult, Integer num, String str, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            num = apiResult.code;
        }
        if ((i & 2) != 0) {
            str = apiResult.msg;
        }
        if ((i & 4) != 0) {
            obj = apiResult.data;
        }
        return apiResult.copy(num, str, obj);
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
    public final ApiResult<T> copy(@Nullable Integer num, @Nullable String str, @Nullable T t) {
        return new ApiResult<>(num, str, t);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ApiResult) {
            ApiResult apiResult = (ApiResult) obj;
            return C14342f0.m8193g(this.code, apiResult.code) && C14342f0.m8193g(this.msg, apiResult.msg) && C14342f0.m8193g(this.data, apiResult.data);
        }
        return false;
    }

    @Nullable
    public final Integer getCode() {
        return this.code;
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
        return hashCode2 + (t != null ? t.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ApiResult(code=" + this.code + ", msg=" + ((Object) this.msg) + ", data=" + this.data + ')';
    }
}
