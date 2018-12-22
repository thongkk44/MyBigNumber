import org.junit.Test;
import static org.junit.Assert.*;


public class MyBigNumberTest {

    @Test
    public void testSum() {
        MyBigNumber a = new MyBigNumber();
        String tong1 = a.sum("123", "123");
        assertEquals("Correct", "246", tong1);
    }

    @Test
    public void testSum2() {
        MyBigNumber a = new MyBigNumber();
        String tong2 = a.sum("123", "abc");
        assertEquals("Correct", "Vui lòng không nhập chữ hoặc ký tự đặt biệt !", tong2);
    }

    @Test
    public void testSum3() {
        MyBigNumber a = new MyBigNumber();
        String tong3 = a.sum("-123", "123");
        assertEquals("Correct", "Phần mềm chưa hỗ trợ số âm !", tong3);
    }

    
}