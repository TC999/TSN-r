package com.bxkj.student.home.teaching.learning.detail.type;

import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.bxkj.base.util.file.C3895a;
import com.bxkj.base.util.file.C3898b;
import com.bxkj.base.util.file.FileVo;
import com.bxkj.base.util.file.RxUtils;
import com.bxkj.student.C4215R;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.daimajia.numberprogressbar.NumberProgressBar;
import com.github.barteksc.pdfviewer.PDFView;
import com.orhanobut.logger.C11792j;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.File;
import p611k0.OnLoadCompleteListener;
import p611k0.OnPageChangeListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PdfFragment extends BaseFragment {

    /* renamed from: h */
    private String f17457h;

    /* renamed from: i */
    private String f17458i;

    /* renamed from: j */
    private C3895a f17459j;

    /* renamed from: k */
    private File f17460k;

    /* renamed from: l */
    private PDFView f17461l;

    /* renamed from: m */
    private TextView f17462m;

    /* renamed from: n */
    private FrameLayout f17463n;

    /* renamed from: o */
    private NumberProgressBar f17464o;

    /* renamed from: p */
    private String f17465p = "";

    /* renamed from: q */
    private String f17466q = "";

    /* renamed from: r */
    private Disposable f17467r;

    /* renamed from: s */
    private InterfaceC4672b f17468s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.detail.type.PdfFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4671a implements C3895a.InterfaceC3897b {

        /* renamed from: a */
        final /* synthetic */ FileVo f17469a;

        /* renamed from: b */
        final /* synthetic */ ObservableEmitter f17470b;

        C4671a(final FileVo val$fileVo, final ObservableEmitter val$e) {
            this.f17469a = val$fileVo;
            this.f17470b = val$e;
        }

        @Override // com.bxkj.base.util.file.C3895a.InterfaceC3897b
        /* renamed from: a */
        public void mo41648a(File file) {
            this.f17469a.m44097d(file);
            this.f17470b.onNext(this.f17469a);
            this.f17470b.onComplete();
        }

        @Override // com.bxkj.base.util.file.C3895a.InterfaceC3897b
        /* renamed from: b */
        public void mo41647b(int progress) {
            Log.d("当前下载的进度", "" + progress);
            PdfFragment.this.m41649c0(progress);
        }

        @Override // com.bxkj.base.util.file.C3895a.InterfaceC3897b
        /* renamed from: c */
        public void mo41646c(Exception e) {
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.learning.detail.type.PdfFragment$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC4672b {
        void onSuccess();
    }

    /* renamed from: T */
    private void m41658T() {
        this.f17467r = Observable.create(new ObservableOnSubscribe() { // from class: com.bxkj.student.home.teaching.learning.detail.type.a
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                PdfFragment.this.m41656V(observableEmitter);
            }
        }).compose(RxUtils.m44091d()).subscribe(new Consumer() { // from class: com.bxkj.student.home.teaching.learning.detail.type.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PdfFragment.this.m41655W((FileVo) obj);
            }
        });
    }

    /* renamed from: U */
    private void m41657U(String url) {
        this.f17465p = url;
        this.f17466q = "aa." + C3898b.m44102i(this.f17465p);
        this.f17459j = C3895a.m44111b();
        m41658T();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public /* synthetic */ void m41656V(ObservableEmitter observableEmitter) throws Exception {
        FileVo fileVo = new FileVo();
        this.f17459j.m44112a(this.f17465p, C3898b.m44106e(this.f1678e), this.f17466q, new C4671a(fileVo, observableEmitter));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X */
    public /* synthetic */ void m41654X(int i, int i2) {
        TextView textView = this.f17462m;
        textView.setText((i + 1) + "/" + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y */
    public /* synthetic */ void m41653Y(int i) {
        InterfaceC4672b interfaceC4672b = this.f17468s;
        if (interfaceC4672b != null) {
            interfaceC4672b.onSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z */
    public /* synthetic */ void m41652Z(int i, Integer num) throws Exception {
        this.f17464o.setProgress(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0 */
    public void m41655W(FileVo fileVo) {
        try {
            NumberProgressBar numberProgressBar = this.f17464o;
            if (numberProgressBar != null) {
                numberProgressBar.setProgress(fileVo.m44099b());
                this.f17464o.setVisibility(8);
            }
            this.f17460k = fileVo.m44100a();
            C11792j.m20470c("file.getName().toLowerCase()=" + this.f17460k.getName().toLowerCase());
            if (this.f17460k.getName().toLowerCase().endsWith("pdf")) {
                this.f17461l.m35428z(this.f17460k).m35426B(10).m35408q(new OnPageChangeListener() { // from class: com.bxkj.student.home.teaching.learning.detail.type.e
                    @Override // p611k0.OnPageChangeListener
                    /* renamed from: a */
                    public final void mo12633a(int i, int i2) {
                        PdfFragment.this.m41654X(i, i2);
                    }
                }).m35410o(new OnLoadCompleteListener() { // from class: com.bxkj.student.home.teaching.learning.detail.type.d
                    @Override // p611k0.OnLoadCompleteListener
                    /* renamed from: a */
                    public final void mo12634a(int i) {
                        PdfFragment.this.m41653Y(i);
                    }
                }).m35415j();
                return;
            }
            iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(this.f1678e);
            iosonebuttondialog.setMessage("暂不支持当前文件类型【" + C3898b.m44102i(this.f17460k.getPath()) + "】请联系管理员").show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c0 */
    public void m41649c0(final int progress) {
        Observable.just(Integer.valueOf(progress)).compose(RxUtils.m44091d()).subscribe(new Consumer() { // from class: com.bxkj.student.home.teaching.learning.detail.type.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PdfFragment.this.m41652Z(progress, (Integer) obj);
            }
        });
    }

    /* renamed from: a0 */
    public void m41651a0(InterfaceC4672b loadOfficeListener) {
        this.f17468s = loadOfficeListener;
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: b */
    public void mo39445b() {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: e */
    public void mo39444e() {
        if (getArguments().containsKey("url")) {
            m41657U(getArguments().getString("url"));
        } else if (getArguments().containsKey(TTDownloadField.TT_FILE_PATH)) {
            String string = getArguments().getString(TTDownloadField.TT_FILE_PATH);
            FileVo fileVo = new FileVo();
            fileVo.m44097d(new File(string));
            this.f17464o.setVisibility(8);
            m41655W(fileVo);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: f */
    protected void mo39443f(View view) {
        this.f17461l = (PDFView) m57916c(C4215R.C4219id.pdfView);
        this.f17464o = (NumberProgressBar) m57916c(C4215R.C4219id.number_progress_bar);
        this.f17462m = (TextView) m57916c(C4215R.C4219id.tv_page);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: i */
    protected int mo39442i() {
        return C4215R.C4221layout.ac_pdf_reader;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Disposable disposable = this.f17467r;
        if (disposable != null && !disposable.isDisposed()) {
            this.f17467r.dispose();
        }
        super.onDestroy();
    }
}
