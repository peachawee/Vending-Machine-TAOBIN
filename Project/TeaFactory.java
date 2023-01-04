public class TeaFactory implements AbstractFactory
{
    public Beverage  getBeverage (String beverageType){    
      if(beverageType.equalsIgnoreCase("ICE")){
         return new IceTea();         
      }else if(beverageType.equalsIgnoreCase("HOT")){
         return new HotTea();
      }
      return null;
   }
}
