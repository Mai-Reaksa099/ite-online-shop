package kh.edu.rupp.ite.onlineshop.Model;

import com.google.gson.annotations.SerializedName;


public class Products {
    private long price;
    private String name;
    private double rating;
    private String description;
    private int id;

    @SerializedName("image-url")
    private String imageurl;
    private String sku;

    public long getPrice() { return price; }
    public void setPrice(long value) { this.price = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public double getRating() { return rating; }
    public void setRating(double value) { this.rating = value; }

    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }

    public int getid() { return id; }
    public void setid(int value) { this.id = value; }

    public String getImageurl() { return imageurl; }
    public void setImageurl(String value) { this.imageurl = value; }

    public String getSku() { return sku; }
    public void setSku(String value) { this.sku = value; }

}
