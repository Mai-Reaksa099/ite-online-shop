//package kh.edu.rupp.ite.onlineshop.Adapter;
//
//import android.annotation.SuppressLint;
//import android.view.LayoutInflater;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.DiffUtil;
//import androidx.recyclerview.widget.ListAdapter;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.squareup.picasso.Picasso;
//
//import kh.edu.rupp.ite.onlineshop.Model.Products;
//import kh.edu.rupp.ite.onlineshop.databinding.ActivityGridUserBinding;
//import kh.edu.rupp.ite.onlineshop.databinding.ProductHolderBinding;
//
//public class ProductGridAdapter extends ListAdapter<Products, ProductAdapter.ProductViewHolder> {
//    public  ProductAdapter(){
//        super(new DiffUtil.ItemCallback<Products>() {
//            @Override
//            public boolean areItemsTheSame(@NonNull Products oldItem, @NonNull Products newItem) {
//                return oldItem == newItem;
//            }
//
//            @SuppressLint("DiffUtilEquals")
//            @Override
//            public boolean areContentsTheSame(@NonNull Products oldItem, @NonNull Products newItem) {
//                return oldItem.getid() == newItem.getid();
//            }
//        });
//    }
//
//    @NonNull
//    @Override
//    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        ActivityGridUserBinding binding = ActivityGridUserBinding.inflate(layoutInflater, parent, false);
//        return new ProductAdapter.ProductViewHolder(binding);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
//        Products item = getItem(position);
//        holder.bind(item);
//    }
//
//    public static class ProductViewHolder extends RecyclerView.ViewHolder{
////        private final ProductHolderBinding bindingProduct;
//        private final ActivityGridUserBinding activityGridUserBinding;
//
//        public ProductViewHolder(@NonNull ActivityGridUserBinding itemViewProduct) {
//            super(itemViewProduct.getRoot());
//
//            this.activityGridUserBinding = itemViewProduct;
//        }
//        public void bind(Products product){
//
//            Picasso.get().load(product.getImageurl()).into(activityGridUserBinding.imgUser);
//            activityGridUserBinding.textPrice.setText("$" + (product.getPrice()));
//            activityGridUserBinding.textDescription.setText(product.getDescription());
//            activityGridUserBinding.textRate.setText("Rating"+ " " + (product.getRating()));
//
//        }
//    }
//}
