package com.four.food.bean;

public class FoodBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int foodID;
	private String foodName;
    private float protein;
    private float carbohydrates;
    private float fat;
    private float totalCaloriesPer100g;
       
    
	public int getFoodID() {return foodID;}
	public String getFoodName() {return foodName;}
	public float getProtein() {return protein;}
	public float getCarbohydrates() {return carbohydrates;}
	public float getFat() {return fat;}
	public float getTotalCaloriesPer100g() {return totalCaloriesPer100g;}

	public void setFoodID(int foodID) {this.foodID = foodID;}
	public void setFoodName(String foodName) {this.foodName = foodName;}
	public void setProtein(float protein) {this.protein = protein;}
	public void setCarbohydrates(float carbohydrates) {this.carbohydrates = carbohydrates;}
	public void setFat(float fat) {this.fat = fat;}
	public void setTotalCaloriesPer100g(float totalCaloriesPer100g) {this.totalCaloriesPer100g = totalCaloriesPer100g;}

    
    
}