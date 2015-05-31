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
import com.gmerino.users.utils.SetImageRunnable;

import javax.inject.Inject;

public class UserDetailFragment extends Fragment implements UserDetailView {

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    private ImageView photo;
    private TextView name;
    private TextView gender;
    private TextView location;
    private TextView date;
    private TextView email;

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

        photo = (ImageView) rootView.findViewById(R.id.photo);
        name = (TextView) rootView.findViewById(R.id.name);
        gender = (TextView) rootView.findViewById(R.id.gender);
        location = (TextView) rootView.findViewById(R.id.location);
        date = (TextView) rootView.findViewById(R.id.date);
        email = (TextView) rootView.findViewById(R.id.email);


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

//            SetImageRunnable aux = new SetImageRunnable(currentUser.getPicture().getLarge(), photo);
//            Thread t = new Thread(aux);
//            t.start();
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
