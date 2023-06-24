package kh.edu.rupp.ite.onlineshop.ApiServices;

import java.util.List;

import kh.edu.rupp.ite.onlineshop.Model.Products;
import kh.edu.rupp.ite.onlineshop.Model.Profiles;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceAPI {

    @GET("kimsongsao/ferupp/main/products.json")
     Call<List<Products>> loadProducts();

    @GET("kimsongsao/ferupp/main/profile.json")
    Call <Profiles> loadProfile();

}
