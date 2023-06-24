package kh.edu.rupp.ite.onlineshop.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import kh.edu.rupp.ite.onlineshop.Model.Profiles;
import kh.edu.rupp.ite.onlineshop.databinding.ProfileHolderBinding;

public class ProfileAdabter extends RecyclerView.Adapter<ProfileAdabter.ProfileViewHolder> {


    private final List<Profiles> profileData = new ArrayList<>();

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ProfileHolderBinding binding = ProfileHolderBinding.inflate(layoutInflater, parent, false);
        ProfileViewHolder profileViewHolder =  new ProfileViewHolder(binding);
        return profileViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {

        Profiles profiles = profileData.get(position);
        holder.bind(profiles);
    }

    @Override
    public int getItemCount() {
        return profileData.size();
    }

    public void setProfile(Profiles profiles){
        profileData.clear();
        profileData.add(profiles);
        notifyDataSetChanged();
    }


    public static class ProfileViewHolder extends RecyclerView.ViewHolder {

        ProfileHolderBinding profileHolderBinding;
        public ProfileViewHolder(@NonNull ProfileHolderBinding ProfileitemView) {
            super(ProfileitemView.getRoot());
            this.profileHolderBinding = ProfileitemView;
        }
        public void bind (Profiles profiles){
//            Picasso.get().load(profiles.getImageUrl()).into(profileHolderBinding.imgProfiles);
//            profileHolderBinding.txtFirstName.setText(profiles.getFirst_name());
//            profileHolderBinding.lastName.setText(profiles.getLast_name());
//            profileHolderBinding.txtEmail.setText(profiles.getEmail());
//            profileHolderBinding.emailTxt1.setText(profiles.getEmail());
//            profileHolderBinding.txtGender1.setText(profiles.getGender());
//            profileHolderBinding.txtNumber1.setText(profiles.getPhoneNumber());
//            profileHolderBinding.txtBirthday1.setText(profiles.getBirthday());
//            profileHolderBinding.txtAddress.setText(profiles.getAddress());

            Picasso.get().load(profiles.getImageUrl()).into(profileHolderBinding.imageProfile);
            profileHolderBinding.textPrice.setText(profiles.getGender());
            profileHolderBinding.textDescription.setText(profiles.getPhoneNumber());
            profileHolderBinding.textRating.setText(profiles.getBirthday());
            profileHolderBinding.textDescription.setText(profiles.getAddress());

        }
    }



}
