package com.acse.ottn;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class l0 {

    /* renamed from: a  reason: collision with root package name */
    public static l0 f5859a;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f5860a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j4, long j5, d dVar) {
            super(j4, j5);
            this.f5860a = dVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f5860a.a();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j4) {
            this.f5860a.a(j4);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int[] f5862a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f5863b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f5864c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f5865d;

        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f5865d.a();
            }
        }

        /* renamed from: com.acse.ottn.l0$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class RunnableC0090b implements Runnable {
            public RunnableC0090b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                bVar.f5865d.a(bVar.f5864c - bVar.f5862a[0]);
            }
        }

        public b(int[] iArr, int i4, int i5, d dVar) {
            this.f5862a = iArr;
            this.f5863b = i4;
            this.f5864c = i5;
            this.f5865d = dVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (j0.f5766h) {
                z1.a("samon-->", "\u89e6\u53d1\u7ed3\u675f\u5faa\u73af\u6761\u4ef6");
                cancel();
            } else {
                j0.f5766h = false;
            }
            int[] iArr = this.f5862a;
            int i4 = iArr[0] + this.f5863b;
            iArr[0] = i4;
            if (i4 >= this.f5864c) {
                cancel();
                new Handler(Looper.getMainLooper()).postDelayed(new a(), 0L);
                return;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0090b(), 0L);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int[] f5869a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f5870b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f5871c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f5872d;

        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.f5872d.a();
            }
        }

        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                cVar.f5872d.a(cVar.f5871c - cVar.f5869a[0]);
            }
        }

        public c(int[] iArr, int i4, int i5, d dVar) {
            this.f5869a = iArr;
            this.f5870b = i4;
            this.f5871c = i5;
            this.f5872d = dVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int[] iArr = this.f5869a;
            int i4 = iArr[0] + this.f5870b;
            iArr[0] = i4;
            if (i4 >= this.f5871c) {
                cancel();
                new Handler(Looper.getMainLooper()).postDelayed(new a(), 0L);
                return;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new b(), 0L);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface d {
        void a();

        void a(long j4);
    }

    public static l0 a() {
        if (f5859a == null) {
            synchronized (l0.class) {
                if (f5859a == null) {
                    f5859a = new l0();
                }
            }
        }
        return f5859a;
    }

    public TimerTask b(int i4, int i5, d dVar) {
        j0.f5766h = false;
        b bVar = new b(new int[]{0}, i5, i4, dVar);
        new Timer().scheduleAtFixedRate(bVar, 0L, i5);
        return bVar;
    }

    public Timer c(int i4, int i5, d dVar) {
        c cVar = new c(new int[]{0}, i5, i4, dVar);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(cVar, 0L, i5);
        return timer;
    }

    public CountDownTimer a(int i4, int i5, d dVar) {
        return new a(i4, i5, dVar);
    }
}
