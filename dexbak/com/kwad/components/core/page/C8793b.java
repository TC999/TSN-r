package com.kwad.components.core.page;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.page.p321c.C8799a;
import com.kwad.components.core.page.p321c.C8826b;
import com.kwad.components.core.page.recycle.AbstractC8845a;
import com.kwad.components.core.page.recycle.AbstractC8849d;
import com.kwad.components.core.page.recycle.C8848c;
import com.kwad.components.core.page.recycle.C8850e;
import com.kwad.components.core.page.recycle.DetailWebRecycleView;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p445n.C10887l;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.page.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8793b extends AbstractC8845a {

    /* renamed from: NY */
    private WebView f28527NY;

    /* renamed from: NZ */
    private FeedVideoView f28528NZ;

    /* renamed from: Oa */
    private LinearLayout f28529Oa;

    /* renamed from: Ob */
    private TextView f28530Ob;

    /* renamed from: Oc */
    private ImageView f28531Oc;
    private AdTemplate mAdTemplate;
    private C8619c mApkDownloadHelper;

    /* renamed from: com.kwad.components.core.page.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C8796a extends AbstractC8849d {

        /* renamed from: Of */
        C8850e f28535Of;
        AdTemplate mAdTemplate;
        private Context mContext;

        C8796a(AdTemplate adTemplate, Context context, C8850e c8850e) {
            this.mAdTemplate = adTemplate;
            this.mContext = context;
            this.f28535Of = c8850e;
        }

        @Override // com.kwad.components.core.page.recycle.AbstractC8849d, androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public final void onBindViewHolder(C8848c c8848c, int i) {
            super.onBindViewHolder(c8848c, i);
        }

        @Override // com.kwad.components.core.page.recycle.AbstractC8849d
        /* renamed from: b */
        public final C8848c mo29742b(ViewGroup viewGroup, int i) {
            if (i == 1) {
                View m24563a = C10887l.m24563a(this.mContext, C9659R.C9663layout.ksad_datail_webview_container, viewGroup, false);
                Presenter presenter = new Presenter();
                presenter.m24612a(new C8826b());
                return new C8848c(m24563a, presenter, this.f28535Of);
            } else if (i == 0) {
                FeedVideoView feedVideoView = new FeedVideoView(viewGroup.getContext());
                Presenter presenter2 = new Presenter();
                presenter2.m24612a(new C8799a());
                return new C8848c(feedVideoView, presenter2, this.f28535Of);
            } else {
                View view = new View(viewGroup.getContext());
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, C10751a.m24924a(viewGroup.getContext(), 64.0f)));
                return new C8848c(view, new Presenter(), this.f28535Of);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return C10483a.m25956aF(C10487e.m25641dQ(this.mAdTemplate)) ? 3 : 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int i) {
            return i;
        }
    }

    /* renamed from: ar */
    public static C8793b m29842ar(AdTemplate adTemplate) {
        C8793b c8793b = new C8793b();
        Bundle bundle = new Bundle();
        bundle.putString("key_photo", adTemplate.toJson().toString());
        bundle.putBoolean("key_report", adTemplate.mPvReported);
        c8793b.setArguments(bundle);
        return c8793b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public void m29841w(View view) {
        this.f28529Oa = (LinearLayout) view.findViewById(C9659R.C9662id.ksad_web_tip_bar);
        this.f28530Ob = (TextView) view.findViewById(C9659R.C9662id.ksad_web_tip_bar_textview);
        ImageView imageView = (ImageView) view.findViewById(C9659R.C9662id.ksad_web_tip_close_btn);
        this.f28531Oc = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.b.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C8793b.this.f28529Oa.setVisibility(8);
            }
        });
        AdInfo m25641dQ = C10487e.m25641dQ(this.mAdTemplate);
        boolean m25857bw = C10483a.m25857bw(m25641dQ);
        String m25861bs = C10483a.m25861bs(m25641dQ);
        if (m25857bw) {
            this.f28529Oa.setVisibility(0);
            this.f28530Ob.setText(m25861bs);
            this.f28530Ob.setSelected(true);
            return;
        }
        this.f28529Oa.setVisibility(8);
    }

    @Override // com.kwad.components.core.proxy.C8888e, com.kwad.sdk.p443m.p444a.InterfaceC10861b
    public final boolean onBackPressed() {
        WebView webView = this.f28527NY;
        if (webView != null && webView.canGoBack()) {
            this.f28527NY.goBack();
            return true;
        }
        FeedVideoView feedVideoView = this.f28528NZ;
        if (feedVideoView != null) {
            return feedVideoView.m28936tq();
        }
        return false;
    }

    @Override // com.kwad.components.core.proxy.C8888e, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String string = getArguments().getString("key_photo");
        AdTemplate adTemplate = new AdTemplate();
        if (string != null) {
            try {
                adTemplate.parseJson(new JSONObject(string));
            } catch (JSONException e) {
                C10331c.printStackTrace(e);
            }
        }
        this.mAdTemplate = adTemplate;
        adTemplate.mPvReported = getArguments().getBoolean("key_report", false);
        this.mAdTemplate.mAdWebVideoPageShowing = true;
    }

    @Override // com.kwad.components.core.page.recycle.AbstractC8845a, com.kwad.components.core.proxy.C8888e, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroy() {
        super.onDestroy();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.mAdWebVideoPageShowing = false;
        }
    }

    @Override // com.kwad.components.core.page.recycle.AbstractC8845a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        final DetailWebRecycleView detailWebRecycleView = (DetailWebRecycleView) m29751pL();
        detailWebRecycleView.setInterceptRequestFocusForWeb(true);
        detailWebRecycleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.components.core.page.b.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                if (detailWebRecycleView.getChildCount() > 0) {
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = detailWebRecycleView.findViewHolderForAdapterPosition(0);
                    int height = findViewHolderForAdapterPosition.itemView.getHeight();
                    C10331c.m26254d("AdRecycleWebFragment", "recycleView.setTopViewHeight(" + height + ")");
                    detailWebRecycleView.setTopViewHeight(findViewHolderForAdapterPosition.itemView.getHeight());
                    View view2 = detailWebRecycleView.findViewHolderForAdapterPosition(0).itemView;
                    if (view2 instanceof FeedVideoView) {
                        C8793b.this.f28528NZ = (FeedVideoView) view2;
                    }
                }
                if (detailWebRecycleView.getChildCount() > 1) {
                    View view3 = detailWebRecycleView.findViewHolderForAdapterPosition(1).itemView;
                    C8793b.this.f28527NY = (WebView) view3.findViewById(C9659R.C9662id.ksad_video_webView);
                    C8793b.this.m29841w(view3);
                }
                C10331c.m26254d("AdRecycleWebFragment", "onGlobalLayout");
                detailWebRecycleView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    @Override // com.kwad.components.core.proxy.C8888e
    /* renamed from: pc */
    public final int mo29671pc() {
        return C9659R.C9663layout.ksad_detail_webview;
    }

    public final void setApkDownloadHelper(C8619c c8619c) {
        this.mApkDownloadHelper = c8619c;
    }

    @Override // com.kwad.components.core.page.recycle.AbstractC8845a
    /* renamed from: a */
    public final AbstractC8849d mo29754a(RecyclerView recyclerView) {
        return new C8796a(this.mAdTemplate, recyclerView.getContext(), new C8850e(this.mAdTemplate, this.mApkDownloadHelper, recyclerView));
    }
}
