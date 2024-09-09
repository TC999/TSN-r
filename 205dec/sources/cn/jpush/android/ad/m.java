package cn.jpush.android.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4027a = d.b(new byte[]{85, 118, 97, 33, 60, 84, 32, 0, 98, 46, 73, 85, 85, 116, 18, 44});

    /* renamed from: b  reason: collision with root package name */
    private static final Object f4028b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> f4029c = new ConcurrentHashMap<>();

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    private static class a extends ThreadLocal<SimpleDateFormat> {

        /* renamed from: a  reason: collision with root package name */
        private String f4030a;

        a(String str) {
            this.f4030a = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(this.f4030a, Locale.ENGLISH);
        }
    }

    public static double a(double d4, double d5, double d6, double d7) {
        double d8 = d5 * 0.008726646259971648d;
        double d9 = d7 * 0.008726646259971648d;
        return Math.round((Math.asin(Math.sqrt(Math.pow(Math.sin(d8 - d9), 2.0d) + ((Math.cos(d8 * 2.0d) * Math.cos(d9 * 2.0d)) * Math.pow(Math.sin((d4 - d6) * 0.008726646259971648d), 2.0d)))) * 1.2756274E7d) * 10000.0d) / ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
    }

    public static int a(Context context, int i4) {
        return context == null ? i4 : (int) TypedValue.applyDimension(1, i4, context.getResources().getDisplayMetrics());
    }

    public static DisplayMetrics a(Context context) {
        WindowManager windowManager;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context != null && (windowManager = (WindowManager) context.getSystemService("window")) != null) {
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public static ViewGroup.LayoutParams a(Context context, View view, boolean z3, int i4, int i5, int i6, int i7) {
        if (context == null || view == null) {
            return null;
        }
        try {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : new ViewGroup.MarginLayoutParams(layoutParams);
            if (z3) {
                i4 = a(context, i4);
                i6 = a(context, i6);
                i5 = a(context, i5);
                i7 = a(context, i7);
            }
            marginLayoutParams.setMargins(i4, i5, i6, i7);
            view.setLayoutParams(marginLayoutParams);
            return marginLayoutParams;
        } catch (Throwable th) {
            Logger.w("Utils", "[setViewMargin] failed. err: " + th.getMessage());
            return null;
        }
    }

    public static String a(Collection<String> collection, String str) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : collection) {
            sb.append(str2);
            sb.append(str);
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static SimpleDateFormat a(String str) {
        ThreadLocal<SimpleDateFormat> threadLocal = f4029c.get(str);
        if (threadLocal == null) {
            synchronized (f4028b) {
                threadLocal = f4029c.get(str);
                if (threadLocal == null) {
                    threadLocal = new a(str);
                    f4029c.put(str, threadLocal);
                }
            }
        }
        return threadLocal.get();
    }

    public static ArrayList<String> a(JSONArray jSONArray) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (jSONArray != null && jSONArray.length() != 0) {
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                String optString = jSONArray.optString(i4);
                if (!TextUtils.isEmpty(optString)) {
                    arrayList.add(optString);
                }
            }
        }
        return arrayList;
    }

    public static void a(Context context, List<String> list) {
        if (!JCoreHelper.isIpv6Priority(context) || list == null || list.size() < 2 || list.get(0).contains("ipv6")) {
            return;
        }
        Collections.swap(list, 0, 1);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static byte[] a(InputStream inputStream) {
        if (inputStream != null) {
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            return bArr;
        }
        throw new IOException("InputStream is null");
    }

    public static byte[] a(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        Throwable th;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        } catch (Throwable th2) {
            gZIPInputStream = null;
            th = th2;
        }
        try {
            byte[] bArr2 = new byte[256];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read < 0) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    a(byteArrayOutputStream);
                    a((Closeable) byteArrayInputStream);
                    a((Closeable) gZIPInputStream);
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (Throwable th3) {
            th = th3;
            a(byteArrayOutputStream);
            a((Closeable) byteArrayInputStream);
            a((Closeable) gZIPInputStream);
            throw th;
        }
    }

    public static int b(Context context, int i4) {
        return (int) (a(context).widthPixels * (i4 / 375.0f));
    }

    public static int b(String str) {
        try {
            return Integer.valueOf(Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim()).intValue();
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static byte[] b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (inputStream == null) {
            throw new IOException("InputStream is null");
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    a(byteArrayOutputStream);
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            a(byteArrayOutputStream2);
            throw th;
        }
    }

    public static int c(Context context, int i4) {
        return (int) (a(context).heightPixels * (i4 / 667.0f));
    }

    public static LinkedList<String> c(String str) {
        String[] split;
        try {
            LinkedList<String> linkedList = new LinkedList<>();
            if (str != null && str.length() > 0) {
                for (String str2 : str.split(",")) {
                    if (!TextUtils.isEmpty(str2)) {
                        linkedList.add(str2);
                    }
                }
            }
            return linkedList;
        } catch (Throwable unused) {
            return null;
        }
    }
}
