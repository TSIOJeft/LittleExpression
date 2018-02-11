package com.fan.littleexpression.pages;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.fan.littleexpression.R;
import com.fan.littleexpression.adapter.RecyclerviewAdapter;
import com.fan.littleexpression.data.Share;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static com.fan.littleexpression.data.AssetsFileName.getFileName;
import static com.fan.littleexpression.data.Images.getImages;
import static com.fan.littleexpression.data.RequestPermission.checkPermission;
import static com.fan.littleexpression.data.SaveBit.save;

/**
 * Created by Fan on 2018/2/2.
 */

public class Page3 extends Fragment {
    private ArrayList<BitmapDrawable> data3 = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private String pathname="xmr";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.expression, container, false);
        layoutInflater = getLayoutInflater();
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        RecyclerviewAdapter adapter = new RecyclerviewAdapter(getContext(), data3);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        final GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 4);
        recyclerView.setLayoutManager(layoutManager);
        new Thread() {
            @Override
            public void run() {
                data3.clear();
                data3.addAll(getImages(getContext(), pathname));
                recyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.getAdapter().notifyDataSetChanged();
                    }
                });
            }
        }.start();
        adapter.setOnRecyclerViewClickListener(new RecyclerviewAdapter.OnRecyclerViewClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void OnItemClick(View view, final int p) {
                View dialog_view = layoutInflater.inflate(R.layout.image_view, null);
                ImageView image_dialog = (ImageView) dialog_view.findViewById(R.id.image_dialog);
                image_dialog.setImageDrawable(data3.get(p));
                final String[] names = getFileName(getContext(), pathname);
                new MaterialDialog.Builder(getActivity())
                        .title(names[p])
                        .customView(dialog_view, false)
                        .positiveColor(getActivity().getColor(R.color.colorAccent))
                        .positiveText(getString(R.string.dialog_button))
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                Intent intent = new Share().shareImage(getContext(), pathname, p);
                                startActivity(Intent.createChooser(intent, getString(R.string.intent_mes)));
                            }
                        })
                        .neutralText(getString(R.string.dialog_save))
                        .onNeutral(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                if (checkPermission(getActivity())) {
                                    save(data3.get(p), names[p], getActivity());
                                }
                                ;
                            }
                        })
                        .show();
            }

            @Override
            public void OnItemLongClick(View v, int p) {

            }
        });
        adapter.notifyDataSetChanged();
        return view;

    }

//    private boolean getAssetsImage() {
//        Context context = getContext();
//        if (context != null && data.isEmpty()) {
//            try {
//                AssetManager assets = context.getAssets();
//                String[] xmrs = assets.list("xmr");
//                for (String xmr : xmrs) {
//                    InputStream image = assets.open("xmr/" + xmr);
//
//                    data.add(new BitmapDrawable(context.getResources(), image));
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return false;
//
//    }
}
