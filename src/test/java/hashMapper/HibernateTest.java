package hashMapper;



import org.junit.Test;

import com.yube.DB.MysqlDB;
import com.yube.data.hashdata;



public class HibernateTest {
@Test
public void ConnectionTest() {
	MysqlDB db=new MysqlDB();
	db.Connection(hashdata.class).isOpen();
	
}
@Test 
public void ExecuteTest() {

    hashdata hashData=new hashdata.Builder("asd","asd","asd").build();
    MysqlDB db = new MysqlDB();
    db.Insert(hashData);
	
}
}
