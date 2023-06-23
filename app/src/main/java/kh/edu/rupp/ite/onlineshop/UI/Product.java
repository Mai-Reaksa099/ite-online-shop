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

import kh.edu.rupp.ite.onlineshop.Adapter.ProductAdapter;
import kh.edu.rupp.ite.onlineshop.ApiServices.ServiceAPI;
import kh.edu.rupp.ite.onlineshop.Model.Products;
import kh.edu.rupp.ite.onlineshop.databinding.ProductActivityFragmentBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Product extends Fragment {

    private ProductActivityFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       binding = ProductActivityFragmentBinding.inflate(inflater, container, false);
        loadProdust();
        return binding.getRoot();
    }

    private void loadProdust(){

        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://raw.githubusercontent.com/").addConverterFactory(GsonConverterFactory.create(gson)).build();

        ServiceAPI serviceAPI = retrofit.create(ServiceAPI.class);
        Call<List<Products>> task = serviceAPI.loadProducts();
        task.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {

                if (response.isSuccessful()) {
                    ShowLoadingProduct(response.body());
                }else {
                    Toast.makeText(getContext(), "Failed", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
                Toast.makeText(getContext(), "Failed", Toast.LENGTH_LONG).show();
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });

    }

    private void ShowLoadingProduct(List<Products> products){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        binding.productRecycler.setLayoutManager(linearLayoutManager);

        ProductAdapter productAdapter = new ProductAdapter();
        productAdapter.submitList(products);
        binding.productRecycler.setAdapter(productAdapter);


    }

}
