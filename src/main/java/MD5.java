import java.security.MessageDigest;

public class MD5{
    public static void main(String args[]){
    String str = "888888";
        System.out.println(Stringmd5(str));

    }
    public static String Stringmd5(String str){
        if(str==null||str.length()==0){
            return null;
        }
        char hexDigits[]={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};

        try{
            //获取信息摘要对象:md5,通过信息摘要单例的构造函数获取
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            //
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest(); //信息摘要对象对字节数组进行摘要,得到摘要字节数组
            int j = str.length();
            char buf[] = new char[j*2];
            int k = 0;
            for (int i=0;i<j;i++){
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];

            }
            return new String(buf).toUpperCase();
        }
        catch (Exception e){
            return null;
        }


    }
}
