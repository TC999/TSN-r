package com.bxkj.base.p085v2.common.utils;

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
import com.bxkj.base.C3801R;
import com.bxkj.base.p085v2.common.ext.PermissionExt;
import com.kuaishou.weapon.p205p0.C7304t;
import com.orhanobut.logger.C11792j;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import master.flame.danmaku.danmaku.parser.IDataSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p618m.StartActivityForResult;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ,\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J,\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J,\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002J\"\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00152\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\"\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\"\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00152\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\"\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\"\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00152\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¨\u0006 "}, m12616d2 = {"Lcom/bxkj/base/v2/common/utils/k;", "", "Landroid/content/Context;", "mContext", "Lm/b;", "startActivityForResult", "Lkotlin/Function1;", "Ljava/io/File;", "Lkotlin/f1;", "callback", "g", "", "o", "k", "Landroid/net/Uri;", "uri", "context", "", "n", IDataSource.f43973c, "j", "Landroidx/fragment/app/FragmentActivity;", "p", "Landroidx/fragment/app/Fragment;", "fragment", "h", "fragmentActivity", "i", C7304t.f25048d, "m", "<init>", "()V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.common.utils.k */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class ImageSelectUtils {
    @NotNull

    /* renamed from: a */
    public static final ImageSelectUtils f15123a = new ImageSelectUtils();

    /* compiled from: ImageSelectUtils.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/base/v2/common/utils/k$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.common.utils.k$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3966a implements StartActivityForResult.InterfaceC15293a {

        /* renamed from: a */
        final /* synthetic */ File f15124a;

        /* renamed from: b */
        final /* synthetic */ Context f15125b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC15280l<File, Unit> f15126c;

        /* JADX WARN: Multi-variable type inference failed */
        C3966a(File file, Context context, InterfaceC15280l<? super File, Unit> interfaceC15280l) {
            this.f15124a = file;
            this.f15125b = context;
            this.f15126c = interfaceC15280l;
        }

        @Override // p618m.StartActivityForResult.InterfaceC15293a
        /* renamed from: a */
        public void mo3459a(int i, @Nullable Intent intent) {
            File file = this.f15124a;
            if (!(i == -1)) {
                file = null;
            }
            if (file == null) {
                return;
            }
            ImageSelectUtils imageSelectUtils = ImageSelectUtils.f15123a;
            File file2 = imageSelectUtils.m43787o() ? file : null;
            if (file2 == null) {
                return;
            }
            imageSelectUtils.m43792j(this.f15125b, file2, this.f15126c);
        }
    }

    /* compiled from: ImageSelectUtils.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\n"}, m12616d2 = {"com/bxkj/base/v2/common/utils/k$b", "Ltop/zibin/luban/d;", "Lkotlin/f1;", "onStart", "Ljava/io/File;", IDataSource.f43973c, "onSuccess", "", "e", "onError", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.common.utils.k$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3967b implements OnCompressListener {

        /* renamed from: a */
        final /* synthetic */ InterfaceC15280l<File, Unit> f15127a;

        /* JADX WARN: Multi-variable type inference failed */
        C3967b(InterfaceC15280l<? super File, Unit> interfaceC15280l) {
            this.f15127a = interfaceC15280l;
        }

        @Override // top.zibin.luban.OnCompressListener
        public void onError(@NotNull Throwable e) {
            C14342f0.m8184p(e, "e");
            e.printStackTrace();
        }

        @Override // top.zibin.luban.OnCompressListener
        public void onStart() {
        }

        @Override // top.zibin.luban.OnCompressListener
        public void onSuccess(@NotNull File file) {
            C14342f0.m8184p(file, "file");
            C11792j.m20469d(C14342f0.m8216C("压缩文件路径", file.getAbsolutePath()), new Object[0]);
            this.f15127a.invoke(file);
        }
    }

    /* compiled from: ImageSelectUtils.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/base/v2/common/utils/k$c", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.common.utils.k$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3968c implements StartActivityForResult.InterfaceC15293a {

        /* renamed from: a */
        final /* synthetic */ Context f15128a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC15280l<File, Unit> f15129b;

        /* JADX WARN: Multi-variable type inference failed */
        C3968c(Context context, InterfaceC15280l<? super File, Unit> interfaceC15280l) {
            this.f15128a = context;
            this.f15129b = interfaceC15280l;
        }

        @Override // p618m.StartActivityForResult.InterfaceC15293a
        /* renamed from: a */
        public void mo3459a(int i, @Nullable Intent intent) {
            Uri data;
            if (intent == null) {
                return;
            }
            if (!(i == -1)) {
                intent = null;
            }
            if (intent == null || (data = intent.getData()) == null) {
                return;
            }
            Context context = this.f15128a;
            InterfaceC15280l<File, Unit> interfaceC15280l = this.f15129b;
            ImageSelectUtils imageSelectUtils = ImageSelectUtils.f15123a;
            String m43788n = imageSelectUtils.m43788n(data, context);
            if (m43788n == null) {
                return;
            }
            imageSelectUtils.m43792j(context, new File(m43788n), interfaceC15280l);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImageSelectUtils.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.common.utils.k$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3969d extends Lambda implements InterfaceC15269a<Unit> {

        /* renamed from: a */
        final /* synthetic */ FragmentActivity f15130a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC15280l<File, Unit> f15131b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C3969d(FragmentActivity fragmentActivity, InterfaceC15280l<? super File, Unit> interfaceC15280l) {
            super(0);
            this.f15130a = fragmentActivity;
            this.f15131b = interfaceC15280l;
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ImageSelectUtils.f15123a.m43793i(this.f15130a, this.f15131b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImageSelectUtils.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.common.utils.k$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3970e extends Lambda implements InterfaceC15269a<Unit> {

        /* renamed from: a */
        final /* synthetic */ FragmentActivity f15132a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC15280l<File, Unit> f15133b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C3970e(FragmentActivity fragmentActivity, InterfaceC15280l<? super File, Unit> interfaceC15280l) {
            super(0);
            this.f15132a = fragmentActivity;
            this.f15133b = interfaceC15280l;
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ImageSelectUtils.f15123a.m43789m(this.f15132a, this.f15133b);
        }
    }

    private ImageSelectUtils() {
    }

    /* renamed from: g */
    private final void m43795g(Context context, StartActivityForResult startActivityForResult, InterfaceC15280l<? super File, Unit> interfaceC15280l) {
        Uri uriForFile;
        if (m43787o()) {
            File file = null;
            if (C14342f0.m8193g("mounted", Environment.getExternalStorageState()) && (((file = context.getExternalCacheDir()) == null || !file.exists()) && file != null)) {
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
                C14342f0.m8185o(uriForFile, "{\n                      …le)\n                    }");
            } else {
                uriForFile = FileProvider.getUriForFile(context, "com.bxkj.student.provider", file3);
                C14342f0.m8185o(uriForFile, "{\n                      …le)\n                    }");
            }
            Intent intent = new Intent();
            intent.putExtra("output", uriForFile);
            intent.setAction("android.media.action.IMAGE_CAPTURE");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(1);
            startActivityForResult.startActivityForResult(intent).m3460c(new C3966a(file3, context, interfaceC15280l));
            return;
        }
        Toast.makeText(context, "未找到存储卡，无法拍照！", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public final void m43792j(Context context, File file, InterfaceC15280l<? super File, Unit> interfaceC15280l) {
        Luban.m288k(context).m282f(file).m280h(new C3967b(interfaceC15280l)).m283e();
    }

    /* renamed from: k */
    private final void m43791k(Context context, StartActivityForResult startActivityForResult, InterfaceC15280l<? super File, Unit> interfaceC15280l) {
        startActivityForResult.startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI)).m3460c(new C3968c(context, interfaceC15280l));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public final String m43788n(Uri uri, Context context) {
        Cursor query = context.getContentResolver().query(uri, null, null, null, null);
        if (query == null) {
            return null;
        }
        int columnIndex = query.getColumnIndex("_display_name");
        int columnIndex2 = query.getColumnIndex("_size");
        query.moveToFirst();
        String string = query.getString(columnIndex);
        C14342f0.m8185o(string, "returnCursor.getString(nameIndex)");
        String.valueOf(query.getLong(columnIndex2));
        File file = new File(context.getFilesDir(), string);
        try {
            try {
                InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                C14342f0.m8187m(openInputStream);
                byte[] bArr = new byte[Math.min(openInputStream.available(), 1048576)];
                while (true) {
                    int read = openInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                Log.e("File Size", C14342f0.m8216C("Size ", Long.valueOf(file.length())));
                openInputStream.close();
                fileOutputStream.close();
                Log.e("File Path", C14342f0.m8216C("Path ", file.getPath()));
                Log.e("File Size", C14342f0.m8216C("Size ", Long.valueOf(file.length())));
            } catch (Exception e) {
                String message = e.getMessage();
                C14342f0.m8187m(message);
                Log.e("Exception", message);
            }
            query.close();
            return file.getPath();
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public final boolean m43787o() {
        return C14342f0.m8193g(Environment.getExternalStorageState(), "mounted");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public static final void m43785q(Ref.ObjectRef dialog, View view) {
        C14342f0.m8184p(dialog, "$dialog");
        ((Dialog) dialog.element).dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public static final void m43784r(Ref.ObjectRef dialog, FragmentActivity mContext, InterfaceC15280l callback, View view) {
        C14342f0.m8184p(dialog, "$dialog");
        C14342f0.m8184p(mContext, "$mContext");
        C14342f0.m8184p(callback, "$callback");
        ((Dialog) dialog.element).dismiss();
        PermissionExt.m43841c(mContext, "拍照", new C3969d(mContext, callback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public static final void m43783s(Ref.ObjectRef dialog, FragmentActivity mContext, InterfaceC15280l callback, View view) {
        C14342f0.m8184p(dialog, "$dialog");
        C14342f0.m8184p(mContext, "$mContext");
        C14342f0.m8184p(callback, "$callback");
        ((Dialog) dialog.element).dismiss();
        PermissionExt.m43836h(mContext, null, new C3970e(mContext, callback), 1, null);
    }

    /* renamed from: h */
    public final void m43794h(@NotNull Fragment fragment, @NotNull InterfaceC15280l<? super File, Unit> callback) {
        C14342f0.m8184p(fragment, "fragment");
        C14342f0.m8184p(callback, "callback");
        FragmentActivity requireActivity = fragment.requireActivity();
        C14342f0.m8185o(requireActivity, "fragment.requireActivity()");
        m43795g(requireActivity, new StartActivityForResult(fragment), callback);
    }

    /* renamed from: i */
    public final void m43793i(@NotNull FragmentActivity fragmentActivity, @NotNull InterfaceC15280l<? super File, Unit> callback) {
        C14342f0.m8184p(fragmentActivity, "fragmentActivity");
        C14342f0.m8184p(callback, "callback");
        m43795g(fragmentActivity, new StartActivityForResult(fragmentActivity), callback);
    }

    /* renamed from: l */
    public final void m43790l(@NotNull Fragment fragment, @NotNull InterfaceC15280l<? super File, Unit> callback) {
        C14342f0.m8184p(fragment, "fragment");
        C14342f0.m8184p(callback, "callback");
        FragmentActivity requireActivity = fragment.requireActivity();
        C14342f0.m8185o(requireActivity, "fragment.requireActivity()");
        m43791k(requireActivity, new StartActivityForResult(fragment), callback);
    }

    /* renamed from: m */
    public final void m43789m(@NotNull FragmentActivity fragmentActivity, @NotNull InterfaceC15280l<? super File, Unit> callback) {
        C14342f0.m8184p(fragmentActivity, "fragmentActivity");
        C14342f0.m8184p(callback, "callback");
        m43791k(fragmentActivity, new StartActivityForResult(fragmentActivity), callback);
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [T, android.app.Dialog] */
    /* renamed from: p */
    public final void m43786p(@NotNull final FragmentActivity mContext, @NotNull final InterfaceC15280l<? super File, Unit> callback) {
        C14342f0.m8184p(mContext, "mContext");
        C14342f0.m8184p(callback, "callback");
        View inflate = LayoutInflater.from(mContext).inflate(C3801R.C3807layout.pub_dialog_add_picture, (ViewGroup) null);
        View findViewById = inflate.findViewById(C3801R.C3805id.tv_camera);
        if (findViewById != null) {
            TextView textView = (TextView) findViewById;
            View findViewById2 = inflate.findViewById(C3801R.C3805id.tv_gallery);
            if (findViewById2 != null) {
                TextView textView2 = (TextView) findViewById2;
                View findViewById3 = inflate.findViewById(C3801R.C3805id.tv_cancel);
                if (findViewById3 != null) {
                    TextView textView3 = (TextView) findViewById3;
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    ?? dialog = new Dialog(mContext, C3801R.C3810style.custom_dialog);
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
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ImageSelectUtils.m43785q(Ref.ObjectRef.this, view);
                        }
                    });
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.v2.common.utils.j
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ImageSelectUtils.m43784r(Ref.ObjectRef.this, mContext, callback, view);
                        }
                    });
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.v2.common.utils.i
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ImageSelectUtils.m43783s(Ref.ObjectRef.this, mContext, callback, view);
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
