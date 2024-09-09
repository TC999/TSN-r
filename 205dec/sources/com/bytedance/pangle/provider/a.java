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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a {
    private static Uri a(String str, Uri uri) {
        return a(str, uri, (String) null);
    }

    public static int b(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        if (contentResolver == null) {
            return 0;
        }
        try {
            try {
                return contentResolver.update(a(uri, str), contentValues, bundle);
            } catch (IllegalArgumentException unused) {
                ZeusLogger.w("Zeus/provider_pangle", "not found plugin provider, but found host ContentResolver execute update !!!");
                return contentResolver.update(uri, contentValues, bundle);
            } catch (Exception e4) {
                e = e4;
                ZeusLogger.w("Zeus/provider_pangle", "ContentProviderManager#update throw exception:", e);
                return 0;
            } catch (IncompatibleClassChangeError e5) {
                e = e5;
                ZeusLogger.w("Zeus/provider_pangle", "ContentProviderManager#update throw exception:", e);
                return 0;
            }
        } catch (Throwable th) {
            ZeusLogger.w("Zeus/provider_pangle", "ContentProviderManager#update throw exception:", th);
            return 0;
        }
    }

    private static Uri a(String str, Uri uri, String str2) {
        ContentProviderManager contentProviderManager = ContentProviderManager.getInstance();
        if (uri != null) {
            str2 = uri.getAuthority();
        }
        String pluginProcessNameByAuthority = contentProviderManager.getPluginProcessNameByAuthority(str2);
        String a4 = b.a(pluginProcessNameByAuthority, str, uri);
        String encodeToString = TextUtils.isEmpty(a4) ? "" : Base64.encodeToString(a4.getBytes(), 10);
        String str3 = ContentProviderManager.getInstance().getSystemProviderInfoMap().get(pluginProcessNameByAuthority).f28882b;
        return Uri.parse("content://" + str3 + File.separator + "proxy?provider_params=" + encodeToString);
    }

    @RequiresApi(api = 16)
    public static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal, String str3) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.query(a(uri, str3), strArr, str, strArr2, str2, cancellationSignal);
            } catch (IllegalArgumentException unused) {
                ZeusLogger.w("Zeus/provider_pangle", "not found plugin provider, but found host ContentResolver execute query(6 params) !!!");
                return contentResolver.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (Exception e4) {
                e = e4;
                ZeusLogger.w("Zeus/provider_pangle", "ContentProviderManager#query(6 params) throw exception:", e);
                return null;
            } catch (IncompatibleClassChangeError e5) {
                e = e5;
                ZeusLogger.w("Zeus/provider_pangle", "ContentProviderManager#query(6 params) throw exception:", e);
                return null;
            }
        } catch (Throwable th) {
            ZeusLogger.w("Zeus/provider_pangle", "not found host provider-ContentProviderManager#query(6 params) throw exception:", th);
            return null;
        }
    }

    @RequiresApi(api = 26)
    public static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal, String str) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.query(a(uri, str), strArr, bundle, cancellationSignal);
            } catch (IllegalArgumentException unused) {
                ZeusLogger.w("Zeus/provider_pangle", "not found plugin provider, but found host ContentResolver execute query(5 params) !!!");
                return contentResolver.query(uri, strArr, bundle, cancellationSignal);
            } catch (Exception e4) {
                e = e4;
                ZeusLogger.w("Zeus/provider_pangle", "ContentProviderManager#query(4 params) throw exception:", e);
                return null;
            } catch (IncompatibleClassChangeError e5) {
                e = e5;
                ZeusLogger.w("Zeus/provider_pangle", "ContentProviderManager#query(4 params) throw exception:", e);
                return null;
            }
        } catch (Throwable th) {
            ZeusLogger.w("Zeus/provider_pangle", "not found host provider-ContentProviderManager#query(4 params) throw exception:", th);
            return null;
        }
    }

    public static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, String str3) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.query(a(uri, str3), strArr, str, strArr2, str2);
            } catch (IllegalArgumentException unused) {
                ZeusLogger.w("Zeus/provider_pangle", "not found plugin provider, but found host ContentResolver execute query(5 params) !!!");
                return contentResolver.query(uri, strArr, str, strArr2, str2);
            } catch (Exception e4) {
                ZeusLogger.w("Zeus/provider_pangle", "ContentProviderManager#query(5 params) throw exception:", e4);
                return null;
            }
        } catch (Throwable th) {
            ZeusLogger.w("Zeus/provider_pangle", "not found host provider-ContentProviderManager#query(5 params) throw exception:", th);
            return null;
        }
    }

    public static String a(ContentResolver contentResolver, Uri uri, String str) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.getType(a(uri, str));
            } catch (IllegalArgumentException unused) {
                ZeusLogger.w("Zeus/provider_pangle", "not found plugin provider, but found host ContentResolver execute getType !!!");
                return contentResolver.getType(uri);
            } catch (Exception e4) {
                ZeusLogger.w("Zeus/provider_pangle", "ContentProviderManager#getType throw exception:", e4);
                return null;
            }
        } catch (Throwable th) {
            ZeusLogger.w("Zeus/provider_pangle", "not found host provider-ContentProviderManager#getType throw exception:", th);
            return null;
        }
    }

    public static Uri a(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.insert(a(uri, str), contentValues);
            } catch (IllegalArgumentException unused) {
                ZeusLogger.w("Zeus/provider_pangle", "not found plugin provider, but found host ContentResolver execute insert !!!");
                return contentResolver.insert(uri, contentValues);
            } catch (Exception e4) {
                ZeusLogger.w("Zeus/provider_pangle", "ContentProviderManager#insert throw exception:", e4);
                return null;
            }
        } catch (Throwable th) {
            ZeusLogger.w("Zeus/provider_pangle", "not found host provider-ContentProviderManager#insert throw exception:", th);
            return null;
        }
    }

    public static Uri a(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.insert(a(uri, str), contentValues, bundle);
            } catch (IllegalArgumentException unused) {
                ZeusLogger.w("Zeus/provider_pangle", "not found plugin provider, but found host ContentResolver execute insert !!!");
                return contentResolver.insert(uri, contentValues, bundle);
            } catch (Exception e4) {
                e = e4;
                ZeusLogger.w("Zeus/provider_pangle", "ContentProviderManager#insert throw exception:", e);
                return null;
            } catch (IncompatibleClassChangeError e5) {
                e = e5;
                ZeusLogger.w("Zeus/provider_pangle", "ContentProviderManager#insert throw exception:", e);
                return null;
            }
        } catch (Throwable th) {
            ZeusLogger.w("Zeus/provider_pangle", "not found host provider-ContentProviderManager#insert throw exception:", th);
            return null;
        }
    }

    public static int a(ContentResolver contentResolver, Uri uri, String str, String[] strArr, String str2) {
        if (contentResolver == null) {
            return -1;
        }
        try {
            try {
                return contentResolver.delete(a(uri, str2), str, strArr);
            } catch (IllegalArgumentException unused) {
                ZeusLogger.w("Zeus/provider_pangle", "not found plugin provider, but found host ContentResolver execute delete !!!");
                return contentResolver.delete(uri, str, strArr);
            } catch (Exception e4) {
                ZeusLogger.w("Zeus/provider_pangle", "ContentProviderManager#delete throw exception:", e4);
                return -1;
            }
        } catch (Throwable th) {
            ZeusLogger.w("Zeus/provider_pangle", "ContentProviderManager#delete throw exception:", th);
            return -1;
        }
    }

    public static int a(ContentResolver contentResolver, Uri uri, Bundle bundle, String str) {
        if (contentResolver == null) {
            return -1;
        }
        try {
            try {
                return contentResolver.delete(a(uri, str), bundle);
            } catch (IllegalArgumentException unused) {
                ZeusLogger.w("Zeus/provider_pangle", "not found plugin provider, but found host ContentResolver execute delete !!!");
                return contentResolver.delete(uri, bundle);
            } catch (Exception e4) {
                e = e4;
                ZeusLogger.w("Zeus/provider_pangle", "ContentProviderManager#delete throw exception:", e);
                return -1;
            } catch (IncompatibleClassChangeError e5) {
                e = e5;
                ZeusLogger.w("Zeus/provider_pangle", "ContentProviderManager#delete throw exception:", e);
                return -1;
            }
        } catch (Throwable th) {
            ZeusLogger.w("Zeus/provider_pangle", "ContentProviderManager#delete throw exception:", th);
            return -1;
        }
    }

    public static int a(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str, String[] strArr, String str2) {
        if (contentResolver == null) {
            return 0;
        }
        try {
            try {
                return contentResolver.update(a(uri, str2), contentValues, str, strArr);
            } catch (IllegalArgumentException unused) {
                ZeusLogger.w("Zeus/provider_pangle", "not found plugin provider, but found host ContentResolver execute update !!!");
                return contentResolver.update(uri, contentValues, str, strArr);
            } catch (Exception e4) {
                ZeusLogger.w("Zeus/provider_pangle", "ContentProviderManager#update throw exception:", e4);
                return 0;
            }
        } catch (Throwable th) {
            ZeusLogger.w("Zeus/provider_pangle", "ContentProviderManager#update throw exception:", th);
            return 0;
        }
    }

    public static Bundle a(ContentResolver contentResolver, Uri uri, String str, String str2, Bundle bundle, String str3) {
        if (contentResolver != null && uri != null) {
            try {
                try {
                    Uri a4 = a(uri, str3);
                    if (bundle == null) {
                        bundle = new Bundle();
                    }
                    bundle.putString("provider_params", uri.getAuthority());
                    bundle.putString("provider_proxy_uri", a4.toString());
                    return contentResolver.call(a4, str, str2, bundle);
                } catch (IllegalArgumentException unused) {
                    ZeusLogger.w("Zeus/provider_pangle", "not found plugin provider, but found host ContentResolver execute call !!!");
                    return contentResolver.call(uri, str, str2, bundle);
                } catch (Exception e4) {
                    e = e4;
                    ZeusLogger.w("Zeus/provider_pangle", "ContentProviderManager#call throw exception:", e);
                    return null;
                } catch (IncompatibleClassChangeError e5) {
                    e = e5;
                    ZeusLogger.w("Zeus/provider_pangle", "ContentProviderManager#call throw exception:", e);
                    return null;
                }
            } catch (Throwable th) {
                ZeusLogger.w("Zeus/provider_pangle", "ContentProviderManager#call throw exception:", th);
            }
        }
        return null;
    }

    public static Bundle a(ContentResolver contentResolver, String str, String str2, String str3, Bundle bundle, String str4) {
        if (contentResolver == null) {
            return null;
        }
        String str5 = ContentProviderManager.getInstance().getSystemProviderInfoMap().get(ContentProviderManager.getInstance().getPluginProcessNameByAuthority(str)).f28882b;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("provider_params", str);
        bundle.putString("provider_proxy_uri", a(str4, (Uri) null, str).toString());
        try {
            try {
                return contentResolver.call(str5, str2, str3, bundle);
            } catch (IllegalArgumentException unused) {
                ZeusLogger.w("Zeus/provider_pangle", "not found plugin provider, but found host ContentResolver execute call !!!");
                return contentResolver.call(str, str2, str3, bundle);
            } catch (Exception e4) {
                e = e4;
                ZeusLogger.w("Zeus/provider_pangle", "ContentProviderManager#call throw exception:", e);
                return null;
            } catch (IncompatibleClassChangeError e5) {
                e = e5;
                ZeusLogger.w("Zeus/provider_pangle", "ContentProviderManager#call throw exception:", e);
                return null;
            }
        } catch (Throwable th) {
            ZeusLogger.w("Zeus/provider_pangle", "ContentProviderManager#call throw exception:", th);
            return null;
        }
    }

    public static Uri a(Uri uri, String str) {
        if (ContentProviderManager.getInstance().isPluginProvider(uri)) {
            return a(str, uri);
        }
        if (uri.getAuthority().startsWith(Zeus.getAppApplication().getPackageName())) {
            Uri parse = Uri.parse(uri.toString().replaceFirst(Zeus.getAppApplication().getPackageName(), str));
            return ContentProviderManager.getInstance().isPluginProvider(parse) ? a(str, parse) : uri;
        }
        return uri;
    }
}
