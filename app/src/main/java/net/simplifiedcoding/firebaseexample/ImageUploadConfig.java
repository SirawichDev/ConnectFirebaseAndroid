package net.simplifiedcoding.firebaseexample;

/**
 * Created by sirawich on 9/2/2017 AD.
 */

public class ImageUploadConfig {
    public String name;
    public String url;

    public String getname(){
        return name;

    }
    public String geturl(){
        return url;
    }
    public ImageUploadConfig(String name ,String url){
        this.name = name;
        this.url = url;
    }
}
