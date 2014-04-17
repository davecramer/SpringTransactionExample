package ca.credativ.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class PostgresArrayTest{

    @Autowired
    private PostgresArrayImpl postgresArray;

    @Test
    @Transactional
    public void testGet() throws Exception {
        postgresArray.get();

    }
}
