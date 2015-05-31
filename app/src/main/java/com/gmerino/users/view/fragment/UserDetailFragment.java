package com.gmerino.users.view.fragment;

import android.app.Fragment;

public class UserDetailFragment extends Fragment {

//    /**
//     * The fragment argument representing the item ID that this fragment
//     * represents.
//     */
//    public static final String ARG_ITEM_ID = "item_id";
//
//    /**
//     * The dummy content this fragment is presenting.
//     */
//    private User currentUser;
//
//    private ImageView photo;
//    private TextView name;
//    private TextView gender;
//    private TextView location;
//    private TextView date;
//    private TextView email;
//
//
//    /**
//     * Mandatory empty constructor for the fragment manager to instantiate the
//     * fragment (e.g. upon screen orientation changes).
//     */
//    public UserDetailFragment() {
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        if (getArguments().containsKey(ARG_ITEM_ID)) {
//            // Load the dummy content specified by the fragment
//            // arguments. In a real-world scenario, use a Loader
//            // to load content from a content provider.
//            currentUser = UserHandler.getInstance().getUserMap().get(getArguments().getString(ARG_ITEM_ID));
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.fragment_user_detail, container, false);
//
//
//        // Show the dummy content as text in a TextView.
//        if (currentUser != null) {
//            photo = (ImageView) rootView.findViewById(R.id.photo);
//            name = (TextView) rootView.findViewById(R.id.name);
//            gender = (TextView) rootView.findViewById(R.id.gender);
//            location = (TextView) rootView.findViewById(R.id.location);
//            date = (TextView) rootView.findViewById(R.id.date);
//            email = (TextView) rootView.findViewById(R.id.email);
//
//            name.setText(currentUser.getName().toString());
//            gender.setText(currentUser.getGender());
//            location.setText(currentUser.getLocation().toString());
//            date.setText(currentUser.getRegistered());
//            email.setText(currentUser.getEmail());
//
//            SetImageRunnable aux = new SetImageRunnable(currentUser.getPicture().getLarge(), photo);
//            Thread t = new Thread(aux);
//            t.start();
//        }
//
//        return rootView;
//    }
}
