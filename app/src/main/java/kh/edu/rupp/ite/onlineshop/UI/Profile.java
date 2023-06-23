package kh.edu.rupp.ite.onlineshop.UI;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.ListIterator;

import kh.edu.rupp.ite.onlineshop.Adapter.ProfileAdabter;
import kh.edu.rupp.ite.onlineshop.ApiServices.ServiceAPI;
import kh.edu.rupp.ite.onlineshop.Model.Profiles;
import kh.edu.rupp.ite.onlineshop.databinding.ProfileActivityFragmentBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Profile extends Fragment {
    private ProfileActivityFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ProfileActivityFragmentBinding.inflate(inflater, container, false);
        LoadingProfile();
        return binding.getRoot();
    }

    public void LoadingProfile() {

        binding.profileRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        ProfileAdabter profileAdabter = new ProfileAdabter();
        binding.profileRecycler.setAdapter(profileAdabter);

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://raw.githubusercontent.com/").addConverterFactory(GsonConverterFactory.create(gson)).build();

        ServiceAPI serviceAPI = retrofit.create(ServiceAPI.class);

        Call<Profiles> task = serviceAPI.loadProfile();

        task.enqueue(new Callback<Profiles>() {
            @Override
            public void onResponse(Call<Profiles> call, Response<Profiles> response) {
                if (response.isSuccessful()) {
                    profileAdabter.setProfile(response.body());
                } else {
                    Toast.makeText(getContext(), "Success", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Profiles> call, Throwable t) {
                Toast.makeText(getContext(), "Failed", Toast.LENGTH_LONG).show();
                Log.d(TAG, "onFailureProfile: " + t.getMessage());
            }
        });
    }
}
