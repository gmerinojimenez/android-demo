package com.gmerino.users.view.fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.domain.user.data.User;
import com.gmerino.users.presenter.UserListPresenter;
import com.gmerino.users.view.adapter.UserAdapter;

import javax.inject.Inject;

/**
 * A list fragment representing a list of Users. This fragment
 * also supports tablet devices by allowing list items to be given an
 * 'activated' state upon selection. This helps indicate which item is
 * currently being viewed in a {@link UserDetailFragment}.
 */
public class UserListFragment extends ListFragment {

    private static final String TAG = UserListFragment.class.getCanonicalName();

    @Inject
    UserListPresenter presenter;

    /**
     * The serialization (saved instance state) Bundle key representing the
     * activated item position. Only used on tablets.
     */
    private static final String STATE_ACTIVATED_POSITION = "activated_position";

    //
//    /**
//     * The fragment's current callback object, which is notified of list item
//     * clicks.
//     */
//    private Callbacks mCallbacks = sDummyCallbacks;
//
    /**
     * The current activated item position. Only used on tablets.
     */
    private int mActivatedPosition = ListView.INVALID_POSITION;

    private UserAdapter adapter;
//
//    @Override
//    public void update(Observable observable, Object data) {
//        //Let's reload the data...
//        Log.d(TAG, "Reloading data");
//        adapter.setUsers(UserHandler.getInstance().getUserList(), UserHandler.getInstance().getDeletedUsers());
//        adapter.notifyDataSetChanged();
//    }
//
//    /**
//     * A callback interface that all activities containing this fragment must
//     * implement. This mechanism allows activities to be notified of item
//     * selections.
//     */
//    public interface Callbacks {
//        /**
//         * Callback for when an item has been selected.
//         */
//        public void onItemSelected(String id);
//
//        public void onFragmentAttached();
//    }
//
//    /**
//     * A dummy implementation of the {@link Callbacks} interface that does
//     * nothing. Used only when this fragment is not attached to an activity.
//     */
//    private static Callbacks sDummyCallbacks = new Callbacks() {
//        @Override
//        public void onItemSelected(String id) {
//        }
//
//        @Override
//        public void onFragmentAttached() {
//
//        }
//    };
//
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public UserListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        adapter = new UserAdapter(getActivity(), R.id.user_list, UserHandler.getInstance().getUserList());
        adapter = null;

//        // TODO: replace with a real list adapter.
//        setListAdapter(new ArrayAdapter<User>(
//                getActivity(),
//                android.R.layout.simple_list_item_activated_1,
//                android.R.id.text1,
//                UserHandler.getInstance().getUserList()));
        setListAdapter(adapter);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Restore the previously serialized activated item position.
        if (savedInstanceState != null
                && savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
            setActivatedPosition(savedInstanceState.getInt(STATE_ACTIVATED_POSITION));
        }
    }
//
//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//
//        // Activities containing this fragment must implement its callbacks.
//        if (!(activity instanceof Callbacks)) {
//            throw new IllegalStateException("Activity must implement fragment's callbacks.");
//        }
//
//        mCallbacks = (Callbacks) activity;
//
//        UserHandler.getInstance().addObserver(this);
//
//        mCallbacks.onFragmentAttached();
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//
//        // Reset the active callbacks interface to the dummy implementation.
//        mCallbacks = sDummyCallbacks;
//
//        UserHandler.getInstance().deleteObserver(this);
//    }
//
    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);

        Log.d(TAG, "onListItemClick");

        // Notify the active callbacks interface (the activity, if the
        // fragment is attached to one) that an item has been selected.
//        mCallbacks.onItemSelected(((User)listView.getAdapter().getItem(position)).getMd5());
        presenter.onUserClicked((User) listView.getAdapter().getItem(position));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mActivatedPosition != ListView.INVALID_POSITION) {
            // Serialize and persist the activated item position.
            outState.putInt(STATE_ACTIVATED_POSITION, mActivatedPosition);
        }
    }

    /**
     * Turns on activate-on-click mode. When this mode is on, list items will be
     * given the 'activated' state when touched.
     */
    public void setActivateOnItemClick(boolean activateOnItemClick) {
        // When setting CHOICE_MODE_SINGLE, ListView will automatically
        // give items the 'activated' state when touched.
        getListView().setChoiceMode(activateOnItemClick
                ? ListView.CHOICE_MODE_SINGLE
                : ListView.CHOICE_MODE_NONE);
    }

    private void setActivatedPosition(int position) {
        if (position == ListView.INVALID_POSITION) {
            getListView().setItemChecked(mActivatedPosition, false);
        } else {
            getListView().setItemChecked(position, true);
        }

        mActivatedPosition = position;
    }
}
