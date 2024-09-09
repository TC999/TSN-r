package cn.jpush.android.service;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import cn.jiguang.d.a;
import cn.jpush.android.api.JPushInterface;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class InitProvider extends ContentProvider {
    private static final String TAG = "InitProvider";
    private Class<?> actionHelperClass;
    private Object actionHelperInstance;
    private Method onJPushMessageReceiveMethod;

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        try {
            Context context = getContext();
            if (context != null) {
                if (context.checkCallingPermission(context.getPackageName() + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX) == 0) {
                    if (this.actionHelperClass == null) {
                        this.actionHelperClass = Class.forName(new String(Base64.decode("Y24uanB1c2guYW5kcm9pZC5sb2NhbC5BY3Rpb25IZWxwZXI=", 2)));
                    }
                    if (this.actionHelperInstance == null) {
                        this.actionHelperInstance = this.actionHelperClass.getMethod(new String(Base64.decode("Z2V0SW5zdGFuY2U=", 2)), new Class[0]).invoke(null, new Object[0]);
                    }
                    if (this.onJPushMessageReceiveMethod == null) {
                        this.onJPushMessageReceiveMethod = this.actionHelperClass.getMethod(new String(Base64.decode("b25KUHVzaE1lc3NhZ2VSZWNlaXZl", 2)), Context.class, String.class, String.class, Bundle.class);
                    }
                    this.onJPushMessageReceiveMethod.invoke(this.actionHelperInstance, context, str, str2, bundle);
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Log.d(TAG, "InitProvider onCreate");
        try {
            a.a((Application) getContext());
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
