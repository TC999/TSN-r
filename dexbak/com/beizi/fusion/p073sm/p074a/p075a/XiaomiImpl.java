package com.beizi.fusion.p073sm.p074a.p075a;

import android.annotation.SuppressLint;
import android.content.Context;
import com.beizi.fusion.p073sm.p074a.IGetter;
import com.beizi.fusion.p073sm.p074a.IOAID;
import com.beizi.fusion.p073sm.p074a.OAIDException;
import com.beizi.fusion.p073sm.p074a.OAIDLog;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.beizi.fusion.sm.a.a.q */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class XiaomiImpl implements IOAID {

    /* renamed from: a */
    private final Context f11517a;

    /* renamed from: b */
    private Class<?> f11518b;

    /* renamed from: c */
    private Object f11519c;

    @SuppressLint({"PrivateApi"})
    public XiaomiImpl(Context context) {
        this.f11517a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f11518b = cls;
            this.f11519c = cls.newInstance();
        } catch (Exception e) {
            OAIDLog.m48130a(e);
        }
    }

    /* renamed from: b */
    private String m48136b() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (String) this.f11518b.getMethod("getOAID", Context.class).invoke(this.f11519c, this.f11517a);
    }

    @Override // com.beizi.fusion.p073sm.p074a.IOAID
    /* renamed from: a */
    public boolean mo48132a() {
        return this.f11519c != null;
    }

    @Override // com.beizi.fusion.p073sm.p074a.IOAID
    /* renamed from: a */
    public void mo48131a(IGetter iGetter) {
        if (this.f11517a == null || iGetter == null) {
            return;
        }
        if (this.f11518b != null && this.f11519c != null) {
            try {
                String m48136b = m48136b();
                if (m48136b != null && m48136b.length() != 0) {
                    OAIDLog.m48130a("OAID query success: " + m48136b);
                    iGetter.mo48133a(m48136b);
                    return;
                }
                throw new OAIDException("OAID query failed");
            } catch (Exception e) {
                OAIDLog.m48130a(e);
                iGetter.mo48134a(e);
                return;
            }
        }
        iGetter.mo48134a(new OAIDException("Xiaomi IdProvider not exists"));
    }
}
