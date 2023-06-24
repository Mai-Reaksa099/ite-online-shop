package kh.edu.rupp.ite.onlineshop.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import kh.edu.rupp.ite.onlineshop.Model.Products;
import kh.edu.rupp.ite.onlineshop.databinding.ProductHolderBinding;

public class ProductAdapter extends ListAdapter<Products, ProductAdapter.ProductViewHolder> {

    public ProductAdapter(){
        super(new DiffUtil.ItemCallback<Products>() {
            @Override
            public boolean areItemsTheSame(@NonNull Products oldItem, @NonNull Products newItem) {
                return oldItem == newItem;
            }

            @SuppressLint("DiffUtilEquals")
            @Override
            public boolean areContentsTheSame(@NonNull Products oldItem, @NonNull Products newItem) {
                return oldItem.getid() == newItem.getid();
            }
        });
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ProductHolderBinding binding = ProductHolderBinding.inflate(layoutInflater, parent, false);
        return new ProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Products item = getItem(position);
        holder.bind(item);
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder{

        private final ProductHolderBinding bindingProduct;


        public ProductViewHolder(@NonNull ProductHolderBinding itemViewProduct) {
            super(itemViewProduct.getRoot());

            this.bindingProduct = itemViewProduct;
        }
        public void bind(Products product){

//            Picasso.get().load(product.getImageurl()).into(bindingProduct.imgProduct);
//            bindingProduct.txtName.setText(product.getName());
//            bindingProduct.txtPrice.setText("$" + (product.getPrice()));
//            bindingProduct.txtDes.setText(product.getDescription());
//            bindingProduct.txtRating.setText("Rating"+ " " + (product.getRating()));

            Picasso.get().load(product.getImageurl()).into(bindingProduct.imgUser);
            bindingProduct.textPrice.setText("$" + (product.getPrice()));
            bindingProduct.textRate.setText("Rating"+ " " + (product.getRating()));


        }
    }

}
