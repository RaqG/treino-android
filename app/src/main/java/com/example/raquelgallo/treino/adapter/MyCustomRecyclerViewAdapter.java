package com.example.raquelgallo.treino.adapter;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.raquelgallo.treino.R;
import com.example.raquelgallo.treino.model.Cars;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raquel Gallo on 17/12/2017.
 */

public class MyCustomRecyclerViewAdapter extends RecyclerView.Adapter<MyCustomRecyclerViewAdapter.ViewHolder> {

    private List<Cars> dataCar = new ArrayList<>();

    public MyCustomRecyclerViewAdapter(List<Cars> dataCar) {
        this.dataCar = dataCar;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_itens, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Cars carInfo = dataCar.get(position);

        holder.imgCar.setBackgroundResource(carInfo.getCarImg(position));

        String carColor = carInfo.getColor();
        int color = getCarColor(carColor);

        holder.carColor.setBackgroundResource(color);
        holder.carColor.setTag(carColor);
        holder.txtBrand.setText(carInfo.getBrand());
        holder.txtModel.setText(carInfo.getModel());
        holder.txtYear.setText(String.valueOf(carInfo.getYear()));
    }

    @Override
    public int getItemCount() {
        return dataCar.size();
    }

    private int getCarColor(String carColor) {
        switch (carColor) {
            case "Vermelha":
                return R.color.vermelha;
            case "Azul":
                return R.color.azul;
            case "Branca":
                return R.color.branca;
            case "Dourada":
                return R.color.dourada;
            default:
                return R.color.colorPrimaryText;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgCar;
        private ImageView carColor;
        private TextView txtBrand;
        private TextView txtModel;
        private TextView txtYear;

        private ViewHolder(View itemView) {
            super(itemView);
            this.imgCar = itemView.findViewById(R.id.img_carros);
            this.carColor = itemView.findViewById(R.id.image_view_cor);
            this.txtBrand = itemView.findViewById(R.id.text_view_marca);
            this.txtModel = itemView.findViewById(R.id.text_view_modelo);
            this.txtYear = itemView.findViewById(R.id.text_ano);

            setOnItemClick(itemView);
        }

        private void setOnItemClick(View itemView) {
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    String snackbarTxt = "Marca: " + txtBrand.getText() + "\nModelo: " + txtModel.getText()
                            + "\nAno: " + txtYear.getText() + "\nCor: " + carColor.getTag();

                    final Snackbar snackbar = Snackbar.make(view, snackbarTxt, Snackbar.LENGTH_INDEFINITE);
                    snackbar.setAction("Close", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            snackbar.dismiss();
                        }
                    });

                    TextView textView = snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
                    textView.setSingleLine(false);

                    snackbar.show();
                }
            });
        }
    }
}