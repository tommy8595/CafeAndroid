package com.example.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.data.DataProduct;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<DataProduct> products = new ArrayList<DataProduct>(){{
        add(new DataProduct("0001",R.drawable.cafe,
                "Iced Latte","Iced",4.00));
        add(new DataProduct("0002",R.drawable.cafe,
                "Iced Mocha","Iced",4.00));
        add(new DataProduct("0003",R.drawable.cafe,
                "Hot Latte","Hot",5.00));
        add(new DataProduct("0004",R.drawable.cafe,
                "Hot Mocha","Hot",5.00));
        add(new DataProduct("0005",R.drawable.cafe,
                "Iced Chocolate","Iced",3.00));
        add(new DataProduct("0006",R.drawable.cafe,
                "Hot Chocolate","Iced",2.50));
        add(new DataProduct("0007",R.drawable.cafe,
                "Iced Americano","Iced",5.40));
        add(new DataProduct("0008",R.drawable.cafe,
                "Hot Expresso","Hot",5.60));
    }};


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.product_adapter_layout,viewGroup,false);
        return new ProductViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i) {
        productViewHolder.setDataProduct(products.get(i));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView mImgCover;
        TextView mTvProductName;
        TextView mTvProductCate;
        TextView mTvProductPrice;

        private ProductViewHolder(View itemView) {
            super(itemView);
            mImgCover = (ImageView)itemView.findViewById(R.id.ivProductCover);
            mTvProductName = (TextView)itemView.findViewById(R.id.tvProductName);
            mTvProductCate = (TextView) itemView.findViewById(R.id.tvProductCate);
            mTvProductPrice = (TextView)itemView.findViewById(R.id.tvProductPrice);

            itemView.setOnClickListener(this);
        }
        private void setDataProduct(DataProduct product) {
            mImgCover.setImageResource(product.getProCover());
            mTvProductName.setText(product.getProName());
            mTvProductCate.setText(product.getProCate());

            String _priceString = String.format("%.2f",product.getProPrice()) + " USD ";
            mTvProductPrice.setText(_priceString);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(),String.valueOf(products.get(getAdapterPosition()).getProName()),
                    Toast.LENGTH_SHORT).show();
        }
    }
}
