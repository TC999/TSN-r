package com.acse.ottn.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.acse.ottn.z1;
import com.stub.StubApp;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class DemoService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public static String f6300a = "DemoService";

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Consumer<String> {
        public a() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(String str) throws Exception {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.acse.ottn.n.a().a(DemoService.this, str);
            DemoService.this.stopSelf();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements Consumer<Throwable> {
        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements ObservableOnSubscribe<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6303a;

        public c(String str) {
            this.f6303a = str;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
            String str;
            try {
                str = new JSONObject(new OkHttpClient().newCall(new Request.Builder().url(this.f6303a).build()).execute().body().string()).getString("content");
                z1.a("samon-->code1", str);
            } catch (Exception e4) {
                e4.printStackTrace();
                z1.a("samon-->code11", "shortcode is null");
                z1.a(DemoService.f6300a, e4.getMessage());
                str = "";
            }
            observableEmitter.onNext(str);
        }
    }

    static {
        StubApp.interface11(5025);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("tkl_url");
            if (!TextUtils.isEmpty(stringExtra)) {
                try {
                    a(stringExtra);
                } catch (Exception unused) {
                    z1.b(f6300a, "request code fail ");
                }
            }
        } else {
            stopSelf();
        }
        return super.onStartCommand(intent, i4, i5);
    }

    public void a(String str) {
        Observable.create(new c(str)).subscribeOn(Schedulers.newThread()).observeOn(com.acse.ottn.h.a()).subscribe(new a(), new b());
    }
}
