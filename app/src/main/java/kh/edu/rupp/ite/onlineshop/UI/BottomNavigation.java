package kh.edu.rupp.ite.onlineshop.UI;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import kh.edu.rupp.ite.onlineshop.R;
import kh.edu.rupp.ite.onlineshop.databinding.BottomNavigationViewBinding;

public class BottomNavigation extends AppCompatActivity {

    private BottomNavigationViewBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = BottomNavigationViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Home home = new Home();
        ShowBottomNavigation(home);

        binding.bottomNavigation.setOnNavigationItemSelectedListener(v -> {

            if (v.getItemId() == R.id.homeMenu){
                Home homes = new Home();
                ShowBottomNavigation(homes);
            }
            else if (v.getItemId() == R.id.productMenu){
                Product product = new Product();
                ShowBottomNavigation(product);
            }
            else if (v.getItemId() == R.id.profileMenu){
                Profile profile = new Profile();
                ShowBottomNavigation(profile);
            }
            else if (v.getItemId() == R.id.moreMenu){
                More more = new More();
                ShowBottomNavigation(more);
            }

            return true;
        });
    }
    protected void ShowBottomNavigation(Fragment fragment){
        FragmentManager fragmentManager =getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.bottomNavigationBody, fragment);
        fragmentTransaction.commit();
    }
}
