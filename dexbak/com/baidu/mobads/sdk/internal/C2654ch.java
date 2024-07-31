package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mobads.sdk.internal.InterfaceC2725v;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

/* renamed from: com.baidu.mobads.sdk.internal.ch */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2654ch implements Observer {

    /* renamed from: a */
    private static final String f8809a = "APKParser";

    /* renamed from: g */
    private static final String f8810g = "__xadsdk_downloaded__version__";

    /* renamed from: h */
    private static final String f8811h = "version";

    /* renamed from: b */
    private Context f8812b;

    /* renamed from: c */
    private URL f8813c;

    /* renamed from: d */
    private String f8814d;

    /* renamed from: e */
    private final C2638bw f8815e;

    /* renamed from: f */
    private InterfaceC2655a f8816f;

    /* renamed from: i */
    private SharedPreferences f8817i;

    /* renamed from: j */
    private SharedPreferences.OnSharedPreferenceChangeListener f8818j;

    /* renamed from: com.baidu.mobads.sdk.internal.ch$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC2655a {
        /* renamed from: a */
        void mo50648a(C2638bw c2638bw);

        /* renamed from: b */
        void mo50647b(C2638bw c2638bw);
    }

    public C2654ch(Context context, URL url, C2638bw c2638bw, InterfaceC2655a interfaceC2655a) {
        this.f8813c = null;
        this.f8814d = null;
        this.f8818j = new SharedPreferences$OnSharedPreferenceChangeListenerC2656ci(this);
        this.f8813c = url;
        this.f8815e = c2638bw;
        m50650a(context, interfaceC2655a);
    }

    /* renamed from: a */
    private void m50650a(Context context, InterfaceC2655a interfaceC2655a) {
        this.f8812b = context;
        this.f8816f = interfaceC2655a;
        SharedPreferences sharedPreferences = context.getSharedPreferences(f8810g, 0);
        this.f8817i = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this.f8818j);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        InterfaceC2725v interfaceC2725v = (InterfaceC2725v) observable;
        if (interfaceC2725v.mo50304l() == InterfaceC2725v.EnumC2726a.COMPLETED) {
            this.f8816f.mo50648a(new C2638bw(this.f8815e, interfaceC2725v.mo50309g(), Boolean.TRUE));
        }
        if (interfaceC2725v.mo50304l() == InterfaceC2725v.EnumC2726a.ERROR) {
            this.f8816f.mo50647b(new C2638bw(this.f8815e, interfaceC2725v.mo50309g(), Boolean.FALSE));
        }
    }

    /* renamed from: a */
    public void m50649a(String str, String str2) {
        RunnableC2593am runnableC2593am = new RunnableC2593am(this.f8812b, this.f8814d != null ? new URL(this.f8814d) : this.f8813c, str, str2, false);
        runnableC2593am.addObserver(this);
        runnableC2593am.mo50316a();
        SharedPreferences.Editor edit = this.f8817i.edit();
        edit.putString("version", this.f8815e.toString());
        edit.apply();
    }

    public C2654ch(Context context, String str, C2638bw c2638bw, InterfaceC2655a interfaceC2655a) {
        this.f8813c = null;
        this.f8814d = null;
        this.f8818j = new SharedPreferences$OnSharedPreferenceChangeListenerC2656ci(this);
        this.f8814d = str;
        this.f8815e = c2638bw;
        m50650a(context, interfaceC2655a);
    }
}
