package and5.abrar.counrty

import and5.abrar.counrty.adapter.AdapterCountry
import and5.abrar.counrty.api.ApiClient
import and5.abrar.counrty.model.GetCountryItem
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getdatacountry()
    }
    fun getdatacountry(){
        ApiClient.instance.getAllCountry().enqueue(object : retrofit2.Callback<List<GetCountryItem>>{
            override fun onResponse(
                call: Call<List<GetCountryItem>>,
                response: Response<List<GetCountryItem>>
            ) {
                if(response.isSuccessful){
                    val datacountry = response.body()
                    val adapterCountry = AdapterCountry(datacountry!!)
                    val lm = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
                    rvCountry.layoutManager=lm
                    rvCountry.adapter=adapterCountry
                }else{
                    Toast.makeText(this@MainActivity,response.message(), Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<GetCountryItem>>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.message, Toast.LENGTH_LONG).show()
            }

        })
    }
}