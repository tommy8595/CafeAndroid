package com.example.myapplication.adapter;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.data.DataProduct;
import com.example.myapplication.databinding.ProductDetailLayoutBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

        private int mValue = 1;
        private AlertDialog mDialog = null;
        ProductDetailLayoutBinding mBindingDetail = null;

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

            String _priceString = String.format(Locale.getDefault(),"%.2f USD",product.getProPrice());
            mTvProductPrice.setText(_priceString);
        }

        @Override
        public void onClick(View view) {
            try{
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                mDialog= builder
                        .setTitle("Detail")
                        .setView(createProductDetailDialog())
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).create();

                mDialog.show();
            }catch (Exception e){
                Log.d("Exception",e.getMessage());
            }
        }

        private View createProductDetailDialog(){
            final View detailView = LayoutInflater.from(this.itemView.getContext())
                    .inflate(R.layout.product_detail_layout,null);

            mBindingDetail = DataBindingUtil.bind(detailView);

            try{
                if(mBindingDetail != null){

                    final int MAX = 99;
                    final int MIN = 1;
                    //set default
                    mBindingDetail.tvValueOfQty.setText(itemView.getResources().getString(R.string.default_qty_value));

                    mBindingDetail.btnDecrement.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(mValue == MIN){
                                mBindingDetail.tvValueOfQty.setText(String.valueOf(MIN));
                            }
                            else{
                                mValue -= 1;
                                mBindingDetail.tvValueOfQty.setText(String.valueOf(mValue));
                            }
                        }
                    });
                    mBindingDetail.btnIncrement.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(mValue < MAX){
                                mValue += 1;
                                mBindingDetail.tvValueOfQty.setText(String.valueOf(mValue));
                            }
                        }
                    });

                    mBindingDetail.imgProduct.setImageResource(products.get(getAdapterPosition()).getProCover());

                    mBindingDetail.tvProductName.setText(products.get(getAdapterPosition()).getProName());

                    mBindingDetail.tvProductCate.setText(products.get(getAdapterPosition()).getProCate());

                    mBindingDetail.tvProductPrice.setText(String.format(Locale.getDefault(),
                            "$%.2f",products.get(getAdapterPosition()).getProPrice()));

                    setUpLetterSpacing(new View[] {
                            mBindingDetail.tvDescription,
                            mBindingDetail.tvProductPrice,
                            mBindingDetail.tvProductName,
                            mBindingDetail.tvProductCate,
                            mBindingDetail.btnAddToCart,
                            mBindingDetail.btnOrderNow
                    });

                    mBindingDetail.btnAddToCart.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    });

                    mBindingDetail.btnOrderNow.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    });
                }
            }catch (Exception e){
                Log.d("Exception",e.getMessage());
            }

            return detailView;
        }

        private void setUpLetterSpacing(View[] views){
            for(View view:views){
                if(view instanceof TextView){
                    ((TextView) view).setLetterSpacing(0.1F);
                }
                if(view instanceof Button){
                    ((Button) view).setLetterSpacing(0.1F);
                }
            }
        }
    }
}
