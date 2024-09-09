package n0;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class d extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private final Context f61490a;

    /* renamed from: b  reason: collision with root package name */
    private final AudioManager f61491b;

    /* renamed from: c  reason: collision with root package name */
    private final a f61492c;

    /* renamed from: d  reason: collision with root package name */
    private final c f61493d;

    /* renamed from: e  reason: collision with root package name */
    private float f61494e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.f61490a = context;
        this.f61491b = (AudioManager) context.getSystemService("audio");
        this.f61492c = aVar;
        this.f61493d = cVar;
    }

    private boolean b(float f4) {
        return f4 != this.f61494e;
    }

    private float d() {
        return this.f61492c.a(this.f61491b.getStreamVolume(3), this.f61491b.getStreamMaxVolume(3));
    }

    private void e() {
        this.f61493d.a(this.f61494e);
    }

    public void a() {
        this.f61494e = d();
        e();
        this.f61490a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void c() {
        this.f61490a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z3) {
        super.onChange(z3);
        float d4 = d();
        if (b(d4)) {
            this.f61494e = d4;
            e();
        }
    }
}
