package com.gmerino.users.view.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.domain.user.data.User;
import com.gmerino.users.R;
import com.gmerino.users.presenter.UserListPresenter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

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

public class UserAdapter extends ArrayAdapter<User> {

    private List<User> users = new ArrayList<>();

    private Activity activity;

    private UserListPresenter presenter;

    @Inject
    public UserAdapter(Activity activity, int layoutResourceId, UserListPresenter presenter) {
        super(activity, layoutResourceId);

        this.activity = activity;
        this.presenter = presenter;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    public void updateUsers(List<User> userList, Map<String, User> deleted) {
//        this.users.clear();
//        for (User user : userList) {
//            if (!deleted.containsKey(user.getMd5()) &&
//                    (!UserHandler.getInstance().shouldFilter() || user.getName().toString().toLowerCase().contains(UserHandler.getInstance().getFilter().toLowerCase()))) {
//                this.users.add(user);
//            }
//        }
        this.users = userList;

    }

    private class StarredListener implements CompoundButton.OnCheckedChangeListener {

        private User currentUser;

        public void setCurrentUser(User currentUser){
            this.currentUser = currentUser;
        }
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(currentUser != null){
                presenter.setStarred(currentUser, isChecked);
            }
        }
    }

    private class ViewHolder {
        TextView name;
        TextView email;
        TextView phone;
        ImageView picture;
        CheckBox starred;
        Button delete;
        StarredListener starredListener = new StarredListener();
    }


    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public User getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View ret = convertView;
        ViewHolder holder;
        if (ret == null) { // Inflate the view and set attributes
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.row_user, parent, false);

            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.email = (TextView) convertView.findViewById(R.id.email);
            holder.phone = (TextView) convertView.findViewById(R.id.phone);
            holder.picture = (ImageView) convertView.findViewById(R.id.picture);
            holder.starred = (CheckBox) convertView.findViewById(R.id.starred);
            holder.delete = (Button) convertView.findViewById(R.id.delete);
            holder.starred.setOnCheckedChangeListener(holder.starredListener);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) ret.getTag();
        }

        final User user = (User) getItem(position);

        if (user != null) {

            holder.name.setText(user.getName().toString());
            holder.email.setText(user.getEmail());
            holder.phone.setText(user.getPhone());

            Picasso.with(activity).load(user.getPicture().getThumbnail()).into(holder.picture);

            holder.starredListener.setCurrentUser(null);
            holder.starred.setChecked(user.getStarred());
            holder.starredListener.setCurrentUser(user);

//            //This should be on viewholder
//            holder.starred.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                    UserHandler.getInstance().addStarred(user, isChecked);
//                }
//            });

//            //This should be on viewholder
//            holder.delete.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    UserHandler.getInstance().removeUser(user);
//                }
//            });
        }

        return convertView;
    }


//    @Override
//    public int getItemViewType(int position) {
//        return 1;
//    }
//
//    @Override
//    public int getViewTypeCount() {
//        return 1;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return users.size() == 0;
//    }


}