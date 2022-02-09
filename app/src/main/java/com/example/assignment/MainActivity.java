package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.assignment.adapters.NumberListAdapter;
import com.example.assignment.databinding.ActivityMainBinding;
import com.example.assignment.models.ListData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding mBinding;
    private final int[] inputValues = {1, 2};
    private final int[] inputValuesColorRes = {R.color.red, R.color.blue};
    private boolean stateFlag = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        init();
        initListner();
    }

    private void init(){
        mBinding.lstNumbers.setHasFixedSize(true);
        mBinding.lstNumbers.setLayoutManager(new LinearLayoutManager(this));
        mBinding.lstNumbers.setVisibility(View.VISIBLE);
    }

    private void initListner() {
        mBinding.btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_submit){
            validateInput();
        }
    }


    private void validateInput() {

        String strInput = mBinding.edtNumber.getText().toString();
        if (strInput != null && strInput.trim().length() > 0){
            try {
                int strInt = Integer.parseInt(strInput);
                createArrayList(strInt);
                stateFlag = !stateFlag;
            } catch (Exception e) {
                Toast.makeText(this, "Please Enter valid number.", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "Please Enter number.", Toast.LENGTH_SHORT).show();
        }
    }

    private void createArrayList(int num) {

        List<ListData> listData = new ArrayList<>();
        if (num > 0){
            for (int i = 0; i < num; i++){
                int index = i % 2;
                int value = inputValues[index];

                listData.add(new ListData(value, getColorByPosition(i)));
            }
        }

        NumberListAdapter numberListAdapter = new NumberListAdapter(this, listData);
        mBinding.lstNumbers.setAdapter(numberListAdapter);

    }

    private int getColorByPosition(int position){
        if (position % 2 == 0 ){
            return inputValuesColorRes[ stateFlag ? 0 : 1];
        }else {
            return inputValuesColorRes[stateFlag ? 1 : 0];
        }
    }
}