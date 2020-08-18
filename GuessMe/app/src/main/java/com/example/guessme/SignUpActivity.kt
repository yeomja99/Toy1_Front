package com.example.guessme

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    lateinit var nicknameView: EditText
    lateinit var password1View: EditText
    lateinit var password2View: EditText
    lateinit var registerBtn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        initView(this@SignUpActivity)

        signup_btn.setOnClickListener {
            register(this)
        }
    }

    fun register(activity: Activity) {
        val nickname = getNickName()
        val password1 = getPassword1()
        val password2 = getPassword2()
        val body = HashMap<String, String>()
        body.put("nickname", nickname)
        body.put("password", password1)


        // 비밀번호 일치 확인
        if (password1 != password2) {
            Log.d("user", "비밀번호 불일치")
            Toast.makeText(activity, "비밀번호가 일치하지 않습니다", Toast.LENGTH_LONG).show()
        }
        // 닉네임 중복 확인
        else if (!(application as MasterApplication).service.getNicknameIsExist(nickname)) {
            Log.d("user", "닉네임 중복")
            Toast.makeText(activity, "닉네임이 중복됩니다", Toast.LENGTH_LONG).show()
        }
        else {
            Log.d("user", "회원가입 가능")
            (application as MasterApplication).service.register(
                body
            ).enqueue(object :
                Callback<User> {
                override fun onFailure(call: Call<User>, t: Throwable) {
//                // 닉네임 중복 확인
//                if (!(application as MasterApplication).service.getNicknameIsExist(nickname)) {
//                    Toast.makeText(activity, "닉네임이 중복됩니다", Toast.LENGTH_LONG).show()
//                }
//                // 비밀번호 일치 확인
//                else if (password1 != password2) {
//                    Toast.makeText(activity, "비밀번호가 일치하지 않습니다", Toast.LENGTH_LONG).show()
//                }
                    Toast.makeText(activity, "회원가입에 실패했습니다", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful) {
                        Toast.makeText(activity, "회원가입에 성공했습니다", Toast.LENGTH_LONG).show()
                        val user = response.body()
//                    val token = user!!.token!!
                        val token = response.headers().get("Authorization").toString()
                        saveUserToken(token, activity)
                        (application as MasterApplication).createRetrofit()
                        activity.startActivity(
                            Intent(activity, SignInActivity::class.java)
                        )
                    }
                }
            })
        }
    }

    // 토큰 받아서 SharedPreference에 저장
    fun saveUserToken(token: String, activity: Activity) {
        val sp = activity.getSharedPreferences("login_token", Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("login_token", token)
        editor.commit()
    }

    fun initView(activity: Activity) {
        nicknameView = activity.findViewById(R.id.nickname_inputbox)
        password1View = activity.findViewById(R.id.password1_inputbox)
        password2View = activity.findViewById(R.id.password2_inputbox)
        registerBtn = activity.findViewById(R.id.signup_btn)
    }

    fun getNickName(): String{
        return nicknameView.text.toString()
    }

    fun getPassword1(): String {
        return password1View.text.toString()
    }

    fun getPassword2(): String {
        return password2View.text.toString()
    }

}