package com.bxkj.base.v2.common.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bxkj.base.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import m.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImageSelectUtils.kt */
@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ,\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J,\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J,\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002J\"\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00152\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\"\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\"\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00152\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\"\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\"\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00152\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a8\u0006 "}, d2 = {"Lcom/bxkj/base/v2/common/utils/k;", "", "Landroid/content/Context;", "mContext", "Lm/b;", "startActivityForResult", "Lkotlin/Function1;", "Ljava/io/File;", "Lkotlin/f1;", "callback", "g", "", "o", "k", "Landroid/net/Uri;", "uri", "context", "", "n", "file", "j", "Landroidx/fragment/app/FragmentActivity;", "p", "Landroidx/fragment/app/Fragment;", "fragment", "h", "fragmentActivity", "i", "l", "m", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class k {
    @NotNull

    /* renamed from: a */
    public static final k f18613a = new k();

    /* compiled from: ImageSelectUtils.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/base/v2/common/utils/k$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a implements b.a {

        /* renamed from: a */
        final /* synthetic */ File f18614a;

        /* renamed from: b */
        final /* synthetic */ Context f18615b;

        /* renamed from: c */
        final /* synthetic */ l1.l<File, f1> f18616c;

        /* JADX WARN: Multi-variable type inference failed */
        a(File file, Context context, l1.l<? super File, f1> lVar) {
            this.f18614a = file;
            this.f18615b = context;
            this.f18616c = lVar;
        }

        @Override // m.b.a
        public void a(int i4, @Nullable Intent intent) {
            File file = this.f18614a;
            if (!(i4 == -1)) {
                file = null;
            }
            if (file == null) {
                return;
            }
            k kVar = k.f18613a;
            File file2 = kVar.o() ? file : null;
            if (file2 == null) {
                return;
            }
            kVar.j(this.f18615b, file2, this.f18616c);
        }
    }

    /* compiled from: ImageSelectUtils.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/bxkj/base/v2/common/utils/k$b", "Ltop/zibin/luban/d;", "Lkotlin/f1;", "onStart", "Ljava/io/File;", "file", "onSuccess", "", "e", "onError", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b implements top.zibin.luban.d {

        /* renamed from: a */
        final /* synthetic */ l1.l<File, f1> f18617a;

        /* JADX WARN: Multi-variable type inference failed */
        b(l1.l<? super File, f1> lVar) {
            this.f18617a = lVar;
        }

        @Override // top.zibin.luban.d
        public void onError(@NotNull Throwable e4) {
            f0.p(e4, "e");
            e4.printStackTrace();
        }

        @Override // top.zibin.luban.d
        public void onStart() {
        }

        @Override // top.zibin.luban.d
        public void onSuccess(@NotNull File file) {
            f0.p(file, "file");
            com.orhanobut.logger.j.d(f0.C("\u538b\u7f29\u6587\u4ef6\u8def\u5f84", file.getAbsolutePath()), new Object[0]);
            this.f18617a.invoke(file);
        }
    }

    /* compiled from: ImageSelectUtils.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/base/v2/common/utils/k$c", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class c implements b.a {

        /* renamed from: a */
        final /* synthetic */ Context f18618a;

        /* renamed from: b */
        final /* synthetic */ l1.l<File, f1> f18619b;

        /* JADX WARN: Multi-variable type inference failed */
        c(Context context, l1.l<? super File, f1> lVar) {
            this.f18618a = context;
            this.f18619b = lVar;
        }

        @Override // m.b.a
        public void a(int i4, @Nullable Intent intent) {
            Uri data;
            if (intent == null) {
                return;
            }
            if (!(i4 == -1)) {
                intent = null;
            }
            if (intent == null || (data = intent.getData()) == null) {
                return;
            }
            Context context = this.f18618a;
            l1.l<File, f1> lVar = this.f18619b;
            k kVar = k.f18613a;
            String n4 = kVar.n(data, context);
            if (n4 == null) {
                return;
            }
            kVar.j(context, new File(n4), lVar);
        }
    }

    /* compiled from: ImageSelectUtils.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class d extends Lambda implements l1.a<f1> {

        /* renamed from: a */
        final /* synthetic */ FragmentActivity f18620a;

        /* renamed from: b */
        final /* synthetic */ l1.l<File, f1> f18621b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(FragmentActivity fragmentActivity, l1.l<? super File, f1> lVar) {
            super(0);
            this.f18620a = fragmentActivity;
            this.f18621b = lVar;
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m56invoke();
            return f1.f55527a;
        }

        /* renamed from: invoke */
        public final void m56invoke() {
            k.f18613a.i(this.f18620a, this.f18621b);
        }
    }

    /* compiled from: ImageSelectUtils.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class e extends Lambda implements l1.a<f1> {

        /* renamed from: a */
        final /* synthetic */ FragmentActivity f18622a;

        /* renamed from: b */
        final /* synthetic */ l1.l<File, f1> f18623b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        e(FragmentActivity fragmentActivity, l1.l<? super File, f1> lVar) {
            super(0);
            this.f18622a = fragmentActivity;
            this.f18623b = lVar;
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m57invoke();
            return f1.f55527a;
        }

        /* renamed from: invoke */
        public final void m57invoke() {
            k.f18613a.m(this.f18622a, this.f18623b);
        }
    }

    private k() {
    }

    public static /* synthetic */ void a(Ref.ObjectRef objectRef, View view) {
        q(objectRef, view);
    }

    private final void g(Context context, m.b bVar, l1.l<? super File, f1> lVar) {
        Uri uriForFile;
        if (o()) {
            File file = null;
            if (f0.g("mounted", Environment.getExternalStorageState()) && (((file = context.getExternalCacheDir()) == null || !file.exists()) && file != null)) {
                file.mkdirs();
            }
            if (file == null || !file.exists()) {
                file = context.getCacheDir();
                if (!file.exists()) {
                    file.mkdirs();
                }
            }
            File file2 = new File(file, "temp");
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(file2, System.currentTimeMillis() + "_temp_photo.jpg");
            if (Build.VERSION.SDK_INT < 24) {
                uriForFile = Uri.fromFile(file3);
                f0.o(uriForFile, "{\n                      \u2026le)\n                    }");
            } else {
                uriForFile = FileProvider.getUriForFile(context, "com.bxkj.student.provider", file3);
                f0.o(uriForFile, "{\n                      \u2026le)\n                    }");
            }
            Intent intent = new Intent();
            intent.putExtra("output", uriForFile);
            intent.setAction("android.media.action.IMAGE_CAPTURE");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(1);
            bVar.startActivityForResult(intent).c(new a(file3, context, lVar));
            return;
        }
        Toast.makeText(context, "\u672a\u627e\u5230\u5b58\u50a8\u5361\uff0c\u65e0\u6cd5\u62cd\u7167\uff01", 0).show();
    }

    public final void j(Context context, File file, l1.l<? super File, f1> lVar) {
        top.zibin.luban.c.k(context).f(file).h(new b(lVar)).e();
    }

    private final void k(Context context, m.b bVar, l1.l<? super File, f1> lVar) {
        bVar.startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI)).c(new c(context, lVar));
    }

    public final String n(Uri uri, Context context) {
        Cursor query = context.getContentResolver().query(uri, null, null, null, null);
        if (query == null) {
            return null;
        }
        int columnIndex = query.getColumnIndex("_display_name");
        int columnIndex2 = query.getColumnIndex("_size");
        query.moveToFirst();
        String string = query.getString(columnIndex);
        f0.o(string, "returnCursor.getString(nameIndex)");
        String.valueOf(query.getLong(columnIndex2));
        File file = new File(context.getFilesDir(), string);
        try {
            try {
                InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                f0.m(openInputStream);
                byte[] bArr = new byte[Math.min(openInputStream.available(), 1048576)];
                while (true) {
                    int read = openInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                Log.e("File Size", f0.C("Size ", Long.valueOf(file.length())));
                openInputStream.close();
                fileOutputStream.close();
                Log.e("File Path", f0.C("Path ", file.getPath()));
                Log.e("File Size", f0.C("Size ", Long.valueOf(file.length())));
            } catch (Exception e4) {
                String message = e4.getMessage();
                f0.m(message);
                Log.e("Exception", message);
            }
            query.close();
            return file.getPath();
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }

    public final boolean o() {
        return f0.g(Environment.getExternalStorageState(), "mounted");
    }

    public static final void q(Ref.ObjectRef dialog, View view) {
        f0.p(dialog, "$dialog");
        ((Dialog) dialog.element).dismiss();
    }

    public static final void r(Ref.ObjectRef dialog, FragmentActivity mContext, l1.l callback, View view) {
        f0.p(dialog, "$dialog");
        f0.p(mContext, "$mContext");
        f0.p(callback, "$callback");
        ((Dialog) dialog.element).dismiss();
        com.bxkj.base.v2.common.ext.g.c(mContext, "\u62cd\u7167", new d(mContext, callback));
    }

    public static final void s(Ref.ObjectRef dialog, FragmentActivity mContext, l1.l callback, View view) {
        f0.p(dialog, "$dialog");
        f0.p(mContext, "$mContext");
        f0.p(callback, "$callback");
        ((Dialog) dialog.element).dismiss();
        com.bxkj.base.v2.common.ext.g.h(mContext, null, new e(mContext, callback), 1, null);
    }

    public final void h(@NotNull Fragment fragment, @NotNull l1.l<? super File, f1> callback) {
        f0.p(fragment, "fragment");
        f0.p(callback, "callback");
        FragmentActivity requireActivity = fragment.requireActivity();
        f0.o(requireActivity, "fragment.requireActivity()");
        g(requireActivity, new m.b(fragment), callback);
    }

    public final void i(@NotNull FragmentActivity fragmentActivity, @NotNull l1.l<? super File, f1> callback) {
        f0.p(fragmentActivity, "fragmentActivity");
        f0.p(callback, "callback");
        g(fragmentActivity, new m.b(fragmentActivity), callback);
    }

    public final void l(@NotNull Fragment fragment, @NotNull l1.l<? super File, f1> callback) {
        f0.p(fragment, "fragment");
        f0.p(callback, "callback");
        FragmentActivity requireActivity = fragment.requireActivity();
        f0.o(requireActivity, "fragment.requireActivity()");
        k(requireActivity, new m.b(fragment), callback);
    }

    public final void m(@NotNull FragmentActivity fragmentActivity, @NotNull l1.l<? super File, f1> callback) {
        f0.p(fragmentActivity, "fragmentActivity");
        f0.p(callback, "callback");
        k(fragmentActivity, new m.b(fragmentActivity), callback);
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [T, android.app.Dialog] */
    public final void p(@NotNull final FragmentActivity mContext, @NotNull final l1.l<? super File, f1> callback) {
        f0.p(mContext, "mContext");
        f0.p(callback, "callback");
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.pub_dialog_add_picture, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.tv_camera);
        if (findViewById != null) {
            TextView textView = (TextView) findViewById;
            View findViewById2 = inflate.findViewById(R.id.tv_gallery);
            if (findViewById2 != null) {
                TextView textView2 = (TextView) findViewById2;
                View findViewById3 = inflate.findViewById(R.id.tv_cancel);
                if (findViewById3 != null) {
                    TextView textView3 = (TextView) findViewById3;
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    ?? dialog = new Dialog(mContext, R.style.custom_dialog);
                    objectRef.element = dialog;
                    Dialog dialog2 = (Dialog) dialog;
                    dialog.setContentView(inflate);
                    Window window = ((Dialog) objectRef.element).getWindow();
                    if (window != null) {
                        window.setGravity(80);
                    }
                    Display defaultDisplay = mContext.getWindowManager().getDefaultDisplay();
                    Window window2 = ((Dialog) objectRef.element).getWindow();
                    WindowManager.LayoutParams attributes = window2 != null ? window2.getAttributes() : null;
                    if (attributes != null) {
                        attributes.width = defaultDisplay.getWidth();
                    }
                    Window window3 = ((Dialog) objectRef.element).getWindow();
                    if (window3 != null) {
                        window3.setAttributes(attributes);
                    }
                    ((Dialog) objectRef.element).show();
                    textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.v2.common.utils.h

                        /* compiled from: FileUtils.kt */
                        @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/bxkj/base/v2/common/utils/h$a;", "", "", "base64Code", "targetPath", "Ljava/io/File;", "a", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
                        /* loaded from: E:\TSN-r\205dec\4499832.dex */
                        public static final class a {
                            private a() {
                            }

                            public /* synthetic */ a(u uVar) {
                                this();
                            }

                            @NotNull
                            public final File a(@NotNull String base64Code, @NotNull String targetPath) {
                                f0.p(base64Code, "base64Code");
                                f0.p(targetPath, "targetPath");
                                try {
                                    try {
                                        byte[] a4 = cn.bluemobi.dylan.base.utils.b.a(base64Code);
                                        FileOutputStream fileOutputStream = new FileOutputStream(targetPath);
                                        fileOutputStream.write(a4);
                                        fileOutputStream.close();
                                        return new File(targetPath);
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                        return new File(targetPath);
                                    }
                                } catch (Throwable unused) {
                                    return new File(targetPath);
                                }
                            }
                        }

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            k.a(Ref.ObjectRef.this, view);
                        }
                    });
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.v2.common.utils.j
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            k.r(Ref.ObjectRef.this, mContext, callback, view);
                        }
                    });
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.v2.common.utils.i
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            k.s(Ref.ObjectRef.this, mContext, callback, view);
                        }
                    });
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }
}
