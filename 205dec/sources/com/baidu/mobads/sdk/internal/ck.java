package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mobads.sdk.internal.v;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ck implements Observer {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12628a = "APKParser";

    /* renamed from: g  reason: collision with root package name */
    private static final String f12629g = "__xadsdk_downloaded__version__";

    /* renamed from: h  reason: collision with root package name */
    private static final String f12630h = "version";

    /* renamed from: b  reason: collision with root package name */
    private Context f12631b;

    /* renamed from: c  reason: collision with root package name */
    private URL f12632c;

    /* renamed from: d  reason: collision with root package name */
    private String f12633d;

    /* renamed from: e  reason: collision with root package name */
    private final bz f12634e;

    /* renamed from: f  reason: collision with root package name */
    private a f12635f;

    /* renamed from: i  reason: collision with root package name */
    private SharedPreferences f12636i;

    /* renamed from: j  reason: collision with root package name */
    private SharedPreferences.OnSharedPreferenceChangeListener f12637j;

    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void a(bz bzVar);

        void b(bz bzVar);
    }

    public ck(Context context, URL url, bz bzVar, a aVar) {
        this.f12632c = null;
        this.f12633d = null;
        this.f12637j = new cl(this);
        this.f12632c = url;
        this.f12634e = bzVar;
        a(context, aVar);
    }

    private void a(Context context, a aVar) {
        this.f12631b = context;
        this.f12635f = aVar;
        SharedPreferences sharedPreferences = context.getSharedPreferences(f12629g, 0);
        this.f12636i = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this.f12637j);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        v vVar = (v) observable;
        if (vVar.l() == v.a.COMPLETED) {
            this.f12635f.a(new bz(this.f12634e, vVar.g(), Boolean.TRUE));
        }
        if (vVar.l() == v.a.ERROR) {
            this.f12635f.b(new bz(this.f12634e, vVar.g(), Boolean.FALSE));
        }
    }

    public void a(String str, String str2) {
        am amVar = new am(this.f12631b, this.f12633d != null ? new URL(this.f12633d) : this.f12632c, str, str2, false);
        amVar.addObserver(this);
        amVar.a();
        SharedPreferences.Editor edit = this.f12636i.edit();
        edit.putString("version", this.f12634e.toString());
        edit.apply();
    }

    public ck(Context context, String str, bz bzVar, a aVar) {
        this.f12632c = null;
        this.f12633d = null;
        this.f12637j = new cl(this);
        this.f12633d = str;
        this.f12634e = bzVar;
        a(context, aVar);
    }
}
