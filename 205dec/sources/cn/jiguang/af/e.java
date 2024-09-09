package cn.jiguang.af;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2124a = cn.jiguang.ao.c.b(new byte[]{122, 103, 123, 63, 68, 69, 119, 107, 115, Byte.MAX_VALUE, 68, 14, 104, 121, 123, 100, 67, 73, 122});

    /* renamed from: b  reason: collision with root package name */
    private static final String f2125b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f2126c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f2127d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f2128e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f2129f;

    /* renamed from: g  reason: collision with root package name */
    private static final ArrayList<String> f2130g;

    static {
        String b4 = cn.jiguang.ao.c.b(new byte[]{122, 103, 123, 63, 68, 69, 119, 107, 115, Byte.MAX_VALUE, 68, 14, 104, 121, 123, 100, 67, 73, 122, 38, 69, 121, 81, 82, 124, 92, 119, 98, 91, 112, 107, 103, 96, 120, 84, 69, 107});
        f2125b = b4;
        String b5 = cn.jiguang.ao.c.b(new byte[]{117, 126, 93, 14, 109, 109, 120, 114, 85, 78, 109, 38, 103, 96, 93, 85, 106, 97, 117, 63, 116, 73, 106, 100, Byte.MAX_VALUE, 122, 85, 105, 119, 110, 121, 65, 66, 79, 111, 97, 114, 116, 66});
        f2126c = b5;
        String b6 = cn.jiguang.ao.c.b(new byte[]{114, 95, 77, 55, 124, 115, Byte.MAX_VALUE, 83, 69, 119, 124, 56, 96, 65, 77, 108, 123, Byte.MAX_VALUE, 114, 30, 97, 106, 123, Byte.MAX_VALUE, 98, 68, 112, 107, 103, 96, 120, 84, 69, 107});
        f2127d = b6;
        String b7 = cn.jiguang.ao.c.b(new byte[]{122, 103, 123, 63, 68, 69, 119, 107, 115, Byte.MAX_VALUE, 68, 14, 104, 121, 123, 100, 67, 73, 122, 38, 80, 126, 92, 68, 124, 122, 87, 98, 68, 112, 107, 103, 96, 120, 84, 69, 107});
        f2128e = b7;
        f2129f = cn.jiguang.ao.c.b(new byte[]{117, 126, 93, 14, 109, 109, 120, 114, 85, 78, 109, 38, 103, 96, 93, 85, 106, 97, 117, 63, 64, 69, 107, 110, 56, 65, 85, 82, Byte.MAX_VALUE, 103, 100, 124, 81, 78, 122, 109, 84, 80, 83, 84, 112, 126, Byte.MAX_VALUE, 101, 73});
        ArrayList<String> arrayList = new ArrayList<>();
        f2130g = arrayList;
        arrayList.add(b4);
        arrayList.add(b5);
        arrayList.add(b6);
        arrayList.add(b7);
    }

    public static boolean a(Context context) {
        try {
            Intent intent = new Intent();
            String str = f2124a;
            intent.setClassName(str, f2129f);
            boolean a4 = a.a(context, str, intent, true);
            cn.jiguang.w.a.b("JWakeSpecialHelper", "q has perform b act: " + a4);
            return a4;
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JWakeSpecialHelper", "check q has perform b act failed, " + th.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str) || !TextUtils.equals(str, f2124a)) {
            return false;
        }
        return b(context);
    }

    private static boolean b(Context context) {
        Uri parse;
        Iterator<String> it = f2130g.iterator();
        while (it.hasNext()) {
            String next = it.next();
            try {
                if (!next.startsWith("content://")) {
                    next = "content://" + next;
                }
                parse = Uri.parse(next);
                cn.jiguang.w.a.b("JWakeSpecialHelper", " provider: " + next + ", uri: " + parse);
            } catch (Throwable unused) {
            }
            if (StubApp.getOrigApplicationContext(context.getApplicationContext()).getContentResolver().insert(parse, new ContentValues()) != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(Context context, String str) {
        if (TextUtils.isEmpty(str) || !TextUtils.equals(str, f2124a)) {
            return true;
        }
        return !a(context);
    }
}
