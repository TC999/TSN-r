package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.ITTProvider;
import com.bytedance.sdk.openadsdk.core.ls;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f implements ITTProvider {

    /* renamed from: c  reason: collision with root package name */
    private static volatile f f33969c;

    /* renamed from: w  reason: collision with root package name */
    private static WeakReference<Context> f33970w;
    private static List<ITTProvider> xv;

    static {
        List<ITTProvider> synchronizedList = Collections.synchronizedList(new ArrayList());
        xv = synchronizedList;
        synchronizedList.add(new xv());
        xv.add(new com.bytedance.sdk.openadsdk.core.multipro.c.w());
        xv.add(new com.bytedance.sdk.openadsdk.core.multipro.xv.c());
        xv.add(new c(new com.bytedance.sdk.component.r.w.w.w.c("csj")));
        for (ITTProvider iTTProvider : xv) {
            iTTProvider.init();
        }
    }

    private f() {
    }

    public static f c(Context context) {
        if (context != null) {
            f33970w = new WeakReference<>(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
        if (f33969c == null) {
            synchronized (f.class) {
                if (f33969c == null) {
                    f33969c = new f();
                }
            }
        }
        return f33969c;
    }

    private Context getContext() {
        WeakReference<Context> weakReference = f33970w;
        return (weakReference == null || weakReference.get() == null) ? ls.getContext() : f33970w.get();
    }

    private boolean w(Uri uri) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int delete(Uri uri, String str, String[] strArr) {
        try {
            ITTProvider c4 = c(uri);
            if (c4 != null) {
                return c4.delete(uri, str, strArr);
            }
            return 0;
        } catch (Throwable th) {
            a.c("TTProviderManager", "==provider delete error==", th);
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getTableName() {
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public String getType(Uri uri) {
        try {
            ITTProvider c4 = c(uri);
            if (c4 != null) {
                return c4.getType(uri);
            }
            return null;
        } catch (Throwable th) {
            a.c("TTProviderManager", "==provider getType error==", th);
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void init() {
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public void injectContext(Context context) {
        for (ITTProvider iTTProvider : xv) {
            iTTProvider.injectContext(context);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        try {
            ITTProvider c4 = c(uri);
            if (c4 != null) {
                return c4.insert(uri, contentValues);
            }
            return null;
        } catch (Throwable th) {
            a.c("TTProviderManager", "==provider insert error==", th);
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            ITTProvider c4 = c(uri);
            if (c4 != null) {
                return c4.query(uri, strArr, str, strArr2, str2);
            }
            return null;
        } catch (Throwable th) {
            a.c("TTProviderManager", "==provider query error==", th);
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            ITTProvider c4 = c(uri);
            if (c4 != null) {
                return c4.update(uri, contentValues, str, strArr);
            }
            return 0;
        } catch (Throwable th) {
            a.c("TTProviderManager", "==provider update error==", th);
            return 0;
        }
    }

    private ITTProvider c(Uri uri) {
        if (uri == null) {
            return null;
        }
        if (!w(uri)) {
            a.w("TTProviderManager", "uri is error1");
            return null;
        }
        String[] split = uri.getPath().split(TTPathConst.sSeparator);
        if (split.length < 2) {
            a.w("TTProviderManager", "uri is error2");
            return null;
        }
        String str = split[1];
        if (TextUtils.isEmpty(str)) {
            a.w("TTProviderManager", "uri is error3");
            return null;
        }
        for (ITTProvider iTTProvider : xv) {
            if (str.equals(iTTProvider.getTableName())) {
                return iTTProvider;
            }
        }
        a.w("TTProviderManager", "uri is error4");
        return null;
    }
}
