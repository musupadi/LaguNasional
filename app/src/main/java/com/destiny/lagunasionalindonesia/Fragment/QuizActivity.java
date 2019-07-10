package com.destiny.lagunasionalindonesia.Fragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.destiny.lagunasionalindonesia.HomeActivity;
import com.destiny.lagunasionalindonesia.MainActivity;
import com.destiny.lagunasionalindonesia.Model.DataModelWajib;
import com.destiny.lagunasionalindonesia.Model.Models;
import com.destiny.lagunasionalindonesia.Model.QuizModel;
import com.destiny.lagunasionalindonesia.R;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    Button A,B,C,D;
    TextView Soal,Tittle;
    private ArrayList<Models> pList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Intent data = getIntent();
        String No = data.getStringExtra("NO");
        final String Score = data.getStringExtra("SCORE");
        final int no = Integer.parseInt(No);
        A = (Button)findViewById(R.id.btnA);
        B = (Button)findViewById(R.id.btnB);
        C = (Button)findViewById(R.id.btnC);
        D = (Button)findViewById(R.id.btnD);
        Soal = (TextView)findViewById(R.id.tvSoal);
        Tittle = (TextView)findViewById(R.id.tvTittle);
        pList.addAll(QuizModel.getListData());
        A.setText(pList.get(no).getJawabana());
        B.setText(pList.get(no).getJawabanb());
        C.setText(pList.get(no).getJawabanc());
        D.setText(pList.get(no).getJawaband());
        Soal.setText(pList.get(no).getSoal());
        Tittle.setText("Soal "+pList.get(no).getNo());
        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pList.get(no).getJawaban().equals("A")){
                    if (no >= pList.size()-1){
                        Intent intent=new Intent(QuizActivity.this, HomeActivity.class);
                        Toast.makeText(QuizActivity.this,String.valueOf(Integer.parseInt(Score)+1),Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }else{
                        Intent goInput = new Intent(QuizActivity.this, QuizActivity.class);
                        goInput.putExtra("NO",String.valueOf(no+1));
                        goInput.putExtra("SCORE",String.valueOf(Integer.parseInt(Score)+1));
                        Toast.makeText(QuizActivity.this,String.valueOf(Integer.parseInt(Score)+1),Toast.LENGTH_SHORT).show();
                        QuizActivity.this.startActivities(new Intent[]{goInput});
                    }
                }else{
                    if (no >= pList.size()-1){
                        Intent intent=new Intent(QuizActivity.this, HomeActivity.class);
                        Toast.makeText(QuizActivity.this,Score,Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }else{
                        Intent goInput = new Intent(QuizActivity.this, QuizActivity.class);
                        goInput.putExtra("NO",String.valueOf(no+1));
                        goInput.putExtra("SCORE",String.valueOf(Score));
                        Toast.makeText(QuizActivity.this,Score,Toast.LENGTH_SHORT).show();
                        QuizActivity.this.startActivities(new Intent[]{goInput});
                    }
                }
            }
        });
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pList.get(no).getJawaban().equals("B")){
                    if (no >= pList.size()-1){
                        Intent intent=new Intent(QuizActivity.this, HomeActivity.class);
                        Toast.makeText(QuizActivity.this,String.valueOf(Integer.parseInt(Score)+1),Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }else{
                        Intent goInput = new Intent(QuizActivity.this, QuizActivity.class);
                        goInput.putExtra("NO",String.valueOf(no+1));
                        goInput.putExtra("SCORE",String.valueOf(Integer.parseInt(Score)+1));
                        Toast.makeText(QuizActivity.this,String.valueOf(Integer.parseInt(Score)+1),Toast.LENGTH_SHORT).show();
                        QuizActivity.this.startActivities(new Intent[]{goInput});
                    }
                }else{
                    if (no >= pList.size()-1){
                        Intent intent=new Intent(QuizActivity.this, HomeActivity.class);
                        Toast.makeText(QuizActivity.this,Score,Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }else{
                        Intent goInput = new Intent(QuizActivity.this, QuizActivity.class);
                        goInput.putExtra("NO",String.valueOf(no+1));
                        goInput.putExtra("SCORE",String.valueOf(Score));
                        Toast.makeText(QuizActivity.this,Score,Toast.LENGTH_SHORT).show();
                        QuizActivity.this.startActivities(new Intent[]{goInput});
                    }
                }
            }
        });
        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pList.get(no).getJawaban().equals("C")){
                    if (no >= pList.size()-1){
                        Intent intent=new Intent(QuizActivity.this, HomeActivity.class);
                        Toast.makeText(QuizActivity.this,String.valueOf(Integer.parseInt(Score)+1),Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }else{
                        Intent goInput = new Intent(QuizActivity.this, QuizActivity.class);
                        goInput.putExtra("NO",String.valueOf(no+1));
                        goInput.putExtra("SCORE",String.valueOf(Integer.parseInt(Score)+1));
                        Toast.makeText(QuizActivity.this,String.valueOf(Integer.parseInt(Score)+1),Toast.LENGTH_SHORT).show();
                        QuizActivity.this.startActivities(new Intent[]{goInput});
                    }
                }else{
                    if (no >= pList.size()-1){
                        Intent intent=new Intent(QuizActivity.this, HomeActivity.class);
                        Toast.makeText(QuizActivity.this,Score,Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }else{
                        Intent goInput = new Intent(QuizActivity.this, QuizActivity.class);
                        goInput.putExtra("NO",String.valueOf(no+1));
                        goInput.putExtra("SCORE",String.valueOf(Score));
                        Toast.makeText(QuizActivity.this,Score,Toast.LENGTH_SHORT).show();
                        QuizActivity.this.startActivities(new Intent[]{goInput});
                    }
                }
            }
        });
        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pList.get(no).getJawaban().equals("D")){
                    if (no >= pList.size()-1){
                        Intent intent=new Intent(QuizActivity.this, HomeActivity.class);
                        Toast.makeText(QuizActivity.this,String.valueOf(Integer.parseInt(Score)+1),Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }else{
                        Intent goInput = new Intent(QuizActivity.this, QuizActivity.class);
                        goInput.putExtra("NO",String.valueOf(no+1));
                        goInput.putExtra("SCORE",String.valueOf(Integer.parseInt(Score)+1));
                        Toast.makeText(QuizActivity.this,String.valueOf(Integer.parseInt(Score)+1),Toast.LENGTH_SHORT).show();
                        QuizActivity.this.startActivities(new Intent[]{goInput});
                    }
                }else{
                    if (no >= pList.size()-1){
                        Intent intent=new Intent(QuizActivity.this, HomeActivity.class);
                        Toast.makeText(QuizActivity.this,Score,Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }else{
                        Intent goInput = new Intent(QuizActivity.this, QuizActivity.class);
                        goInput.putExtra("NO",String.valueOf(no+1));
                        goInput.putExtra("SCORE",String.valueOf(Score));
                        Toast.makeText(QuizActivity.this,Score,Toast.LENGTH_SHORT).show();
                        QuizActivity.this.startActivities(new Intent[]{goInput});
                    }
                }
            }
        });
    }
}
