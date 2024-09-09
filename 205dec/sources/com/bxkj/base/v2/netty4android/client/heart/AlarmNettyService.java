package com.bxkj.base.v2.netty4android.client.heart;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.bxkj.base.BaseApp;
import com.bxkj.base.v2.data.a;
import com.bxkj.base.v2.netty4android.service.NettySocketService;
import com.orhanobut.logger.j;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.Nullable;

/* compiled from: AlarmNettyService.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\"\u0010\f\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/bxkj/base/v2/netty4android/client/heart/AlarmNettyService;", "Landroid/app/Service;", "Lkotlin/f1;", "a", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "onCreate", "", "flags", "startId", "onStartCommand", "Lcom/bxkj/base/v2/netty4android/client/heart/a;", "Lcom/bxkj/base/v2/netty4android/client/heart/a;", "alarmChatTimer", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class AlarmNettyService extends Service {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private a f18780a;

    private final void a() {
        try {
            BaseApp.b().startService(new Intent(BaseApp.b(), NettySocketService.class).putExtra("action", 1));
        } catch (Exception e4) {
            j.e(f0.C("AlarmChatService\u5fc3\u8df3\u68c0\u6d4b\u670d\u52a1\u91cd\u8fde\u5931\u8d25:", e4.getMessage()), new Object[0]);
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@Nullable Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        j.d("AlarmChatService\u5fc3\u8df3\u68c0\u6d4b\u670d\u52a1\u91cd\u65b0\u521b\u5efa", new Object[0]);
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i4, int i5) {
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = this.f18780a;
        if (aVar == null) {
            aVar = new a(this);
        }
        this.f18780a = aVar;
        aVar.b();
        a.b bVar = com.bxkj.base.v2.data.a.f18673h;
        if (bVar.a().G() && currentTimeMillis - bVar.a().m() > 180000) {
            j.e("\u8d85\u8fc760\u79d23\u6b21\u672a\u6536\u5230\u5fc3\u8df3\u56de\u8c03\u91cd\u8fde", new Object[0]);
            a();
        }
        return super.onStartCommand(intent, i4, i5);
    }
}
