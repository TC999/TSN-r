package cn.jiguang.internal;

import android.content.Context;
import android.os.Bundle;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class JCoreHelperAction {
    public abstract Bundle directHandle(Context context, String str, String str2, Bundle bundle);

    public abstract Object onCommonMethod(Context context, String str, Object obj);

    public abstract Object onEvent(Context context, String str, int i4, String str2, Bundle bundle, Object... objArr);
}
