import com.lsf.test.bean.Member;
import com.lsf.test.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2020/3/11.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/*.xml"})
@MapperScan(annotationClass = Repository.class, basePackages = "com.lsf.test.mybatis.mapper")
@TestPropertySource("classpath:application.properties")
public class ApplicationTest {


    @Resource
    private MemberService memberService;

    @Test
    public void testWrite() {
        Member member = new Member();
        member.setName("lishfe");
        member.setAge("28");
        member.setId(1);
        member.setPassword("123456");
        member.setPhone("18310727696");
        member.setSex(1);
        memberService.insert(member);
    }

    @Test
    public void testRead() {
        memberService.selectByPrimaryKey(1);
    }

    @Test
    public void testSave() {
        Member member = new Member();
        member.setName("lishfe1");
        member.setAge("28");
        member.setId(1);
        member.setPassword("123456");
        member.setPhone("18310727696");
        member.setSex(1);
        memberService.save(member);
    }

}
