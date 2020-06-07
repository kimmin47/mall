package jhcool1988.spring.mvc.service;


import jhcool1988.spring.mvc.dao.MallsDAO;
import jhcool1988.spring.mvc.vo.MallsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("msrv")
public class MallsService {

    private MallsDAO mdao;

    @Autowired
    public MallsService(MallsDAO mdao) {
        this.mdao = mdao;
    }


    public ArrayList<MallsVO> showMalls() {
        return (ArrayList<MallsVO>)
                mdao.selectMalls();
    }

}
