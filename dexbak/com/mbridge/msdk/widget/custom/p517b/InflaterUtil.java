package com.mbridge.msdk.widget.custom.p517b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.widget.custom.p516a.MBResource;
import java.io.File;

/* renamed from: com.mbridge.msdk.widget.custom.b.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class InflaterUtil {

    /* renamed from: a */
    private static InflaterUtil f32503a;

    /* renamed from: b */
    private MBResource f32504b;

    private InflaterUtil(Context context) {
        this.f32504b = null;
        MBResource m20600a = MBResource.m20600a();
        this.f32504b = m20600a;
        m20600a.m20598a("");
    }

    /* renamed from: a */
    public static InflaterUtil m20568a(Context context) {
        if (f32503a == null) {
            f32503a = new InflaterUtil(context);
        }
        return f32503a;
    }

    /* renamed from: a */
    public final View m20567a(String str) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return null;
        }
        return this.f32504b.m20590f(str);
    }
}
