import java.util.ArrayList;
public class TaobinDataBase
{
    ArrayList<String> member = new ArrayList<>();
    ArrayList<Integer> point = new ArrayList<>();
    
    public int checkMember(String phoneNB)
    {
        int i=0;
        for(; i<member.size(); i++)
        {
            if(phoneNB.equalsIgnoreCase(member.get(i)))
            {
                return i;
            }    
        }
        return -1;
    }
    
    public void addMember(String phone)
    {
        member.add(phone);
        point.add(5);
    }
    
    /*public void addPoint(int no){
        int x = point.get(no)+5;
        point.add(no,x);
    }*/
    
    public int getSize(){
        return point.size();
    }
    
    public int getPoint(int no){
        //System.out.println("You have : "+ point.get(no) +" points");
        return point.get(no);
    }
}

