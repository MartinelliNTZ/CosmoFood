package com.example.cosmofood;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Double  pcBurrito, pcFrango, pcHamburg,pcPizza,pcRefri, pcSand ;
    private Double vlTotal;
    private Button btFinalizar, btLimpar;
    private TextView txtPedido, txtFinalizado;
    private ImageView imgFinalizado;
    private CheckBox  ckBurrito, ckFrango, ckHamburg, ckPizza, ckRefri, ckSand;
    private DecimalFormat fmt = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vlTotal=0.0;
        pcBurrito= 14.5;
        pcFrango=12.5;
        pcHamburg=20.0;
        pcPizza = 35.0;
        pcRefri = 5.5;
        pcSand=14.5;
        btFinalizar = findViewById(R.id.btnFinalizar);
        btLimpar = findViewById(R.id.btnLimpar);
        txtPedido = findViewById(R.id.txtPedido);
        txtFinalizado = findViewById(R.id.txtFinalizado);
        imgFinalizado = findViewById(R.id.imgFinalizado);
        ckBurrito = findViewById(R.id.chkBurrito);
        ckFrango = findViewById(R.id.chkFrango);
        ckHamburg = findViewById(R.id.chkHamburg);
        ckPizza = findViewById(R.id.chkPizza);
        ckRefri = findViewById(R.id.chkRefri);
        ckSand=  (CheckBox)findViewById(R.id.chkSand);


        ckBurrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTotal(pcBurrito,ckBurrito.isChecked());
            }
        });
        ckFrango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTotal(pcFrango,ckFrango.isChecked());
            }
        });
        ckHamburg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTotal(pcHamburg,ckHamburg.isChecked());
            }
        });
        ckPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTotal(pcPizza,ckPizza.isChecked());
            }
        });
        ckRefri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTotal(pcRefri,ckRefri.isChecked());
            }
        });
        ckSand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTotal(pcSand,ckSand.isChecked());
            }
        });
        /*mudar fundo das checkbox para cinza*/
        ckBurrito.setBackgroundColor(Color.GRAY);
        ckFrango.setBackgroundColor(Color.GRAY);
        ckHamburg.setBackgroundColor(Color.GRAY);
        ckPizza.setBackgroundColor(Color.GRAY);
        ckRefri.setBackgroundColor(Color.GRAY);
        ckSand.setBackgroundColor(Color.GRAY);




        btFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(temAlguemSeleccionado()) {
                    edicaoChk(false);
                    imgFinalizado.setVisibility(View.VISIBLE);
                    txtFinalizado.setText("Pedido Finalizado no valor de R$" + fmt.format(vlTotal) + "\n Obrigado Pela Preferencia.");
                    txtFinalizado.setVisibility(View.VISIBLE);
                }else{

                }
            }
        });
        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edicaoChk(true);
                vlTotal = 0.0;
                imgFinalizado.setVisibility(View.INVISIBLE);
                txtPedido.setText("Valor final do seu Pedido: R$"+fmt.format(vlTotal));

                txtFinalizado.setVisibility(View.INVISIBLE);

                limparSelecao();
            }
        });



    }
    public void changeTotal(Double preco, boolean checado){
        if(checado){
            vlTotal=vlTotal+preco;
            txtPedido.setText("Valor final do seu Pedido: R$"+fmt.format(vlTotal));
        }else{
            vlTotal=vlTotal-preco;
            txtPedido.setText("Valor final do seu Pedido: R$"+fmt.format(vlTotal));
        }


    }
    public void edicaoChk (boolean edit){
        ckBurrito.setEnabled(edit);
        ckFrango.setEnabled(edit);
        ckHamburg.setEnabled(edit);
        ckPizza.setEnabled(edit);
        ckRefri.setEnabled(edit);
        ckSand.setEnabled(edit);


    }
    public void limparSelecao(){
        ckBurrito.setChecked(false);
        ckFrango.setChecked(false);
        ckHamburg.setChecked(false);
        ckPizza.setChecked(false);
        ckRefri.setChecked(false);
        ckSand.setChecked(false);
    }
    public boolean temAlguemSeleccionado(){
        boolean retorno;
        if(ckBurrito.isChecked() || ckFrango.isChecked() || ckHamburg.isChecked() || ckPizza.isChecked() || ckRefri.isChecked() || ckSand.isChecked()){
            retorno=true;
            return retorno;
        }else{
            retorno=false;
            return retorno;

        }
    }






}