package com.city.erp.model;

import java.io.Serializable;
import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Alias("Product")
public class ProductModel implements Serializable {
	private int no=0;
	private String name=null;
	private double price=0;
	private int qty=0;
	@JsonIgnore
	private byte[] photo=null;
	private String photoFileName=null; 
	private String photoContentType=null;
	private String photoIsImage=null;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public String getPhotoContentType() {
		return photoContentType;
	}
	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	public String getPhotoIsImage() {
		if(photoContentType.startsWith("image")) {
			photoIsImage="Y";
		}
		else {
			photoIsImage="N";
		}
		return photoIsImage;
	}
	public void setPhotoIsImage(String photoIsImage) {
		this.photoIsImage = photoIsImage;
	}
}
