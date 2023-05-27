package com.example.dangdiary.menu;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.dangdiary.R;

import org.json.JSONException;
import org.json.JSONObject;

public class Join extends AppCompatActivity {

    private Button btn_register, validateButton;
    private RadioGroup sex_radioGroup;
    private EditText et_id, et_pass, et_passck, et_height, et_weight, et_age, et_nickname;
    private String selected_sex;
    private boolean validate=false;
    private AlertDialog dialog;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //layout 넘어오기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);
        Intent intent = getIntent();

        //아이디 값 찾아주기
        et_id=findViewById(R.id.et_id);
        et_pass=findViewById(R.id.et_pass);
        et_nickname=findViewById(R.id.et_nickname);
        et_age=findViewById(R.id.et_age);
        et_height=findViewById(R.id.et_height);
        et_weight=findViewById(R.id.et_weight);
        et_passck=findViewById(R.id.et_passck);

        sex_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn_female:
                        selected_sex = "여자";
                        break;
                    case R.id.btn_male:
                        selected_sex = "남자";
                        break;
                }
            }
        });

        // 중복확인 버튼
        validateButton = (Button) findViewById(R.id.validateButton);
        // ValidateRequest 자바 클래스 파일 만든 후에 실행 가능!
//        validateButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                String userID=et_id.getText().toString();
//                if(validate)
//                {
//                    return;
//                }
//                if(userID.equals("")){
//                    AlertDialog.Builder builder=new AlertDialog.Builder( RegisterActivity.this );
//                    dialog=builder.setMessage("아이디는 빈 칸일 수 없습니다")
//                            .setPositiveButton("확인",null)
//                            .create();
//                    dialog.show();
//                    return;
//                }
//                Response.Listener<String> responseListener=new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            JSONObject jsonResponse=new JSONObject(response);
//                            boolean success=jsonResponse.getBoolean("success");
//                            if(success){
//                                AlertDialog.Builder builder=new AlertDialog.Builder( RegisterActivity.this );
//                                dialog=builder.setMessage("사용할 수 있는 아이디입니다.")
//                                        .setPositiveButton("확인",null)
//                                        .create();
//                                dialog.show();
//                                et_id.setEnabled(false);
//                                validate=true;
//                                validateButton.setText("확인");
//                            }
//                            else{
//                                AlertDialog.Builder builder=new AlertDialog.Builder( RegisterActivity.this );
//                                dialog=builder.setMessage("사용할 수 없는 아이디입니다.")
//                                        .setNegativeButton("확인",null)
//                                        .create();
//                                dialog.show();
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                };
//                ValidateRequest validateRequest=new ValidateRequest(userID,responseListener);
//                RequestQueue queue= Volley.newRequestQueue(Join.this);
//                queue.add(validateRequest);
//
//            }
//        });


        // 회원가입 버튼
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //editText에 입력되어있는 값을 get(가져온다)해온다
                String userID=et_id.getText().toString();
                final String userPass=et_pass.getText().toString();
                final String userPassCk=et_passck.getText().toString();
                String userNickname=et_nickname.getText().toString();
                int userAge=Integer.parseInt(et_age.getText().toString());
                int userHeight=Integer.parseInt(et_height.getText().toString());
                int userWeight=Integer.parseInt(et_weight.getText().toString());

                Intent intent = new Intent(Join.this, HomeMenu.class);//현재,이동 적기
                startActivity(intent);
//                Response.Listener<String> responseListener=new Response.Listener<String>() {//volley
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            JSONObject jasonObject=new JSONObject(response);//Register2 php에 response
//                            boolean success=jasonObject.getBoolean("success");//Register2 php에 sucess
//                            if(userPass.equals(PassCk)) {
//                                if (success) {//회원등록 성공한 경우
//                                    Toast.makeText(getApplicationContext(), "회원 등록 성공", Toast.LENGTH_SHORT).show();
//                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
//                                    startActivity(intent);
//                                }
//                            }
//                            else{//회원등록 실패한 경우
//                                Toast.makeText(getApplicationContext(),"회원 등록 실패",Toast.LENGTH_SHORT).show();
//                                return;
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                };
//                //서버로 volley를 이용해서 요청을 함
//                RegisterRequest registerRequest=new RegisterRequest(userID,userPass, userName, userAge,userHak,userMajor,responseListener);
//                RequestQueue queue= Volley.newRequestQueue(RegisterActivity.this);
//                queue.add(registerRequest);
            }
        });
    }

}
