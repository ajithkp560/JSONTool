import android.util.Log;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;

import java.net.HttpCookie;
import java.util.List;

/**
 * Coded By AJITH KP [@ajithkp560]
 * Visit: www.terminalcoders.blogspot.com
 */
public class JSONTool {
    static InputStream is = null;
    static JSONObject jobj = null;
    static JSONArray  jarr = null;
    List<NameValuePair> params = null;
    String url;
    List<Cookie> cookies;
    String strCookie;
    String response;
    String method="get";
    boolean flg = false;
    JSONTool(String u)
    {
        url = u;
    }
    JSONTool()
    {

    }
    JSONTool(String u, List<NameValuePair> p)
    {
        params = p;
    }
    public void setUrl(String u)
    {
        url = u;
    }
    public void setParams(List<NameValuePair> p)
    {
        params = p;
    }
    public void setMethod(String m)
    {
        method = m.toLowerCase();
    }
    public JSONObject getJSONObject()
    {
        try
        {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpEntity httpEntity = null;
            HttpResponse httpResponse = null;
            if(params==null)
            {
                HttpGet httpGet = new HttpGet(url);
                if(flg)
                {
                    httpGet.setHeader("Cookie",strCookie);
                }
                else {
                    cookies = httpClient.getCookieStore().getCookies();
                }

                httpResponse = httpClient.execute(httpGet);
            }
            else if(params!=null && method.equals("get"))
            {
                String paramString = URLEncodedUtils.format(params, "utf-8");
                url+="?"+paramString;
                HttpGet httpGet = new HttpGet(url);
                if(flg)
                {
                    httpGet.setHeader("Cookie", strCookie);
                }
                else {
                    cookies = httpClient.getCookieStore().getCookies();
                }

                httpResponse = httpClient.execute(httpGet);
            }
            else
            {
                HttpPost httpPost = new HttpPost(url);
                if(flg)
                {
                    httpPost.setHeader("Cookie", strCookie);
                }
                else {
                    cookies = httpClient.getCookieStore().getCookies();
                }

                httpPost.setEntity(new UrlEncodedFormEntity(params));
            }
            httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();

            if(!flg) {
                cookies = httpClient.getCookieStore().getCookies();
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            response = sb.toString();

            Log.d("Message", response);
            jobj = new JSONObject(response);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jobj;
    }
    public JSONObject getJSONObject(String u, List<NameValuePair> l, String m)
    {
        params = l;
        method = m;
        url = u;
        try
        {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpEntity httpEntity = null;
            HttpResponse httpResponse = null;
            if(params==null)
            {
                HttpGet httpGet = new HttpGet(url);
                if(flg)
                {
                    httpGet.setHeader("Cookie", strCookie);
                }
                else {
                    cookies = httpClient.getCookieStore().getCookies();
                }
                httpResponse = httpClient.execute(httpGet);
            }
            else if(params!=null && method.equals("get"))
            {
                String paramString = URLEncodedUtils.format(params, "utf-8");
                url+="?"+paramString;
                HttpGet httpGet = new HttpGet(url);
                if(flg)
                {
                    httpGet.setHeader("Cookie", strCookie);
                }
                else {
                    cookies = httpClient.getCookieStore().getCookies();
                }
                httpResponse = httpClient.execute(httpGet);
            }
            else
            {
                HttpPost httpPost = new HttpPost(url);
                if(flg)
                {
                    httpPost.setHeader("Cookie", strCookie+";");
                }
                else {
                    cookies = httpClient.getCookieStore().getCookies();
                }
                httpPost.setEntity(new UrlEncodedFormEntity(params));
                httpResponse = httpClient.execute(httpPost);
            }
            httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();

            if(!flg) {
                cookies = httpClient.getCookieStore().getCookies();
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            response = sb.toString();

            Log.d("Message", response);
            jobj = new JSONObject(response);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jobj;
    }
    public String getString()
    {
        try
        {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpEntity httpEntity = null;
            HttpResponse httpResponse = null;
            if(params==null)
            {
                HttpGet httpGet = new HttpGet(url);
                if(flg)
                {
                    httpGet.setHeader("Cookie", strCookie);
                }
                else {
                    cookies = httpClient.getCookieStore().getCookies();
                }
                httpResponse = httpClient.execute(httpGet);
            }
            else
            {
                HttpPost httpPost = new HttpPost(url);
                if(flg)
                {
                    httpPost.setHeader("Cookie", strCookie);
                }
                else {
                    cookies = httpClient.getCookieStore().getCookies();
                }
                httpPost.setEntity(new UrlEncodedFormEntity(params));
                httpResponse = httpClient.execute(httpPost);
            }
            httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();

            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            response = sb.toString();
            Log.d("Message", response);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public String getString(String u, List<NameValuePair> l, String m)
    {
        url = u;
        params = l;
        method = m.toLowerCase();

        params = l;
        method = m;
        url = u;
        try
        {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpEntity httpEntity = null;
            HttpResponse httpResponse = null;
            if(params==null)
            {
                HttpGet httpGet = new HttpGet(url);
                if(flg)
                {
                    httpGet.setHeader("Cookie", strCookie);
                }
                else {
                    cookies = httpClient.getCookieStore().getCookies();
                }
                httpResponse = httpClient.execute(httpGet);
                httpEntity = httpResponse.getEntity();
            }
            else if(params!=null && method.equals("get"))
            {
                String paramString = URLEncodedUtils.format(params, "utf-8");
                url+="?"+paramString;
                HttpGet httpGet = new HttpGet(url);
                if(flg)
                {
                    httpGet.setHeader("Cookie", strCookie);
                }
                else {
                    cookies = httpClient.getCookieStore().getCookies();
                }
                httpResponse = httpClient.execute(httpGet);
                httpEntity = httpResponse.getEntity();
            }
            else
            {
                HttpPost httpPost = new HttpPost(url);
                if(flg)
                {
                    httpPost.setHeader("Cookie", strCookie);
                }
                else {
                    cookies = httpClient.getCookieStore().getCookies();
                }
                httpPost.setEntity(new UrlEncodedFormEntity(params));
                httpResponse = httpClient.execute(httpPost);
                httpEntity = httpResponse.getEntity();
            }

            is = httpEntity.getContent();

            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            response = sb.toString();

            Log.d("Message", response);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public List<Cookie> getCookies()
    {
        return cookies;
    }

    public void setCookies(String c)
    {
        strCookie = c;
        flg = true;
    }
}
