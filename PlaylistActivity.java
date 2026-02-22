package com.tflix.live;

import B0.f;
import H5.A;
import H5.C;
import H5.D;
import H5.E;
import H5.h;
import H5.u;
import H5.v;
import H5.w;
import H5.x;
import H5.y;
import H5.z;
import I5.r;
import P5.g;
import Q5.b;
import Y5.j;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.bumptech.glide.c;
import com.google.android.gms.internal.measurement.K1;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tflix.live.app.ProApplication;
import g.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class PlaylistActivity extends k {
    public static final /* synthetic */ int a0 = 0;
    public f U;
    public r V;
    public ArrayList W;
    public N5.k X;
    public ProApplication Y;
    public final x Z = new x(this);

    public static void r(PlaylistActivity playlistActivity, String str) {
        if (str == null) {
            return;
        }
        if (((FragmentContainerView) playlistActivity.U.c).getVisibility() == 0) {
            playlistActivity.X.U(str);
            return;
        }
        if (playlistActivity.W != null) {
            if (TextUtils.isEmpty(str)) {
                r rVar = playlistActivity.V;
                ArrayList arrayList = playlistActivity.W;
                rVar.getClass();
                rVar.f = new ArrayList(arrayList);
                rVar.d();
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = playlistActivity.W.iterator();
            while (it.hasNext()) {
                g gVar = (g) it.next();
                String str2 = gVar.a;
                if (str2 != null && str2.toLowerCase().contains(str.toLowerCase())) {
                    arrayList2.add(gVar);
                }
            }
            r rVar2 = playlistActivity.V;
            rVar2.getClass();
            rVar2.f = new ArrayList(arrayList2);
            rVar2.d();
        }
    }

    public final void onCreate(Bundle bundle) {
        FragmentContainerView h;
        SwipeRefreshLayout h2;
        RecyclerView h3;
        Toolbar h4;
        TextView h5;
        super.onCreate(bundle);
        CoordinatorLayout inflate = getLayoutInflater().inflate(D.activity_playlist, (ViewGroup) null, false);
        int r0 = C.add_playlist;
        FloatingActionButton h6 = K1.h(inflate, r0);
        if (h6 != null && (h = K1.h(inflate, (r0 = C.fragment_container))) != null) {
            r0 = C.main_toolbar_layout;
            if (K1.h(inflate, r0) != null && (h2 = K1.h(inflate, (r0 = C.playlist_refresh_layout))) != null && (h3 = K1.h(inflate, (r0 = C.recycler_view))) != null && (h4 = K1.h(inflate, (r0 = C.toolbar))) != null && (h5 = K1.h(inflate, (r0 = C.toolbar_title))) != null) {
                r0 = C.toolbar_title_layout;
                if (K1.h(inflate, r0) != null) {
                    CoordinatorLayout coordinatorLayout = inflate;
                    this.U = new f(coordinatorLayout, h6, h, h2, h3, h4, h5, 2);
                    setContentView((View) coordinatorLayout);
                    ((SwipeRefreshLayout) this.U.d).setRefreshing(true);
                    this.Y = (ProApplication) getApplication();
                    j().a(this, this.Z);
                    q((Toolbar) this.U.f);
                    c p = p();
                    Objects.requireNonNull(p);
                    p.E();
                    p().D(true);
                    ((Toolbar) this.U.f).setNavigationOnClickListener(new u(this, 0));
                    ((Toolbar) this.U.f).setTitleTextColor(-1);
                    s();
                    ((FloatingActionButton) this.U.b).setOnClickListener(new u(this, 1));
                    ((SwipeRefreshLayout) this.U.d).setOnRefreshListener(new v(this));
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(r0)));
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(E.menu_buttons, menu);
        menu.findItem(C.favorites).setVisible(false);
        MenuItem findItem = menu.findItem(C.donate);
        Drawable drawable = getDrawable(A.donate);
        if (drawable != null) {
            int dimension = (int) getResources().getDimension(z.menu_icon_size);
            Bitmap createBitmap = Bitmap.createBitmap(dimension, dimension, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, dimension, dimension);
            drawable.draw(canvas);
            findItem.setIcon(new BitmapDrawable(getResources(), createBitmap));
        }
        findItem.setOnMenuItemClickListener(new h(this, 2));
        MenuItem findItem2 = menu.findItem(C.search);
        findItem2.setOnActionExpandListener(new w(0, this, findItem));
        SearchView actionView = findItem2.getActionView();
        SearchView.SearchAutoComplete findViewById = actionView.findViewById(f.f.search_src_text);
        findViewById.setHintTextColor(getColor(y.gray_77));
        findViewById.setTextColor(-1);
        actionView.setQueryHint("Search..");
        actionView.setOnQueryTextListener(new t5.c(15, this));
        return super.onCreateOptionsMenu(menu);
    }

    public final void onPause() {
        this.Y.H = null;
        super.onPause();
    }

    public final void onResume() {
        super.onResume();
        b.a(this);
    }

    public final void s() {
        ArrayList q = j.q(this);
        this.W = q;
        r rVar = this.V;
        if (rVar == null) {
            r rVar2 = new r(this, q, new t2.c(15, this));
            this.V = rVar2;
            ((RecyclerView) this.U.e).setAdapter(rVar2);
            ((RecyclerView) this.U.e).setLayoutManager(new LinearLayoutManager(1));
        } else {
            rVar.f = new ArrayList(q);
            rVar.d();
            ((RecyclerView) this.U.e).k0(0);
        }
        ((SwipeRefreshLayout) this.U.d).setRefreshing(false);
    }
}
