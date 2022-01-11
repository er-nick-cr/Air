package com.example.airquality;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.w3c.dom.Attr;

import java.util.List;

import javax.xml.transform.Result;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class AirModel {

    public static class NetworkService {
        private static NetworkService mInstance;
        private static final String BASE_URL = "https://api.waqi.info/feed/";
        private final Retrofit mRetrofit;

        private NetworkService() {

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor);



            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client.build())
                    .build();
        }




        public static NetworkService getInstance() {
            if(mInstance == null) {
                mInstance = new NetworkService();
            }
            return mInstance;
        }

        public JSONPlaceHolderApi getJSONApi() {
            return mRetrofit.create(JSONPlaceHolderApi.class);
        }
    }

    public class Post {
        @SerializedName("data")
        @Expose
        public Result data;
        @SerializedName("body")
        @Expose
        private String body;

       public class Result {
           @SerializedName("aqi")
           @Expose
           public int aqi;
           @SerializedName("city")
           @Expose
           public City city;
           @SerializedName("forecast")
           @Expose
           public Forecast forecast;

           public class City{
               @SerializedName("name")
               @Expose
               public String name;

               public void setCity(String name) {
                   this.name = name;
               }

               public String getName() {
                   return name;
               }
           }
            public City getCity() {
               return city;
            }

            public class Forecast {
                @SerializedName("daily")
                @Expose
                public Daily daily;

                public class Daily {
                    @SerializedName("o3")
                    @Expose
                    public List<o3> o3;
                    @SerializedName("uvi")
                    @Expose
                    public List<Uvi> uvi;

                    public class o3 {
                        @SerializedName("avg")
                        @Expose
                        public int avg;

                        public void setAvg(int avg) {
                            this.avg = avg;
                        }

                        public int getAvg() {
                            return avg;
                        }
                    }

                    public class Uvi {
                        @SerializedName("avg")
                        @Expose
                        public int avg;

                        public void setAvg(int avg) {
                            this.avg = avg;
                        }

                        public int getAvg() {
                            return avg;
                        }
                    }

                    public void setO3(List<o3> o3) {
                        this.o3 = o3;
                    }

                    public List<o3> getO3() {
                        return o3;
                    }

                    public void setUvi(List<Uvi> uvi) {
                        this.uvi = uvi;
                    }

                    public List<Uvi> getUvi() {
                        return uvi;
                    }
                }

                public void setDaily(Daily daily) {
                    this.daily = daily;
                }

                public Daily getDaily() {
                   return daily;
                }
            }
            public void setForecast (Forecast forecast) {
               this.forecast = forecast;
            }

            public Forecast getForecast() {
               return forecast;
            }

           public void setAqi(int aqi) {
               this.aqi = aqi;
           }

           public int getAqi() {
               return aqi;
           }
       }



       public Result getData() {
           return data;
       }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }

    public interface JSONPlaceHolderApi {
        @GET("here/?token=2f99a98ceaf7a87f0cb09ca411e1fa02608daa40")
        Call<Post> getGeolocalizedPost();

        @GET("{cityName}/?token=2f99a98ceaf7a87f0cb09ca411e1fa02608daa40")
        Call<Post> getPostWithCityNAme(@Path("cityName") String cityName);
    }


}
