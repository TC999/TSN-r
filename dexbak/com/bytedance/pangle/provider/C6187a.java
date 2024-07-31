package com.bytedance.pangle.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

@Keep
/* renamed from: com.bytedance.pangle.provider.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6187a {
    /* renamed from: a */
    private static Uri m37026a(String str, Uri uri) {
        return m37025a(str, uri, (String) null);
    }

    /* renamed from: b */
    public static int m37024b(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        if (contentResolver == null) {
            return 0;
        }
        try {
            try {
                return contentResolver.update(m37027a(uri, str), contentValues, bundle);
            } catch (IllegalArgumentException unused) {
                ZeusLogger.m37077w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute update !!!");
                return contentResolver.update(uri, contentValues, bundle);
            } catch (Exception e) {
                e = e;
                ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", e);
                return 0;
            } catch (IncompatibleClassChangeError e2) {
                e = e2;
                ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", e);
                return 0;
            }
        } catch (Throwable th) {
            ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", th);
            return 0;
        }
    }

    /* renamed from: a */
    private static Uri m37025a(String str, Uri uri, String str2) {
        ContentProviderManager contentProviderManager = ContentProviderManager.getInstance();
        if (uri != null) {
            str2 = uri.getAuthority();
        }
        String pluginProcessNameByAuthority = contentProviderManager.getPluginProcessNameByAuthority(str2);
        String m37023a = C6188b.m37023a(pluginProcessNameByAuthority, str, uri);
        String encodeToString = TextUtils.isEmpty(m37023a) ? "" : Base64.encodeToString(m37023a.getBytes(), 10);
        String str3 = ContentProviderManager.getInstance().getSystemProviderInfoMap().get(pluginProcessNameByAuthority).f22121b;
        return Uri.parse("content://" + str3 + File.separator + "proxy?provider_params=" + encodeToString);
    }

    @RequiresApi(api = 16)
    /* renamed from: a */
    public static Cursor m37030a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal, String str3) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.query(m37027a(uri, str3), strArr, str, strArr2, str2, cancellationSignal);
            } catch (IllegalArgumentException unused) {
                ZeusLogger.m37077w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute query(6 params) !!!");
                return contentResolver.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (Exception e) {
                e = e;
                ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(6 params) throw exception:", e);
                return null;
            } catch (IncompatibleClassChangeError e2) {
                e = e2;
                ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(6 params) throw exception:", e);
                return null;
            }
        } catch (Throwable th) {
            ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#query(6 params) throw exception:", th);
            return null;
        }
    }

    @RequiresApi(api = 26)
    /* renamed from: a */
    public static Cursor m37031a(ContentResolver contentResolver, Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal, String str) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.query(m37027a(uri, str), strArr, bundle, cancellationSignal);
            } catch (IllegalArgumentException unused) {
                ZeusLogger.m37077w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute query(5 params) !!!");
                return contentResolver.query(uri, strArr, bundle, cancellationSignal);
            } catch (Exception e) {
                e = e;
                ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(4 params) throw exception:", e);
                return null;
            } catch (IncompatibleClassChangeError e2) {
                e = e2;
                ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(4 params) throw exception:", e);
                return null;
            }
        } catch (Throwable th) {
            ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#query(4 params) throw exception:", th);
            return null;
        }
    }

    /* renamed from: a */
    public static Cursor m37029a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, String str3) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.query(m37027a(uri, str3), strArr, str, strArr2, str2);
            } catch (IllegalArgumentException unused) {
                ZeusLogger.m37077w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute query(5 params) !!!");
                return contentResolver.query(uri, strArr, str, strArr2, str2);
            } catch (Exception e) {
                ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(5 params) throw exception:", e);
                return null;
            }
        } catch (Throwable th) {
            ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#query(5 params) throw exception:", th);
            return null;
        }
    }

    /* renamed from: a */
    public static String m37034a(ContentResolver contentResolver, Uri uri, String str) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.getType(m37027a(uri, str));
            } catch (IllegalArgumentException unused) {
                ZeusLogger.m37077w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute getType !!!");
                return contentResolver.getType(uri);
            } catch (Exception e) {
                ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#getType throw exception:", e);
                return null;
            }
        } catch (Throwable th) {
            ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#getType throw exception:", th);
            return null;
        }
    }

    /* renamed from: a */
    public static Uri m37037a(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.insert(m37027a(uri, str), contentValues);
            } catch (IllegalArgumentException unused) {
                ZeusLogger.m37077w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute insert !!!");
                return contentResolver.insert(uri, contentValues);
            } catch (Exception e) {
                ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#insert throw exception:", e);
                return null;
            }
        } catch (Throwable th) {
            ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#insert throw exception:", th);
            return null;
        }
    }

    /* renamed from: a */
    public static Uri m37038a(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.insert(m37027a(uri, str), contentValues, bundle);
            } catch (IllegalArgumentException unused) {
                ZeusLogger.m37077w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute insert !!!");
                return contentResolver.insert(uri, contentValues, bundle);
            } catch (Exception e) {
                e = e;
                ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#insert throw exception:", e);
                return null;
            } catch (IncompatibleClassChangeError e2) {
                e = e2;
                ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#insert throw exception:", e);
                return null;
            }
        } catch (Throwable th) {
            ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#insert throw exception:", th);
            return null;
        }
    }

    /* renamed from: a */
    public static int m37032a(ContentResolver contentResolver, Uri uri, String str, String[] strArr, String str2) {
        if (contentResolver == null) {
            return -1;
        }
        try {
            try {
                return contentResolver.delete(m37027a(uri, str2), str, strArr);
            } catch (IllegalArgumentException unused) {
                ZeusLogger.m37077w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute delete !!!");
                return contentResolver.delete(uri, str, strArr);
            } catch (Exception e) {
                ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", e);
                return -1;
            }
        } catch (Throwable th) {
            ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", th);
            return -1;
        }
    }

    /* renamed from: a */
    public static int m37035a(ContentResolver contentResolver, Uri uri, Bundle bundle, String str) {
        if (contentResolver == null) {
            return -1;
        }
        try {
            try {
                return contentResolver.delete(m37027a(uri, str), bundle);
            } catch (IllegalArgumentException unused) {
                ZeusLogger.m37077w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute delete !!!");
                return contentResolver.delete(uri, bundle);
            } catch (Exception e) {
                e = e;
                ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", e);
                return -1;
            } catch (IncompatibleClassChangeError e2) {
                e = e2;
                ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", e);
                return -1;
            }
        } catch (Throwable th) {
            ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", th);
            return -1;
        }
    }

    /* renamed from: a */
    public static int m37036a(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str, String[] strArr, String str2) {
        if (contentResolver == null) {
            return 0;
        }
        try {
            try {
                return contentResolver.update(m37027a(uri, str2), contentValues, str, strArr);
            } catch (IllegalArgumentException unused) {
                ZeusLogger.m37077w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute update !!!");
                return contentResolver.update(uri, contentValues, str, strArr);
            } catch (Exception e) {
                ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", e);
                return 0;
            }
        } catch (Throwable th) {
            ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", th);
            return 0;
        }
    }

    /* renamed from: a */
    public static Bundle m37033a(ContentResolver contentResolver, Uri uri, String str, String str2, Bundle bundle, String str3) {
        if (contentResolver != null && uri != null) {
            try {
                try {
                    Uri m37027a = m37027a(uri, str3);
                    if (bundle == null) {
                        bundle = new Bundle();
                    }
                    bundle.putString("provider_params", uri.getAuthority());
                    bundle.putString(ContentProviderManager.PROVIDER_PROXY_URI, m37027a.toString());
                    return contentResolver.call(m37027a, str, str2, bundle);
                } catch (IllegalArgumentException unused) {
                    ZeusLogger.m37077w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute call !!!");
                    return contentResolver.call(uri, str, str2, bundle);
                } catch (Exception e) {
                    e = e;
                    ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", e);
                    return null;
                } catch (IncompatibleClassChangeError e2) {
                    e = e2;
                    ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", e);
                    return null;
                }
            } catch (Throwable th) {
                ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", th);
            }
        }
        return null;
    }

    /* renamed from: a */
    public static Bundle m37028a(ContentResolver contentResolver, String str, String str2, String str3, Bundle bundle, String str4) {
        if (contentResolver == null) {
            return null;
        }
        String str5 = ContentProviderManager.getInstance().getSystemProviderInfoMap().get(ContentProviderManager.getInstance().getPluginProcessNameByAuthority(str)).f22121b;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("provider_params", str);
        bundle.putString(ContentProviderManager.PROVIDER_PROXY_URI, m37025a(str4, (Uri) null, str).toString());
        try {
            try {
                return contentResolver.call(str5, str2, str3, bundle);
            } catch (IllegalArgumentException unused) {
                ZeusLogger.m37077w(ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute call !!!");
                return contentResolver.call(str, str2, str3, bundle);
            } catch (Exception e) {
                e = e;
                ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", e);
                return null;
            } catch (IncompatibleClassChangeError e2) {
                e = e2;
                ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", e);
                return null;
            }
        } catch (Throwable th) {
            ZeusLogger.m37076w(ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", th);
            return null;
        }
    }

    /* renamed from: a */
    public static Uri m37027a(Uri uri, String str) {
        if (ContentProviderManager.getInstance().isPluginProvider(uri)) {
            return m37026a(str, uri);
        }
        if (uri.getAuthority().startsWith(Zeus.getAppApplication().getPackageName())) {
            Uri parse = Uri.parse(uri.toString().replaceFirst(Zeus.getAppApplication().getPackageName(), str));
            return ContentProviderManager.getInstance().isPluginProvider(parse) ? m37026a(str, parse) : uri;
        }
        return uri;
    }
}
