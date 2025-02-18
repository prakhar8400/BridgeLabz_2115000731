import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    boolean isValid(); // Check if the meal plan is valid
}

class VegetarianMeal implements MealPlan {
    private List<String> meals;

    public VegetarianMeal() {
        meals = new ArrayList<>();
        // Add default vegetarian meals
        meals.add("Vegetable Stir-Fry");
        meals.add("Lentil Soup");
        meals.add("Tofu Scramble");
    }

    @Override
    public boolean isValid() {
        // Check if the meal plan contains only vegetarian options
        for (String meal : meals) {
            if (!meal.toLowerCase().contains("vegetable") && 
                    !meal.toLowerCase().contains("tofu") && 
                    !meal.toLowerCase().contains("lentil") && 
                    !meal.toLowerCase().contains("fruit")) {
                return false; 
            }
        }
        return true;
    }
}

class VeganMeal implements MealPlan {
    private List<String> meals;

    public VeganMeal() {
        meals = new ArrayList<>();
        // Add default vegan meals
        meals.add("Vegan Burger");
        meals.add("Vegetable Curry");
        meals.add("Fruit Salad");
    }

    @Override
    public boolean isValid() {
        // Check if the meal plan contains only vegan options
        for (String meal : meals) {
            if (meal.toLowerCase().contains("meat") || meal.toLowerCase().contains("dairy") || 
                    meal.toLowerCase().contains("eggs")) {
                return false; 
            }
        }
        return true;
    }
}

// Implement other MealPlan subtypes (KetoMeal, HighProteinMeal) similarly

class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }

    public boolean isValid() {
        return mealPlan.isValid();
    }
}

class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealPlan) {
        if (mealPlan.isValid()) {
            return new Meal<>(mealPlan); 
        } else {
            System.out.println("Invalid meal plan. Please provide a valid meal plan.");
            return null; 
        }
    }
}

public class Main {
    public static void main(String[] args) {
        VegetarianMeal vegetarianMeal = new VegetarianMeal();
        VeganMeal veganMeal = new VeganMeal();

        Meal<VegetarianMeal> vegetarianMealPlan = MealPlanGenerator.generateMealPlan(vegetarianMeal);
        Meal<VeganMeal> veganMealPlan = MealPlanGenerator.generateMealPlan(veganMeal);

        if (vegetarianMealPlan != null) {
            System.out.println("Valid Vegetarian Meal Plan:");
            // Access and use vegetarianMealPlan 
        }

        if (veganMealPlan != null) {
            System.out.println("Valid Vegan Meal Plan:");
            // Access and use veganMealPlan 
        }
    }
}
