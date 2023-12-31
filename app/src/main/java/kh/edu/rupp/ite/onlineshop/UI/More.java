package kh.edu.rupp.ite.onlineshop.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import kh.edu.rupp.ite.onlineshop.databinding.MoreActivityFragmentBinding;

public class More extends Fragment {

    private MoreActivityFragmentBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = MoreActivityFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
