package com.imooc.sell.utils;

import com.imooc.sell.vo.ResultVO;

public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO =new ResultVO();
        resultVO.setData(object);
        resultVO.setMeg("成功");
        resultVO.setCode(0);
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code, String meg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMeg(meg);
        return resultVO;
    }
}
