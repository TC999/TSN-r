package com.bxkj.student.home.teaching.learning.detail.type;

import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.bxkj.base.util.file.a;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.daimajia.numberprogressbar.NumberProgressBar;
import com.github.barteksc.pdfviewer.PDFView;
import com.orhanobut.logger.j;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.File;
import k0.f;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class PdfFragment extends BaseFragment {

    /* renamed from: h  reason: collision with root package name */
    private String f20800h;

    /* renamed from: i  reason: collision with root package name */
    private String f20801i;

    /* renamed from: j  reason: collision with root package name */
    private com.bxkj.base.util.file.a f20802j;

    /* renamed from: k  reason: collision with root package name */
    private File f20803k;

    /* renamed from: l  reason: collision with root package name */
    private PDFView f20804l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f20805m;

    /* renamed from: n  reason: collision with root package name */
    private FrameLayout f20806n;

    /* renamed from: o  reason: collision with root package name */
    private NumberProgressBar f20807o;

    /* renamed from: p  reason: collision with root package name */
    private String f20808p = "";

    /* renamed from: q  reason: collision with root package name */
    private String f20809q = "";

    /* renamed from: r  reason: collision with root package name */
    private Disposable f20810r;

    /* renamed from: s  reason: collision with root package name */
    private b f20811s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.bxkj.base.util.file.c f20812a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ObservableEmitter f20813b;

        a(final com.bxkj.base.util.file.c val$fileVo, final ObservableEmitter val$e) {
            this.f20812a = val$fileVo;
            this.f20813b = val$e;
        }

        @Override // com.bxkj.base.util.file.a.b
        public void a(File file) {
            this.f20812a.d(file);
            this.f20813b.onNext(this.f20812a);
            this.f20813b.onComplete();
        }

        @Override // com.bxkj.base.util.file.a.b
        public void b(int progress) {
            Log.d("\u5f53\u524d\u4e0b\u8f7d\u7684\u8fdb\u5ea6", "" + progress);
            PdfFragment.this.c0(progress);
        }

        @Override // com.bxkj.base.util.file.a.b
        public void c(Exception e4) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface b {
        void onSuccess();
    }

    private void T() {
        this.f20810r = Observable.create(new ObservableOnSubscribe() { // from class: com.bxkj.student.home.teaching.learning.detail.type.a
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                PdfFragment.this.V(observableEmitter);
            }
        }).compose(com.bxkj.base.util.file.d.d()).subscribe(new Consumer() { // from class: com.bxkj.student.home.teaching.learning.detail.type.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PdfFragment.this.W((com.bxkj.base.util.file.c) obj);
            }
        });
    }

    private void U(String url) {
        this.f20808p = url;
        this.f20809q = "aa." + com.bxkj.base.util.file.b.i(this.f20808p);
        this.f20802j = com.bxkj.base.util.file.a.b();
        T();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(ObservableEmitter observableEmitter) throws Exception {
        com.bxkj.base.util.file.c cVar = new com.bxkj.base.util.file.c();
        this.f20802j.a(this.f20808p, com.bxkj.base.util.file.b.e(this.f1665e), this.f20809q, new a(cVar, observableEmitter));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(int i4, int i5) {
        TextView textView = this.f20805m;
        textView.setText((i4 + 1) + TTPathConst.sSeparator + i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(int i4) {
        b bVar = this.f20811s;
        if (bVar != null) {
            bVar.onSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(int i4, Integer num) throws Exception {
        this.f20807o.setProgress(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0 */
    public void W(com.bxkj.base.util.file.c fileVo) {
        try {
            NumberProgressBar numberProgressBar = this.f20807o;
            if (numberProgressBar != null) {
                numberProgressBar.setProgress(fileVo.b());
                this.f20807o.setVisibility(8);
            }
            this.f20803k = fileVo.a();
            j.c("file.getName().toLowerCase()=" + this.f20803k.getName().toLowerCase());
            if (this.f20803k.getName().toLowerCase().endsWith("pdf")) {
                this.f20804l.z(this.f20803k).B(10).q(new f() { // from class: com.bxkj.student.home.teaching.learning.detail.type.e
                    @Override // k0.f
                    public final void a(int i4, int i5) {
                        PdfFragment.this.X(i4, i5);
                    }
                }).o(new k0.d() { // from class: com.bxkj.student.home.teaching.learning.detail.type.d
                    @Override // k0.d
                    public final void a(int i4) {
                        PdfFragment.this.Y(i4);
                    }
                }).j();
                return;
            }
            iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(this.f1665e);
            iosonebuttondialog.setMessage("\u6682\u4e0d\u652f\u6301\u5f53\u524d\u6587\u4ef6\u7c7b\u578b\u3010" + com.bxkj.base.util.file.b.i(this.f20803k.getPath()) + "\u3011\u8bf7\u8054\u7cfb\u7ba1\u7406\u5458").show();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(final int progress) {
        Observable.just(Integer.valueOf(progress)).compose(com.bxkj.base.util.file.d.d()).subscribe(new Consumer() { // from class: com.bxkj.student.home.teaching.learning.detail.type.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PdfFragment.this.Z(progress, (Integer) obj);
            }
        });
    }

    public void a0(b loadOfficeListener) {
        this.f20811s = loadOfficeListener;
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void e() {
        if (getArguments().containsKey("url")) {
            U(getArguments().getString("url"));
        } else if (getArguments().containsKey("filePath")) {
            String string = getArguments().getString("filePath");
            com.bxkj.base.util.file.c cVar = new com.bxkj.base.util.file.c();
            cVar.d(new File(string));
            this.f20807o.setVisibility(8);
            W(cVar);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f20804l = (PDFView) c(2131232449);
        this.f20807o = (NumberProgressBar) c(2131232412);
        this.f20805m = (TextView) c(2131233068);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131427449;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Disposable disposable = this.f20810r;
        if (disposable != null && !disposable.isDisposed()) {
            this.f20810r.dispose();
        }
        super.onDestroy();
    }
}
