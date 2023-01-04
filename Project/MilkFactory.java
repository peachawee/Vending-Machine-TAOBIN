public class MilkFactory implements AbstractFactory
{
    public Beverage  getBeverage (String beverageType){    
      if(beverageType.equalsIgnoreCase("ICE")){
         return new IceMilk();         
      }else if(beverageType.equalsIgnoreCase("HOT")){
         return new HotMilk();
      }
      return null;
   }
}
