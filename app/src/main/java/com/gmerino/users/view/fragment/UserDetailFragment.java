package com.gmerino.users.view.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.domain.user.data.User;
import com.gmerino.users.R;
import com.gmerino.users.presenter.UserDetailPresenter;
import com.squareup.picasso.Picasso;

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

            Picasso.with(getActivity()).load(currentUser.getPicture().getLarge()).into(photo);
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
