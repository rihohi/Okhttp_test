import okhttp3.*;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {

    }
    public void get(){
        Response response=null;
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://182.254.163.248:8080/web/Park")
                    .build();
            response = client.newCall(request).execute();
        }catch (IOException e){
            e.printStackTrace();
        }
        String reponseData=response.body().toString();

    }

    public boolean post(String poi,int cost,String user_id){
        Response response=null;
        try{
            OkHttpClient client=new OkHttpClient();
            RequestBody body=new FormBody.Builder()
                    .add("poi",poi)
                    .add("cost",String.valueOf(cost))
                    .add("user_id",user_id)
                    .build();
            Request request=new Request.Builder()
                    .url("http://182.254.163.248:8080/web/Park")
                    .post(body)
                    .build();
            response=client.newCall(request).execute();
        }catch (IOException e){
            e.printStackTrace();
        }
        if (response!=null)
            return true;
        return false;
    }
}
