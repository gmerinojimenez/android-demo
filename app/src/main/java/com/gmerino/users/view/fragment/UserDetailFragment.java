package com.gmerino.users.view.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.domain.user.data.User;
import com.gmerino.users.R;
import com.gmerino.users.presenter.UserDetailPresenter;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/*
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

public class UserDetailFragment extends Fragment implements UserDetailView {

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";
    private static final int FADE_IN_TIME_MS = 1000;

    @InjectView(R.id.photo)
    ImageView photo;

    @InjectView(R.id.name)
    TextView name;

    @InjectView(R.id.gender)
    TextView gender;

    @InjectView(R.id.location)
    TextView location;

    @InjectView(R.id.date)
    TextView date;

    @InjectView(R.id.email)
    TextView email;

    @InjectView(R.id.container)
    LinearLayout container;

    @Inject
    UserDetailPresenter presenter;

    User currentUser = null;
    String userId = null;

    private FragmentInjector injector = new FragmentInjector(this);


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public UserDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter.setView(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_detail, container, false);
        ButterKnife.inject(this, rootView);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.

            presenter.loadUser(getArguments().getString(ARG_ITEM_ID));
        }

        return rootView;
    }

    @Override
    public void onUserLoaded(User user) {
        currentUser = user;
        loadData();
    }

    private void loadData() {
        if (currentUser != null) {
            name.setText(currentUser.getName().toString());
            gender.setText(currentUser.getGender());
            location.setText(currentUser.getLocation().toString());
            date.setText(currentUser.getRegistered());
            email.setText(currentUser.getEmail());

            loadPicture();
        }
    }

    private void loadPicture() {
        Target target = new Target() {

            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {

                TransitionDrawable td = new TransitionDrawable(new Drawable[]{
                        new ColorDrawable(android.R.color.transparent),
                        new BitmapDrawable(getActivity().getResources(), bitmap)
                });

                photo.setImageDrawable(td);
                td.startTransition(FADE_IN_TIME_MS);

//                photo.setImageBitmap(bitmap);
                generatePalette(bitmap);
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };

        Picasso.with(getActivity()).load(currentUser.getPicture().getLarge())
                .into(target);

    }

    private void generatePalette(Bitmap bitmap) {
        Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                if (palette != null) {
                    final Palette.Swatch darkVibrantSwatch = palette.getDarkVibrantSwatch();
                    final Palette.Swatch darkMutedSwatch = palette.getDarkMutedSwatch();
                    final Palette.Swatch lightVibrantSwatch = palette.getLightVibrantSwatch();
                    final Palette.Swatch lightMutedSwatch = palette.getLightMutedSwatch();
                    final Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();

                    setDarkVibrants(darkVibrantSwatch);
                    setDarkMuteds(darkMutedSwatch);

                }
            }


        });
    }

    private void setDarkVibrants(Palette.Swatch swatch) {
        if (swatch != null) {
            name.setBackgroundColor(swatch.getRgb());
            name.setTextColor(swatch.getTitleTextColor());
        }
    }
    private void setDarkMuteds(Palette.Swatch swatch) {
        if (swatch != null) {
            container.setBackgroundColor(swatch.getRgb());
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        injector.attemptFragmentInjection();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        injector.attemptFragmentInjection();
    }
}
