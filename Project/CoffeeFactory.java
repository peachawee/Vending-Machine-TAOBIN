public class CoffeeFactory implements AbstractFactory
{
    public Beverage  getBeverage (String beverageType){    
      if(beverageType.equalsIgnoreCase("ICE")){
         return new IceCoffee();         
      }else if(beverageType.equalsIgnoreCase("HOT")){
         return new HotCoffee();
      }
      return null;
   }
}
