public class Decorate implements State
{
    private Vendingmachine v;
    public Decorate(Vendingmachine v){
        this.v = v;
        
    }
    public void addTopping(){
        System.out.println("Enter (1) for yes or (2) for no");
        System.out.println("Do you want to blended? (+5Baht)");
        int temp = v.kb.nextInt();
        while(temp!=1 && temp!=2){
            System.out.println("Please press only (1) or (2) !!");
            System.out.println("Enter (1) for yes or (2) for no");
            System.out.println("Do you want to blended? (+5Baht)");
            temp = v.kb.nextInt();
            }
        if(temp==1) v.beverage = new Blended(v.beverage);
        
        System.out.println("Do you want 1 shot of Espresso? (+15Baht)");
        temp = v.kb.nextInt();
        while(temp!=1 && temp!=2){
            System.out.println("Please press only (1) or (2) !!");
            System.out.println("Enter (1) for yes or (2) for no");
            System.out.println("Do you want 1 shot of Espresso? (+15Baht)");
            temp = v.kb.nextInt();
            }
        if(temp==1) v.beverage = new OneShotEspresso(v.beverage);
        
        System.out.println("Do you want brown sugar konjac bobar? (+10Baht)");
        temp = v.kb.nextInt();
        while(temp!=1 && temp!=2){
            System.out.println("Please press only (1) or (2) !!");
            System.out.println("Enter (1) for yes or (2) for no");
            System.out.println("Do you want brown sugar konjac bobar? (+10Baht)");
            temp = v.kb.nextInt();
            }
        if(temp==1) v.beverage = new BrownSugarKonjacBobar(v.beverage);
        
        System.out.println("Do you want a straw? (+0Baht)");
        temp = v.kb.nextInt();
        while(temp!=1 && temp!=2){
            System.out.println("Please press only (1) or (2) !!");
            System.out.println("Enter (1) for yes or (2) for no");
            System.out.println("Do you want a straw? (+0Baht)");
            temp = v.kb.nextInt();
            }
        if(temp==1) v.beverage = new WantAStraw(v.beverage);
        
        System.out.println("Do you want a lid? (+0Baht)");
        temp = v.kb.nextInt();
        while(temp!=1 && temp!=2){
            System.out.println("Please press only (1) or (2) !!");
            System.out.println("Enter (1) for yes or (2) for no");
            System.out.println("Do you want a lid? (+0Baht)");
            temp = v.kb.nextInt();
            }
        if(temp==1) v.beverage = new WantALid(v.beverage);
        v.setState(v.unpaymentState);
    }
    public void selectAndCreate(){
        throw new RuntimeException("Can't select and create.\nYou're in decorate state.");
    }
    public void choosePaymentMethod(){
        throw new RuntimeException("Can't choose payment method.\nYou're in decorate state.");
    }
    public void collectAPoint(){
        throw new RuntimeException("Can't collect a point.\nYou're in decorate state.");
    }
}
