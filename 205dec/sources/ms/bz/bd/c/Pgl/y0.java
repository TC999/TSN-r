package ms.bz.bd.c.Pgl;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class y0 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f61476a;

    public y0(Context context) {
        this.f61476a = context;
    }

    public String a() {
        Bundle call;
        Uri parse = Uri.parse((String) pblk.a(16777217, 0, 0L, "a9059b", new byte[]{115, 52, 77, 85, 3, 123, 118, 66, 46, 42, 115, 53, 13, 79, 19, 119, 107, 25, 47, 108, 116, 62, 77, 85, 15, 97, 123, 87, 104, 97, 117, 53, 87, 72, 18, 108}));
        try {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 > 17) {
                ContentProviderClient acquireContentProviderClient = this.f61476a.getContentResolver().acquireContentProviderClient(parse);
                call = acquireContentProviderClient.call((String) pblk.a(16777217, 0, 0L, "260e45", new byte[]{36, 49, 87, 62, 42, 11, 21}), null, null);
                if (i4 >= 24) {
                    acquireContentProviderClient.close();
                } else {
                    acquireContentProviderClient.release();
                }
            } else {
                call = this.f61476a.getContentResolver().call(parse, (String) pblk.a(16777217, 0, 0L, "43ca3b", new byte[]{34, 52, 4, 58, 45, 92, 19}), (String) null, (Bundle) null);
            }
        } catch (Exception unused) {
        }
        if (call.getInt((String) pblk.a(16777217, 0, 0L, "4190dc", new byte[]{38, 60, 78, 65}), -1) == 0) {
            return call.getString((String) pblk.a(16777217, 0, 0L, "5418ee", new byte[]{45, 50}));
        }
        call.getString((String) pblk.a(16777217, 0, 0L, "ec6cbe", new byte[]{121, 100, 86, 4, 92, 117, 99}));
        return null;
    }
}
