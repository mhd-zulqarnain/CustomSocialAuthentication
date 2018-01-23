package com.example.zulup.authenticationdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;


/**
 * Created by zulup on 1/22/2018.
 */

public class TwitterHomeFragment extends Fragment {
    private TextView textView;
    private Button btnLogout;
    private ImageView imageView;
    String userName;
    String imgUrl;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        userName = bundle.getString("username");
        imgUrl = bundle.getString("img_url");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = LayoutInflater.from(container.getContext()).inflate(R.layout.home_fragement_view, container, false);
        textView = v.findViewById(R.id.text_response);
        btnLogout = v.findViewById(R.id.fb_logout_btn);
        imageView = v.findViewById(R.id.prf_img);
//        imageView.setImageBitmap();
        textView.setText(userName);
        Picasso.with(container.getContext()).load(imgUrl).into(imageView);

        logout();

        return v;
    }

    private void logout() {
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TwitterCore.getInstance().getSessionManager().clearActiveSession();
                imageView.setImageBitmap(null);
                textView.setText("Session Destroy");

            }
        });
    }

}
