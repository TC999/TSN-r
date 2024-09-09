package com.tencent.turingfd.sdk.ams.au;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.turingfd.sdk.ams.au.Arbutus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.class  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Cclass extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final Lichee f52233a;

    /* renamed from: b  reason: collision with root package name */
    public final List<LeoMinor> f52234b;

    public Cclass(Looper looper, Lichee lichee) {
        super(looper);
        this.f52234b = new ArrayList();
        this.f52233a = lichee;
    }

    public final void a() {
        for (LeoMinor leoMinor : this.f52234b) {
            leoMinor.getClass();
            synchronized (LeoMinor.f52113i) {
                int i4 = LeoMinor.f52114j;
                if (i4 < 200) {
                    LeoMinor.f52114j = i4 + 1;
                    leoMinor.f52116a = LeoMinor.f52115k;
                    LeoMinor.f52115k = leoMinor;
                }
            }
        }
        this.f52234b.clear();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i4 = message.what;
        Codlin codlin = null;
        if (i4 == 1) {
            Object obj = message.obj;
            if (obj instanceof String) {
                ((Arbutus.Cdo) this.f52233a).a(new Cconst((String) obj, 3, null));
            }
        } else if (i4 == 2) {
            Object obj2 = message.obj;
            if (obj2 instanceof LeoMinor) {
                LeoMinor leoMinor = (LeoMinor) obj2;
                String str = leoMinor.f52117b;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (!this.f52234b.isEmpty() && !this.f52234b.get(0).f52117b.equals(leoMinor.f52117b)) {
                    a();
                }
                int i5 = leoMinor.f52118c;
                if (i5 == 0) {
                    a();
                    this.f52234b.add(leoMinor);
                } else if (i5 != 1) {
                    if (i5 == 2) {
                        this.f52234b.isEmpty();
                        this.f52234b.add(leoMinor);
                    } else if (i5 == 3) {
                        a();
                    }
                } else if (!this.f52234b.isEmpty()) {
                    this.f52234b.add(leoMinor);
                    List<LeoMinor> list = this.f52234b;
                    ArrayList arrayList = new ArrayList();
                    if (list.size() <= 8) {
                        arrayList.addAll(list);
                    } else {
                        LeoMinor leoMinor2 = list.get(0);
                        LeoMinor leoMinor3 = list.get(list.size() - 1);
                        list.remove(leoMinor2);
                        list.remove(leoMinor3);
                        int ceil = (int) Math.ceil(list.size() / 6);
                        arrayList.add(leoMinor2);
                        for (int i6 = 1; i6 < list.size(); i6 += ceil) {
                            arrayList.add(list.get(i6));
                        }
                        arrayList.add(leoMinor3);
                    }
                    if (!arrayList.isEmpty()) {
                        Codlin codlin2 = new Codlin();
                        long currentTimeMillis = System.currentTimeMillis();
                        long j4 = ((LeoMinor) arrayList.get(0)).f52123h;
                        codlin2.f51973d = (int) (currentTimeMillis - j4);
                        codlin2.f51972c = j4;
                        ArrayList<Core> arrayList2 = new ArrayList<>();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            LeoMinor leoMinor4 = (LeoMinor) it.next();
                            Core core = new Core();
                            int i7 = leoMinor4.f52118c;
                            if (i7 == 0) {
                                core.f51976c = 1;
                            } else if (i7 == 1) {
                                core.f51976c = 3;
                            } else if (i7 == 2) {
                                core.f51976c = 2;
                            } else if (i7 != 3) {
                                core.f51976c = 0;
                            } else {
                                core.f51976c = 4;
                            }
                            core.f51979f = leoMinor4.f52121f;
                            core.f51980g = leoMinor4.f52122g;
                            arrayList2.add(core);
                        }
                        codlin2.f51974e = arrayList2;
                        codlin = codlin2;
                    }
                    if (codlin == null) {
                        return;
                    }
                    if (leoMinor.f52119d <= 0) {
                        codlin.f51975f |= 1;
                    }
                    if (leoMinor.f52120e == 0) {
                        codlin.f51975f |= 2;
                    }
                    if (codlin.f51975f != 0) {
                        ((Arbutus.Cdo) this.f52233a).a(new Cconst(str, 2, codlin));
                    } else {
                        ((Arbutus.Cdo) this.f52233a).a(new Cconst(str, 1, codlin));
                    }
                    a();
                }
            }
        }
    }
}
