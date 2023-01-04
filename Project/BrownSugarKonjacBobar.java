public class BrownSugarKonjacBobar extends BeverageDecorator
{
    private final Beverage temp;
    BrownSugarKonjacBobar(Beverage input){
        temp = input;
    }
    String getDesc(){
        return temp.getDesc()+" + Brown Sugar Konjac Bobar (10 Baht)";
    }
    double getPrice(){
        return temp.getPrice()+10;
    }
}
