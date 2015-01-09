package Mathematical;

public class ReverseInteger {

	private static final int INT_MAX = 2147483647;
    private static final int INT_MIN = -2147483648;
    
	public static void main(String[] args) {

		System.out.println(reverse(10000));

	}

	//Does not handle overflows
    public static int reverse(int x) {
        String str = String.valueOf(x);
        char[] c = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        boolean negFlag = false;

        if(x< 0)    {
            negFlag = true;
        }

        
        int i =c.length-1;        
        for(; i>= 1; i--) {
            sb.append(c[i]);
        }
        if(negFlag == false)    {
            sb.append(c[0]);
            long l = Long.parseLong(sb.toString());
            if(l > INT_MAX) return 0;
            else    return (int) l;
        }
        else    {
            long l = -Long.parseLong(sb.toString());
            if(l < INT_MIN) return 0;
            else    return (int) l;
        }
    }
	
}
