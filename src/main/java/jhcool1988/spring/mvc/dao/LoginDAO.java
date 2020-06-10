package jhcool1988.spring.mvc.dao;

import jhcool1988.spring.mvc.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("ldao")
public class LoginDAO {

    private JdbcTemplate jdbcTemplate;

    @Value("#{jdbc['selectLoginSQL']}") private String selectLoginSQL;

    @Autowired
    public LoginDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 로그인 여부 확인
    public int selectLogin(MemberVO mvo) {
        Object[] params = new Object[] {
                mvo.getC_id(), mvo.getC_pwd() };

        return jdbcTemplate.queryForObject(
                selectLoginSQL, params, Integer.class);
    }

}