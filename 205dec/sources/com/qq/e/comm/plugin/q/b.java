package com.qq.e.comm.plugin.q;

import com.qq.e.comm.plugin.dysi.IGDTBiz;
import com.qq.e.comm.plugin.g0.y;
import com.qq.e.comm.plugin.o0.h.f;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class b implements IGDTBiz {

    /* renamed from: d  reason: collision with root package name */
    private static final String f45359d = e.c(IGDTBiz.KEY_GDTBIZ);

    /* renamed from: a  reason: collision with root package name */
    private final int f45360a;

    /* renamed from: b  reason: collision with root package name */
    private final com.qq.e.comm.dynamic.b f45361b;

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.n0.c f45362c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f45363a;

        static {
            int[] iArr = new int[f.t.values().length];
            f45363a = iArr;
            try {
                iArr[f.t.UNINITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45363a[f.t.PREPARED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45363a[f.t.PLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f45363a[f.t.STOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f45363a[f.t.PAUSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f45363a[f.t.END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f45363a[f.t.ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private b(int i4, com.qq.e.comm.dynamic.b bVar, com.qq.e.comm.plugin.g0.e eVar, y yVar) {
        this.f45360a = i4;
        this.f45361b = bVar;
        this.f45362c = com.qq.e.comm.plugin.n0.c.a(eVar, yVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IGDTBiz a(int i4, com.qq.e.comm.dynamic.b bVar, com.qq.e.comm.plugin.g0.e eVar, y yVar) {
        if (i4 != 0 && bVar != null) {
            try {
                Boolean bool = (Boolean) bVar.b(f45359d);
                if (bool != null && !bool.booleanValue()) {
                    return new b(i4, bVar, eVar, yVar);
                }
                return null;
            } catch (Throwable th) {
                i.a(f45359d, com.qq.e.comm.plugin.n0.c.a(eVar, yVar), th);
            }
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTBiz
    public boolean isTimerTickEnable() {
        return (this.f45360a & 1) != 0;
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTBiz
    public void onDialogDismiss(int i4) {
        h.b().a(IGDTBiz.KEY_GDTBIZ, "onDialogDismiss", Integer.valueOf(i4)).d().a("event_onDialogDismiss", Integer.valueOf(i4)).c().a(this.f45361b, this.f45362c);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTBiz
    public void onDialogShow(int i4) {
        h.b().a(IGDTBiz.KEY_GDTBIZ, "onDialogShow", Integer.valueOf(i4)).d().a("event_onDialogShow", Integer.valueOf(i4)).c().a(this.f45361b, this.f45362c);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTBiz
    public void onLandingPageClose() {
        h.b().a(IGDTBiz.KEY_GDTBIZ, "onLandingPageClose", new Object[0]).d().a("event_onLandingPageClose", new Object[0]).c().a(this.f45361b, this.f45362c);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTBiz
    public void onLandingPageOpen() {
        h.b().a(IGDTBiz.KEY_GDTBIZ, "onLandingPageOpen", new Object[0]).d().a("event_onLandingPageOpen", new Object[0]).c().a(this.f45361b, this.f45362c);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTBiz
    public void onPlayStateChange(f.t tVar, int i4) {
        String a4 = a(tVar);
        h.b().a(IGDTBiz.KEY_GDTBIZ, "onPlayStateChange", a4, Integer.valueOf(i4)).d().a("event_onPlayStateChange", a4, Integer.valueOf(i4)).c().a(this.f45361b, this.f45362c);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTBiz
    public void onReward(int i4) {
        h.b().a(IGDTBiz.KEY_GDTBIZ, "onReward", Integer.valueOf(i4)).d().a("event_onReward", Integer.valueOf(i4)).c().a(this.f45361b, this.f45362c);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTBiz
    public void onTimerTick(long j4) {
        if ((this.f45360a & 1) == 0) {
            return;
        }
        h.b().a(IGDTBiz.KEY_GDTBIZ, "onTimerTick", Long.valueOf(j4)).d().a("event_onTimerTick", Long.valueOf(j4)).c().a(this.f45361b, this.f45362c);
    }

    private String a(f.t tVar) {
        if (tVar == null) {
            return "";
        }
        switch (a.f45363a[tVar.ordinal()]) {
            case 1:
                return "UNINITIALIZED";
            case 2:
                return "PREPARED";
            case 3:
                return "PLAY";
            case 4:
                return "STOP";
            case 5:
                return "PAUSE";
            case 6:
                return "END";
            case 7:
                return "ERROR";
            default:
                return "";
        }
    }
}
