package cn.bluemobi.dylan.http;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: HttpJsonKey.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcn/bluemobi/dylan/http/HttpJsonKey;", "", "getCode", "", "getData", "getMsg", "getSuccessCode", "", "http_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public interface HttpJsonKey {
    @NotNull
    String getCode();

    @NotNull
    String getData();

    @NotNull
    String getMsg();

    int getSuccessCode();
}
