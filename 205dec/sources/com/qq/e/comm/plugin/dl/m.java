package com.qq.e.comm.plugin.dl;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.qq.e.comm.plugin.util.b1;
import java.io.File;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private final File f42484a = b1.i();

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f42485b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a extends com.qq.e.comm.plugin.dl.a {
        a(File file, String str, boolean z3) {
            super(file, str, z3);
        }

        @Override // com.qq.e.comm.plugin.dl.a
        void a(JSONObject jSONObject) {
            m.this.f42485b = jSONObject;
            m.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b extends com.qq.e.comm.plugin.dl.a {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ File f42487f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(m mVar, File file, String str, boolean z3, File file2) {
            super(file, str, z3);
            this.f42487f = file2;
        }

        @Override // com.qq.e.comm.plugin.dl.a
        public void a(JSONObject jSONObject) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    b1.b(new File(this.f42487f, next), jSONObject.optString(next));
                } catch (Exception unused) {
                }
            }
        }
    }

    public m() {
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        JSONObject jSONObject = this.f42485b;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        a(this.f42485b.optString(LiveConfigKey.MEDIUM), a(LiveConfigKey.MEDIUM));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.qq.e.comm.plugin.g0.y a(int i4, String str) {
        int i5 = 2;
        File a4 = i4 == 2 ? a(LiveConfigKey.MEDIUM) : null;
        if (a4 == null) {
            return null;
        }
        File file = new File(a4, str);
        String d4 = file.exists() ? b1.d(file) : null;
        if (TextUtils.isEmpty(d4)) {
            if (i4 == 2) {
                d4 = g.a(str);
            }
            i5 = 3;
        }
        if (TextUtils.isEmpty(d4)) {
            return null;
        }
        try {
            return new com.qq.e.comm.plugin.g0.y(new JSONObject(d4), i5);
        } catch (JSONException unused) {
            return null;
        }
    }

    private void a() {
        new a(this.f42484a, com.qq.e.comm.plugin.d0.a.d().f().b("tplou", ""), true).b();
    }

    private void a(String str, File file) {
        new b(this, file, str, false, file).b();
    }

    private File a(String str) {
        File file = this.f42484a;
        return new File(file, str + "_fb");
    }
}
